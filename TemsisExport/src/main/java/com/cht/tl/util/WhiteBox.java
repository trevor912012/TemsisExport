package com.cht.tl.util;

import java.io.BufferedReader;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.SAXParserFactory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;



public class WhiteBox {
	private static final Logger m_logger = LogManager.getLogger(WhiteBox.class);

	/*
	 * 可參考 http://breezylee.iteye.com/blog/2063615 透過 Filter 過濾所有參數
	 */

	/* to avoid XSS: filter parameter */
	public static String xss(String strSource) {
		String strEscape = null;

		if (strSource != null) {
			strEscape = org.owasp.encoder.Encode.forHtml(strSource); //[V1.1.4] modified, 改用此 OWASP 程式庫
		}

		return strEscape;
	}

	/* 當要取得真正的文字訊息，而不考慮 XSS 攻擊者 (如: 傳送的簡訊內容) */
	public static String unXss(String strEscape) {
		String strText = null;

		if (strEscape != null) {
			strText = org.apache.commons.lang3.StringEscapeUtils.unescapeHtml4(strEscape); //for JDK 1.6
		}

		return strText;
	}

	/* to avoid Log Forging: ensure no CRLF injection into logs for forging records */
	public static String logForging(String source) {
		String clean = null;

		if (source != null) {
			String strToken = source.replace("\r", "").replace("\n", "\r\n[LINE_FEED]");
			clean = getMyselfString((strToken));
		}

		return clean;
	}

	/*
	 * 解決 [Fortify High] Dynamic Code Evaluation: Unsafe Deserialization 弱掃:
	 * 
	 * 如果可能，請勿在未驗證物件串流內容的情況下還原序列化不可信賴的資料。若要驗證正在還原序列化的類別， 
	 * 應使用前瞻式還原序列化模式。
	 * 
	 * 物件串流會先包含類別描述中繼資料，接著再包含其成員欄位的序列化位元組。透過 Java 序列化程序，開發
	 * 人員可以讀取類別描述，並決定是否要繼續還原序列化物件或中止操作。若要執行此作業，需要在應該執行類別 
	 * 確認和驗證的位置，子類別化 java.io.ObjectInputStream 並提供 resolveClass(ObjectStreamClass desc) 
	 * 方法的自訂實作。
	 * 
	 * 雖然此情況下的理想方法是將預期的類別加入安全名單，但是在某些情況下，此方法不一定可行。對於複雜的
	 * 物件圖形結構來說，黑名單方法更合適。請牢記，雖然某些類別可達成程式碼執行為眾所皆知，但是某些類別 
	 * 可能還不明或尚未公開，因此安全名單方法永遠是優先方法。若要避開阻斷服務攻擊，建議您取代
	 * resolveObject(Object obj) 方法，以計數要還原序列化的物件數目，並在超過臨界值時中止還原序列化。
	 * 
	 * 當還原序列化在程式庫或架構中執行時 (例如，使用 JMX、RMI、JMS、HTTP Invoker 時)，上述建議將不適用，
	 * 因為這已超過開發人員的控制範圍。在這些情況下，您可能想要確定這些通訊協定符合以下需求：
	 * 
	 * - 未對外公開。 - 使用驗證。 - 使用完整性檢查。 - 使用加密。
	 * 
	 * 此外，每當應用程式從 ObjectInputStream 執行還原序列化時，將會執行 HPE Security Fortify Runtime
	 * 所提供的安全控制，藉此同時保護應用程式程式碼以及程式庫與架構程式碼，使其免於遭受此類型的攻擊。
	 * 
	 * => 參考 https://www.contrastsecurity.com/security-influencers/java-serialization-vulnerability-
	 * threatens-millions-of-applications
	 * 
	 * => you can limit the objects available to be deserialized by overriding the resolveClass
	 * method on objectInputStream. This way you can ensure only objects you have verified are safe
	 * will be populated during deserialization.
	 * 
	 * A method to replace the unsafe ObjectInputStream.readObject() method built into Java. This
	 * method checks to be sure the classes referenced are safe, the number of objects is limited to
	 * something sane, and the number of bytes is limited to a reasonable number. The returned
	 * Object is also cast to the specified type.
	 *
	 * 原呼叫端用法: (Unsafe Deserialization)
	 * 
	 * Data data = (Data) in.readObject();
	 * 
	 * 新呼叫端用法: (read in the serialized object SAFELY)
	 * 
	 * List<Class<?>> safeClasses = Arrays.asList(BitSet.class, ArrayList.class); 
	 * Data data = safeReadObject(Data.class, safeClasses, 10, 50, inputStream);
	 * 
	 * => This allows the developer to specify the return type and a list of the classes that they
	 * expect to show up in serialized objects. The prevents the attacker from loading classes that
	 * allow him to execute attacks. This also empowers the developer to limit the input to a
	 * maximum of 10 embedded objects and 50 bytes of input. This way, the attacker can't send an
	 * arbitrarily large serialized object to blow up your JVM by exhausting memory.
	 * 
	 * @param type
	 *            Class representing the object type expected to be returned
	 * @param safeClasses
	 *            List of Classes allowed in serialized object being read
	 * @param maxObjects
	 *            long representing the maximum number of objects allowed inside the serialized
	 *            object being read
	 * @param maxBytes
	 *            long representing the maximum number of bytes allowed to be read from the
	 *            InputStream
	 * @param in
	 *            InputStream containing an untrusted serialized object
	 * @return Object read from the stream (cast to the Class of the type parameter)
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	@SuppressWarnings("unchecked")
	public static <T> T safeReadObject(final Class<?> type, final List<Class<?>> safeClasses,
			final long maxObjects, final long maxBytes, InputStream in)
			throws IOException, ClassNotFoundException {

		// create an input stream limited to a certain number of bytes
		InputStream lis = new FilterInputStream(in) {
			private long len = 0;

			public int read() throws IOException {
				int val = super.read();
				if (val != -1) {
					len++;
					checkLength();
				}
				return val;
			}

			public int read(byte[] b, int off, int len) throws IOException {
				int val = super.read(b, off, len);
				if (val > 0) {
					len += val;
					checkLength();
				}
				return val;
			}

			private void checkLength() throws IOException {
				if (len > maxBytes) {
					throw new SecurityException(
							"Security violation: attempt to deserialize too many bytes from stream. Limit is "
									+ maxBytes);
				}
			}
		};

		// create an object input stream that checks classes and limits the number of objects to read
		ObjectInputStream ois = new ObjectInputStream(lis) {
			private int	objCount	= 0;
			@SuppressWarnings("unused")
			boolean		b			= enableResolveObject(true);

			protected Object resolveObject(Object obj) throws IOException {
				if (objCount++ > maxObjects) {
					throw new SecurityException(
							"Security violation: attempt to deserialize too many objects from stream. Limit is "
									+ maxObjects);
				}
				Object object = super.resolveObject(obj);
				return object;
			}

			protected Class<?> resolveClass(ObjectStreamClass osc)
					throws IOException, ClassNotFoundException {
				Class<?> clazz = super.resolveClass(osc);
				if (clazz.isArray() || clazz.equals(type) || clazz.equals(String.class)
						|| Number.class.isAssignableFrom(clazz) || safeClasses.contains(clazz)) {
					return clazz;
				}
				throw new SecurityException(
						"Security violation: attempt to deserialize unauthorized " + clazz);
			}
		};

		// use the protected ObjectInputStream to read object safely and cast to T
		return (T) ois.readObject();
	}

	/*
	 * to avoid Portability Flaw: Locale Dependent Comparison attack
	 */
	public static void setHostLocale() {
		/*
		 * 如果 SCA 看到在應用程式的任何位置呼叫 java.util.Locale.setDefault()，
		 * 將會假設地區設定已進行對應的設定，故呼叫 equals(), toUpperCase(), 
		 * toLowerCase() 不會出現因為存在不同的地區設定，可能會導致非預期的輸出。
		 * 這也可能會規避自訂驗證例行程序。
		 * 
		 * 解決 1: 使用 str.toUpperCase(Locale.ENGLISH 或 Locale.CHINESE);
		 * 解決 2: 使用 str.equalsIgnoreCase(some_value);
		 * 解決 3: 呼叫本 API 內的 Locale.setDefault() 指令.
		 */
		java.util.Locale.setDefault(Locale.CHINESE);
	}

	/*
	 * to avoid XML External Entities (XXE) attack, and get safe DocumentBuilderFactory.
	 */
	public static DocumentBuilderFactory xxe(DocumentBuilderFactory dbf) {

		/* 當您建立 XML 解析器或者解析器因數時，請務必啟用驗證功能。
		 * 因為定義形式合法文件的規則錯綜複雜或難以了解，所以啟用驗證功能會導致一些問題，
		 * 如此一來，在這個段落就會潛在一些安全性錯誤。
		*/
		dbf.setValidating(true);

		/* This should be the default, but let's be safe and try and disable it.
		 * We also have to cater for older XML parsers that do not support this.
		 */
		try {
			dbf.setXIncludeAware(false);
		} catch (Exception e) { //OK, not all parsers will support this attribute 
			if (m_logger.isTraceEnabled()) { //UnsupportedOperationException, NoSuchMethodError
				m_logger.trace(String.format(
						"FAILED and IGNORED to set XML include aware property: [%s] %s",
						e.getClass().getName(), e.getMessage()));
			}
		}

		dbf.setExpandEntityReferences(false);

		/*
		 * To avoid XML Entity Expansion injection the "secure-processing" property should  
		 * be set for an XML factory, parser or reader: 
		 */
		try {
			dbf.setAttribute("http://javax.xml.XMLConstants/feature/secure-processing", true);
		} catch (Exception e) { //OK, not all parsers will support this attribute 
			if (m_logger.isTraceEnabled()) {
				m_logger.trace(String.format(
						"FAILED and IGNORED to set XML secure-processing property: [%s] %s",
						e.getClass().getName(), e.getMessage()));
			}
		}

		/*
		 * to avoid XML External Entities (XXE) attack
		 */
		try {
			dbf.setAttribute("http://xml.org/sax/features/external-general-entities", false);
		} catch (Exception e) { //OK, not all parsers will support this attribute 
			if (m_logger.isTraceEnabled()) {
				m_logger.trace(String.format(
						"FAILED and IGNORED to set XML external-general-entities property: [%s] %s",
						e.getClass().getName(), e.getMessage()));
			}
		}

		/*
		 * to avoid XML External Entities (XXE) attack
		 */
		try {
			dbf.setAttribute("http://xml.org/sax/features/external-parameter-entities", false);
		} catch (Exception e) { //OK, not all parsers will support this attribute 
			if (m_logger.isTraceEnabled()) {
				m_logger.trace(String.format(
						"FAILED and IGNORED to set XML external-parameter-entities property: [%s] %s",
						e.getClass().getName(), e.getMessage()));
			}
		}

		/*
		 * if inline DOCTYPE declaration is not needed, it can be completely disabled with 
		 * the following property:
		 */
		try {
			dbf.setAttribute("http://apache.org/xml/features/disallow-doctype-decl", true);
		} catch (Exception e) { //OK, not all parsers will support this attribute (SAXNotRecognizedException)
			if (m_logger.isTraceEnabled()) {
				m_logger.trace(String.format(
						"FAILED and IGNORED to set XML disallow-doctype-decl property: [%s] %s",
						e.getClass().getName(), e.getMessage()));
			}
		}

		try {
			dbf.setAttribute("http://apache.org/xml/features/nonvalidating/load-external-dtd",
					Boolean.FALSE);
		} catch (Exception e) { //OK, not all parsers will support this attribute 
			if (m_logger.isTraceEnabled()) {
				m_logger.trace(String.format(
						"FAILED and IGNORED to set XML load-external-dtd property: [%s] %s",
						e.getClass().getName(), e.getMessage()));
			}
		}

		return dbf;
	}

	/*
	 * to avoid XML External Entities (XXE) attack, and get safe SAXParserFactory.
	 */
	public static SAXParserFactory xxe(SAXParserFactory spf) {

		/* 當您建立 XML 解析器或者解析器因數時，請務必啟用驗證功能。
		 * 因為定義形式合法文件的規則錯綜複雜或難以了解，所以啟用驗證功能會導致一些問題，
		 * 如此一來，在這個段落就會潛在一些安全性錯誤。
		*/
		spf.setValidating(true);

		/* This should be the default, but let's be safe and try and disable it.
		 * We also have to cater for older XML parsers that do not support this.
		 */
		try {
			spf.setXIncludeAware(false);
		} catch (UnsupportedOperationException e) {
			/* This is OK; older versions of the parser do not support XInclude at
			 * all.
			*/
		} catch (NoSuchMethodError e) {
			/* This is OK; older versions of the parser do not support XInclude at
			 * all.  This is here for jdk 1.4 and earlier Xerces versions.
			*/
		}

		/* Setting the attribute
		 * http://apache.org/xml/features/disallow-doctype-decl to true causes an
		 * immediate exception when a DTD is encountered. Unfortunately, an XML
		 * document will sometimes include a harmless DTD so we cannot ban DTDs
		 * outright.
		 */
		try {
			spf.setFeature("http://xml.org/sax/features/external-general-entities", false);
		} catch (Exception e) { //IllegalArgumentException, SAXNotRecognizedException
			/* OK, not all parsers will support this attribute */
			if (m_logger.isTraceEnabled()) {
				m_logger.trace(String.format(
						"FAILED and IGNORED to set XML external-general-entities property: [%s] %s",
						e.getClass().getName(), e.getMessage()));
			}
		}

		try {
			spf.setFeature("http://xml.org/sax/features/external-parameter-entities", false);
		} catch (Exception e) { //IllegalArgumentException, SAXNotRecognizedException
			/* OK, not all parsers will support this attribute */
			if (m_logger.isTraceEnabled()) {
				m_logger.trace(String.format(
						"FAILED and IGNORED to set XML external-parameter-entities property: [%s] %s",
						e.getClass().getName(), e.getMessage()));
			}
		}

		try {
			spf.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);
		} catch (Exception e) { //IllegalArgumentException, SAXNotRecognizedException
			/* OK, not all parsers will support this attribute */
			if (m_logger.isTraceEnabled()) {
				m_logger.trace(String.format(
						"FAILED and IGNORED to set XML load-external-dtd property: [%s] %s",
						e.getClass().getName(), e.getMessage()));
			}
		}

		/* Again, older XML parsers do not support this. */
		try {
			spf.setFeature("http://javax.xml.XMLConstants/feature/secure-processing", true);
		} catch (Exception e) { //IllegalArgumentException, SAXNotRecognizedException
			/* OK, not all parsers will support this attribute */
			if (m_logger.isTraceEnabled()) {
				m_logger.trace(String.format(
						"FAILED and IGNORED to set XML secure-processing property: [%s] %s",
						e.getClass().getName(), e.getMessage()));
			}
		}

		return spf;
	}

	private static final char[] hexArray = "0123456789ABCDEF".toCharArray();

	public static String getHexString(char[] value) {
		String strHex = null;

		if ((value != null) && (value.length > 0)) {
			StringBuilder sb = new StringBuilder();

			for (int i = 0; i < value.length; i++) {
				int v = value[i] & 0xFF;
				char[] hexChars = new char[2];

				hexChars[0] = hexArray[v >>> 4];
				hexChars[1] = hexArray[v & 0x0F];

				sb.append("0x" + new String(hexChars) + " ");
			}

			strHex = sb.toString();
		}

		return strHex;
	}

	public static String getHexString(String value) {
		if ((value != null) && (value.length() > 0)) {
			char[] v = value.toCharArray();

			return getHexString(v);
		} else {
			return "";
		}
	}

	public static String getHexString(byte[] value, int startIdx, int length) { //[V1.2.1] added
		if ((value != null) && (value.length > 0)) {
			StringBuilder sb = new StringBuilder();

			int nIdx = 0;
			for (byte b : value) {
				if ((nIdx >= startIdx) && (nIdx < startIdx + length)) { //[V1.2.1] added, //[V1.2.3] modified
					sb.append("0x" + String.format("%02x ", b & 0xff));
				}
				nIdx++;
			}

			return sb.toString();
		} else {
			return "";
		}
	}

	public static String getHexString(byte[] value, int startIdx) { //[V1.2.1] added
		if ((value != null) && (value.length > 0)) {
			return getHexString(value, startIdx, value.length - startIdx);
		} else {
			return "";
		}
	}

	public static String getHexString(byte[] value) {
		if ((value != null) && (value.length > 0)) {
			return getHexString(value, 0, value.length);
		} else {
			return "";
		}
	}

	//[V5.3.0 added]
	public static String bytesToHex(byte[] bytes) {
		String strHex = null;

		if ((bytes != null) && (bytes.length > 0)) {
			char[] hexChars = new char[bytes.length * 2];
			for (int j = 0; j < bytes.length; j++) {
				int v = bytes[j] & 0xFF;
				hexChars[j * 2] = hexArray[v >>> 4];
				hexChars[j * 2 + 1] = hexArray[v & 0x0F];
			}
			strHex = new String(hexChars);
		}

		return strHex;
	}

	public static String getReadableString(String strHex) {
		if (strHex != null) {
			//先計算所需的 char 空間
			String[] hex = strHex.replace("0x", "").trim().split(" |\\[|\\]");

			//寫入 char 資料
			char[] c = new char[hex.length];

			for (int i = 0; i < hex.length; i++) {
				char[] a = hex[i].toCharArray();

				c[i] = 0;

				for (int j = 0; j < a.length; j++) {
					c[i] *= 16;
					if ((a[j] >= '0') && (a[j] <= '9')) {
						c[i] += (a[j] - '0');
					} else if ((a[j] >= 'a') && (a[j] <= 'f')) {
						c[i] += 10 + (a[j] - 'a');
					} else if ((a[j] >= 'A') && (a[j] <= 'F')) {
						c[i] += 10 + (a[j] - 'A');
					}
				}
			}

			return new String(c);
		} else {
			return null;
		}
	}

	public static byte[] hexStringToByteArray(String s) { //[V1.1.7] added
		int len = s.length();
		byte[] data = new byte[len / 2];

		for (int i = 0; i < len; i += 2) {
			data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
					+ Character.digit(s.charAt(i + 1), 16));
		}

		return data;
	}

	public static String getMyselfString(String s, final int nMaxChar) { //[V1.2.8] added
		String str = null;

		if ((s != null) && (s.length() > 0) && (s.length() <= nMaxChar)) {
			try {
				byte[] ba = s.getBytes(StandardCharsets.UTF_8/*"UTF-8"*/);

				String sHex = bytesToHex(ba);
				String sFilter = getNonChineseValue(sHex);
				byte[] b2 = hexStringToByteArray(sFilter);

				str = new String(b2, StandardCharsets.UTF_8/*"UTF-8"*/);
			} catch (Exception e) {
				if (m_logger.isWarnEnabled()) {
					m_logger.warn(String.format("*** FAILED to getMySelfString(): [%s] %s",
							e.getClass().getName(), e.getMessage()), e);
				}
			}
		} else if ((s != null) && (s.length() > nMaxChar) && m_logger.isWarnEnabled()) {
//			m_logger.warn(String.format(
//					"*** FAILED to getMyselfString(maxChar=%d): over max length => [len %d]",
//					nMaxChar, s.length()));
		}

		return str;
	}

	public static String getMyselfString(String s) { //[V1.1.7] added
		final int nMaxChar = 4096; //[V1.2.8] added, 增加內定最大長度限制

		return getMyselfString(s, nMaxChar); //[V1.2.8] modified
	}

//	public static String getValidMyselfHexString(String s, final int nMaxChar) { //[V1.2.8] added
//		String s2 = getMyselfString(s);
//
//		if (s2 != null) {
//			if (s2.matches(PatternConstants.PATTERN_HEX_STRING) && (s2.length() <= nMaxChar)) {
//				return s2;
//			} else if (m_logger.isWarnEnabled()) {
//				if (s2.length() > nMaxChar) {
//					if (m_logger.isWarnEnabled()) {
//						m_logger.warn(String.format(
//								"*** FAILED to getValidMyselfHexString(maxChar=%d): over max length => [len %d] %s",
//								nMaxChar, s2.length(), s2));
//					}
//				} else if (m_logger.isWarnEnabled()) {
//					m_logger.warn(String.format(
//							"*** FAILED to getValidMyselfHexString(maxChar=%d): invalid hex string => [len %d] %s",
//							nMaxChar, s2.length(), s2));
//				}
//			}
//		}
//
//		return null;
//	}

//	public static String getValidMyselfTwoHexString(String s, final int nMaxChar) { //[V1.2.8] added
//		String s2 = getMyselfString(s);
//
//		if (s2 != null) {
//			if (s2.matches(PatternConstants.PATTERN_TWO_HEX_STRING) && (s2.length() <= nMaxChar)) {
//				return s2;
//			} else if (m_logger.isWarnEnabled()) {
//				if (s2.length() > nMaxChar) {
//					if (m_logger.isWarnEnabled()) {
//						m_logger.warn(String.format(
//								"*** FAILED to getValidMyselfTwoHexString(maxChar=%d): over max length => [len %d] %s",
//								nMaxChar, s2.length(), s2));
//					}
//				} else if (m_logger.isWarnEnabled()) {
//					m_logger.warn(String.format(
//							"*** FAILED to getValidMyselfTwoHexString(maxChar=%d): invalid two hex string => [len %d] %s",
//							nMaxChar, s2.length(), s2));
//				}
//			}
//		}
//
//		return null;
//	}

//	public static String getValidMyselfIPv4(String s) { //[V1.2.8] added
//		String s2 = getMyselfString(s);
//
//		if (s2 != null) {
//			if (s2.matches(PatternConstants.PATTERN_IP_V4)) {
//				return s2;
//			} else if (m_logger.isWarnEnabled()) {
//				m_logger.warn(String.format(
//						"*** FAILED to getValidMyselfIPv4(): invalid IPv4 format => %s", s2));
//			}
//		}
//
//		return null;
//	}

//	public static String getValidMyselfIPv6(String s) { //[V1.2.8] added
//		String s2 = getMyselfString(s);
//
//		if (s2 != null) {
//			if (s2.matches(PatternConstants.PATTERN_IP_V6)
//					|| s2.matches(PatternConstants.PATTERN_IP_V6_ADVANCED)) {
//				return s2;
//			} else if (m_logger.isWarnEnabled()) {
//				m_logger.warn(String.format(
//						"*** FAILED to getValidMyselfIPv6(): invalid IPv4 format => %s", s2));
//			}
//		}
//
//		return null;
//	}

//	public static String getValidMyselfIPv4orIPv6(String s) { //[V1.2.8] added
//		String s2 = getMyselfString(s);
//
//		if (s2 != null) {
//			if (s2.matches(PatternConstants.PATTERN_IP_V4)
//					|| s2.matches(PatternConstants.PATTERN_IP_V6)
//					|| s2.matches(PatternConstants.PATTERN_IP_V6_ADVANCED)) {
//				return s2;
//			} else if (m_logger.isWarnEnabled()) {
//				m_logger.warn(String.format(
//						"*** FAILED to getValidMyselfIPv4orIPv6(): invalid format => %s", s2));
//			}
//		}
//
//		return null;
//	}

	public static long getSecureRandomValue() {
		SecureRandom random = new SecureRandom();
		long lValue = random.nextLong();

		while (lValue < 100000000) {
			lValue = random.nextLong();
		}

		return lValue;
	}

	public static long getPositiveRandomValue() {
		return Math.abs(getSecureRandomValue());
	}

	public static long getPositiveRandomValue(final long nMaxValue) { //[V1.2.9] added
		return Math.abs(getSecureRandomValue()) % nMaxValue;
	}

	public static long getPositiveRandomValue(final long nMinValue, final long nMaxValue) { //[V1.2.9] added
		long lValue;

		if (nMaxValue > nMinValue) {
			do {
				lValue = Math.abs(getSecureRandomValue()) % nMaxValue;
			} while (lValue <= nMinValue);
		} else if (nMaxValue == nMinValue) {
			lValue = getPositiveRandomValue(nMaxValue);
		} else {
			do {
				lValue = Math.abs(getSecureRandomValue()) % nMinValue;
			} while (lValue <= nMaxValue);
		}

		return lValue;
	}

	//to avoid Fortify Path Manipulation
	public static String getAllowFileName(String filename) { //不接受含中文、 / 及 \ 符號之檔名
		HashMap<String, String> map = new HashMap<>();

		for (int i = 0; i < 26; i++) { //a ~ z, A ~ Z
			String s1 = String.valueOf(Character.toChars(97 + i)); //start from "a"
			String s2 = String.valueOf(Character.toChars(65 + i)); //start from "A"

			map.put(s1, s1);
			map.put(s2, s2);
		}

		for (int i = 0; i < 10; i++) {
			String s = String.valueOf(Character.toChars(48 + i)); //start from "0"

			map.put(s, s);
		}

		map.put("_", "_");
		map.put("-", "-");
		map.put(".", ".");

		String strAllowFileName = null;

		if ((filename != null) && (filename.length() > 0)) {
			StringBuilder sb = new StringBuilder();

			for (int i = 0; i < filename.length(); i++) {
				if (map.get(filename.charAt(i) + "") != null) {
					sb.append(map.get(filename.charAt(i) + ""));
				}
			}

			if (sb.length() > 0) {
				if (!sb.toString().equals(filename) && m_logger.isWarnEnabled()) {
					m_logger.warn(String.format("*** UNEXPECTED to get allowed file name: %s",
							sb.toString()));
				}

				strAllowFileName = sb.toString();
			} else if (m_logger.isWarnEnabled()) {
				m_logger.warn(String.format("*** FAILED to get allowed file name: %s", filename));
			}
		}

		return strAllowFileName;
	}

	//get non-chinese parameter value
	private static HashMap<Character, Character>	m_map		= null;
	private static HashMap<Byte, Byte>				m_mapByte	= null;

	private static synchronized void initMap() {
		if (m_map == null) {
			//System.out.println("start WhiteBox.initMap()...");

			m_map = new HashMap<Character, Character>();
			m_mapByte = new HashMap<Byte, Byte>();

			String s1 = "abcdefghijklmnopqrstuvwxyz";
			String s2 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

			for (int i = 0; i < s1.length(); i++) { //a ~ z, A ~ Z
				m_map.put(s1.charAt(i), s1.charAt(i));
				m_map.put(s2.charAt(i), s2.charAt(i));
			}

			String s3 = "0123456789";

			for (int i = 0; i < s3.length(); i++) {
				m_map.put(s3.charAt(i), s3.charAt(i));
			}

			String s4 = "!@#$%^&*()_+-={}|[ ]\\:\";'<>?,./~`'";

			for (int i = 0; i < s4.length(); i++) {
				m_map.put(s4.charAt(i), s4.charAt(i));
			}

			for (byte i = 0; i <= ((byte) 0xFF); i++) { //若只用 0xFF，則會卡住。
				m_mapByte.put(new Byte(i), new Byte(i));
			}
		}
	}

	//get non-chinese parameter value
	public static String getNonChineseValue(char[] value) { //不接受含中文
		String strNonChineseValue = null;

		if ((value != null) && (value.length > 0)) {
			StringBuilder sb = new StringBuilder();

			if (m_map == null) {
				initMap();
			}

			for (int i = 0; i < value.length; i++) {
				char c = value[i];

				if (m_map.get(c) != null) {
					sb.append(m_map.get(c));
				} else if (c == '\r') {
					sb.append("[\\r]");
				} else if (c == '\n') {
					sb.append("[\\n]");
				} else {
					//sb.append("[0x" + String.format("%02x", (int) c) + "]"); //可能特殊符號或中文 <-- LogForging
					sb.append("[X]");
				}
			}

			strNonChineseValue = sb.toString();
		}

		return strNonChineseValue;
	}

	public static String getNonChineseValue(byte[] value) { //不接受含中文
		if (value != null) {
			String str = null;

			try {
				str = new String(value, "Big5");
			} catch (Exception e) {
				str = new String(value); //using the platform's default charset
			}

			char[] v = str.toCharArray();

			return getNonChineseValue(v);
		} else {
			return null;
		}
	}

	public static String getNonChineseValue(String value) { //不接受含中文
		if (value != null) {
			char[] v = value.toCharArray();

			return getNonChineseValue(v);
		} else {
			return null;
		}
	}

	public static byte[] getPassByteArray(byte[] value) {
		byte[] v = null;

		if (value != null) {
			v = new byte[value.length];

			if (m_mapByte == null) {
				initMap();
			}

			for (int i = 0; i < value.length; i++) {
				Byte b = m_mapByte.get(new Byte(value[i]));

				v[i] = b.byteValue();
			}
		}

		return v;
	}
}