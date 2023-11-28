package com.cht.temsis;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.annotation.Resource;

import org.jasypt.encryption.StringEncryptor;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cht.tl.csv.CsvExport;
import com.cht.tl.jdbc.dao.TemsisDaoImpl;
import com.cht.tl.model.ParseTemsis;
import com.cht.tl.vo.TemsisVo;
import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;

import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;

@SpringBootApplication
@EnableEncryptableProperties
public class TemsisApplication /* implements CommandLineRunner */ {
//	@Resource
//    private static StringEncryptor jasyptStringEncryptor;
	
	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(TemsisApplication.class);
//		System.out.println( "加密密文：" + jasyptStringEncryptor.encrypt("Trevor242433") );
//        System.out.println("解密密文：" + jasyptStringEncryptor.decrypt(jasyptStringEncryptor.encrypt("Trevor242433")));
//		
//		TemsisDaoImpl temsisDaoImpl = new TemsisDaoImpl();
//		ArrayList<String> xmlList = temsisDaoImpl.getXmlsByCreatedTime("高雄市", "6/1/2021", "6/3/2021");
//		
////		String xml = "<EMSDataSet xmlns=\"http://temsis.org\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://temsis.org http://temsis.org/media/temsis_v1/release-1.1.0/XSDs/TEMSIS_XSDs/EMSDataSet.xsd\">\n"
////				+ "<PatientCareReport>\n"
////				+ "<eRecord>\n"
////				+ "<eRecord.T01>2021061110100613524701</eRecord.T01>\n"
////				+ "<eRecord.T02>101006</eRecord.T02>\n"
////				+ "<eRecord.T03>高雄市消防局緊急救護管理系統</eRecord.T03>\n"
////				+ "<eRecord.T04>1.0.0</eRecord.T04>\n"
////				+ "<eRecord.T05>1.1.0</eRecord.T05>\n"
////				+ "</eRecord>\n"
////				+ "<eResponse>\n"
////				+ "<eResponse.T01>655201</eResponse.T01>\n"
////				+ "<eResponse.T02>BDY-1639</eResponse.T02>\n"
////				+ "<eResponse.T03>101006_岡山91</eResponse.T03>\n"
////				+ "<eResponse.T08>102001</eResponse.T08>\n"
////				+ "<eResponse.T09 NV=\"7701001\" xsi:nil=\"true\"/>\n"
////				+ "</eResponse>\n"
////				+ "<eTimes>\n"
////				+ "<eTimes.T01>2021-06-11T13:52:47+08:00</eTimes.T01>\n"
////				+ "<eTimes.T03>2021-06-11T13:54:22+08:00</eTimes.T03>\n"
////				+ "<eTimes.T04>2021-06-11T14:00:09+08:00</eTimes.T04>\n"
////				+ "<eTimes.T06 NV=\"7701003\" xsi:nil=\"true\"/>\n"
////				+ "<eTimes.T07 NV=\"7701003\" xsi:nil=\"true\"/>\n"
////				+ "<eTimes.T08 NV=\"7701003\" xsi:nil=\"true\"/>\n"
////				+ "<eTimes.T09 NV=\"7701003\" xsi:nil=\"true\"/>\n"
////				+ "</eTimes>\n"
////				+ "<ePatient>\n"
////				+ "<ePatient.T01>吳宋盡</ePatient.T01>\n"
////				+ "<ePatient.T02>S201081007</ePatient.T02>\n"
////				+ "<ePatient.T03>106001</ePatient.T03>\n"
////				+ "<ePatient.T04>95</ePatient.T04>\n"
////				+ "<ePatient.T05>107001</ePatient.T05>\n"
////				+ "<ePatient.T06>1926-01-11</ePatient.T06>\n"
////				+ "<ePatient.T07>通校路226號</ePatient.T07>\n"
////				+ "<ePatient.T08>E</ePatient.T08>\n"
////				+ "<ePatient.T09>19</ePatient.T09>\n"
////				+ "</ePatient>\n"
////				+ "<eScene>\n"
////				+ "<eScene.T01>高雄市岡山區通校路226號</eScene.T01>\n"
////				+ "<eScene.T02>22.790703,120.281294</eScene.T02>\n"
////				+ "<eScene.T05>108001</eScene.T05>\n"
////				+ "</eScene>\n"
////				+ "<eSituation>\n"
////				+ "<eSituation.T01>109001</eSituation.T01>\n"
////				+ "<eSituation.T02>110008</eSituation.T02>\n"
////				+ "<eSituation.T06>1、感覺哪裡不舒服？發燒,2、感覺怎樣的不舒服？發燒,3、大約不舒服有多久了？半小時,4、還有哪些地方不舒服嗎？無</eSituation.T06>\n"
////				+ "</eSituation>\n"
////				+ "<eInjury>\n"
////				+ "<eInjury.T01 NV=\"7701001\" xsi:nil=\"true\"/>\n"
////				+ "<eInjury.T05 NV=\"7701001\" xsi:nil=\"true\"/>\n"
////				+ "</eInjury>\n"
////				+ "<eArrest>\n"
////				+ "<eArrest.T01>111001</eArrest.T01>\n"
////				+ "<eArrest.T04 NV=\"7701003\" xsi:nil=\"true\"/>\n"
////				+ "<eArrest.T05 NV=\"7701003\" xsi:nil=\"true\"/>\n"
////				+ "<eArrest.T06 NV=\"7701003\" xsi:nil=\"true\"/>\n"
////				+ "<eArrest.T07 NV=\"7701003\" xsi:nil=\"true\"/>\n"
////				+ "<eArrest.T08 NV=\"7701003\" xsi:nil=\"true\"/>\n"
////				+ "<eArrest.T13 NV=\"7701003\" xsi:nil=\"true\"/>\n"
////				+ "</eArrest>\n"
////				+ "<eHistory>\n"
////				+ "<eHistory.T01>117002</eHistory.T01>\n"
////				+ "<eHistory.T03>118002</eHistory.T03>\n"
////				+ "<eHistory.T05>119002</eHistory.T05>\n"
////				+ "<eHistory.T07>I25</eHistory.T07>\n"
////				+ "</eHistory>\n"
////				+ "<eNarrative>\n"
////				+ "<eNarrative.T01>病患表示發燒 呼吸喘</eNarrative.T01>\n"
////				+ "</eNarrative>\n"
////				+ "<eVitals>\n"
////				+ "<eVitals.VitalGroup>\n"
////				+ "<eVitals.T01>2021-06-11T14:01:09+08:00</eVitals.T01>\n"
////				+ "<eVitals.T02>120001</eVitals.T02>\n"
////				+ "<eVitals.T03>3326001</eVitals.T03>\n"
////				+ "<eVitals.T04>4</eVitals.T04>\n"
////				+ "<eVitals.T05>5</eVitals.T05>\n"
////				+ "<eVitals.T06>6</eVitals.T06>\n"
////				+ "<eVitals.T07>18</eVitals.T07>\n"
////				+ "<eVitals.T08>97</eVitals.T08>\n"
////				+ "<eVitals.T10>133</eVitals.T10>\n"
////				+ "<eVitals.T11>81</eVitals.T11>\n"
////				+ "<eVitals.T13>99</eVitals.T13>\n"
////				+ "<eVitals.T19>37</eVitals.T19>\n"
////				+ "</eVitals.VitalGroup>\n"
////				+ "<eVitals.VitalGroup>\n"
////				+ "<eVitals.T01>2021-06-11T14:11:51+08:00</eVitals.T01>\n"
////				+ "<eVitals.T02>120002</eVitals.T02>\n"
////				+ "<eVitals.T03>3326001</eVitals.T03>\n"
////				+ "<eVitals.T04>4</eVitals.T04>\n"
////				+ "<eVitals.T05>5</eVitals.T05>\n"
////				+ "<eVitals.T06>6</eVitals.T06>\n"
////				+ "<eVitals.T07>18</eVitals.T07>\n"
////				+ "<eVitals.T08>98</eVitals.T08>\n"
////				+ "<eVitals.T10>137</eVitals.T10>\n"
////				+ "<eVitals.T11>81</eVitals.T11>\n"
////				+ "<eVitals.T13>99</eVitals.T13>\n"
////				+ "<eVitals.T19>37</eVitals.T19>\n"
////				+ "</eVitals.VitalGroup>\n"
////				+ "<eVitals.VitalGroup>\n"
////				+ "<eVitals.T01>2021-06-11T14:11:51+08:00</eVitals.T01>\n"
////				+ "<eVitals.T02>120003</eVitals.T02>\n"
////				+ "<eVitals.T03>3326001</eVitals.T03>\n"
////				+ "<eVitals.T04>4</eVitals.T04>\n"
////				+ "<eVitals.T05>5</eVitals.T05>\n"
////				+ "<eVitals.T06>6</eVitals.T06>\n"
////				+ "<eVitals.T07>18</eVitals.T07>\n"
////				+ "<eVitals.T08>97</eVitals.T08>\n"
////				+ "<eVitals.T10>139</eVitals.T10>\n"
////				+ "<eVitals.T11>81</eVitals.T11>\n"
////				+ "<eVitals.T13>99</eVitals.T13>\n"
////				+ "<eVitals.T19>37</eVitals.T19>\n"
////				+ "</eVitals.VitalGroup>\n"
////				+ "</eVitals>\n"
////				+ "<eMedications>\n"
////				+ "<eMedications.MedicationGroup>\n"
////				+ "<eMedications.T01 NV=\"7701001\" xsi:nil=\"true\"/>\n"
////				+ "<eMedications.T02 NV=\"7701001\" xsi:nil=\"true\"/>\n"
////				+ "<eMedications.T03 NV=\"7701001\" xsi:nil=\"true\"/>\n"
////				+ "<eMedications.T04 NV=\"7701001\" xsi:nil=\"true\"/>\n"
////				+ "</eMedications.MedicationGroup>\n"
////				+ "</eMedications>\n"
////				+ "<eProcedures>\n"
////				+ "<eProcedures.ProcedureGroup>\n"
////				+ "<eProcedures.T01>127402</eProcedures.T01>\n"
////				+ "</eProcedures.ProcedureGroup>\n"
////				+ "</eProcedures>\n"
////				+ "<eDisposition>\n"
////				+ "<eDisposition.T02>0542020011</eDisposition.T02>\n"
////				+ "<eDisposition.T06>4220001</eDisposition.T06>\n"
////				+ "<eDisposition.T07>128001</eDisposition.T07>\n"
////				+ "<eDisposition.T09>129001</eDisposition.T09>\n"
////				+ "<eDisposition.T10 NV=\"7701005\" xsi:nil=\"true\"/>\n"
////				+ "</eDisposition>\n"
////				+ "<eCrew>\n"
////				+ "<eCrew.CrewGroup>\n"
////				+ "<eCrew.T02>105002</eCrew.T02>\n"
////				+ "</eCrew.CrewGroup>\n"
////				+ "<eCrew.CrewGroup>\n"
////				+ "<eCrew.T02>105003</eCrew.T02>\n"
////				+ "</eCrew.CrewGroup>\n"
////				+ "</eCrew>\n"
////				+ "<eOutcome>\n"
////				+ "<eOutcome.T01>131003</eOutcome.T01>\n"
////				+ "</eOutcome>\n"
////				+ "</PatientCareReport>\n"
////				+ "</EMSDataSet>";
//		ParseTemsis pts = new ParseTemsis();
//		System.out.println("Temsis record parse start");
//		List<TemsisVo> trList = new ArrayList<TemsisVo>();
//		
//		for(String xml : xmlList) {
//			TemsisVo vo = pts.parseTemsis(xml);
//			trList.add(vo);
//		}
//		
//		CsvExport exoprt = new CsvExport();
//		try {
//			exoprt.beanToCSVWithCustomHeaderAndPositionStrategy(trList);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
////		app.setBannerMode(Banner.Mode.OFF);
//		System.out.println("Temsis record parse finish");
		app.run(args);
	}

//	@Override
//	public void run(String... args) throws Exception {
//		while (args.length > 0) {
//            System.out.println("h1");
//        } 
//	}
}
