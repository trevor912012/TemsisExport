package com.cht.tl.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.time.Duration;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.ResourceBundle;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.LoggerContext;


public class Constant {
	private static final Logger	m_logger	= LogManager.getLogger(Constant.class);
	public static final Properties apProperties = new Properties();
	private static boolean propertyInitFlag = false;
	private static boolean logInitFlag = false;
	public static boolean natsInitFlag = false;
	public static boolean jsNatsInitFlag = false;
	public static boolean jsNatsRecvInitFlag = false;
	public static HashMap emhiHm = null;

//	/**
//	 * 判斷是否已有log4j設定
//	 * 
//	 * @return boolean
//	 */
//	public static boolean isLog4jConfigured() {
//		boolean b_flag = false;
//		Enumeration<?> appenders = Logger.getRootLogger().getAllAppenders();
//		if (appenders.hasMoreElements()) {
//			b_flag = true;
//		} else {
//			Enumeration<?> loggers = LogManager.getCurrentLoggers();
//			while (loggers.hasMoreElements()) {
//				Logger c = (Logger) loggers.nextElement();
//				if (c.getAllAppenders().hasMoreElements()) {
//					b_flag = true;
//					break;
//				}
//			}
//		}
//		return b_flag;
//	}

	public static String removeSpecialCharacters(String str) {
		  Map map = getClearStringCompareMap();
		  String resultStr = "";
		  if(str == null){
			  return null;
		  }
		  for(char c : str.toCharArray()){
			  String s = String.valueOf(c);
			  if(map.get(s)!= null){
				  resultStr += map.get(s); 
			  }
		  }
		  return resultStr;
	}

	private static Map getClearStringCompareMap() {
		Map map = new HashMap();
		map.put("a", "a");
		map.put("b", "b");
		map.put("c", "c");
		map.put("d", "d");
		map.put("e", "e");
		map.put("f", "f");
		map.put("g", "g");
		map.put("h", "h");
		map.put("i", "i");
		map.put("j", "j");
		map.put("k", "k");
		map.put("l", "l");
		map.put("m", "m");
		map.put("n", "n");
		map.put("o", "o");
		map.put("p", "p");
		map.put("q", "q");
		map.put("r", "r");
		map.put("s", "s");
		map.put("t", "t");
		map.put("u", "u");
		map.put("v", "v");
		map.put("w", "w");
		map.put("x", "x");
		map.put("y", "y");
		map.put("z", "z");
		map.put("A", "A");
		map.put("B", "B");
		map.put("C", "C");
		map.put("D", "D");
		map.put("E", "E");
		map.put("F", "F");
		map.put("G", "G");
		map.put("H", "H");
		map.put("I", "I");
		map.put("J", "J");
		map.put("K", "K");
		map.put("L", "L");
		map.put("M", "M");
		map.put("N", "N");
		map.put("O", "O");
		map.put("P", "P");
		map.put("Q", "Q");
		map.put("R", "R");
		map.put("S", "S");
		map.put("T", "T");
		map.put("U", "U");
		map.put("V", "V");
		map.put("W", "W");
		map.put("X", "X");
		map.put("Y", "Y");
		map.put("Z", "Z");
		map.put(".", ".");
		map.put("-", "-");
		map.put("1", "1");
		map.put("2", "2");
		map.put("3", "3");
		map.put("4", "4");
		map.put("5", "5");
		map.put("6", "6");
		map.put("7", "7");
		map.put("8", "8");
		map.put("9", "9");
		map.put("0", "0");
		map.put("/", "/");
		map.put("\\", "\\");
		map.put(":", ":");
		map.put("_", "_");
		return map;
	}

	

	public static void propertyInit() {
		String configFile = System.getProperty("user.dir")+File.separator+"config"+File.separator+"config2.properties";
//		m_logger.info("@@@@@configFile="+configFile);
		System.out.println("@@@@@configFile="+configFile);
		FileInputStream fileInputStream = null;
		try {
			fileInputStream = new FileInputStream(Constant.removeSpecialCharacters(configFile));
			apProperties.load(new InputStreamReader(fileInputStream, "UTF-8"));
			propertyInitFlag = true;
		} catch (FileNotFoundException e) {
			m_logger.error(e);
		    //e.printStackTrace();
		} catch (IOException e) {
			m_logger.error(e);
		    //e.printStackTrace();
		}finally{
			if(fileInputStream!=null){
				safeClose(fileInputStream);
			}
		}
	}
	public static void safeClose(FileInputStream fileInputStream){
		if (fileInputStream != null) {
			try {
				fileInputStream.close();
		    }catch (IOException e) {
		    	m_logger.error(e);
		    }
		}
	}
	public static Properties getApProperties() {
		return apProperties;
	}
	
	public static boolean isPropertyInitFlag() {
		return propertyInitFlag;
	}
	public static boolean isLogInitFlag() {
		return logInitFlag;
	}
	public static boolean isNatsInitFlag() {
		return natsInitFlag;
	}
	
	
	
	public static String getFileSaveDir() {		
		String fileSaveDir = "";
		if(apProperties.getProperty("FILE_SAVE_DIR").equalsIgnoreCase("OA")){
			fileSaveDir = "D:\\FDKC_TEMSIS2\\file\\".replace("\\", File.separator).replace("/", File.separator);
		}else if(apProperties.getProperty("FILE_SAVE_DIR").equalsIgnoreCase("windows")){
			fileSaveDir = "C:\\FDKC_TEMSIS2\\file\\".replace("\\", File.separator).replace("/", File.separator);
		}else if(apProperties.getProperty("FILE_SAVE_DIR").equalsIgnoreCase("linux")){
			//fileSaveDir = "/home/luckysky/FDKC_TEMSIS2/file/".replace("\\", File.separator).replace("/", File.separator);
			fileSaveDir = "/mnt/sdb/file/FDKC_TEMSIS2/".replace("\\", File.separator).replace("/", File.separator);
		}else if(apProperties.getProperty("FILE_SAVE_DIR").equalsIgnoreCase("linux_qa")){
			//fileSaveDir = "/home/luckysky/FDKC_TEMSIS2_qa/file/".replace("\\", File.separator).replace("/", File.separator);
			fileSaveDir = "/mnt/sdb/file/FDKC_TEMSIS2_qa/".replace("\\", File.separator).replace("/", File.separator);
		}else{
			fileSaveDir = "toDoList";
		}
//		System.out.println("fileSaveDir="+fileSaveDir);
		return fileSaveDir;
	}
	
//	public static StreamConfiguration getStreamConfiguration(String stream, String subject) {
//		StreamConfiguration streamConfiguration = StreamConfiguration.builder()
//			    .name(stream)
//			    .subjects(subject)
//			    .retentionPolicy(RetentionPolicy.WorkQueue)
//			    .replicas(1)
//			    .discardPolicy(DiscardPolicy.Old)
//			    .duplicateWindow(Duration.ofSeconds(30))
//			    .build();
//		return streamConfiguration;
//	}
	/*
	public static StreamConfiguration getStreamConfiguration(String stream, String subject) {
		StreamConfiguration streamConfiguration = StreamConfiguration.builder()
			    .name(stream)
			    .subjects(subject)
			    .retentionPolicy(RetentionPolicy.WorkQueue)
			    .replicas(1)
			    .discardPolicy(DiscardPolicy.Old)
			    //.duplicateWindow(Duration.ofSeconds(30))
			    .maxMessages(-1)
                .maxBytes(-1)
                .maxMsgSize(-1).storageType(StorageType.File)
                .noAck(false)
                .discardPolicy(DiscardPolicy.Old)
                .duplicateWindow(Duration.ofSeconds(30))

			    .build();
		return streamConfiguration;
	}*/
	/*
	public static PullSubscribeOptions getpullSubscribeOptions(String stream, String durable, String subject) {
		ConsumerConfiguration configuration = ConsumerConfiguration.builder()
			    //.durable("consumerJetStreamNcdrTemsis")
			    .durable(durable)
			    .filterSubject(subject)
			    .replayPolicy(ReplayPolicy.Instant)
			    .ackPolicy(AckPolicy.Explicit)
			    .ackWait(Duration.ofSeconds(30))
			    .deliverPolicy(DeliverPolicy.All)
			    .maxDeliver(10)
			    //.rateLimit(100)
			    .maxAckPending(20000)
			    .build();

		PullSubscribeOptions pullSubscribeOptions = (PullSubscribeOptions
		          .builder()
		          //.configuration(configuration).stream("jetStreamNcdrTemsis")
		          //.configuration(configuration).stream(stream)
		          .configuration(configuration)
		          .build());
		return pullSubscribeOptions;
	}*/
	/*
	public static PullSubscribeOptions getpullSubscribeOptions(String stream, String durable) {
		ConsumerConfiguration configuration = ConsumerConfiguration.builder()
			    //.durable("consumerJetStreamNcdrTemsis")
			    .durable(durable)
			    .replayPolicy(ReplayPolicy.Instant)
			    .ackPolicy(AckPolicy.Explicit)
//			    .ackWait(Duration.ofSeconds(30))
			    .ackWait(Duration.ofDays(7))
			    .deliverPolicy(DeliverPolicy.All)
			    .maxDeliver(100)
			    //.rateLimit(100)
			    .maxAckPending(20000)
			    .build();

		PullSubscribeOptions pullSubscribeOptions = (PullSubscribeOptions
		          .builder()
		          //.configuration(configuration).stream("jetStreamNcdrTemsis")
		          //.configuration(configuration).stream(stream)
		          .configuration(configuration)
		          .build());
		return pullSubscribeOptions;
	}*/
}
