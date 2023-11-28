package com.cht.tl.util;

import java.io.File;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.LoggerContext;


public class Convert {
	private static final Logger m_logger = LogManager.getLogger(Convert.class);
//	protected static void logInit() {
//		String strLog4jConfigFilePath = Constant.getLog4jConfigFilePath();
//		//System.out.println("strLog4jConfigFilePath="+strLog4jConfigFilePath);
//        File fLog = new File(strLog4jConfigFilePath.replace("/", File.separator).replace("\\", File.separator));
//		if(fLog.exists()) {
//		    LoggerContext context = (org.apache.logging.log4j.core.LoggerContext) LogManager.getContext(false);
//		    context.setConfigLocation(fLog.toURI());
//		    m_logger.debug("OK to load log config file path: " + fLog.getAbsolutePath());
//		}else {
//			m_logger.debug("*** FAILED to load log4j config file path: "+ fLog.getAbsolutePath());
//		}
//	}
	
	public static String getArea(String area) {
		String result="";
		switch(area) { 
        case "101001":
        	result = "新北市";
            break; 
        case "101002":
        	result = "臺北市";
        	break;
        case "101003":
        	result = "桃園市";
        	break;
        case "101004":
        	result = "臺中市";
        	break;
        case "101005":
        	result = "臺南市";
        	break;
        case "101006":
        	result = "高雄市";
        	break;
        case "101007":
        	result = "宜蘭縣";
        	break;
        case "101008":
        	result = "新竹縣";
        	break;
        case "101009":
        	result = "苗栗縣";
        	break;
        case "101010":
        	result = "彰化縣";
        	break;
        case "101011":
        	result = "南投縣";
        	break;
        case "101012":
        	result = "雲林縣";
        	break;
        case "101013":
        	result = "嘉義縣";
        	break;
        case "101014":
        	result = "屏東縣";
        	break;
        case "101015":
        	result = "臺東縣";
        	break;
        case "101016":
        	result = "花蓮縣";
        	break;
        case "101017":
        	result = "澎湖縣";
        	break;
        case "101018":
        	result = "基隆市";
        	break;
        case "101019":
        	result = "新竹市";
        	break;
        case "101020":
        	result = "嘉義市";
        	break;
        case "101021":
        	result = "金門縣";
        	break;
        case "101022":
        	result = "連江縣";
        	break;
        case "101023":
        	result = "基隆港";
        	break;
        case "101024":
        	result = "臺中港";
        	break;
        case "101025":
        	result = "高雄港";
        	break;
        case "101026":
        	result = "花蓮港";        	
        	break;
        	
        default: 
        	result = area;
        	m_logger.info(WhiteBox.logForging("area無對應:"+area));
        	break;
		}
		return result;
	}
	
	public static String getVehicleDispatchCityCounty(String vehicleDispatchCityCounty) {
		String result=getCityCounty(vehicleDispatchCityCounty);
		if(result.equalsIgnoreCase(vehicleDispatchCityCounty)) {
			m_logger.info(WhiteBox.logForging("vehicleDispatchCityCounty無對應:"+vehicleDispatchCityCounty));
		}
		return result;
	}
	
	public static String getVehicleDispatchDistrict(String cityCounty, String vehicleDispatchDistrict) {
		String result=getDistrict(cityCounty, vehicleDispatchDistrict);
		if(result.equalsIgnoreCase(vehicleDispatchDistrict)) {
			m_logger.info(WhiteBox.logForging("vehicleDispatchDistrict無對應:"+vehicleDispatchDistrict));
		}
		return result;
	}
	
	public static String getDispatchType(String dispatchType) {
		String result="";
		if(dispatchType.equalsIgnoreCase("102001")) {
			result = "救災救護指揮中心";
		}else if(dispatchType.equalsIgnoreCase("102001")) {
			result = "分隊自行受理";
		}else {
			result = dispatchType;
			m_logger.info(WhiteBox.logForging("dispatchType無對應:"+dispatchType));
		}
		return result;
	}
	
	public static String getDispatchComplaint(String dispatchComplaint) {
		String result="";
		switch(dispatchComplaint) { 
        case "103101":
        	result = "心跳/呼吸停止";
            break; 
        case "103102":
        	result = "哽塞";
        	break;
        case "103103":
        	result = "呼吸問題";
        	break;
        case "103104":
        	result = "腦中風";
        	break;
        case "103105":
        	result = "抽搐／痙攣";
        	break;
        case "103106":
        	result = "認識的人意識不清/暈厥";
        	break;
        case "103107":
        	result = "心臟問題";
        	break;
        case "103108":
        	result = "糖尿病問題";
        	break;
        case "103109":
        	result = "胸痛";
        	break;
        case "103110":
        	result = "腹痛/腹部的問題";
			break;
		case "103111":
        	result = "頭痛";
            break; 
        case "103112":
        	result = "背痛";
        	break;
        case "103113":
        	result = "認識的有病的人/不明診斷";
        	break;
        case "103114":
        	result = "藥物過量/中毒";
        	break;
        case "103115":
        	result = "不認識的人/路倒";
        	break;
        case "103116":
        	result = "過敏/藥物反應/昆蟲叮咬";
        	break;
        case "103117":
        	result = "一氧化碳中毒/吸入/危險性物質";
        	break;
        case "103118":
        	result = "懷孕/生產/流產";
        	break;
        case "103119":
        	result = "精神/行為問題";
        	break;
        case "103120":
        	result = "非外傷性出血";
			break;
        case "103201":
        	result = "交通傷害意外事件";
            break; 
        case "103202":
        	result = "落下/跌倒摔傷";
        	break;
        case "103203":
        	result = "燒傷";
        	break;
        case "103204":
        	result = "刺/槍傷";
        	break;
        case "103205":
        	result = "外傷出血";
        	break;
        case "103206":
        	result = "工業/機械意外事件";
        	break;
        case "103207":
        	result = "眼睛問題";
        	break;
        case "103208":
        	result = "攻擊/強姦";
        	break;
        case "103209":
        	result = "熱/冷暴露";
        	break;
        case "103210":
        	result = "電擊";	
			break;
		case "103211":
        	result = "溺斃(溺水)/潛水意外事外";
            break; 
        case "103212":
        	result = "動物咬傷";
        	break;
        case "103213":
        	result = "特殊型創傷事件";
        	break;
        case "103214":
        	result = "頭部外傷";
        	break;
        case "103215":
        	result = "火場患者";
        	break;
        case "103216":
        	result = "現場待命";
        	break;
        case "103217":
        	result = "空中救護後轉送";
        	break;
        case "103218":
        	result = "流感/疫情";
        	break;
		case "103219":
			result = "其他";
			break;

        default: 
        	result = dispatchComplaint;
        	m_logger.info(WhiteBox.logForging("dispatchComplaint無對應:"+dispatchComplaint));
        	break;
		}
		return result;
	}
	
	public static String getDispatchLevel(String dispatchLevel) {
		String result="";
		if(dispatchLevel.equalsIgnoreCase("2305001")) {
			result = "OHCA";
		}else if(dispatchLevel.equalsIgnoreCase("2305003")) {
			result = "ALS";
		}else if(dispatchLevel.equalsIgnoreCase("2305005")) {
			result = "BLS";
		}else if(dispatchLevel.equalsIgnoreCase("2305007")) {
			result = "其他";
		}else {
			result = dispatchLevel;
			m_logger.info(WhiteBox.logForging("dispatchLevel無對應:"+dispatchLevel));
		}
		return result;
	}
	
	public static String getDispatchResponseMode(String dispatchResponseMode) {
		String result="";
		if(dispatchResponseMode.equalsIgnoreCase("104001")) {
			result = "一般";
		}else if(dispatchResponseMode.equalsIgnoreCase("104002")) {
			result = "快速";
		}else {
			result = dispatchResponseMode;
			m_logger.info(WhiteBox.logForging("dispatchResponseMode無對應:"+dispatchResponseMode));
		}
		return result;
	}
	
	public static String getCrewLevel(String crewLevel) {
		String result="";
		if(crewLevel.equalsIgnoreCase("105001")) {
			result = "EMT1";
		}else if(crewLevel.equalsIgnoreCase("105002")) {
			result = "EMT2";
		}else if(crewLevel.equalsIgnoreCase("105003")) {
			result = "EMTP";
		}else if(crewLevel.equalsIgnoreCase("105004")) {
			result = "護理人員";
		}else if(crewLevel.equalsIgnoreCase("105005")) {
			result = "醫師";
		}else if(crewLevel.equalsIgnoreCase("105006")) {
			result = "其他";
		}else {
			result = crewLevel;
			m_logger.info(WhiteBox.logForging("crewLevel無對應:"+crewLevel));
		}
		return result;
	}
	
	public static String getPpatientGender(String patientGender) {
		String result="";
		if(patientGender.equalsIgnoreCase("106001")) {
			result = "男";
		}else if(patientGender.equalsIgnoreCase("106002")) {
			result = "女";
		}else {
			result = patientGender;
			m_logger.info(WhiteBox.logForging("patientGender無對應:"+patientGender));
		}
		return result;
	}
	
	public static String getPatientAgeUnit(String patientAgeUnit) {
		String result="";
		if(patientAgeUnit.equalsIgnoreCase("107001")) {
			result = "歲";
		}else if(patientAgeUnit.equalsIgnoreCase("107002")) {
			result = "月";
		}else if(patientAgeUnit.equalsIgnoreCase("107003")) {
			result = "週";
		}else if(patientAgeUnit.equalsIgnoreCase("107004")) {
			result = "天";
		}else {
			result = patientAgeUnit;
			m_logger.info(WhiteBox.logForging("patientAgeUnit無對應:"+patientAgeUnit));
		}
		return result;
	}
	
	public static String getPatientHomeCityCounty(String patientHomeCityCounty) {
		String result=getCityCounty(patientHomeCityCounty);
		if(result.equalsIgnoreCase(patientHomeCityCounty)) {
			m_logger.info(WhiteBox.logForging("patientHomeCityCounty無對應:"+patientHomeCityCounty));
		}
		return result;
	}
	
	public static String getPatientHomeDistrict(String cityCounty, String patientHomeDistrict) {
		String result=getDistrict(cityCounty, patientHomeDistrict);
		if(result.equalsIgnoreCase(patientHomeDistrict)) {
			m_logger.info(WhiteBox.logForging("patientHomeDistrict無對應:"+patientHomeDistrict));
		}
		return result;
	}
	
	public static String getSceneCityCounty(String sceneCityCounty) {
		String result=getCityCounty(sceneCityCounty);
		if(result.equalsIgnoreCase(sceneCityCounty)) {
			m_logger.info(WhiteBox.logForging("sceneCityCounty無對應:"+sceneCityCounty));
		}
		return result;
	}
	
	public static String getSceneDistrict(String cityCounty, String sceneDistrict) {
		String result=getDistrict(cityCounty, sceneDistrict);
		if(result.equalsIgnoreCase(sceneDistrict)) {
			m_logger.info(WhiteBox.logForging("sceneDistrict無對應:"+sceneDistrict));
		}
		return result;
	}
	
	
	public static String getIsMCIString(String isMCI) {
		String result="";
		if(isMCI.equalsIgnoreCase("108001")) {
			result = "否";
		}else if(isMCI.equalsIgnoreCase("108002")) {
			result = "是";
		}else {
			result = isMCI;
			m_logger.info(WhiteBox.logForging("isMCI無對應:"+isMCI));
		}
		return result;
	}
	
	public static int getIsMCI(String isMCI) {
		int result=0;
		if(isMCI.equalsIgnoreCase("108001")) {
			result = 0;
		}else if(isMCI.equalsIgnoreCase("108002")) {
			result = 1;
		}else {
			result = 0;
			m_logger.info(WhiteBox.logForging("isMCI無對應:"+isMCI));
		}
		return result;
	}
	
	public static String getIsPossibleTrauma(String isPossibleTrauma) {
		String result="";
		if(isPossibleTrauma.equalsIgnoreCase("109001")) {
			result = "否";
		}else if(isPossibleTrauma.equalsIgnoreCase("109002")) {
			result = "是";
		}else {
			result = isPossibleTrauma;
			m_logger.info(WhiteBox.logForging("isPossibleTrauma無對應:"+isPossibleTrauma));
		}
		return result;
	}
	
	public static int getIsTrauma(String isTrauma) {
		int result=0;
		if(isTrauma.equalsIgnoreCase("109001")) {
			result = 0;
		}else if(isTrauma.equalsIgnoreCase("109002")) {
			result = 1;
		}else {
			result = 0;
			m_logger.info(WhiteBox.logForging("isTrauma(isPossibleTrauma)無對應:"+isTrauma));
		}
		return result;
	}
	
	public static String getSituationPrimaryCategory(String situationPrimaryCategory) {
		String result=getSituationCategory(situationPrimaryCategory);
		if(result.equalsIgnoreCase(situationPrimaryCategory)) {
			m_logger.info(WhiteBox.logForging("situationPrimaryCategory無對應:"+situationPrimaryCategory));
		}
		return result;
	}
	
	public static String getSituationOtherAssociatedCategories(String situationOtherAssociatedCategories) {
		String result=getSituationCategory(situationOtherAssociatedCategories);
		if(result.equalsIgnoreCase(situationOtherAssociatedCategories)) {
			m_logger.info(WhiteBox.logForging("situationOtherAssociatedCategories無對應:"+situationOtherAssociatedCategories));
		}
		return result;
	}
	
	public static String getPrimarySymptom(String primarySymptom) {
		String result=getSymptom(primarySymptom);
		if(result.equalsIgnoreCase(primarySymptom)) {
			m_logger.info(WhiteBox.logForging("primarySymptom無對應:"+primarySymptom));
		}
		return result;
	}
	
	public static String getOtherAssociatedSymptoms(String otherAssociatedSymptoms) {
		String result=getSymptom(otherAssociatedSymptoms);
		if(result.equalsIgnoreCase(otherAssociatedSymptoms)) {
			m_logger.info(WhiteBox.logForging("otherAssociatedSymptoms無對應:"+otherAssociatedSymptoms));
		}
		return result;
	}
	
	public static String getInjuryCause(String injuryCause) {
		String result="";
		if(injuryCause.equalsIgnoreCase("V99")) {
			result = "交通事故";
		}else if(injuryCause.equalsIgnoreCase("V49.9")) {
			result = "車禍機轉-汽車";
		}else if(injuryCause.equalsIgnoreCase("V29.9")) {
			result = "車禍機轉-機車";
		}else if(injuryCause.equalsIgnoreCase("V19.9")) {
			result = "車禍機轉-自行車";
		}else if(injuryCause.equalsIgnoreCase("V01")) {
			result = "車禍機轉-行人：行人與腳踏車";
		}else if(injuryCause.equalsIgnoreCase("V02")) {
			result = "車禍機轉-行人：行人與二輪或三輪摩托車";
		}else if(injuryCause.equalsIgnoreCase("V03")) {
			result = "車禍機轉-行人：行人與汽車、小貨車或廂型車碰撞";
		}else if(injuryCause.equalsIgnoreCase("V09")) {
			result = "車禍機轉-行人：行人與非特定交通意外中受傷";
		}else if(injuryCause.equalsIgnoreCase("W19")) {
			result = "墜落";
		}else if(injuryCause.equalsIgnoreCase("W31.9")) {
			result = "工業/機械意外事件";
		}else if(injuryCause.equalsIgnoreCase("X99.9")) {
			result = "穿刺傷";
		}else if(injuryCause.equalsIgnoreCase("W23")) {
			result = "壓碾傷";
		}else if(injuryCause.equalsIgnoreCase("T75.4")) {
			result = "電擊傷";
		}else if(injuryCause.equalsIgnoreCase("W69")) {
			result = "溺水";
		}else if(injuryCause.equalsIgnoreCase("W01")) {
			result = "摔跌傷";
		}else if(injuryCause.equalsIgnoreCase("W64")) {
			result = "螫咬傷";
		}else if(injuryCause.equalsIgnoreCase("T14.90")) {
			result = "其他創傷外因";
		}else {
			result = injuryCause;
			m_logger.info(WhiteBox.logForging("injuryCause無對應:"+injuryCause));
		}
		return result;
	}
	
	public static String getInjuryMechanism(String injuryMechanism) {
		String result="";
		if(injuryMechanism.equalsIgnoreCase("2902001")) {
			result = "鈍傷(Blunt)";
		}else if(injuryMechanism.equalsIgnoreCase("2902001")) {
			result = "燒燙傷(Burn)";
		}else if(injuryMechanism.equalsIgnoreCase("2902007")) {
			result = "穿刺傷(Penetrating)";
		}else if(injuryMechanism.equalsIgnoreCase("2902005")) {
			result = "其他(Other)";
		}else {
			result = injuryMechanism;
			m_logger.info(WhiteBox.logForging("injuryMechanism無對應:"+injuryMechanism));
		}
		return result;
	}
	
	
	
	public static String getTraumaCenterCriteria(String traumaCenterCriteria) {
		String result="";
		switch(traumaCenterCriteria) { 
        case "2903007":
        	result = "意識GCS<=13";
            break; 
        case "2903017":
        	result = "呼吸速率>=30/min或<10/min";
            break; 
		case "2903801*":
        	result = "脈搏>=140/min或<50/min";
            break; 
		case "2903802*":
        	result = "收縮壓>=220mmHg";
            break; 
        case "2903019":
        	result = "收縮壓<90mmHg";
            break; 
		case "2903803*":
        	result = "微血管填充CRT>=2secs";
            break; 
		case "2903804*":
        	result = "體溫>=40或<32";
            break; 
        case "2903805*":
        	result = "血氧SpO2<90%";
            break; 
		case "2903807*":
        	result = "二度或三度燒傷面積>=18%";
            break; 
		case "2903808*":
        	result = "顏面或會陰燒傷";
            break; 
        case "2903809*":
        	result = "大量皮下氣腫";
            break; 
		case "2903001":
        	result = "手腕或腳踝以上截肢";
            break; 
		case "2903810*":
        	result = "大而深的傷口";
            break; 
        case "2903015":
        	result = "頭頸胸腹鼠蹊部穿刺傷或開放性傷口";
            break; 
		case "2903005":
        	result = "連枷胸";
            break; 
		case "2903811*":
        	result = "腦組織或臟器外露";
            break; 
        case "2903011":
        	result = "頭部或脊椎傷害併肢體癱瘓";
            break; 
		case "2903009":
        	result = "長骨開放性骨折";
            break; 
		case "2903021":
        	result = "兩處以上長骨";
            break; 
        case "2903013":
        	result = "骨盆骨折";
            break; 
		case "2903812*":
        	result = "高處墜落>=6m或>=2層樓";
            break; 
		case "2903813*":
        	result = "脫困時間>=20min";
            break; 
        case "2903814*":
        	result = "身體被車輛輾過";
            break; 
		case "2903815*":
        	result = "從車內拋出或其他高能量撞擊";
            break; 

        default: 
        	result = traumaCenterCriteria;
        	m_logger.info(WhiteBox.logForging("traumaCenterCriteria無對應:"+traumaCenterCriteria));
        	break;
		}
		return result;
	}
	
	public static String getUseSafetyEquipment(String useSafetyEquipment) {
		String result="";
		if(useSafetyEquipment.equalsIgnoreCase("2907015")) {
			result = "沒有使用";
		}else if(useSafetyEquipment.equalsIgnoreCase("2907005")) {
			result = "安全帽";
		}else if(useSafetyEquipment.equalsIgnoreCase("2907001")) {
			result = "兒童安全座椅-椅墊式";
		}else if(useSafetyEquipment.equalsIgnoreCase("2907007")) {
			result = "嬰兒安全座椅-面向前";;
		}else if(useSafetyEquipment.equalsIgnoreCase("2907009")) {
			result = "嬰兒安全座椅-面向後";
		}else if(useSafetyEquipment.equalsIgnoreCase("2907027")) {
			result = "安全帶";
		}else {
			result = useSafetyEquipment;
			m_logger.info(WhiteBox.logForging("useSafetyEquipment無對應:"+useSafetyEquipment));
		}
		return result;
	}
	
	public static String getIsCardiacArrest(String isCardiacArrest) {
		String result="";
		if(isCardiacArrest.equalsIgnoreCase("111001")) {
			result = "否";
		}else if(isCardiacArrest.equalsIgnoreCase("111002")) {
			result = "是";
		}else {
			result = isCardiacArrest;
			m_logger.info(WhiteBox.logForging("isCardiacArrest無對應:"+isCardiacArrest));
		}
		return result;
	}
	
	public static int getIsOhca(String IsOhca) {
		int result=0;
		if(IsOhca.equalsIgnoreCase("111001")) {
			result = 0;
		}else if(IsOhca.equalsIgnoreCase("111002")) {
			result = 1;
		}else {
			result = 0;
			m_logger.info(WhiteBox.logForging("IsOhca(isCardiacArrest)無對應:"+IsOhca));
		}
		return result;
	}
	
	public static String getPossibleOHCAEtiology(String possibleOHCAEtiology) {
		String result="";
		if(possibleOHCAEtiology.equalsIgnoreCase("3002001")) {
			result = "疑似心因性";
		}else if(possibleOHCAEtiology.equalsIgnoreCase("3002003")) {
			result = "溺水";
		}else if(possibleOHCAEtiology.equalsIgnoreCase("3002005")) {
			result = "藥物過量";
		}else if(possibleOHCAEtiology.equalsIgnoreCase("3002007")) {
			result = "電擊";
		}else if(possibleOHCAEtiology.equalsIgnoreCase("3002009")) {
			result = "失血";
		}else if(possibleOHCAEtiology.equalsIgnoreCase("3002013")) {
			result = "呼吸相關(異物梗塞)";
		}else if(possibleOHCAEtiology.equalsIgnoreCase("3002015")) {
			result = "創傷";
		}else if(possibleOHCAEtiology.equalsIgnoreCase("3002011")) {
			result = "其他";
		}else {
			result = possibleOHCAEtiology;
			m_logger.info(WhiteBox.logForging("possibleOHCAEtiology無對應:"+possibleOHCAEtiology));
		}
		return result;
	}
	
	public static String getResuscitationAttemptedByEMS(String resuscitationAttemptedByEMS) {
		String result="";
		if(resuscitationAttemptedByEMS.equalsIgnoreCase("3003001")) {
			result = "試圖急救 - 去顫";
		}else if(resuscitationAttemptedByEMS.equalsIgnoreCase("3003003")) {
			result = "試圖急救 - 通氣";
		}else if(resuscitationAttemptedByEMS.equalsIgnoreCase("3003005")) {
			result = "試圖急救 - 壓胸";
		}else if(resuscitationAttemptedByEMS.equalsIgnoreCase("3003007")) {
			result = "未試圖急救 - 考慮急救無用";
		}else if(resuscitationAttemptedByEMS.equalsIgnoreCase("3003009")) {
			result = "未試圖急救 - DNR";
		}else if(resuscitationAttemptedByEMS.equalsIgnoreCase("3003010")) {
			result = "未試圖急救 - 家屬放棄急救";
		}else {
			result = resuscitationAttemptedByEMS;
			m_logger.info(WhiteBox.logForging("resuscitationAttemptedByEMS無對應:"+resuscitationAttemptedByEMS));
		}
		return result;
	}
	
	public static String getArrestWitnessedBy(String arrestWitnessedBy) {
		String result="";
		if(arrestWitnessedBy.equalsIgnoreCase("112001")) {
			result = "無";
		}else if(arrestWitnessedBy.equalsIgnoreCase("112002")) {
			result = "有，家人";
		}else if(arrestWitnessedBy.equalsIgnoreCase("112003")) {
			result = "有，民眾";
		}else if(arrestWitnessedBy.equalsIgnoreCase("112004")) {
			result = "有，EMS";
		}else if(arrestWitnessedBy.equalsIgnoreCase("112005")) {
			result = "有，不知道或不確定";
		}else if(arrestWitnessedBy.equalsIgnoreCase("112006")) {
			result = "有，舊制";
		}else {
			result = arrestWitnessedBy;
			m_logger.info(WhiteBox.logForging("arrestWitnessedBy無對應:"+arrestWitnessedBy));
		}
		return result;
	}
	
	public static String getIsCPRPriorEMSArrival(String isCPRPriorEMSArrival) {
		String result="";
		if(isCPRPriorEMSArrival.equalsIgnoreCase("113001")) {
			result = "無";
		}else if(isCPRPriorEMSArrival.equalsIgnoreCase("113002")) {
			result = "有";
		}else {
			result = isCPRPriorEMSArrival;
			m_logger.info(WhiteBox.logForging("isCPRPriorEMSArrival無對應:"+isCPRPriorEMSArrival));
		}
		return result;
	}
	
	public static String getIsUsePADPriorEMSArrival(String isUsePADPriorEMSArrival) {
		String result="";
		if(isUsePADPriorEMSArrival.equalsIgnoreCase("114001")) {
			result = "無";
		}else if(isUsePADPriorEMSArrival.equalsIgnoreCase("114002")) {
			result = "有";
		}else {
			result = isUsePADPriorEMSArrival;
			m_logger.info(WhiteBox.logForging("isUsePADPriorEMSArrival無對應:"+isUsePADPriorEMSArrival));
		}
		return result;
	}
	
	public static String getIsROSC(String isROSC) {
		String result="";
		if(isROSC.equalsIgnoreCase("115001")) {
			result = "無";
		}else if(isROSC.equalsIgnoreCase("115002")) {
			result = "有";
		}else {
			result = isROSC;
			m_logger.info(WhiteBox.logForging("isROSC無對應:"+isROSC));
		}
		return result;
	}
	
	public static String getOHCAtLocationType(String OHCAtLocationType) {
		String result="";
		if(OHCAtLocationType.equalsIgnoreCase("116001")) {
			result = "住宅";
		}else if(OHCAtLocationType.equalsIgnoreCase("116002")) {
			result = "工廠/工作地點";
		}else if(OHCAtLocationType.equalsIgnoreCase("116003")) {
			result = "運動中心";
		}else if(OHCAtLocationType.equalsIgnoreCase("116004")) {
			result = "街道/公路";
		}else if(OHCAtLocationType.equalsIgnoreCase("116005")) {
			result = "公共建築";
		}else if(OHCAtLocationType.equalsIgnoreCase("116006")) {
			result = "療養院";
		}else if(OHCAtLocationType.equalsIgnoreCase("116007")) {
			result = "教育/學校";
		}else if(OHCAtLocationType.equalsIgnoreCase("116008")) {
			result = "捷運站/車站/機場";
		}else if(OHCAtLocationType.equalsIgnoreCase("116009")) {
			result = "診所/護理之家";
		}else if(OHCAtLocationType.equalsIgnoreCase("116010")) {
			result = "其他";
		}else if(OHCAtLocationType.equalsIgnoreCase("116011")) {
			result = "不清楚";
		}else {
			result = OHCAtLocationType;
			m_logger.info(WhiteBox.logForging("OHCAtLocationType無對應:"+OHCAtLocationType));
		}
		return result;
	}
	
	public static String getWhoCPRPriorEMSArrival(String whoCPRPriorEMSArrival) {
		String result="";
		if(whoCPRPriorEMSArrival.equalsIgnoreCase("3006001")) {
			result = "家人";
		}else if(whoCPRPriorEMSArrival.equalsIgnoreCase("3006003")) {
			result = "緊急應變人員";
		}else if(whoCPRPriorEMSArrival.equalsIgnoreCase("3006005")) {
			result = "非EMS之醫護人員";
		}else if(whoCPRPriorEMSArrival.equalsIgnoreCase("3006007")) {
			result = "旁人";
		}else if(whoCPRPriorEMSArrival.equalsIgnoreCase("3006009")) {
			result = "EMS之醫護人員";
		}else {
			result = whoCPRPriorEMSArrival;
			m_logger.info(WhiteBox.logForging("whoCPRPriorEMSArrival無對應:"+whoCPRPriorEMSArrival));
		}
		return result;
	}
	
	public static String getTypeCPRPriorEMSArrival(String typeCPRPriorEMSArrival) {
		String result="";
		if(typeCPRPriorEMSArrival.equalsIgnoreCase("3009001")) {
			result = "壓胸only";
		}else if(typeCPRPriorEMSArrival.equalsIgnoreCase("3009009")) {
			result = "壓胸與通氣";
		}else {
			result = typeCPRPriorEMSArrival;
			m_logger.info(WhiteBox.logForging("typeCPRPriorEMSArrival無對應:"+typeCPRPriorEMSArrival));
		}
		return result;
	}
	
	public static String getFirstArrestRhythm(String firstArrestRhythm) {
		String result="";
		if(firstArrestRhythm.equalsIgnoreCase("3011001")) {
			result = "Asystole";
		}else if(firstArrestRhythm.equalsIgnoreCase("3011005")) {
			result = "PEA";
		}else if(firstArrestRhythm.equalsIgnoreCase("3011011")) {
			result = "VF";
		}else if(firstArrestRhythm.equalsIgnoreCase("3011013")) {
			result = "VT";
		}else if(firstArrestRhythm.equalsIgnoreCase("3011007")) {
			result = "未知不可去顫心律";
		}else if(firstArrestRhythm.equalsIgnoreCase("3011009")) {
			result = "未知可去顫心率";
		}else {
			result = firstArrestRhythm;
			m_logger.info(WhiteBox.logForging("firstArrestRhythm無對應:"+firstArrestRhythm));
		}
		return result;
	}
	
	public static String getAarrivalArrestRhythm(String arrivalArrestRhythm) {
		String result="";
		switch(arrivalArrestRhythm) { 
        case "9901001":
        	result = "Agonal/Idioventricular";
            break; 
		case "9901003":
        	result = "Asystole";
            break;			
		case "9901005":
        	result = "Artifact";
            break;
		case "9901007":
        	result = "Atrial Fibrillation";
            break; 
		case "9901009":
        	result = "Atrial Flutter";
            break;			
		case "9901011":
        	result = "AV Block-1st Degree";
            break; 
		case "9901013":
        	result = "AV Block-2nd Degree-Type 1";
            break;			
		case "9901015":
        	result = "AV Block-2nd Degree-Type 2";
            break;
		case "9901017":
        	result = "AV Block-3rd Degree";
            break; 
		case "9901019":
        	result = "Junctional";
            break;
		case "9901021":
        	result = "Left Bundle Branch Block";
            break; 
		case "9901023":
        	result = "Non-STEMI Anterior Ischemia";
            break;			
		case "9901025":
        	result = "Non-STEMI Inferior Ischemia";
            break;
		case "9901027":
        	result = "Non-STEMI Lateral Ischemia";
            break; 
		case "9901029":
        	result = "Non-STEMI Posterior Ischemia";
            break;
		case "9901031":
        	result = "Other";
            break; 
		case "9901033":
        	result = "Paced Rhythm";
            break;			
		case "9901035":
        	result = "PEA";
            break;
		case "9901037":
        	result = "Premature Atrial Contractions";
            break; 
		case "9901039":
        	result = "Premature Ventricular Contractions";
            break;
		case "9901041":
        	result = "Right Bundle Branch Block";
            break; 
		case "9901043":
        	result = "Sinus Arrhythmia";
            break;			
		case "9901045":
        	result = "Sinus Bradycardia";
            break;
		case "9901047":
        	result = "Sinus Rhythm";
            break; 
		case "9901049":
        	result = "Sinus Tachycardia";
            break;
        case "9901051":
        	result = "STEMI Anterior Ischemia";
            break; 
		case "9901053":
        	result = "STEMI Inferior Ischemia";
            break;			
		case "9901055":
        	result = "STEMI Lateral Ischemia";
            break;
		case "9901057":
        	result = "STEMI Posterior Ischemia";
            break; 
		case "9901059":
        	result = "Supraventricular Tachycardia";
            break;
		case "9901061":
        	result = "Torsades De Points";
            break; 
		case "9901063":
        	result = "Unknown AED Non-Shockable Rhythm";
            break;			
		case "9901065":
        	result = "Unknown AED Shockable Rhythm";
            break;
		case "9901067":
        	result = "Ventricular Fibrillation";
            break; 
		case "9901069":
        	result = "Ventricular Tachycardia (With Pulse)";
            break;
		case "9901071":
        	result = "Ventricular Tachycardia (Pulseless)";
            break;


        default: 
        	result = arrivalArrestRhythm;
        	m_logger.info(WhiteBox.logForging("arrivalArrestRhythm無對應:"+arrivalArrestRhythm));
        	break;
		}
		return result;
	}
	
	public static String getIsMedicationAllergies(String isMedicationAllergies) {
		String result="";
		if(isMedicationAllergies.equalsIgnoreCase("117001")) {
			result = "是";
		}else if(isMedicationAllergies.equalsIgnoreCase("117002")) {
			result = "否";
		}else if(isMedicationAllergies.equalsIgnoreCase("117003")) {
			result = "不清楚";
		}else {
			result = isMedicationAllergies;
			m_logger.info(WhiteBox.logForging("isMedicationAllergies無對應:"+isMedicationAllergies));
		}
		return result;
	}
	
	public static String getMedicationAllergies(String medicationAllergies) {
		String result="";
		if(medicationAllergies.equalsIgnoreCase("Z88.0")) {
			result = "對盤尼西林過敏狀態";
		}else if(medicationAllergies.equalsIgnoreCase("Z88.1")) {
			result = "對其他抗生素過敏狀態";
		}else if(medicationAllergies.equalsIgnoreCase("Z88.2")) {
			result = "對磺醯胺過敏狀態";
		}else if(medicationAllergies.equalsIgnoreCase("Z88.3")) {
			result = "對其他抗感染藥物過敏狀態";
		}else if(medicationAllergies.equalsIgnoreCase("Z88.4")) {
			result = "對麻醉劑過敏狀態";
		}else if(medicationAllergies.equalsIgnoreCase("Z88.5")) {
			result = "對麻醉止痛藥劑過敏狀態";
		}else if(medicationAllergies.equalsIgnoreCase("Z88.6")) {
			result = "對止痛劑過敏狀態";
		}else if(medicationAllergies.equalsIgnoreCase("Z88.7")) {
			result = "對血清或疫苗過敏狀態";
		}else if(medicationAllergies.equalsIgnoreCase("Z88.8")) {
			result = "對其他藥物及藥劑及生物性物質(製劑、製品、材料)過敏狀態";
		}else if(medicationAllergies.equalsIgnoreCase("Z88.9")) {
			result = "對未明示藥物、藥劑及生物性物質(製劑、製品、材料)過敏狀態";
		}else {
			result = medicationAllergies;
			m_logger.info(WhiteBox.logForging("medicationAllergies無對應:"+medicationAllergies));
		}
		return result;
	}
	
	public static String getIsFoodAllergies(String isFoodAllergies) {
		String result="";
		if(isFoodAllergies.equalsIgnoreCase("118001")) {
			result = "是";
		}else if(isFoodAllergies.equalsIgnoreCase("118002")) {
			result = "否";
		}else if(isFoodAllergies.equalsIgnoreCase("118003")) {
			result = "不清楚";
		}else {
			result = isFoodAllergies;
			m_logger.info(WhiteBox.logForging("isFoodAllergies無對應:"+isFoodAllergies));
		}
		return result;
	}
	
	public static String getFoodAllergies(String foodAllergies) {
		String result="";
		if(foodAllergies.equalsIgnoreCase("Z91.010")) {
			result = "花生過敏 ";
		}else if(foodAllergies.equalsIgnoreCase("Z91.011")) {
			result = "奶製品過敏 ";
		}else if(foodAllergies.equalsIgnoreCase("Z91.012")) {
			result = "蛋製品過敏";
		}else if(foodAllergies.equalsIgnoreCase("Z91.013")) {
			result = "海鮮過敏 ";
		}else if(foodAllergies.equalsIgnoreCase("Z91.018")) {
			result = "其他食物過敏";
		}else {
			result = foodAllergies;
			m_logger.info(WhiteBox.logForging("foodAllergies無對應:"+foodAllergies));
		}
		return result;
	}
	
	public static String getIsOtherAllergies(String isOtherAllergies) {
		String result="";
		if(isOtherAllergies.equalsIgnoreCase("119001")) {
			result = "是";
		}else if(isOtherAllergies.equalsIgnoreCase("119002")) {
			result = "否";
		}else if(isOtherAllergies.equalsIgnoreCase("119003")) {
			result = "不清楚";
		}else {
			result = isOtherAllergies;
			m_logger.info(WhiteBox.logForging("isOtherAllergies無對應:"+isOtherAllergies));
		}
		return result;
	}
	
	public static String getOtherAllergies(String otherAllergies) {
		String result="";
		if(otherAllergies.equalsIgnoreCase("Z91.030")) {
			result = "蜜蜂過敏狀態";
		}else if(otherAllergies.equalsIgnoreCase("Z91.02")) {
			result = "食物添加劑過敏狀態";
		}else if(otherAllergies.equalsIgnoreCase("Z91.040")) {
			result = "合成乳膠過敏狀態";
		}else if(otherAllergies.equalsIgnoreCase("Z91.09")) {
			result = "其他過敏狀態，除了藥物及生物性物質(製劑、製品、材料)";
		}else if(otherAllergies.equalsIgnoreCase("Z91.038")) {
			result = "其他昆蟲過敏狀態";
		}else if(otherAllergies.equalsIgnoreCase("Z91.048")) {
			result = "其他非藥物物質過敏狀態";
		}else if(otherAllergies.equalsIgnoreCase("Z91.041")) {
			result = "放射顯影劑過敏狀態";
		}else {
			result = otherAllergies;
			m_logger.info(WhiteBox.logForging("otherAllergies無對應:"+otherAllergies));
		}
		return result;
	}
	
	public static String getPastMedicalSurgicalHistory(String pastMedicalSurgicalHistory) {
		String result="";
		if(pastMedicalSurgicalHistory.equalsIgnoreCase("E11")) {
			result = "糖尿病";
		}else if(pastMedicalSurgicalHistory.equalsIgnoreCase("I10")) {
			result = "高血壓";
		}else if(pastMedicalSurgicalHistory.equalsIgnoreCase("C80")) {
			result = "癌症";
		}else if(pastMedicalSurgicalHistory.equalsIgnoreCase("J44.9")) {
			result = "慢性阻塞性肺病";
		}else if(pastMedicalSurgicalHistory.equalsIgnoreCase("J45")) {
			result = "氣喘";
		}else if(pastMedicalSurgicalHistory.equalsIgnoreCase("I69")) {
			result = "中風";
		}else if(pastMedicalSurgicalHistory.equalsIgnoreCase("K77")) {
			result = "肝臟疾病";
		}else if(pastMedicalSurgicalHistory.equalsIgnoreCase("N18")) {
			result = "腎臟疾病";
		}else if(pastMedicalSurgicalHistory.equalsIgnoreCase("I25")) {
			result = "心臟疾病";
		}else if(pastMedicalSurgicalHistory.equalsIgnoreCase("G40")) {
			result = "癲癇";
		}else if(pastMedicalSurgicalHistory.equalsIgnoreCase("F39")) {
			result = "精神疾病";
		}else if(pastMedicalSurgicalHistory.equalsIgnoreCase("135001")) {
			result = "其他";
		}else {
			result = pastMedicalSurgicalHistory;
			m_logger.info(WhiteBox.logForging("pastMedicalSurgicalHistory無對應:"+pastMedicalSurgicalHistory));
		}
		return result;
	}
	
	public static String getVitalSignsTakenPhase(String vitalSignsTakenPhase) {
		String result="";
		if(vitalSignsTakenPhase.equalsIgnoreCase("120001")) {
			result = "現場";
		}else if(vitalSignsTakenPhase.equalsIgnoreCase("120002")) {
			result = "運送中";
		}else if(vitalSignsTakenPhase.equalsIgnoreCase("120003")) {
			result = "到院檢傷";
		}else {
			result = vitalSignsTakenPhase;
			m_logger.info(WhiteBox.logForging("vitalSignsTakenPhase無對應:"+vitalSignsTakenPhase));
		}
		return result;
	}
	
	public static String getResponsivenessLevel(String responsivenessLevel) {
		String result="";
		if(responsivenessLevel.equalsIgnoreCase("3326001")) {
			result = "清醒";
		}else if(responsivenessLevel.equalsIgnoreCase("3326003")) {
			result = "對聲音有反應";
		}else if(responsivenessLevel.equalsIgnoreCase("3326005")) {
			result = "對痛有反應";
		}else if(responsivenessLevel.equalsIgnoreCase("3326007")) {
			result = "無意識";
		}else {
			result = responsivenessLevel;
			m_logger.info(WhiteBox.logForging("responsivenessLevel無對應:"+responsivenessLevel));
		}
		return result;
	}
	
	public static String getGCSEye(String GCSEye) {
	String result="";
	if(GCSEye.equalsIgnoreCase("4")) {
		result = "自然睜眼(Opens Eyes spontaneously)";
	}else if(GCSEye.equalsIgnoreCase("3")) {
		result = "呼喚會睜眼(Opens Eyes to verbal stimulation)";
	}else if(GCSEye.equalsIgnoreCase("2")) {
		result = "有刺激或痛楚會睜眼(Opens Eyes to painful stimulation)";
	}else if(GCSEye.equalsIgnoreCase("1")) {
		result = "對於刺激無反應(No eye movement when assessed)";
	}else if(GCSEye.equalsIgnoreCase("C")) {
		result = "眼腫無法睜眼";
	}else {
		result = GCSEye;
		m_logger.info(WhiteBox.logForging("GCSEye無對應:"+GCSEye));
	}
	return result;
}

public static String getGCSVerbal(String GCSVerbal) {
	String result="";
	if(GCSVerbal.equalsIgnoreCase("5")) {
		result = "說話有條理（Oriented (>2 Years); Smiles, oriented to sounds, follows objects, interacts)";
	}else if(GCSVerbal.equalsIgnoreCase("4")) {
		result = "可應答，但有答非所問的情形(Confused (>2 Years); Cries but is consolable, inappropriate interactions)";
	}else if(GCSVerbal.equalsIgnoreCase("3")) {
		result = "可說出單字(Inappropriate words (>2 Years); Inconsistently consolable, moaning) ";
	}else if(GCSVerbal.equalsIgnoreCase("2")) {
		result = "可發出呻吟(Incomprehensible sounds (>2 Years); Inconsolable, agitated)";
	}else if(GCSVerbal.equalsIgnoreCase("1")) {
		result = "無任何反應(No verbal/vocal response)";
	}else if(GCSVerbal.equalsIgnoreCase("A")) {
		result = "失語症";
	}else if(GCSVerbal.equalsIgnoreCase("T")) {
		result = "氣切";
	}else if(GCSVerbal.equalsIgnoreCase("E")) {
		result = "插管";
	}else if(GCSVerbal.equalsIgnoreCase("11")) {//2021/9/10:<eVitals.T05>有出現 11，都轉成 1 跟 GCSVerbal-VE
		result = "無任何反應(No verbal/vocal response), 插管";
	}else {
		result = GCSVerbal;
		m_logger.info(WhiteBox.logForging("GCSVerbal無對應:"+GCSVerbal));
	}
	return result;
}

public static String getGCSMotor(String GCSMotor) {
	String result="";
	if(GCSMotor.equalsIgnoreCase("6")) {
		result = "可依指令動作(Obeys commands (>2Years); Appropriate response to stimulation)";
	}else if(GCSMotor.equalsIgnoreCase("5")) {
		result = "施以刺激時，可定位出疼痛位置(Localizing pain)";
	}else if(GCSMotor.equalsIgnoreCase("4")) {
		result = "對疼痛刺激有反應，肢體會回縮(Withdrawal from pain)";
	}else if(GCSMotor.equalsIgnoreCase("3")) {
		result = "對疼痛刺激有反應，肢體會彎曲(Flexion to pain)";
	}else if(GCSMotor.equalsIgnoreCase("2")) {
		result = "對疼痛刺激有反應，肢體會伸直(Extension to pain)";
	}else if(GCSMotor.equalsIgnoreCase("1")) {
		result = "無任何反應(No Motor Response)";
	}else {
		result = GCSMotor;
		m_logger.info(WhiteBox.logForging("GCSMotor無對應:"+GCSMotor));
	}
	return result;
}
	
	public static String getHeartRateMeasureMethod(String heartRateMeasureMethod) {
		String result="";
		if(heartRateMeasureMethod.equalsIgnoreCase("3311001")) {
			result = "聽診";
		}else if(heartRateMeasureMethod.equalsIgnoreCase("3311005")) {
			result = "心電圖儀器";
		}else if(heartRateMeasureMethod.equalsIgnoreCase("3311007")) {
			result = "血氧機";
		}else if(heartRateMeasureMethod.equalsIgnoreCase("3311009")) {
			result = "其他電子儀器";
		}else if(heartRateMeasureMethod.equalsIgnoreCase("3311011")) {
			result = "觸診";
		}else {
			result = heartRateMeasureMethod;
			m_logger.info(WhiteBox.logForging("heartRateMeasureMethod無對應:"+heartRateMeasureMethod));
		}
		return result;
	}
	
	public static String getBPMeasureMethod(String BPMeasureMethod) {
		String result="";
		if(BPMeasureMethod.equalsIgnoreCase("3308005")) {
			result = "全自動Cuff血壓計";
		}else if(BPMeasureMethod.equalsIgnoreCase("3308007")) {
			result = "半自動Cuff血壓計-聽診";
		}else if(BPMeasureMethod.equalsIgnoreCase("3308009")) {
			result = "半自動Cuff血壓計-觸診";
		}else if(BPMeasureMethod.equalsIgnoreCase("3308801")) {
			result = "觸診";
		}else {
			result = BPMeasureMethod;
			m_logger.info(WhiteBox.logForging("BPMeasureMethod無對應:"+BPMeasureMethod));
		}
		return result;
	}
	
	public static String getPupilLightReflexLeft(String pupilLightReflexLeft) {
		String result="";
		if(pupilLightReflexLeft.equalsIgnoreCase("121001")) {
			result = "正常";
		}else if(pupilLightReflexLeft.equalsIgnoreCase("121002")) {
			result = "不正常";
		}else {
			result = pupilLightReflexLeft;
			m_logger.info(WhiteBox.logForging("pupilLightReflexLeft無對應:"+pupilLightReflexLeft));
		}
		return result;
	}
	
	public static String getPupilLightReflexRight(String pupilLightReflexRight) {
		String result="";
		if(pupilLightReflexRight.equalsIgnoreCase("121001")) {
			result = "正常";
		}else if(pupilLightReflexRight.equalsIgnoreCase("121002")) {
			result = "不正常";
		}else {
			result = pupilLightReflexRight;
			m_logger.info(WhiteBox.logForging("pupilLightReflexRight無對應:"+pupilLightReflexRight));
		}
		return result;
	}
	
	public static String getSkin(String skin) {
		String result="";
		if(skin.equalsIgnoreCase("122001")) {
			result = "正常";
		}else if(skin.equalsIgnoreCase("122002")) {
			result = "蒼白";
		}else if(skin.equalsIgnoreCase("122003")) {
			result = "發紺";
		}else if(skin.equalsIgnoreCase("122004")) {
			result = "其他異常";
		}else {
			result = skin;
			m_logger.info(WhiteBox.logForging("skin無對應:"+skin));
		}
		return result;
	}
	
	public static String getTemperatureMethodemperature(String temperatureMethod) {
		String result="";
		if(temperatureMethod.equalsIgnoreCase("123001")) {
			result = "耳溫";
		}else if(temperatureMethod.equalsIgnoreCase("123002")) {
			result = "額溫";
		}else if(temperatureMethod.equalsIgnoreCase("123003")) {
			result = "其他";
		}else {
			result = temperatureMethod;
			m_logger.info(WhiteBox.logForging("temperatureMethod無對應:"+temperatureMethod));
		}
		return result;
	}
	
	public static String getNeurologicalAssessment(String neurologicalAssessment) {
		String result="";
		switch(neurologicalAssessment) { 
        case "3520001":
        	result = "Aphagia";
            break;
		case "3520003":
        	result = "Aphasia";
            break;
		case "3520005":
        	result = "Cerebellar Function-Abnormal";
            break;
		case "3520007":
        	result = "Cerebellar Function-Normal";
            break;
		case "3520009":
        	result = "Decerebrate Posturing";
            break;
		case "3520011":
        	result = "Decorticate Posturing";
            break;
		case "3520013":
        	result = "Gait-Abnormal";
            break;
		case "3520015":
        	result = "Gait-Normal";
            break;
		case "3520017":
        	result = "Hemiplegia-Left";
            break;
		case "3520019":
        	result = "Hemiplegia-Right";
            break;
		case "3520021":
        	result = "Normal Baseline for Patient";
            break;
		case "3520023":
        	result = "Not Done";
            break;
		case "3520025":
        	result = "Seizures";
            break;
		case "3520027":
        	result = "Speech Normal";
            break;
		case "3520029":
        	result = "語言異常(Speech Slurring)";
            break;
		case "3520031":
        	result = "Strength-Asymmetric";
            break;
		case "3520033":
        	result = "Strength-Normal";
            break;
		case "3520035":
        	result = "Strength-Symmetric";
            break;
		case "3520037":
        	result = "Tremors";
            break;
		case "3520039":
        	result = "嘴角上揚-左臉動得不如對側(Weakness-Facial Droop-Left)";
            break;
		case "3520041":
        	result = "嘴角上揚-右臉動得不如對側(Weakness-Facial Droop-Right)";
            break;
		case "3520802":
        	result = "嘴角上揚-不正常(Weakness-Facial Droop, side unspecified)";
            break;
		case "3520043":
        	result = "Weakness-Left Sided";
            break;
		case "3520045":
        	result = "Weakness-Right Sided";
            break;
		case "3520051":
        	result = "手臂支撐-左手無力(Arm Drift-Left)	";
            break;
		case "3520053":
        	result = "手臂支撐-右手無力(Arm Drift-Right)";
            break;
		case "3520801":
        	result = "手臂支撐-不正常(Arm Drift, side unspecified)";
            break;

        default: 
        	result = neurologicalAssessment;
        	m_logger.info(WhiteBox.logForging("neurologicalAssessment無對應:"+neurologicalAssessment));
        	break;
		}
		return result;
	}
	
	public static String getMedicationGiven(String medicationGiven) {
		String result="";
		switch(medicationGiven) { 
		case "124101":
        	result = "Normal Saline, irrigation";
            break;
		case "124102":
        	result = "Oxygen";
            break;
		case "124103":
        	result = "Prednisone";
            break;
		case "124104":
        	result = "Sodium Bicarbonate";
            break;
		case "124105":
        	result = "Sterile Water";
            break;
		case "124201":
        	result = "Aspirin";
            break;
		case "124202":
        	result = "Clopidogrel (e.g., Plavix)";
            break;
		case "124203":
        	result = "Heparin";
            break;
		case "124204":
        	result = "Abciximab (e.g., Reopro)";
            break;
		case "124205":
        	result = "Eptifibatide (e.g., Integrilin)";
            break;
		case "124206":
        	result = "Tirofiban (e.g., Aggrastat)";
            break;
		case "124207":
        	result = "Alteplase (e.g., Activase)";
            break;
		case "124208":
        	result = "Reteplase (e.g., Retavase)";
            break;
		case "124209":
        	result = "Tenecteplase";
            break;
		case "124301":
        	result = "Epi 1:10,000 (Epinephrine 0.1 mg/ml)	";
            break;
		case "124302":
        	result = "Dexamethasone (e.g., Decadron)";
            break;
		case "124303":
        	result = "Hydrocortisone (e.g., Solu-Cortef)";
            break;
		case "124304":
        	result = "Methylprednisolone (e.g., Solu-Medrol)";
            break;
		case "124401":
        	result = "Lidocaine Topical Gel";
            break;
		case "124402":
        	result = "Propofol (e.g., Diprivan)";
            break;
		case "124403":
        	result = "Tetracaine (e.g., Altacaine)";
            break;
		case "124501":
        	result = "Diphenhydramine (e.g., Bendadryl)";
            break;
		case "124502":
        	result = "Hydroxyzine (e.g., Vistaril)";
            break;
		case "124503":
        	result = "Promethazine (e.g., Phenergan)";
            break;
		case "124601":
        	result = "Albuterol (e.g., Proventil, Ventolin, AccuNeb)";
            break;
		case "124602":
        	result = "Albuterol / Ipratropium (e.g., Combivent, Duoneb)";
            break;
		case "124603":
        	result = "Ipratropium (e.g., Atrovent)";
            break;
		case "124604":
        	result = "Epinephrine, Racemic HCl";
            break;
		case "124605":
        	result = "Levalbuterol (e.g., Xopenex)";
            break;
		case "124606":
        	result = "Terbutaline (e.g., Brethine)";
            break;
		case "124701":
        	result = "Amiodarone (e.g., Cordarone)";
            break;
		case "124702":
        	result = "Atropine Bumetanide (e.g., Bumex)";
            break;
		case "124703":
        	result = "Epi 1:1,000 (Epinephrine 1 mg/ml)";
            break;
		case "124704":
        	result = "Nitroglycerin";
            break;
		case "124705":
        	result = "Adenosine (e.g., Adenocard)";
            break;
		case "124706":
        	result = "Calcium Chloride";
            break;
		case "124707":
        	result = "Calcium Gluconate (e.g., Calgonate)";
            break;
		case "124708":
        	result = "Captopril (e.g., Capoten)";
            break;
		case "124709":
        	result = "Clonidine (e.g., Catapres)";
            break;
		case "124710":
        	result = "Diltiazem (e.g., Cardizem)";
            break;
		case "124711":
        	result = "Enalapril (e.g., Vasotec)";
            break;
		case "124712":
        	result = "Esmolol (e.g., Brevibloc)";
            break;
		case "124713":
        	result = "Furosemide (e.g., Lasix)";
            break;
		case "124714":
        	result = "Hydralazine (e.g., Apresoline)";
            break;
		case "124715":
        	result = "Isoproterenol (e.g., Isuprel)";
            break;
		case "124716":
        	result = "Labetalol (e.g., Normodyne)";
            break;
		case "124717":
        	result = "Lidocaine";
            break;
		case "124718":
        	result = "Magnesium Sulfate";
            break;
		case "124719":
        	result = "Metoprolol (e.g., Lopressor)";
            break;
		case "124720":
        	result = "Nicardipine (e.g., Cardene)";
            break;
		case "124721":
        	result = "Nitroprusside (e.g., Nitropress)";
            break;
		case "124722":
        	result = "Nitrous Oxide";
            break;
		case "124723":
        	result = "Potassium Chloride";
            break;
		case "124724":
        	result = "Procainamide";
            break;
		case "124725":
        	result = "Propranolol (e.g., Inderal)";
            break;
		case "124726":
        	result = "Quinidine";
            break;
		case "124727":
        	result = "Vasopressin";
            break;
		case "124728":
        	result = "Verapamil";
            break;
		case "124801":
        	result = "D10 (Dextrose 10% per 500 ML";
            break;
		case "124802":
        	result = "D50 (Dextrose 50% solution)";
            break;
		case "124803":
        	result = "D10 (Dextrose 10% per 250 ML)";
            break;
		case "124804":
        	result = "D25 (Dextrose 25%)";
            break;
		case "124805":
        	result = "Glucagon";
            break;
		case "124806":
        	result = "Glucose Oral";
            break;
		case "124807":
        	result = "Insulin (e.g., Humulin)";
            break;
		case "124901":
        	result = "Famotidine (e.g., Pepcid, Tums)";
            break;
		case "124902":
        	result = "Metoclopramide (e.g., Reglan)";
            break;
		case "124903":
        	result = "Ondansetron (e.g., Zofran)";
            break;
		case "124904":
        	result = "Prochlorperazine (e.g., Compazine)";
            break;
		case "124905":
        	result = "Ranitidine (e.g., Zantac)";
            break;
		case "125101":
        	result = "Factor IX";
            break;
		case "125102":
        	result = "Factor VIIa";
            break;
		case "125103":
        	result = "Plasma protein fraction (e.g., Plasmanate)";
            break;
		case "125201":
        	result = "Benzocaine (e.g., Cetacaine)";
            break;
		case "125202":
        	result = "Chitosan (e.g., Hemostatic Agent)";
            break;
		case "125203":
        	result = "Neomycin";
            break;
		case "125204":
        	result = "Oxymetazoline (e.g., Afrin)";
            break;
		case "125205":
        	result = "Phenylephrine (e.g., Sudafed, Neo-Synephrine)";
            break;
		case "125206":
        	result = "Povidone Iodine";
            break;
		case "125207":
        	result = "Proparacaine HCl (e.g., Alcaine)";
            break;
		case "125301":
        	result = "Diazepam (e.g., Valium)";
            break;
		case "125302":
        	result = "Fosphenytoin (e.g., Cerebyx)";
            break;
		case "125303":
        	result = "Levetiracetam (e.g., Keppra)";
            break;
		case "125304":
        	result = "Mannitol (e.g., Osmitrol)";
            break;
		case "125305":
        	result = "Phenobarbital (e.g., Luminal)";
            break;
		case "125306":
        	result = "Phenytoin (e.g., Dilantin)";
            break;
		case "125401":
        	result = "Oxytocin (e.g., Pitocin)";
            break;
		case "125501":
        	result = "Acetaminophen (e.g., Tylenol, Anacin)";
            break;
		case "125502":
        	result = "Butorphanol (e.g., Stadol)";
            break;
		case "125503":
        	result = "Hydromorphone (e.g., Dilaudid)";
            break;
		case "125504":
        	result = "Ibuprofen (e.g., Advil)";
            break;
		case "125505":
        	result = "Ketorolac (e.g., Toradol)";
            break;
		case "125506":
        	result = "Meperidine (e.g., Demerol)";
            break;
		case "125507":
        	result = "Morphine";
            break;
		case "125508":
        	result = "Nalbuphine (e.g., Nubain)";
            break;
		case "125601":
        	result = "D5 Injectable Solution (Dextrose 5%)";
            break;
		case "125602":
        	result = "Normal Saline 0.9% Infusion Solution (Sodium Chloride 0.9%)";
            break;
		case "125603":
        	result = "Lactated Ringers (e.g., LR, RL)";
            break;
		case "125604":
        	result = "Sodium Chloride 0.45% Injectable Solution (NaCl 0.45%)";
            break;
		case "125605":
        	result = "Sodium Chloride 3% Injectable Solution (NaCl 3%)";
            break;
		case "125701":
        	result = "Midazolam";
            break;
		case "125702":
        	result = "Droperidol (e.g., Inapsine)";
            break;
		case "125703":
        	result = "Haloperidol (e.g., Haldol)";
            break;
		case "125704":
        	result = "Lorazepam (e.g., Ativan)";
            break;
		case "125705":
        	result = "Ziprasidone (e.g., Geodon)";
            break;
		case "125801":
        	result = "Etomidate (e.g., Amidate)";
            break;
		case "125802":
        	result = "Fentanyl";
            break;
		case "125803":
        	result = "Ketamine (e.g., Ketalar)";
            break;
		case "125804":
        	result = "Pancuronium";
            break;
		case "125805":
        	result = "Rocuronium (e.g., Zemuron)";
            break;
		case "125806":
        	result = "Succinylcholine (e.g., Anectine)";
            break;
		case "125807":
        	result = "Vecuronium (e.g., Norcuron)";
            break;
		case "125901":
        	result = "Albumin (e.g., Blood Products, all)";
            break;
		case "125902":
        	result = "Dobutamine";
            break;
		case "125903":
        	result = "Dopamine";
            break;
		case "125904":
        	result = "Hetastarch (e.g., Hespan, Hextend)";
            break;
		case "125905":
        	result = "Norepinephrine (e.g., Levophed)";
            break;
		case "126101":
        	result = "Activated Charcoal (e.g., Actidoes)";
            break;
		case "126102":
        	result = "Atropine / Pralidoxime Auto-Injector (e.g., Duodote)";
            break;
		case "126103":
        	result = "Epinephrine Auto-Injector, Adult (0.3 ml of Epi 1.0 mg/ml)";
            break;
		case "126104":
        	result = "Epinephrine Auto-Injector, Junior (0.3 ml of Epi 0.5 mg/ml";
            break;
		case "126105":
        	result = "Flumazenil (e.g., Romazicon)";
            break;
		case "126106":
        	result = "Hydroxocobalamin (e.g., Cyanokit)";
            break;
		case "126107":
        	result = "Ipecac";
            break;
		case "126108":
        	result = "Naloxone (e.g., Narcan)";
            break;
		case "126109":
        	result = "Potassium Iodide Pralidoxime (e.g., Protopam)";
            break;
		case "126110":
        	result = "Sodium Thiosulfate (e.g., Nithiodote [cyanide] Kit)";
            break;
		case "126111":
        	result = "Thiamine";
            break;
			
        default: 
        	result = medicationGiven;
        	m_logger.info(WhiteBox.logForging("medicationGiven無對應:"+medicationGiven));
        	break;
		}
		return result;
	}
	
	public static String getMedicationAdministeredRoute(String medicationAdministeredRoute) {
		String result="";
		switch(medicationAdministeredRoute) { 
        case "9927001":
        	result = "Blow-By";
            break;
		case "9927005":
        	result = "Endotracheal Tube (ET)";
            break;
		case "9927009":
        	result = "Inhalation";
            break;
		case "9927015":
        	result = "Intramuscular (IM)";
            break;
		case "9927017":
        	result = "Intranasal";
            break;
		case "9927021":
        	result = "Intraosseous (IO)";
            break;
		case "9927023":
        	result = "Intravenous (IV)";
            break;
		case "9927025":
        	result = "Nasal Cannula";
            break;
		case "9927031":
        	result = "Non-Rebreather Mask";
            break;
		case "9927035":
        	result = "Oral";
            break;
		case "9927037":
        	result = "Other/miscellaneous";
            break;
		case "9927041":
        	result = "Re-breather mask";
            break;
		case "9927045":
        	result = "Subcutaneous";
            break;
		case "9927047":
        	result = "Sublingual";
            break;
		case "9927049":
        	result = "Topical";
            break;
		case "9927057":
        	result = "Ventimask";
            break;
		case "9927059":
        	result = "Wound";
            break;

        default: 
        	result = medicationAdministeredRoute;
        	m_logger.info(WhiteBox.logForging("medicationAdministeredRoute無對應:"+medicationAdministeredRoute));
        	break;
		}
		return result;
	}
	
	public static String getMedicationDosageUnits(String medicationDosageUnits) {
		String result="";
		if(medicationDosageUnits.equalsIgnoreCase("3706001")) {
			result = "Grams (gms)";
		}else if(medicationDosageUnits.equalsIgnoreCase("3706011")) {
			result = "Liters Per Minute (l/min [fluid])";
		}else if(medicationDosageUnits.equalsIgnoreCase("3706013")) {
			result = "Metered Dose (MDI)";
		}else if(medicationDosageUnits.equalsIgnoreCase("3706015")) {
			result = "Micrograms (mcg)";
		}else if(medicationDosageUnits.equalsIgnoreCase("3706021")) {
			result = "Milligrams (mg)";
		}else if(medicationDosageUnits.equalsIgnoreCase("3706025")) {
			result = "Milliliters (ml)";
		}else if(medicationDosageUnits.equalsIgnoreCase("3706027")) {
			result = "Milliliters per Hour (ml/hr)";
		}else if(medicationDosageUnits.equalsIgnoreCase("3706029")) {
			result = "Other";
		}else if(medicationDosageUnits.equalsIgnoreCase("3706031")) {
			result = "Centimeters (cm)";
		}else if(medicationDosageUnits.equalsIgnoreCase("3706033")) {
			result = "Drops (gtts)";
		}else if(medicationDosageUnits.equalsIgnoreCase("3706035")) {
			result = "Liters Per Minute (LPM [gas])";
		}else if(medicationDosageUnits.equalsIgnoreCase("3706037")) {
			result = "Micrograms per Minute (mcg/min)";
		}else if(medicationDosageUnits.equalsIgnoreCase("3706043")) {
			result = "Puffs";
		}else if(medicationDosageUnits.equalsIgnoreCase("3706049")) {
			result = "Units";
		}else {
			result = medicationDosageUnits;
			m_logger.info(WhiteBox.logForging("medicationDosageUnits無對應:"+medicationDosageUnits));
		}
		return result;
	}
	
	public static String getProcedure(String procedure) {
		String result="";
		switch(procedure) { 
		case "127101":
        	result = "口咽呼吸道";
            break;
		case "127102":
        	result = "鼻咽呼吸道";
            break;
		case "127103":
        	result = "抽吸";
            break;
		case "127104":
        	result = "哈姆立克法";
            break;
		case "127105":
        	result = "SGA";
            break;
		case "127106":
        	result = "BVM(正壓輔助呼吸)";
            break;
		case "127107":
        	result = "氣管插管";
            break;
		case "127108":
        	result = "EtCO2";
            break;
		case "127109":
        	result = "鼻管";
            break;
		case "127110":
        	result = "面罩";
            break;
		case "127111":
        	result = "非再呼吸型面罩";
            break;
		case "127199":
        	result = "其他呼吸道/呼吸處置";
            break;
		case "127201":
        	result = "頸圈";
            break;
		case "127202":
        	result = "清洗傷口";
            break;
		case "127203":
        	result = "止血、包紮";
            break;
		case "127204":
        	result = "夾板固定";
            break;
		case "127205":
        	result = "長背板固定";
            break;
		case "127206":
        	result = "KED固定";
            break;
		case "127207":
        	result = "抽吸式護木";
            break;
		case "127208":
        	result = "止血帶";
            break;
		case "127299":
        	result = "創傷處置-其他";
            break;
		case "127301":
        	result = "CPR";
            break;
		case "127302":
        	result = "使用 AED(建議電擊)";
            break;
		case "127303":
        	result = "使用 AED(不建議電擊)";
            break;
		case "127304":
        	result = "心肺復甦術 自動心肺復甦機";
            break;
		case "127305":
        	result = "手動電擊器";
            break;
		case "127399":
        	result = "心肺復甦術-其他";
            break;
		case "127401":
        	result = "靜脈輸液";
            break;
		case "127402":
        	result = "口服葡萄糖";
            break;
		case "127403":
        	result = "協助TNG含片";
            break;
		case "127404":
        	result = "協助支氣管擴張劑";
            break;
		case "127501":
        	result = "保暖";
            break;
		case "127502":
        	result = "心理支持";
            break;
		case "127503":
        	result = "急產接生";
            break;
		case "127504":
        	result = "測量血糖";
            break;
		case "127505":
        	result = "12導程心電圖";
            break;
		case "127499":
        	result = "其他處置-其他";
            break;
		case "127601":
        	result = "醫療/線上指導醫師簽核";
            break;
      

        default: 
        	result = procedure;
        	m_logger.info(WhiteBox.logForging("procedure無對應:"+procedure));
        	break;
		}
		return result;
	}
	
	public static String getDestinationCityCounty(String destinationCityCounty) {
		String result=getCityCounty(destinationCityCounty);
		if(result.equalsIgnoreCase(destinationCityCounty)) {
			m_logger.info(WhiteBox.logForging("destinationCityCounty無對應:"+destinationCityCounty));
		}
		return result;
	}
	
	public static String getDestinationDistrict(String cityCounty, String destinationDistrict) {
		String result=getDistrict(cityCounty, destinationDistrict);
		if(result.equalsIgnoreCase(destinationDistrict)) {
			m_logger.info(WhiteBox.logForging("destinationDistrict無對應:"+destinationDistrict));
		}
		return result;
	}
	
	public static String getDestinationChoice(String destinationChoice) {
		String result="";
		if(destinationChoice.equalsIgnoreCase("4220001")) {
			result = "最近醫院";
		}else if(destinationChoice.equalsIgnoreCase("4220003")) {
			result = "分流";
		}else if(destinationChoice.equalsIgnoreCase("4220005")) {
			result = "家屬要求";
		}else if(destinationChoice.equalsIgnoreCase("4220009")) {
			result = "執法部門要求";
		}else if(destinationChoice.equalsIgnoreCase("4220011")) {
			result = "線上/現場醫療指導";
		}else if(destinationChoice.equalsIgnoreCase("4220015")) {
			result = "病人要求";
		}else if(destinationChoice.equalsIgnoreCase("4220019")) {
			result = "依Protocol";
		}else if(destinationChoice.equalsIgnoreCase("4220021")) {
			result = "當地特殊中心";
		}else if(destinationChoice.equalsIgnoreCase("4220023")) {
			result = "救災救護指揮中心";
		}else if(destinationChoice.equalsIgnoreCase("4220013")) {
			result = "其他";
		}else {
			result = destinationChoice;
			m_logger.info(WhiteBox.logForging("destinationChoice無對應:"+destinationChoice));
		}
		return result;
	}
	
	public static String getPatientDisposition(String patientDisposition) {
		String result="";
		if(patientDisposition.equalsIgnoreCase("128001")) {
			result = "有送醫";
		}else if(patientDisposition.equalsIgnoreCase("128002")) {
			result = "未發現";
		}else if(patientDisposition.equalsIgnoreCase("128003")) {
			result = "誤報";
		}else if(patientDisposition.equalsIgnoreCase("128004")) {
			result = "中途取消";
		}else if(patientDisposition.equalsIgnoreCase("128005")) {
			result = "出勤待命(火警)";
		}else if(patientDisposition.equalsIgnoreCase("128006")) {
			result = "不需要";
		}else if(patientDisposition.equalsIgnoreCase("128007")) {
			result = "拒送";
		}else if(patientDisposition.equalsIgnoreCase("128008")) {
			result = "警察處理";
		}else if(patientDisposition.equalsIgnoreCase("128009")) {
			result = "現場死亡";
		}else if(patientDisposition.equalsIgnoreCase("128010")) {
			result = "其他原因未運送";
		}else if(patientDisposition.equalsIgnoreCase("128011")) {
			result = "出勤待命(支援勤務)";
		}else {
			result = patientDisposition;
			m_logger.info(WhiteBox.logForging("patientDisposition無對應:"+patientDisposition));
		}
		return result;
	}
	
	public static String getWayMovedToAmbulance(String wayMovedToAmbulance) {
		String result="";
		if(wayMovedToAmbulance.equalsIgnoreCase("9909001")) {
			result = "自行上車";
		}else if(wayMovedToAmbulance.equalsIgnoreCase("9909007")) {
			result = "背負、抱";
		}else if(wayMovedToAmbulance.equalsIgnoreCase("9909801")) {
			result = "搬運墊";
		}else if(wayMovedToAmbulance.equalsIgnoreCase("9909003")) {
			result = "長背板";
		}else if(wayMovedToAmbulance.equalsIgnoreCase("9909011")) {
			result = "折疊式搬運椅";
		}else if(wayMovedToAmbulance.equalsIgnoreCase("9909013")) {
			result = "擔架";
		}else if(wayMovedToAmbulance.equalsIgnoreCase("9909009")) {
			result = "其他";
		}else {
			result = wayMovedToAmbulance;
			m_logger.info(WhiteBox.logForging("wayMovedToAmbulance無對應:"+wayMovedToAmbulance));
		}
		return result;
	}
	
	public static String getIsALSString(String isALS) {
		String result="";
		if(isALS.equalsIgnoreCase("129001")) {
			result = "否(BLS)";
		}else if(isALS.equalsIgnoreCase("129002")) {
			result = "是(ALS)";
		}else {
			result = isALS;
			m_logger.info(WhiteBox.logForging("isALS無對應:"+isALS));
		}
		return result;
	}
	public static int getIsALS(String isALS) {
		int result=0;
		if(isALS.equalsIgnoreCase("129001")) {
			result = 0;
		}else if(isALS.equalsIgnoreCase("129002")) {
			result = 1;
		}else {
			result = 0;
			m_logger.info(WhiteBox.logForging("isALS無對應:"+isALS));
		}
		return result;
	}
	
	public static String getSceneAcuityLevel(String sceneAcuityLevel) {
		String result="";
		if(sceneAcuityLevel.equalsIgnoreCase("130001")) {
			result = "一級";
		}else if(sceneAcuityLevel.equalsIgnoreCase("130002")) {
			result = "二級";
		}else if(sceneAcuityLevel.equalsIgnoreCase("130003")) {
			result = "三級";
		}else if(sceneAcuityLevel.equalsIgnoreCase("130004")) {
			result = "四級";
		}else if(sceneAcuityLevel.equalsIgnoreCase("130005")) {
			result = "五級";
		}else {
			result = sceneAcuityLevel;
			m_logger.info(WhiteBox.logForging("sceneAcuityLevel無對應:"+sceneAcuityLevel));
		}
		return result;
	}
	
	public static String getERTriageLevel(String ERTriageLevel) {
		String result="";
		if(ERTriageLevel.equalsIgnoreCase("131001")) {
			result = "一級";
		}else if(ERTriageLevel.equalsIgnoreCase("131002")) {
			result = "二級";
		}else if(ERTriageLevel.equalsIgnoreCase("131003")) {
			result = "三級";
		}else if(ERTriageLevel.equalsIgnoreCase("131004")) {
			result = "四級";
		}else if(ERTriageLevel.equalsIgnoreCase("131005")) {
			result = "五級";
		}else {
			result = ERTriageLevel;
			m_logger.info(WhiteBox.logForging("ERTriageLevel無對應:"+ERTriageLevel));
		}
		return result;
	}
	
	public static String getERDisposition(String ERDisposition) {
		String result="";
		switch(ERDisposition) { 
		case "01":
        	result = "急診醫療後即返家";
            break;
		case "02":
        	result = "急診醫療後轉院-短期照護";
            break;
		case "03":
        	result = "急診醫療後轉入專門護理機構";
            break;
		case "04":
        	result = "急診醫療後轉入中途照護機構";
            break;
		case "05":
        	result = "急診醫療後轉入非定義之機構";
            break;
		case "06":
        	result = "急診醫療後返家接受家庭健康照護 ";
            break;
		case "07":
        	result = "急診醫療後拒絕醫療建議與後續照護";
            break;
		case "09":
        	result = "急診醫療後入院";
            break;
		case "20":
        	result = "急診醫療後拒絕醫療/死亡(宗教因素)";
            break;
		case "21":
        	result = "急診醫療後轉入執法相關機構";
            break;
		case "30":
        	result = "急診醫療後期望轉為門診病患";
            break;
		case "50":
        	result = "急診醫療後臨終照護 - 返家";
            break;
		case "51":
        	result = "急診醫療後臨終照護 - 醫療機構";
            break;
		case "61":
        	result = "(Discharged/transferred within this institution to a hospital based Medicare approved swing bed)";
            break;
		case "62":
        	result = "急診醫療後轉入復健機構";
            break;
		case "63":
        	result = "急診醫療後轉院-長期照護";
            break;
		case "64":
        	result = "急診醫療後轉入一般護理機構";
            break;
		case "65":
        	result = "急診醫療後轉入精神醫學機構";
            break;			
		case "66":
        	result = "(Discharged/transferred to a Critical Access Hospital (CAH))";
            break;
		case "70":
        	result = "其他";
            break;

        default: 
        	result = ERDisposition;
        	m_logger.info(WhiteBox.logForging("ERDisposition無對應:"+ERDisposition));
        	break;
		}
		return result;
	}
	
	public static String getHospitalDisposition(String hospitalDisposition) {
		String result="";
		switch(hospitalDisposition) { 
		case "01":
        	result = "醫療後即返家";
            break;
		case "02":
        	result = "醫療後轉院-短期照護";
            break;
		case "03":
        	result = "醫療後轉入專門護理機構";
            break;
		case "04":
        	result = "醫療後轉入中途照護機構";
            break;
		case "05":
        	result = "醫療後轉入非定義之機構";
            break;
		case "06":
        	result = "醫療後返家接受家庭健康照護";
            break;
		case "07":
        	result = "醫療後拒絕醫療建議與後續照護";
            break;
		case "20":
        	result = "醫療後拒絕醫療/死亡(宗教因素)";
            break;
		case "21":
        	result = "醫療後轉入執法相關機構";
            break;
		case "30":
        	result = "醫療後期望轉為門診病患";
            break;
		case "50":
        	result = "醫療後臨終照護 - 返家";
            break;
		case "51":
        	result = "醫療後臨終照護 - 醫療機構";
            break;
		case "61":
        	result = "(Discharged/transferred within this institution to a hospital based Medicare approved swing bed)";
            break;
		case "62":
        	result = "急診醫療後轉入復健機構";
            break;
		case "63":
        	result = "急診醫療後轉院-長期照護";
            break;
		case "64":
        	result = "急診醫療後轉入一般護理機構";
            break;
		case "65":
        	result = "急診醫療後轉入精神醫學機構";
            break;
		case "66":
        	result = "(Discharged/transferred to a Critical Access Hospital (CAH))	";
            break;
		case "70":
        	result = "其他";
            break;

        default: 
        	result = hospitalDisposition;
        	m_logger.info(WhiteBox.logForging("hospitalDisposition無對應:"+hospitalDisposition));
        	break;
		}
		return result;
	}
	
	public static String getIsDischargedAlive(String isDischargedAlive) {
		String result="";
		if(isDischargedAlive.equalsIgnoreCase("132001")) {
			result = "否";
		}else if(isDischargedAlive.equalsIgnoreCase("132002")) {
			result = "是";
		}else {
			result = isDischargedAlive;
			m_logger.info(WhiteBox.logForging("isDischargedAlive無對應:"+isDischargedAlive));
		}
		return result;
	}
	
	public static String getCPCLevel(String CPCLevel) {
		String result="";
		if(CPCLevel.equalsIgnoreCase("133001")) {
			result = "CPC 1：Good cerebral performance. Conscious, alert, able to work; might have mild neurologic or psychologic deficit";
		}else if(CPCLevel.equalsIgnoreCase("133002")) {
			result = "CPC 2：Moderate cerebral disability. Conscious, sufficient cerebral function for independent activities of daily life. Able to work in sheltered environment";
		}else if(CPCLevel.equalsIgnoreCase("133003")) {
			result = "CPC 3：Severe cerebral disability. Conscious, dependent on others for daily support because of impaired brain function. Ranges from ambulatory state to severe dementia or paralysis";
		}else if(CPCLevel.equalsIgnoreCase("133004")) {
			result = "CPC 4：Coma or vegetative state. Any degree of coma without the presence of all brain death criteria. Unawareness, even if appears awake (vegetative state) without interaction with environment; might have spontaneous eye opening and sleep/awake cycles. Cerebral unresponsiveness";
		}else {
			result = CPCLevel;
			m_logger.info(WhiteBox.logForging("CPCLevel無對應:"+CPCLevel));
		}
		return result;
	}
	
	public static String getDNRInER(String DNRInER) {
		String result="";
		if(DNRInER.equalsIgnoreCase("134001")) {
			result = "否";
		}else if(DNRInER.equalsIgnoreCase("134002")) {
			result = "是";
		}else {
			result = DNRInER;
			m_logger.info(WhiteBox.logForging("DNRInER無對應:"+DNRInER));
		}
		return result;
	}
	//共用
	public static String getCityCounty(String cityCounty) {
		String result="";
		switch(cityCounty) { 
        case "A":
        	result = "臺北市";
            break; 
        case "B":
        	result = "臺中市";
        	break;
        case "C":
        	result = "基隆市";
        	break;
        case "D":
        	result = "臺南市";
        	break;
        case "E":
        	result = "高雄市";
        	break;
        case "F":
        	result = "新北市";
        	break;
        case "G":
        	result = "宜蘭縣";
        	break;
        case "H":
        	result = "桃園市";
        	break;
        case "I":
        	result = "嘉義市";
        	break;
        case "J":
        	result = "新竹縣";
        	break;
        case "K":
        	result = "苗栗縣";
        	break;
        case "M":
        	result = "南投縣";
        	break;
        case "N":
        	result = "彰化縣";
        	break;
        case "O":
        	result = "新竹市";
        	break;
        case "P":
        	result = "雲林縣";
        	break;
        case "Q":
        	result = "嘉義縣";
        	break;
        case "T":
        	result = "屏東縣";
        	break;
        case "U":
        	result = "花蓮縣";
        	break;
        case "V":
        	result = "臺東縣";
        	break;
        case "W":
        	result = "金門縣";
        	break;
        case "X":
        	result = "澎湖縣";
        	break;
        case "Z":
        	result = "連江縣";        	
        	break;
        	
        default: 
        	result = cityCounty;
        	m_logger.info(WhiteBox.logForging("cityCounty無對應:"+cityCounty));
        	break;
		}
		return result;
	}
	public static String getDistrict(String cityCounty, String district) {
		String result="";
		if(cityCounty == null) {
			result = district;
			m_logger.info(WhiteBox.logForging("(cityCounty,district)無對應:("+cityCounty+","+district+")"));
			return result;
		}		
		if(cityCounty.equalsIgnoreCase("A") && (district.equalsIgnoreCase("1") || district.equalsIgnoreCase("01"))){
			result = "松山區";
		}else if(cityCounty.equalsIgnoreCase("A") && (district.equalsIgnoreCase("2") || district.equalsIgnoreCase("02"))){
			result = "大安區";
		}else if(cityCounty.equalsIgnoreCase("A") && (district.equalsIgnoreCase("3") || district.equalsIgnoreCase("03"))){
			result = "中正區";
		}else if(cityCounty.equalsIgnoreCase("A") && (district.equalsIgnoreCase("3") || district.equalsIgnoreCase("03"))){
			result = "中正區";
		}else if(cityCounty.equalsIgnoreCase("A") && (district.equalsIgnoreCase("5") || district.equalsIgnoreCase("05"))){
			result = "萬華區";
		}else if(cityCounty.equalsIgnoreCase("A") && (district.equalsIgnoreCase("9") || district.equalsIgnoreCase("09"))){
			result = "大同區";
		}else if(cityCounty.equalsIgnoreCase("A") && district.equalsIgnoreCase("10")){
			result = "中山區";
		}else if(cityCounty.equalsIgnoreCase("A") && district.equalsIgnoreCase("11")){
			result = "文山區";
		}else if(cityCounty.equalsIgnoreCase("A") && district.equalsIgnoreCase("13")){
			result = "南港區";
		}else if(cityCounty.equalsIgnoreCase("A") && district.equalsIgnoreCase("14")){
			result = "內湖區";
		}else if(cityCounty.equalsIgnoreCase("A") && district.equalsIgnoreCase("15")){
			result = "士林區";
		}else if(cityCounty.equalsIgnoreCase("A") && district.equalsIgnoreCase("16")){
			result = "北投區";
		}else if(cityCounty.equalsIgnoreCase("A") && district.equalsIgnoreCase("17")){
			result = "信義區";
		}else if(cityCounty.equalsIgnoreCase("B") && (district.equalsIgnoreCase("1") || district.equalsIgnoreCase("01"))){
			result = "中區";
		}else if(cityCounty.equalsIgnoreCase("B") && (district.equalsIgnoreCase("2") || district.equalsIgnoreCase("02"))){
			result = "東區";
		}else if(cityCounty.equalsIgnoreCase("B") && (district.equalsIgnoreCase("3") || district.equalsIgnoreCase("03"))){
			result = "南區";
		}else if(cityCounty.equalsIgnoreCase("B") && (district.equalsIgnoreCase("4") || district.equalsIgnoreCase("04"))){
			result = "西區";
		}else if(cityCounty.equalsIgnoreCase("B") && (district.equalsIgnoreCase("5") || district.equalsIgnoreCase("05"))){
			result = "北區";
		}else if(cityCounty.equalsIgnoreCase("B") && (district.equalsIgnoreCase("6") || district.equalsIgnoreCase("06"))){
			result = "西屯區";
		}else if(cityCounty.equalsIgnoreCase("B") && (district.equalsIgnoreCase("7") || district.equalsIgnoreCase("07"))){
			result = "南屯區";
		}else if(cityCounty.equalsIgnoreCase("B") && (district.equalsIgnoreCase("8") || district.equalsIgnoreCase("08"))){
			result = "北屯區";
		}else if(cityCounty.equalsIgnoreCase("B") && (district.equalsIgnoreCase("9") || district.equalsIgnoreCase("09"))){
			result = "豐原區";
		}else if(cityCounty.equalsIgnoreCase("B") && district.equalsIgnoreCase("10")){
			result = "東勢區";
		}else if(cityCounty.equalsIgnoreCase("B") && district.equalsIgnoreCase("11")){
			result = "大甲區";
		}else if(cityCounty.equalsIgnoreCase("B") && district.equalsIgnoreCase("12")){
			result = "清水區";
		}else if(cityCounty.equalsIgnoreCase("B") && district.equalsIgnoreCase("13")){
			result = "沙鹿區";
		}else if(cityCounty.equalsIgnoreCase("B") && district.equalsIgnoreCase("14")){
			result = "梧棲區";
		}else if(cityCounty.equalsIgnoreCase("B") && district.equalsIgnoreCase("15")){
			result = "后里區";
		}else if(cityCounty.equalsIgnoreCase("B") && district.equalsIgnoreCase("16")){
			result = "神岡區";
		}else if(cityCounty.equalsIgnoreCase("B") && district.equalsIgnoreCase("17")){
			result = "潭子區";
		}else if(cityCounty.equalsIgnoreCase("B") && district.equalsIgnoreCase("18")){
			result = "大雅區";
		}else if(cityCounty.equalsIgnoreCase("B") && district.equalsIgnoreCase("19")){
			result = "新社區";
		}else if(cityCounty.equalsIgnoreCase("B") && district.equalsIgnoreCase("20")){
			result = "石岡區";
		}else if(cityCounty.equalsIgnoreCase("B") && district.equalsIgnoreCase("21")){
			result = "外埔區";
		}else if(cityCounty.equalsIgnoreCase("B") && district.equalsIgnoreCase("22")){
			result = "大安區";
		}else if(cityCounty.equalsIgnoreCase("B") && district.equalsIgnoreCase("23")){
			result = "烏日區";
		}else if(cityCounty.equalsIgnoreCase("B") && district.equalsIgnoreCase("24")){
			result = "大肚區";
		}else if(cityCounty.equalsIgnoreCase("B") && district.equalsIgnoreCase("25")){
			result = "龍井區";
		}else if(cityCounty.equalsIgnoreCase("B") && district.equalsIgnoreCase("26")){
			result = "霧峰區";
		}else if(cityCounty.equalsIgnoreCase("B") && district.equalsIgnoreCase("27")){
			result = "太平區";
		}else if(cityCounty.equalsIgnoreCase("B") && district.equalsIgnoreCase("28")){
			result = "大里區";
		}else if(cityCounty.equalsIgnoreCase("B") && district.equalsIgnoreCase("29")){
			result = "和平區";
		}else if(cityCounty.equalsIgnoreCase("C") && (district.equalsIgnoreCase("1") || district.equalsIgnoreCase("01"))){
			result = "中正區";
		}else if(cityCounty.equalsIgnoreCase("C") && (district.equalsIgnoreCase("2") || district.equalsIgnoreCase("02"))){
			result = "七堵區";
		}else if(cityCounty.equalsIgnoreCase("C") && (district.equalsIgnoreCase("3") || district.equalsIgnoreCase("03"))){
			result = "暖暖區";
		}else if(cityCounty.equalsIgnoreCase("C") && (district.equalsIgnoreCase("4") || district.equalsIgnoreCase("04"))){
			result = "仁愛區";
		}else if(cityCounty.equalsIgnoreCase("C") && (district.equalsIgnoreCase("5") || district.equalsIgnoreCase("05"))){
			result = "中山區";
		}else if(cityCounty.equalsIgnoreCase("C") && (district.equalsIgnoreCase("6") || district.equalsIgnoreCase("06"))){
			result = "安樂區";
		}else if(cityCounty.equalsIgnoreCase("C") && (district.equalsIgnoreCase("7") || district.equalsIgnoreCase("07"))){
			result = "信義區";
		}else if(cityCounty.equalsIgnoreCase("D") && (district.equalsIgnoreCase("1") || district.equalsIgnoreCase("01"))){
			result = "東區";
		}else if(cityCounty.equalsIgnoreCase("D") && (district.equalsIgnoreCase("2") || district.equalsIgnoreCase("02"))){
			result = "南區";
		}else if(cityCounty.equalsIgnoreCase("D") && (district.equalsIgnoreCase("4") || district.equalsIgnoreCase("04"))){
			result = "北區";
		}else if(cityCounty.equalsIgnoreCase("D") && (district.equalsIgnoreCase("6") || district.equalsIgnoreCase("06"))){
			result = "安南區";
		}else if(cityCounty.equalsIgnoreCase("D") && (district.equalsIgnoreCase("7") || district.equalsIgnoreCase("07"))){
			result = "安平區";
		}else if(cityCounty.equalsIgnoreCase("D") && (district.equalsIgnoreCase("8") || district.equalsIgnoreCase("08"))){
			result = "中西區";
		}else if(cityCounty.equalsIgnoreCase("D") && (district.equalsIgnoreCase("9") || district.equalsIgnoreCase("09"))){
			result = "新營區";
		}else if(cityCounty.equalsIgnoreCase("D") && district.equalsIgnoreCase("10")){
			result = "鹽水區";
		}else if(cityCounty.equalsIgnoreCase("D") && district.equalsIgnoreCase("11")){
			result = "柳營區";
		}else if(cityCounty.equalsIgnoreCase("D") && district.equalsIgnoreCase("12")){
			result = "白河區";
		}else if(cityCounty.equalsIgnoreCase("D") && district.equalsIgnoreCase("13")){
			result = "後壁區";
		}else if(cityCounty.equalsIgnoreCase("D") && district.equalsIgnoreCase("14")){
			result = "東山區";
		}else if(cityCounty.equalsIgnoreCase("D") && district.equalsIgnoreCase("15")){
			result = "麻豆區";
		}else if(cityCounty.equalsIgnoreCase("D") && district.equalsIgnoreCase("16")){
			result = "下營區";
		}else if(cityCounty.equalsIgnoreCase("D") && district.equalsIgnoreCase("17")){
			result = "六甲區";
		}else if(cityCounty.equalsIgnoreCase("D") && district.equalsIgnoreCase("18")){
			result = "官田區";
		}else if(cityCounty.equalsIgnoreCase("D") && district.equalsIgnoreCase("19")){
			result = "大內區";
		}else if(cityCounty.equalsIgnoreCase("D") && district.equalsIgnoreCase("20")){
			result = "佳里區";
		}else if(cityCounty.equalsIgnoreCase("D") && district.equalsIgnoreCase("21")){
			result = "西港區";
		}else if(cityCounty.equalsIgnoreCase("D") && district.equalsIgnoreCase("22")){
			result = "七股區";
		}else if(cityCounty.equalsIgnoreCase("D") && district.equalsIgnoreCase("23")){
			result = "將軍區";
		}else if(cityCounty.equalsIgnoreCase("D") && district.equalsIgnoreCase("24")){
			result = "北門區";
		}else if(cityCounty.equalsIgnoreCase("D") && district.equalsIgnoreCase("25")){
			result = "學甲區";
		}else if(cityCounty.equalsIgnoreCase("D") && district.equalsIgnoreCase("26")){
			result = "新化區";
		}else if(cityCounty.equalsIgnoreCase("D") && district.equalsIgnoreCase("27")){
			result = "善化區";
		}else if(cityCounty.equalsIgnoreCase("D") && district.equalsIgnoreCase("28")){
			result = "新市區";
		}else if(cityCounty.equalsIgnoreCase("D") && district.equalsIgnoreCase("29")){
			result = "安定區";
		}else if(cityCounty.equalsIgnoreCase("D") && district.equalsIgnoreCase("30")){
			result = "山上區";
		}else if(cityCounty.equalsIgnoreCase("D") && district.equalsIgnoreCase("31")){
			result = "左鎮區";
		}else if(cityCounty.equalsIgnoreCase("D") && district.equalsIgnoreCase("32")){
			result = "仁德區";
		}else if(cityCounty.equalsIgnoreCase("D") && district.equalsIgnoreCase("33")){
			result = "歸仁區";
		}else if(cityCounty.equalsIgnoreCase("D") && district.equalsIgnoreCase("34")){
			result = "關廟區";
		}else if(cityCounty.equalsIgnoreCase("D") && district.equalsIgnoreCase("35")){
			result = "龍崎區";
		}else if(cityCounty.equalsIgnoreCase("D") && district.equalsIgnoreCase("36")){
			result = "玉井區";
		}else if(cityCounty.equalsIgnoreCase("D") && district.equalsIgnoreCase("37")){
			result = "楠西區";
		}else if(cityCounty.equalsIgnoreCase("D") && district.equalsIgnoreCase("38")){
			result = "南化區";
		}else if(cityCounty.equalsIgnoreCase("D") && district.equalsIgnoreCase("39")){
			result = "永康區";
		}else if(cityCounty.equalsIgnoreCase("E") && (district.equalsIgnoreCase("1") || district.equalsIgnoreCase("01"))){
			result = "鹽埕區";
		}else if(cityCounty.equalsIgnoreCase("E") && (district.equalsIgnoreCase("2") || district.equalsIgnoreCase("02"))){
			result = "鼓山區";
		}else if(cityCounty.equalsIgnoreCase("E") && (district.equalsIgnoreCase("3") || district.equalsIgnoreCase("03"))){
			result = "左營區";
		}else if(cityCounty.equalsIgnoreCase("E") && (district.equalsIgnoreCase("4") || district.equalsIgnoreCase("04"))){
			result = "楠梓區";
		}else if(cityCounty.equalsIgnoreCase("E") && (district.equalsIgnoreCase("5") || district.equalsIgnoreCase("05"))){
			result = "三民區";
		}else if(cityCounty.equalsIgnoreCase("E") && (district.equalsIgnoreCase("6") || district.equalsIgnoreCase("06"))){
			result = "新興區";
		}else if(cityCounty.equalsIgnoreCase("E") && (district.equalsIgnoreCase("7") || district.equalsIgnoreCase("07"))){
			result = "前金區";
		}else if(cityCounty.equalsIgnoreCase("E") && (district.equalsIgnoreCase("8") || district.equalsIgnoreCase("08"))){
			result = "苓雅區";
		}else if(cityCounty.equalsIgnoreCase("E") && (district.equalsIgnoreCase("9") || district.equalsIgnoreCase("09"))){
			result = "前鎮區";
		}else if(cityCounty.equalsIgnoreCase("E") && district.equalsIgnoreCase("10")){
			result = "旗津區";
		}else if(cityCounty.equalsIgnoreCase("E") && district.equalsIgnoreCase("11")){
			result = "小港區";
		}else if(cityCounty.equalsIgnoreCase("E") && district.equalsIgnoreCase("12")){
			result = "鳳山區";
		}else if(cityCounty.equalsIgnoreCase("E") && district.equalsIgnoreCase("13")){
			result = "林園區";
		}else if(cityCounty.equalsIgnoreCase("E") && district.equalsIgnoreCase("14")){
			result = "大寮區";
		}else if(cityCounty.equalsIgnoreCase("E") && district.equalsIgnoreCase("15")){
			result = "大樹區";
		}else if(cityCounty.equalsIgnoreCase("E") && district.equalsIgnoreCase("16")){
			result = "大社區";
		}else if(cityCounty.equalsIgnoreCase("E") && district.equalsIgnoreCase("17")){
			result = "仁武區";
		}else if(cityCounty.equalsIgnoreCase("E") && district.equalsIgnoreCase("18")){
			result = "鳥松區";
		}else if(cityCounty.equalsIgnoreCase("E") && district.equalsIgnoreCase("19")){
			result = "岡山區";
		}else if(cityCounty.equalsIgnoreCase("E") && district.equalsIgnoreCase("20")){
			result = "橋頭區";
		}else if(cityCounty.equalsIgnoreCase("E") && district.equalsIgnoreCase("21")){
			result = "燕巢區";
		}else if(cityCounty.equalsIgnoreCase("E") && district.equalsIgnoreCase("22")){
			result = "田寮區";
		}else if(cityCounty.equalsIgnoreCase("E") && district.equalsIgnoreCase("23")){
			result = "阿蓮區";
		}else if(cityCounty.equalsIgnoreCase("E") && district.equalsIgnoreCase("24")){
			result = "路竹區";
		}else if(cityCounty.equalsIgnoreCase("E") && district.equalsIgnoreCase("25")){
			result = "湖內區";
		}else if(cityCounty.equalsIgnoreCase("E") && district.equalsIgnoreCase("26")){
			result = "茄萣區";
		}else if(cityCounty.equalsIgnoreCase("E") && district.equalsIgnoreCase("27")){
			result = "永安區";
		}else if(cityCounty.equalsIgnoreCase("E") && district.equalsIgnoreCase("28")){
			result = "彌陀區";
		}else if(cityCounty.equalsIgnoreCase("E") && district.equalsIgnoreCase("29")){
			result = "梓官區";
		}else if(cityCounty.equalsIgnoreCase("E") && district.equalsIgnoreCase("30")){
			result = "旗山區";
		}else if(cityCounty.equalsIgnoreCase("E") && district.equalsIgnoreCase("31")){
			result = "美濃區";
		}else if(cityCounty.equalsIgnoreCase("E") && district.equalsIgnoreCase("32")){
			result = "六龜區";
		}else if(cityCounty.equalsIgnoreCase("E") && district.equalsIgnoreCase("33")){
			result = "甲仙區";
		}else if(cityCounty.equalsIgnoreCase("E") && district.equalsIgnoreCase("34")){
			result = "杉林區";
		}else if(cityCounty.equalsIgnoreCase("E") && district.equalsIgnoreCase("35")){
			result = "內門區";
		}else if(cityCounty.equalsIgnoreCase("E") && district.equalsIgnoreCase("36")){
			result = "茂林區";
		}else if(cityCounty.equalsIgnoreCase("E") && district.equalsIgnoreCase("37")){
			result = "桃源區";
		}else if(cityCounty.equalsIgnoreCase("E") && district.equalsIgnoreCase("38")){
			result = "那瑪夏區";
		}else if(cityCounty.equalsIgnoreCase("F") && (district.equalsIgnoreCase("1") || district.equalsIgnoreCase("01"))){
			result = "新莊區";
		}else if(cityCounty.equalsIgnoreCase("F") && (district.equalsIgnoreCase("2") || district.equalsIgnoreCase("02"))){
			result = "林口區";
		}else if(cityCounty.equalsIgnoreCase("F") && (district.equalsIgnoreCase("3") || district.equalsIgnoreCase("03"))){
			result = "五股區";
		}else if(cityCounty.equalsIgnoreCase("F") && (district.equalsIgnoreCase("4") || district.equalsIgnoreCase("04"))){
			result = "蘆洲區";
		}else if(cityCounty.equalsIgnoreCase("F") && (district.equalsIgnoreCase("5") || district.equalsIgnoreCase("05"))){
			result = "三重區";
		}else if(cityCounty.equalsIgnoreCase("F") && (district.equalsIgnoreCase("6") || district.equalsIgnoreCase("06"))){
			result = "泰山區";
		}else if(cityCounty.equalsIgnoreCase("F") && (district.equalsIgnoreCase("7") || district.equalsIgnoreCase("07"))){
			result = "新店區";
		}else if(cityCounty.equalsIgnoreCase("F") && (district.equalsIgnoreCase("8") || district.equalsIgnoreCase("08"))){
			result = "石碇區";
		}else if(cityCounty.equalsIgnoreCase("F") && (district.equalsIgnoreCase("9") || district.equalsIgnoreCase("09"))){
			result = "深坑區";
		}else if(cityCounty.equalsIgnoreCase("F") && district.equalsIgnoreCase("10")){
			result = "坪林區";
		}else if(cityCounty.equalsIgnoreCase("F") && district.equalsIgnoreCase("11")){
			result = "烏來區";
		}else if(cityCounty.equalsIgnoreCase("F") && district.equalsIgnoreCase("14")){
			result = "板橋區";
		}else if(cityCounty.equalsIgnoreCase("F") && district.equalsIgnoreCase("15")){
			result = "三峽區";
		}else if(cityCounty.equalsIgnoreCase("F") && district.equalsIgnoreCase("16")){
			result = "鶯歌區";
		}else if(cityCounty.equalsIgnoreCase("F") && district.equalsIgnoreCase("17")){
			result = "樹林區";
		}else if(cityCounty.equalsIgnoreCase("F") && district.equalsIgnoreCase("18")){
			result = "中和區";
		}else if(cityCounty.equalsIgnoreCase("F") && district.equalsIgnoreCase("19")){
			result = "土城區";
		}else if(cityCounty.equalsIgnoreCase("F") && district.equalsIgnoreCase("21")){
			result = "瑞芳區";
		}else if(cityCounty.equalsIgnoreCase("F") && district.equalsIgnoreCase("22")){
			result = "平溪區";
		}else if(cityCounty.equalsIgnoreCase("F") && district.equalsIgnoreCase("23")){
			result = "雙溪區";
		}else if(cityCounty.equalsIgnoreCase("F") && district.equalsIgnoreCase("24")){
			result = "貢寮區";
		}else if(cityCounty.equalsIgnoreCase("F") && district.equalsIgnoreCase("25")){
			result = "金山區";
		}else if(cityCounty.equalsIgnoreCase("F") && district.equalsIgnoreCase("26")){
			result = "萬里區";
		}else if(cityCounty.equalsIgnoreCase("F") && district.equalsIgnoreCase("27")){
			result = "淡水區";
		}else if(cityCounty.equalsIgnoreCase("F") && district.equalsIgnoreCase("28")){
			result = "汐止區";
		}else if(cityCounty.equalsIgnoreCase("F") && district.equalsIgnoreCase("30")){
			result = "三芝區";
		}else if(cityCounty.equalsIgnoreCase("F") && district.equalsIgnoreCase("31")){
			result = "石門區";
		}else if(cityCounty.equalsIgnoreCase("F") && district.equalsIgnoreCase("32")){
			result = "八里區";
		}else if(cityCounty.equalsIgnoreCase("F") && district.equalsIgnoreCase("33")){
			result = "永和區";
		}else if(cityCounty.equalsIgnoreCase("G") && (district.equalsIgnoreCase("1") || district.equalsIgnoreCase("01"))){
			result = "宜蘭市";
		}else if(cityCounty.equalsIgnoreCase("G") && (district.equalsIgnoreCase("2") || district.equalsIgnoreCase("02"))){
			result = "頭城鎮";
		}else if(cityCounty.equalsIgnoreCase("G") && (district.equalsIgnoreCase("3") || district.equalsIgnoreCase("03"))){
			result = "礁溪鄉";
		}else if(cityCounty.equalsIgnoreCase("G") && (district.equalsIgnoreCase("4") || district.equalsIgnoreCase("04"))){
			result = "壯圍鄉";
		}else if(cityCounty.equalsIgnoreCase("G") && (district.equalsIgnoreCase("5") || district.equalsIgnoreCase("05"))){
			result = "員山鄉";
		}else if(cityCounty.equalsIgnoreCase("G") && (district.equalsIgnoreCase("6") || district.equalsIgnoreCase("06"))){
			result = "羅東鎮";
		}else if(cityCounty.equalsIgnoreCase("G") && (district.equalsIgnoreCase("7") || district.equalsIgnoreCase("07"))){
			result = "五結鄉";
		}else if(cityCounty.equalsIgnoreCase("G") && (district.equalsIgnoreCase("8") || district.equalsIgnoreCase("08"))){
			result = "冬山鄉";
		}else if(cityCounty.equalsIgnoreCase("G") && (district.equalsIgnoreCase("9") || district.equalsIgnoreCase("09"))){
			result = "蘇澳鎮";
		}else if(cityCounty.equalsIgnoreCase("G") && district.equalsIgnoreCase("10")){
			result = "三星鄉";
		}else if(cityCounty.equalsIgnoreCase("G") && district.equalsIgnoreCase("11")){
			result = "大同鄉";
		}else if(cityCounty.equalsIgnoreCase("G") && district.equalsIgnoreCase("12")){
			result = "南澳鄉";
		}else if(cityCounty.equalsIgnoreCase("H") && (district.equalsIgnoreCase("1") || district.equalsIgnoreCase("01"))){
			result = "桃園區";
		}else if(cityCounty.equalsIgnoreCase("H") && (district.equalsIgnoreCase("2") || district.equalsIgnoreCase("02"))){
			result = "大溪區";
		}else if(cityCounty.equalsIgnoreCase("H") && (district.equalsIgnoreCase("3") || district.equalsIgnoreCase("03"))){
			result = "中壢區";
		}else if(cityCounty.equalsIgnoreCase("H") && (district.equalsIgnoreCase("4") || district.equalsIgnoreCase("04"))){
			result = "楊梅區";
		}else if(cityCounty.equalsIgnoreCase("H") && (district.equalsIgnoreCase("5") || district.equalsIgnoreCase("05"))){
			result = "蘆竹區";
		}else if(cityCounty.equalsIgnoreCase("H") && (district.equalsIgnoreCase("6") || district.equalsIgnoreCase("06"))){
			result = "大園區";
		}else if(cityCounty.equalsIgnoreCase("H") && (district.equalsIgnoreCase("7") || district.equalsIgnoreCase("07"))){
			result = "龜山區";
		}else if(cityCounty.equalsIgnoreCase("H") && (district.equalsIgnoreCase("8") || district.equalsIgnoreCase("08"))){
			result = "八德區";
		}else if(cityCounty.equalsIgnoreCase("H") && (district.equalsIgnoreCase("9") || district.equalsIgnoreCase("09"))){
			result = "龍潭區";
		}else if(cityCounty.equalsIgnoreCase("H") && district.equalsIgnoreCase("10")){
			result = "平鎮區";
		}else if(cityCounty.equalsIgnoreCase("H") && district.equalsIgnoreCase("11")){
			result = "新屋區";
		}else if(cityCounty.equalsIgnoreCase("H") && district.equalsIgnoreCase("12")){
			result = "觀音區";
		}else if(cityCounty.equalsIgnoreCase("H") && district.equalsIgnoreCase("13")){
			result = "復興區";
		}else if(cityCounty.equalsIgnoreCase("I") && (district.equalsIgnoreCase("1") || district.equalsIgnoreCase("01"))){
			result = "嘉義市";
		}else if(cityCounty.equalsIgnoreCase("J") && (district.equalsIgnoreCase("2") || district.equalsIgnoreCase("02"))){
			result = "竹東鎮";
		}else if(cityCounty.equalsIgnoreCase("J") && (district.equalsIgnoreCase("3") || district.equalsIgnoreCase("03"))){
			result = "關西鎮";
		}else if(cityCounty.equalsIgnoreCase("J") && (district.equalsIgnoreCase("4") || district.equalsIgnoreCase("04"))){
			result = "新埔鎮";
		}else if(cityCounty.equalsIgnoreCase("J") && (district.equalsIgnoreCase("5") || district.equalsIgnoreCase("05"))){
			result = "竹北市";
		}else if(cityCounty.equalsIgnoreCase("J") && (district.equalsIgnoreCase("6") || district.equalsIgnoreCase("06"))){
			result = "湖口鄉";
		}else if(cityCounty.equalsIgnoreCase("J") && (district.equalsIgnoreCase("8") || district.equalsIgnoreCase("08"))){
			result = "橫山鄉";
		}else if(cityCounty.equalsIgnoreCase("J") && (district.equalsIgnoreCase("9") || district.equalsIgnoreCase("09"))){
			result = "新豐鄉";
		}else if(cityCounty.equalsIgnoreCase("J") && district.equalsIgnoreCase("10")){
			result = "芎林鄉";
		}else if(cityCounty.equalsIgnoreCase("J") && district.equalsIgnoreCase("11")){
			result = "寶山鄉";
		}else if(cityCounty.equalsIgnoreCase("J") && district.equalsIgnoreCase("12")){
			result = "北埔鄉";
		}else if(cityCounty.equalsIgnoreCase("J") && district.equalsIgnoreCase("13")){
			result = "峨眉鄉";
		}else if(cityCounty.equalsIgnoreCase("J") && district.equalsIgnoreCase("14")){
			result = "尖石鄉";
		}else if(cityCounty.equalsIgnoreCase("J") && district.equalsIgnoreCase("15")){
			result = "五峰鄉";
		}else if(cityCounty.equalsIgnoreCase("K") && (district.equalsIgnoreCase("1") || district.equalsIgnoreCase("01"))){
			result = "苗栗市";
		}else if(cityCounty.equalsIgnoreCase("K") && (district.equalsIgnoreCase("2") || district.equalsIgnoreCase("02"))){
			result = "苑裡鎮";
		}else if(cityCounty.equalsIgnoreCase("K") && (district.equalsIgnoreCase("3") || district.equalsIgnoreCase("03"))){
			result = "通霄鎮";
		}else if(cityCounty.equalsIgnoreCase("K") && (district.equalsIgnoreCase("4") || district.equalsIgnoreCase("04"))){
			result = "公館鄉";
		}else if(cityCounty.equalsIgnoreCase("K") && (district.equalsIgnoreCase("5") || district.equalsIgnoreCase("05"))){
			result = "銅鑼鄉";
		}else if(cityCounty.equalsIgnoreCase("K") && (district.equalsIgnoreCase("6") || district.equalsIgnoreCase("06"))){
			result = "三義鄉";
		}else if(cityCounty.equalsIgnoreCase("K") && (district.equalsIgnoreCase("7") || district.equalsIgnoreCase("07"))){
			result = "西湖鄉";
		}else if(cityCounty.equalsIgnoreCase("K") && (district.equalsIgnoreCase("8") || district.equalsIgnoreCase("08"))){
			result = "頭屋鄉";
		}else if(cityCounty.equalsIgnoreCase("K") && (district.equalsIgnoreCase("9") || district.equalsIgnoreCase("09"))){
			result = "竹南鎮";
		}else if(cityCounty.equalsIgnoreCase("K") && district.equalsIgnoreCase("10")){
			result = "頭份市";
		}else if(cityCounty.equalsIgnoreCase("K") && district.equalsIgnoreCase("11")){
			result = "造橋鄉";
		}else if(cityCounty.equalsIgnoreCase("K") && district.equalsIgnoreCase("12")){
			result = "後龍鎮";
		}else if(cityCounty.equalsIgnoreCase("K") && district.equalsIgnoreCase("13")){
			result = "三灣鄉";
		}else if(cityCounty.equalsIgnoreCase("K") && district.equalsIgnoreCase("14")){
			result = "南庄鄉";
		}else if(cityCounty.equalsIgnoreCase("K") && district.equalsIgnoreCase("15")){
			result = "大湖鄉";
		}else if(cityCounty.equalsIgnoreCase("K") && district.equalsIgnoreCase("16")){
			result = "卓蘭鎮";
		}else if(cityCounty.equalsIgnoreCase("K") && district.equalsIgnoreCase("17")){
			result = "獅潭鄉";
		}else if(cityCounty.equalsIgnoreCase("K") && district.equalsIgnoreCase("18")){
			result = "泰安鄉";
		}else if(cityCounty.equalsIgnoreCase("M") && (district.equalsIgnoreCase("1") || district.equalsIgnoreCase("01"))){
			result = "南投市";
		}else if(cityCounty.equalsIgnoreCase("M") && (district.equalsIgnoreCase("2") || district.equalsIgnoreCase("02"))){
			result = "埔里鎮";
		}else if(cityCounty.equalsIgnoreCase("M") && (district.equalsIgnoreCase("3") || district.equalsIgnoreCase("03"))){
			result = "草屯鎮";
		}else if(cityCounty.equalsIgnoreCase("M") && (district.equalsIgnoreCase("4") || district.equalsIgnoreCase("04"))){
			result = "竹山鎮";
		}else if(cityCounty.equalsIgnoreCase("M") && (district.equalsIgnoreCase("5") || district.equalsIgnoreCase("05"))){
			result = "集集鎮";
		}else if(cityCounty.equalsIgnoreCase("M") && (district.equalsIgnoreCase("6") || district.equalsIgnoreCase("06"))){
			result = "名間鄉";
		}else if(cityCounty.equalsIgnoreCase("M") && (district.equalsIgnoreCase("7") || district.equalsIgnoreCase("07"))){
			result = "鹿谷鄉";
		}else if(cityCounty.equalsIgnoreCase("M") && (district.equalsIgnoreCase("8") || district.equalsIgnoreCase("08"))){
			result = "中寮鄉";
		}else if(cityCounty.equalsIgnoreCase("M") && (district.equalsIgnoreCase("9") || district.equalsIgnoreCase("09"))){
			result = "魚池鄉";
		}else if(cityCounty.equalsIgnoreCase("M") && district.equalsIgnoreCase("10")){
			result = "國姓鄉";
		}else if(cityCounty.equalsIgnoreCase("M") && district.equalsIgnoreCase("11")){
			result = "水里鄉";
		}else if(cityCounty.equalsIgnoreCase("M") && district.equalsIgnoreCase("12")){
			result = "信義鄉";
		}else if(cityCounty.equalsIgnoreCase("M") && district.equalsIgnoreCase("13")){
			result = "仁愛鄉";
		}else if(cityCounty.equalsIgnoreCase("N") && (district.equalsIgnoreCase("1") || district.equalsIgnoreCase("01"))){
			result = "彰化市";
		}else if(cityCounty.equalsIgnoreCase("N") && (district.equalsIgnoreCase("2") || district.equalsIgnoreCase("02"))){
			result = "鹿港鎮";
		}else if(cityCounty.equalsIgnoreCase("N") && (district.equalsIgnoreCase("3") || district.equalsIgnoreCase("03"))){
			result = "和美鎮";
		}else if(cityCounty.equalsIgnoreCase("N") && (district.equalsIgnoreCase("4") || district.equalsIgnoreCase("04"))){
			result = "北斗鎮";
		}else if(cityCounty.equalsIgnoreCase("N") && (district.equalsIgnoreCase("5") || district.equalsIgnoreCase("05"))){
			result = "員林市";
		}else if(cityCounty.equalsIgnoreCase("N") && (district.equalsIgnoreCase("6") || district.equalsIgnoreCase("06"))){
			result = "溪湖鎮";
		}else if(cityCounty.equalsIgnoreCase("N") && (district.equalsIgnoreCase("7") || district.equalsIgnoreCase("07"))){
			result = "田中鎮";
		}else if(cityCounty.equalsIgnoreCase("N") && (district.equalsIgnoreCase("8") || district.equalsIgnoreCase("08"))){
			result = "二林鎮";
		}else if(cityCounty.equalsIgnoreCase("N") && (district.equalsIgnoreCase("9") || district.equalsIgnoreCase("09"))){
			result = "線西鄉";
		}else if(cityCounty.equalsIgnoreCase("N") && district.equalsIgnoreCase("10")){
			result = "伸港鄉";
		}else if(cityCounty.equalsIgnoreCase("N") && district.equalsIgnoreCase("11")){
			result = "福興鄉";
		}else if(cityCounty.equalsIgnoreCase("N") && district.equalsIgnoreCase("12")){
			result = "秀水鄉";
		}else if(cityCounty.equalsIgnoreCase("N") && district.equalsIgnoreCase("13")){
			result = "花壇鄉";
		}else if(cityCounty.equalsIgnoreCase("N") && district.equalsIgnoreCase("14")){
			result = "芬園鄉";
		}else if(cityCounty.equalsIgnoreCase("N") && district.equalsIgnoreCase("15")){
			result = "大村鄉";
		}else if(cityCounty.equalsIgnoreCase("N") && district.equalsIgnoreCase("16")){
			result = "埔鹽鄉";
		}else if(cityCounty.equalsIgnoreCase("N") && district.equalsIgnoreCase("17")){
			result = "埔心鄉";
		}else if(cityCounty.equalsIgnoreCase("N") && district.equalsIgnoreCase("18")){
			result = "永靖鄉";
		}else if(cityCounty.equalsIgnoreCase("N") && district.equalsIgnoreCase("19")){
			result = "社頭鄉";
		}else if(cityCounty.equalsIgnoreCase("N") && district.equalsIgnoreCase("20")){
			result = "二水鄉";
		}else if(cityCounty.equalsIgnoreCase("N") && district.equalsIgnoreCase("21")){
			result = "田尾鄉";
		}else if(cityCounty.equalsIgnoreCase("N") && district.equalsIgnoreCase("22")){
			result = "埤頭鄉";
		}else if(cityCounty.equalsIgnoreCase("N") && district.equalsIgnoreCase("23")){
			result = "芳苑鄉";
		}else if(cityCounty.equalsIgnoreCase("N") && district.equalsIgnoreCase("24")){
			result = "大城鄉";
		}else if(cityCounty.equalsIgnoreCase("N") && district.equalsIgnoreCase("25")){
			result = "竹塘鄉";
		}else if(cityCounty.equalsIgnoreCase("N") && district.equalsIgnoreCase("26")){
			result = "溪州鄉";
		}else if(cityCounty.equalsIgnoreCase("O") && (district.equalsIgnoreCase("1") || district.equalsIgnoreCase("01"))){
			result = "新竹市";
		}else if(cityCounty.equalsIgnoreCase("P") && (district.equalsIgnoreCase("1") || district.equalsIgnoreCase("01"))){
			result = "斗六市";
		}else if(cityCounty.equalsIgnoreCase("P") && (district.equalsIgnoreCase("2") || district.equalsIgnoreCase("02"))){
			result = "斗南鎮";
		}else if(cityCounty.equalsIgnoreCase("P") && (district.equalsIgnoreCase("3") || district.equalsIgnoreCase("03"))){
			result = "虎尾鎮";
		}else if(cityCounty.equalsIgnoreCase("P") && (district.equalsIgnoreCase("4") || district.equalsIgnoreCase("04"))){
			result = "西螺鎮";
		}else if(cityCounty.equalsIgnoreCase("P") && (district.equalsIgnoreCase("5") || district.equalsIgnoreCase("05"))){
			result = "土庫鎮";
		}else if(cityCounty.equalsIgnoreCase("P") && (district.equalsIgnoreCase("6") || district.equalsIgnoreCase("06"))){
			result = "北港鎮";
		}else if(cityCounty.equalsIgnoreCase("P") && (district.equalsIgnoreCase("7") || district.equalsIgnoreCase("07"))){
			result = "古坑鄉";
		}else if(cityCounty.equalsIgnoreCase("P") && (district.equalsIgnoreCase("8") || district.equalsIgnoreCase("08"))){
			result = "大埤鄉";
		}else if(cityCounty.equalsIgnoreCase("P") && (district.equalsIgnoreCase("9") || district.equalsIgnoreCase("09"))){
			result = "莿桐鄉";
		}else if(cityCounty.equalsIgnoreCase("P") && district.equalsIgnoreCase("10")){
			result = "林內鄉";
		}else if(cityCounty.equalsIgnoreCase("P") && district.equalsIgnoreCase("11")){
			result = "二崙鄉";
		}else if(cityCounty.equalsIgnoreCase("P") && district.equalsIgnoreCase("12")){
			result = "崙背鄉";
		}else if(cityCounty.equalsIgnoreCase("P") && district.equalsIgnoreCase("13")){
			result = "麥寮鄉";
		}else if(cityCounty.equalsIgnoreCase("P") && district.equalsIgnoreCase("14")){
			result = "東勢鄉";
		}else if(cityCounty.equalsIgnoreCase("P") && district.equalsIgnoreCase("15")){
			result = "褒忠鄉";
		}else if(cityCounty.equalsIgnoreCase("P") && district.equalsIgnoreCase("16")){
			result = "台西鄉";
		}else if(cityCounty.equalsIgnoreCase("P") && district.equalsIgnoreCase("17")){
			result = "元長鄉";
		}else if(cityCounty.equalsIgnoreCase("P") && district.equalsIgnoreCase("18")){
			result = "四湖鄉";
		}else if(cityCounty.equalsIgnoreCase("P") && district.equalsIgnoreCase("19")){
			result = "口湖鄉";
		}else if(cityCounty.equalsIgnoreCase("P") && district.equalsIgnoreCase("20")){
			result = "水林鄉";
		}else if(cityCounty.equalsIgnoreCase("Q") && (district.equalsIgnoreCase("2") || district.equalsIgnoreCase("02"))){
			result = "朴子市";
		}else if(cityCounty.equalsIgnoreCase("Q") && (district.equalsIgnoreCase("3") || district.equalsIgnoreCase("03"))){
			result = "布袋鎮";
		}else if(cityCounty.equalsIgnoreCase("Q") && (district.equalsIgnoreCase("4") || district.equalsIgnoreCase("04"))){
			result = "大林鎮";
		}else if(cityCounty.equalsIgnoreCase("Q") && (district.equalsIgnoreCase("5") || district.equalsIgnoreCase("05"))){
			result = "民雄鄉";
		}else if(cityCounty.equalsIgnoreCase("Q") && (district.equalsIgnoreCase("6") || district.equalsIgnoreCase("06"))){
			result = "溪口鄉";
		}else if(cityCounty.equalsIgnoreCase("Q") && (district.equalsIgnoreCase("7") || district.equalsIgnoreCase("07"))){
			result = "新港鄉";
		}else if(cityCounty.equalsIgnoreCase("Q") && (district.equalsIgnoreCase("8") || district.equalsIgnoreCase("08"))){
			result = "六腳鄉";
		}else if(cityCounty.equalsIgnoreCase("Q") && (district.equalsIgnoreCase("9") || district.equalsIgnoreCase("09"))){
			result = "東石鄉";
		}else if(cityCounty.equalsIgnoreCase("Q") && district.equalsIgnoreCase("10")){
			result = "義竹鄉";
		}else if(cityCounty.equalsIgnoreCase("Q") && district.equalsIgnoreCase("11")){
			result = "鹿草鄉";
		}else if(cityCounty.equalsIgnoreCase("Q") && district.equalsIgnoreCase("12")){
			result = "太保市";
		}else if(cityCounty.equalsIgnoreCase("Q") && district.equalsIgnoreCase("13")){
			result = "水上鄉";
		}else if(cityCounty.equalsIgnoreCase("Q") && district.equalsIgnoreCase("14")){
			result = "中埔鄉";
		}else if(cityCounty.equalsIgnoreCase("Q") && district.equalsIgnoreCase("15")){
			result = "竹崎鄉";
		}else if(cityCounty.equalsIgnoreCase("Q") && district.equalsIgnoreCase("16")){
			result = "梅山鄉";
		}else if(cityCounty.equalsIgnoreCase("Q") && district.equalsIgnoreCase("17")){
			result = "番路鄉";
		}else if(cityCounty.equalsIgnoreCase("Q") && district.equalsIgnoreCase("18")){
			result = "大埔鄉";
		}else if(cityCounty.equalsIgnoreCase("Q") && district.equalsIgnoreCase("20")){
			result = "阿里山鄉";
		}else if(cityCounty.equalsIgnoreCase("T") && (district.equalsIgnoreCase("1") || district.equalsIgnoreCase("01"))){
			result = "屏東市";
		}else if(cityCounty.equalsIgnoreCase("T") && (district.equalsIgnoreCase("2") || district.equalsIgnoreCase("02"))){
			result = "潮州鎮";
		}else if(cityCounty.equalsIgnoreCase("T") && (district.equalsIgnoreCase("3") || district.equalsIgnoreCase("03"))){
			result = "東港鎮";
		}else if(cityCounty.equalsIgnoreCase("T") && (district.equalsIgnoreCase("4") || district.equalsIgnoreCase("04"))){
			result = "恆春鎮";
		}else if(cityCounty.equalsIgnoreCase("T") && (district.equalsIgnoreCase("5") || district.equalsIgnoreCase("05"))){
			result = "萬丹鄉";
		}else if(cityCounty.equalsIgnoreCase("T") && (district.equalsIgnoreCase("6") || district.equalsIgnoreCase("06"))){
			result = "長治鄉";
		}else if(cityCounty.equalsIgnoreCase("T") && (district.equalsIgnoreCase("7") || district.equalsIgnoreCase("07"))){
			result = "麟洛鄉";
		}else if(cityCounty.equalsIgnoreCase("T") && (district.equalsIgnoreCase("8") || district.equalsIgnoreCase("08"))){
			result = "九如鄉";
		}else if(cityCounty.equalsIgnoreCase("T") && (district.equalsIgnoreCase("9") || district.equalsIgnoreCase("09"))){
			result = "里港鄉";
		}else if(cityCounty.equalsIgnoreCase("T") && district.equalsIgnoreCase("10")){
			result = "鹽埔鄉";
		}else if(cityCounty.equalsIgnoreCase("T") && district.equalsIgnoreCase("11")){
			result = "高樹鄉";
		}else if(cityCounty.equalsIgnoreCase("T") && district.equalsIgnoreCase("12")){
			result = "萬巒鄉";
		}else if(cityCounty.equalsIgnoreCase("T") && district.equalsIgnoreCase("13")){
			result = "內埔鄉";
		}else if(cityCounty.equalsIgnoreCase("T") && district.equalsIgnoreCase("14")){
			result = "竹田鄉";
		}else if(cityCounty.equalsIgnoreCase("T") && district.equalsIgnoreCase("15")){
			result = "新埤鄉";
		}else if(cityCounty.equalsIgnoreCase("T") && district.equalsIgnoreCase("16")){
			result = "枋寮鄉";
		}else if(cityCounty.equalsIgnoreCase("T") && district.equalsIgnoreCase("17")){
			result = "新園鄉";
		}else if(cityCounty.equalsIgnoreCase("T") && district.equalsIgnoreCase("18")){
			result = "崁頂鄉";
		}else if(cityCounty.equalsIgnoreCase("T") && district.equalsIgnoreCase("19")){
			result = "林邊鄉";
		}else if(cityCounty.equalsIgnoreCase("T") && district.equalsIgnoreCase("20")){
			result = "南州鄉";
		}else if(cityCounty.equalsIgnoreCase("T") && district.equalsIgnoreCase("21")){
			result = "佳冬鄉";
		}else if(cityCounty.equalsIgnoreCase("T") && district.equalsIgnoreCase("22")){
			result = "琉球鄉";
		}else if(cityCounty.equalsIgnoreCase("T") && district.equalsIgnoreCase("23")){
			result = "車城鄉";
		}else if(cityCounty.equalsIgnoreCase("T") && district.equalsIgnoreCase("24")){
			result = "滿州鄉";
		}else if(cityCounty.equalsIgnoreCase("T") && district.equalsIgnoreCase("25")){
			result = "枋山鄉";
		}else if(cityCounty.equalsIgnoreCase("T") && district.equalsIgnoreCase("26")){
			result = "三地門鄉";
		}else if(cityCounty.equalsIgnoreCase("T") && district.equalsIgnoreCase("27")){
			result = "霧臺鄉";
		}else if(cityCounty.equalsIgnoreCase("T") && district.equalsIgnoreCase("28")){
			result = "瑪家鄉";
		}else if(cityCounty.equalsIgnoreCase("T") && district.equalsIgnoreCase("29")){
			result = "泰武鄉";
		}else if(cityCounty.equalsIgnoreCase("T") && district.equalsIgnoreCase("30")){
			result = "來義鄉";
		}else if(cityCounty.equalsIgnoreCase("T") && district.equalsIgnoreCase("31")){
			result = "春日鄉";
		}else if(cityCounty.equalsIgnoreCase("T") && district.equalsIgnoreCase("32")){
			result = "獅子鄉";
		}else if(cityCounty.equalsIgnoreCase("T") && district.equalsIgnoreCase("33")){
			result = "牡丹鄉";
		}else if(cityCounty.equalsIgnoreCase("U") && (district.equalsIgnoreCase("1") || district.equalsIgnoreCase("01"))){
			result = "花蓮市";
		}else if(cityCounty.equalsIgnoreCase("U") && (district.equalsIgnoreCase("2") || district.equalsIgnoreCase("02"))){
			result = "光復鄉";
		}else if(cityCounty.equalsIgnoreCase("U") && (district.equalsIgnoreCase("3") || district.equalsIgnoreCase("03"))){
			result = "玉里鎮";
		}else if(cityCounty.equalsIgnoreCase("U") && (district.equalsIgnoreCase("4") || district.equalsIgnoreCase("04"))){
			result = "新城鄉";
		}else if(cityCounty.equalsIgnoreCase("U") && (district.equalsIgnoreCase("5") || district.equalsIgnoreCase("05"))){
			result = "吉安鄉";
		}else if(cityCounty.equalsIgnoreCase("U") && (district.equalsIgnoreCase("6") || district.equalsIgnoreCase("06"))){
			result = "壽豐鄉";
		}else if(cityCounty.equalsIgnoreCase("U") && (district.equalsIgnoreCase("7") || district.equalsIgnoreCase("07"))){
			result = "鳳林鎮";
		}else if(cityCounty.equalsIgnoreCase("U") && (district.equalsIgnoreCase("8") || district.equalsIgnoreCase("08"))){
			result = "豐濱鄉";
		}else if(cityCounty.equalsIgnoreCase("U") && (district.equalsIgnoreCase("9") || district.equalsIgnoreCase("09"))){
			result = "瑞穗鄉";
		}else if(cityCounty.equalsIgnoreCase("U") && district.equalsIgnoreCase("10")){
			result = "富里鄉";
		}else if(cityCounty.equalsIgnoreCase("U") && district.equalsIgnoreCase("11")){
			result = "秀林鄉";
		}else if(cityCounty.equalsIgnoreCase("U") && district.equalsIgnoreCase("12")){
			result = "萬榮鄉";
		}else if(cityCounty.equalsIgnoreCase("U") && district.equalsIgnoreCase("13")){
			result = "卓溪鄉";
		}else if(cityCounty.equalsIgnoreCase("V") && (district.equalsIgnoreCase("1") || district.equalsIgnoreCase("01"))){
			result = "台東市";
		}else if(cityCounty.equalsIgnoreCase("V") && (district.equalsIgnoreCase("2") || district.equalsIgnoreCase("02"))){
			result = "成功鎮";
		}else if(cityCounty.equalsIgnoreCase("V") && (district.equalsIgnoreCase("3") || district.equalsIgnoreCase("03"))){
			result = "關山鎮";
		}else if(cityCounty.equalsIgnoreCase("V") && (district.equalsIgnoreCase("4") || district.equalsIgnoreCase("04"))){
			result = "卑南鄉";
		}else if(cityCounty.equalsIgnoreCase("V") && (district.equalsIgnoreCase("5") || district.equalsIgnoreCase("05"))){
			result = "大武鄉";
		}else if(cityCounty.equalsIgnoreCase("V") && (district.equalsIgnoreCase("6") || district.equalsIgnoreCase("06"))){
			result = "太麻里鄉";
		}else if(cityCounty.equalsIgnoreCase("V") && (district.equalsIgnoreCase("7") || district.equalsIgnoreCase("07"))){
			result = "東河鄉";
		}else if(cityCounty.equalsIgnoreCase("V") && (district.equalsIgnoreCase("8") || district.equalsIgnoreCase("08"))){
			result = "長濱鄉";
		}else if(cityCounty.equalsIgnoreCase("V") && (district.equalsIgnoreCase("9") || district.equalsIgnoreCase("09"))){
			result = "鹿野鄉";
		}else if(cityCounty.equalsIgnoreCase("V") && district.equalsIgnoreCase("10")){
			result = "池上鄉";
		}else if(cityCounty.equalsIgnoreCase("V") && district.equalsIgnoreCase("11")){
			result = "綠島鄉";
		}else if(cityCounty.equalsIgnoreCase("V") && district.equalsIgnoreCase("12")){
			result = "延平鄉";
		}else if(cityCounty.equalsIgnoreCase("V") && district.equalsIgnoreCase("13")){
			result = "海端鄉";
		}else if(cityCounty.equalsIgnoreCase("V") && district.equalsIgnoreCase("14")){
			result = "達仁鄉";
		}else if(cityCounty.equalsIgnoreCase("V") && district.equalsIgnoreCase("15")){
			result = "金峰鄉";
		}else if(cityCounty.equalsIgnoreCase("V") && district.equalsIgnoreCase("16")){
			result = "蘭嶼鄉";
		}else if(cityCounty.equalsIgnoreCase("W") && (district.equalsIgnoreCase("1") || district.equalsIgnoreCase("01"))){
			result = "金湖鎮";
		}else if(cityCounty.equalsIgnoreCase("W") && (district.equalsIgnoreCase("2") || district.equalsIgnoreCase("02"))){
			result = "金沙鎮";
		}else if(cityCounty.equalsIgnoreCase("W") && (district.equalsIgnoreCase("3") || district.equalsIgnoreCase("03"))){
			result = "金城鎮";
		}else if(cityCounty.equalsIgnoreCase("W") && (district.equalsIgnoreCase("4") || district.equalsIgnoreCase("04"))){
			result = "金寧鄉";
		}else if(cityCounty.equalsIgnoreCase("W") && (district.equalsIgnoreCase("5") || district.equalsIgnoreCase("05"))){
			result = "烈嶼鄉";
		}else if(cityCounty.equalsIgnoreCase("W") && (district.equalsIgnoreCase("6") || district.equalsIgnoreCase("06"))){
			result = "烏坵鄉";
		}else if(cityCounty.equalsIgnoreCase("X") && (district.equalsIgnoreCase("1") || district.equalsIgnoreCase("01"))){
			result = "馬公市";
		}else if(cityCounty.equalsIgnoreCase("X") && (district.equalsIgnoreCase("2") || district.equalsIgnoreCase("02"))){
			result = "湖西鄉";
		}else if(cityCounty.equalsIgnoreCase("X") && (district.equalsIgnoreCase("3") || district.equalsIgnoreCase("03"))){
			result = "白沙鄉";
		}else if(cityCounty.equalsIgnoreCase("X") && (district.equalsIgnoreCase("4") || district.equalsIgnoreCase("04"))){
			result = "西嶼鄉";
		}else if(cityCounty.equalsIgnoreCase("X") && (district.equalsIgnoreCase("5") || district.equalsIgnoreCase("05"))){
			result = "望安鄉";
		}else if(cityCounty.equalsIgnoreCase("X") && (district.equalsIgnoreCase("6") || district.equalsIgnoreCase("06"))){
			result = "七美鄉";
		}else if(cityCounty.equalsIgnoreCase("Z") && (district.equalsIgnoreCase("1") || district.equalsIgnoreCase("01"))){
			result = "南竿鄉";
		}else if(cityCounty.equalsIgnoreCase("Z") && (district.equalsIgnoreCase("2") || district.equalsIgnoreCase("02"))){
			result = "北竿鄉";
		}else if(cityCounty.equalsIgnoreCase("Z") && (district.equalsIgnoreCase("3") || district.equalsIgnoreCase("03"))){
			result = "莒光鄉";
		}else if(cityCounty.equalsIgnoreCase("Z") && (district.equalsIgnoreCase("4") || district.equalsIgnoreCase("04"))){
			result = "東引鄉";
		}else {
			result = district;
			m_logger.info(WhiteBox.logForging("(cityCounty,district)無對應:("+cityCounty+","+district+")"));
		}
		
		return result;
	}
	/*
	public static String getDistrict(String cityCounty, String district) {
		String result="";
		if(cityCounty == null) {
			result = district;
			m_logger.info(WhiteBox.logForging("(cityCounty,district)無對應:("+cityCounty+","+district+")");
			return result;
		}		
		if(cityCounty.equalsIgnoreCase("A") && district.equalsIgnoreCase("1")){
			result = "松山區";
		}else if(cityCounty.equalsIgnoreCase("A") && district.equalsIgnoreCase("2")){
			result = "大安區";
		}else if(cityCounty.equalsIgnoreCase("A") && district.equalsIgnoreCase("3")){
			result = "中正區";
		}else if(cityCounty.equalsIgnoreCase("A") && district.equalsIgnoreCase("3")){
			result = "中正區";
		}else if(cityCounty.equalsIgnoreCase("A") && district.equalsIgnoreCase("5")){
			result = "萬華區";
		}else if(cityCounty.equalsIgnoreCase("A") && district.equalsIgnoreCase("9")){
			result = "大同區";
		}else if(cityCounty.equalsIgnoreCase("A") && district.equalsIgnoreCase("10")){
			result = "中山區";
		}else if(cityCounty.equalsIgnoreCase("A") && district.equalsIgnoreCase("11")){
			result = "文山區";
		}else if(cityCounty.equalsIgnoreCase("A") && district.equalsIgnoreCase("13")){
			result = "南港區";
		}else if(cityCounty.equalsIgnoreCase("A") && district.equalsIgnoreCase("14")){
			result = "內湖區";
		}else if(cityCounty.equalsIgnoreCase("A") && district.equalsIgnoreCase("15")){
			result = "士林區";
		}else if(cityCounty.equalsIgnoreCase("A") && district.equalsIgnoreCase("16")){
			result = "北投區";
		}else if(cityCounty.equalsIgnoreCase("A") && district.equalsIgnoreCase("17")){
			result = "信義區";
		}else if(cityCounty.equalsIgnoreCase("B") && district.equalsIgnoreCase("1")){
			result = "中區";
		}else if(cityCounty.equalsIgnoreCase("B") && district.equalsIgnoreCase("2")){
			result = "東區";
		}else if(cityCounty.equalsIgnoreCase("B") && district.equalsIgnoreCase("3")){
			result = "南區";
		}else if(cityCounty.equalsIgnoreCase("B") && district.equalsIgnoreCase("4")){
			result = "西區";
		}else if(cityCounty.equalsIgnoreCase("B") && district.equalsIgnoreCase("5")){
			result = "北區";
		}else if(cityCounty.equalsIgnoreCase("B") && district.equalsIgnoreCase("6")){
			result = "西屯區";
		}else if(cityCounty.equalsIgnoreCase("B") && district.equalsIgnoreCase("7")){
			result = "南屯區";
		}else if(cityCounty.equalsIgnoreCase("B") && district.equalsIgnoreCase("8")){
			result = "北屯區";
		}else if(cityCounty.equalsIgnoreCase("B") && district.equalsIgnoreCase("9")){
			result = "豐原區";
		}else if(cityCounty.equalsIgnoreCase("B") && district.equalsIgnoreCase("10")){
			result = "東勢區";
		}else if(cityCounty.equalsIgnoreCase("B") && district.equalsIgnoreCase("11")){
			result = "大甲區";
		}else if(cityCounty.equalsIgnoreCase("B") && district.equalsIgnoreCase("12")){
			result = "清水區";
		}else if(cityCounty.equalsIgnoreCase("B") && district.equalsIgnoreCase("13")){
			result = "沙鹿區";
		}else if(cityCounty.equalsIgnoreCase("B") && district.equalsIgnoreCase("14")){
			result = "梧棲區";
		}else if(cityCounty.equalsIgnoreCase("B") && district.equalsIgnoreCase("15")){
			result = "后里區";
		}else if(cityCounty.equalsIgnoreCase("B") && district.equalsIgnoreCase("16")){
			result = "神岡區";
		}else if(cityCounty.equalsIgnoreCase("B") && district.equalsIgnoreCase("17")){
			result = "潭子區";
		}else if(cityCounty.equalsIgnoreCase("B") && district.equalsIgnoreCase("18")){
			result = "大雅區";
		}else if(cityCounty.equalsIgnoreCase("B") && district.equalsIgnoreCase("19")){
			result = "新社區";
		}else if(cityCounty.equalsIgnoreCase("B") && district.equalsIgnoreCase("20")){
			result = "石岡區";
		}else if(cityCounty.equalsIgnoreCase("B") && district.equalsIgnoreCase("21")){
			result = "外埔區";
		}else if(cityCounty.equalsIgnoreCase("B") && district.equalsIgnoreCase("22")){
			result = "大安區";
		}else if(cityCounty.equalsIgnoreCase("B") && district.equalsIgnoreCase("23")){
			result = "烏日區";
		}else if(cityCounty.equalsIgnoreCase("B") && district.equalsIgnoreCase("24")){
			result = "大肚區";
		}else if(cityCounty.equalsIgnoreCase("B") && district.equalsIgnoreCase("25")){
			result = "龍井區";
		}else if(cityCounty.equalsIgnoreCase("B") && district.equalsIgnoreCase("26")){
			result = "霧峰區";
		}else if(cityCounty.equalsIgnoreCase("B") && district.equalsIgnoreCase("27")){
			result = "太平區";
		}else if(cityCounty.equalsIgnoreCase("B") && district.equalsIgnoreCase("28")){
			result = "大里區";
		}else if(cityCounty.equalsIgnoreCase("B") && district.equalsIgnoreCase("29")){
			result = "和平區";
		}else if(cityCounty.equalsIgnoreCase("C") && district.equalsIgnoreCase("1")){
			result = "中正區";
		}else if(cityCounty.equalsIgnoreCase("C") && district.equalsIgnoreCase("2")){
			result = "七堵區";
		}else if(cityCounty.equalsIgnoreCase("C") && district.equalsIgnoreCase("3")){
			result = "暖暖區";
		}else if(cityCounty.equalsIgnoreCase("C") && district.equalsIgnoreCase("4")){
			result = "仁愛區";
		}else if(cityCounty.equalsIgnoreCase("C") && district.equalsIgnoreCase("5")){
			result = "中山區";
		}else if(cityCounty.equalsIgnoreCase("C") && district.equalsIgnoreCase("6")){
			result = "安樂區";
		}else if(cityCounty.equalsIgnoreCase("C") && district.equalsIgnoreCase("7")){
			result = "信義區";
		}else if(cityCounty.equalsIgnoreCase("D") && district.equalsIgnoreCase("1")){
			result = "東區";
		}else if(cityCounty.equalsIgnoreCase("D") && district.equalsIgnoreCase("2")){
			result = "南區";
		}else if(cityCounty.equalsIgnoreCase("D") && district.equalsIgnoreCase("4")){
			result = "北區";
		}else if(cityCounty.equalsIgnoreCase("D") && district.equalsIgnoreCase("6")){
			result = "安南區";
		}else if(cityCounty.equalsIgnoreCase("D") && district.equalsIgnoreCase("7")){
			result = "安平區";
		}else if(cityCounty.equalsIgnoreCase("D") && district.equalsIgnoreCase("8")){
			result = "中西區";
		}else if(cityCounty.equalsIgnoreCase("D") && district.equalsIgnoreCase("9")){
			result = "新營區";
		}else if(cityCounty.equalsIgnoreCase("D") && district.equalsIgnoreCase("10")){
			result = "鹽水區";
		}else if(cityCounty.equalsIgnoreCase("D") && district.equalsIgnoreCase("11")){
			result = "柳營區";
		}else if(cityCounty.equalsIgnoreCase("D") && district.equalsIgnoreCase("12")){
			result = "白河區";
		}else if(cityCounty.equalsIgnoreCase("D") && district.equalsIgnoreCase("13")){
			result = "後壁區";
		}else if(cityCounty.equalsIgnoreCase("D") && district.equalsIgnoreCase("14")){
			result = "東山區";
		}else if(cityCounty.equalsIgnoreCase("D") && district.equalsIgnoreCase("15")){
			result = "麻豆區";
		}else if(cityCounty.equalsIgnoreCase("D") && district.equalsIgnoreCase("16")){
			result = "下營區";
		}else if(cityCounty.equalsIgnoreCase("D") && district.equalsIgnoreCase("17")){
			result = "六甲區";
		}else if(cityCounty.equalsIgnoreCase("D") && district.equalsIgnoreCase("18")){
			result = "官田區";
		}else if(cityCounty.equalsIgnoreCase("D") && district.equalsIgnoreCase("19")){
			result = "大內區";
		}else if(cityCounty.equalsIgnoreCase("D") && district.equalsIgnoreCase("20")){
			result = "佳里區";
		}else if(cityCounty.equalsIgnoreCase("D") && district.equalsIgnoreCase("21")){
			result = "西港區";
		}else if(cityCounty.equalsIgnoreCase("D") && district.equalsIgnoreCase("22")){
			result = "七股區";
		}else if(cityCounty.equalsIgnoreCase("D") && district.equalsIgnoreCase("23")){
			result = "將軍區";
		}else if(cityCounty.equalsIgnoreCase("D") && district.equalsIgnoreCase("24")){
			result = "北門區";
		}else if(cityCounty.equalsIgnoreCase("D") && district.equalsIgnoreCase("25")){
			result = "學甲區";
		}else if(cityCounty.equalsIgnoreCase("D") && district.equalsIgnoreCase("26")){
			result = "新化區";
		}else if(cityCounty.equalsIgnoreCase("D") && district.equalsIgnoreCase("27")){
			result = "善化區";
		}else if(cityCounty.equalsIgnoreCase("D") && district.equalsIgnoreCase("28")){
			result = "新市區";
		}else if(cityCounty.equalsIgnoreCase("D") && district.equalsIgnoreCase("29")){
			result = "安定區";
		}else if(cityCounty.equalsIgnoreCase("D") && district.equalsIgnoreCase("30")){
			result = "山上區";
		}else if(cityCounty.equalsIgnoreCase("D") && district.equalsIgnoreCase("31")){
			result = "左鎮區";
		}else if(cityCounty.equalsIgnoreCase("D") && district.equalsIgnoreCase("32")){
			result = "仁德區";
		}else if(cityCounty.equalsIgnoreCase("D") && district.equalsIgnoreCase("33")){
			result = "歸仁區";
		}else if(cityCounty.equalsIgnoreCase("D") && district.equalsIgnoreCase("34")){
			result = "關廟區";
		}else if(cityCounty.equalsIgnoreCase("D") && district.equalsIgnoreCase("35")){
			result = "龍崎區";
		}else if(cityCounty.equalsIgnoreCase("D") && district.equalsIgnoreCase("36")){
			result = "玉井區";
		}else if(cityCounty.equalsIgnoreCase("D") && district.equalsIgnoreCase("37")){
			result = "楠西區";
		}else if(cityCounty.equalsIgnoreCase("D") && district.equalsIgnoreCase("38")){
			result = "南化區";
		}else if(cityCounty.equalsIgnoreCase("D") && district.equalsIgnoreCase("39")){
			result = "永康區";
		}else if(cityCounty.equalsIgnoreCase("E") && district.equalsIgnoreCase("1")){
			result = "鹽埕區";
		}else if(cityCounty.equalsIgnoreCase("E") && district.equalsIgnoreCase("2")){
			result = "鼓山區";
		}else if(cityCounty.equalsIgnoreCase("E") && district.equalsIgnoreCase("3")){
			result = "左營區";
		}else if(cityCounty.equalsIgnoreCase("E") && district.equalsIgnoreCase("4")){
			result = "楠梓區";
		}else if(cityCounty.equalsIgnoreCase("E") && district.equalsIgnoreCase("5")){
			result = "三民區";
		}else if(cityCounty.equalsIgnoreCase("E") && district.equalsIgnoreCase("6")){
			result = "新興區";
		}else if(cityCounty.equalsIgnoreCase("E") && district.equalsIgnoreCase("7")){
			result = "前金區";
		}else if(cityCounty.equalsIgnoreCase("E") && district.equalsIgnoreCase("8")){
			result = "苓雅區";
		}else if(cityCounty.equalsIgnoreCase("E") && district.equalsIgnoreCase("9")){
			result = "前鎮區";
		}else if(cityCounty.equalsIgnoreCase("E") && district.equalsIgnoreCase("10")){
			result = "旗津區";
		}else if(cityCounty.equalsIgnoreCase("E") && district.equalsIgnoreCase("11")){
			result = "小港區";
		}else if(cityCounty.equalsIgnoreCase("E") && district.equalsIgnoreCase("12")){
			result = "鳳山區";
		}else if(cityCounty.equalsIgnoreCase("E") && district.equalsIgnoreCase("13")){
			result = "林園區";
		}else if(cityCounty.equalsIgnoreCase("E") && district.equalsIgnoreCase("14")){
			result = "大寮區";
		}else if(cityCounty.equalsIgnoreCase("E") && district.equalsIgnoreCase("15")){
			result = "大樹區";
		}else if(cityCounty.equalsIgnoreCase("E") && district.equalsIgnoreCase("16")){
			result = "大社區";
		}else if(cityCounty.equalsIgnoreCase("E") && district.equalsIgnoreCase("17")){
			result = "仁武區";
		}else if(cityCounty.equalsIgnoreCase("E") && district.equalsIgnoreCase("18")){
			result = "鳥松區";
		}else if(cityCounty.equalsIgnoreCase("E") && district.equalsIgnoreCase("19")){
			result = "岡山區";
		}else if(cityCounty.equalsIgnoreCase("E") && district.equalsIgnoreCase("20")){
			result = "橋頭區";
		}else if(cityCounty.equalsIgnoreCase("E") && district.equalsIgnoreCase("21")){
			result = "燕巢區";
		}else if(cityCounty.equalsIgnoreCase("E") && district.equalsIgnoreCase("22")){
			result = "田寮區";
		}else if(cityCounty.equalsIgnoreCase("E") && district.equalsIgnoreCase("23")){
			result = "阿蓮區";
		}else if(cityCounty.equalsIgnoreCase("E") && district.equalsIgnoreCase("24")){
			result = "路竹區";
		}else if(cityCounty.equalsIgnoreCase("E") && district.equalsIgnoreCase("25")){
			result = "湖內區";
		}else if(cityCounty.equalsIgnoreCase("E") && district.equalsIgnoreCase("26")){
			result = "茄萣區";
		}else if(cityCounty.equalsIgnoreCase("E") && district.equalsIgnoreCase("27")){
			result = "永安區";
		}else if(cityCounty.equalsIgnoreCase("E") && district.equalsIgnoreCase("28")){
			result = "彌陀區";
		}else if(cityCounty.equalsIgnoreCase("E") && district.equalsIgnoreCase("29")){
			result = "梓官區";
		}else if(cityCounty.equalsIgnoreCase("E") && district.equalsIgnoreCase("30")){
			result = "旗山區";
		}else if(cityCounty.equalsIgnoreCase("E") && district.equalsIgnoreCase("31")){
			result = "美濃區";
		}else if(cityCounty.equalsIgnoreCase("E") && district.equalsIgnoreCase("32")){
			result = "六龜區";
		}else if(cityCounty.equalsIgnoreCase("E") && district.equalsIgnoreCase("33")){
			result = "甲仙區";
		}else if(cityCounty.equalsIgnoreCase("E") && district.equalsIgnoreCase("34")){
			result = "杉林區";
		}else if(cityCounty.equalsIgnoreCase("E") && district.equalsIgnoreCase("35")){
			result = "內門區";
		}else if(cityCounty.equalsIgnoreCase("E") && district.equalsIgnoreCase("36")){
			result = "茂林區";
		}else if(cityCounty.equalsIgnoreCase("E") && district.equalsIgnoreCase("37")){
			result = "桃源區";
		}else if(cityCounty.equalsIgnoreCase("E") && district.equalsIgnoreCase("38")){
			result = "那瑪夏區";
		}else if(cityCounty.equalsIgnoreCase("F") && district.equalsIgnoreCase("1")){
			result = "新莊區";
		}else if(cityCounty.equalsIgnoreCase("F") && district.equalsIgnoreCase("2")){
			result = "林口區";
		}else if(cityCounty.equalsIgnoreCase("F") && district.equalsIgnoreCase("3")){
			result = "五股區";
		}else if(cityCounty.equalsIgnoreCase("F") && district.equalsIgnoreCase("4")){
			result = "蘆洲區";
		}else if(cityCounty.equalsIgnoreCase("F") && district.equalsIgnoreCase("5")){
			result = "三重區";
		}else if(cityCounty.equalsIgnoreCase("F") && district.equalsIgnoreCase("6")){
			result = "泰山區";
		}else if(cityCounty.equalsIgnoreCase("F") && district.equalsIgnoreCase("7")){
			result = "新店區";
		}else if(cityCounty.equalsIgnoreCase("F") && district.equalsIgnoreCase("8")){
			result = "石碇區";
		}else if(cityCounty.equalsIgnoreCase("F") && district.equalsIgnoreCase("9")){
			result = "深坑區";
		}else if(cityCounty.equalsIgnoreCase("F") && district.equalsIgnoreCase("10")){
			result = "坪林區";
		}else if(cityCounty.equalsIgnoreCase("F") && district.equalsIgnoreCase("11")){
			result = "烏來區";
		}else if(cityCounty.equalsIgnoreCase("F") && district.equalsIgnoreCase("14")){
			result = "板橋區";
		}else if(cityCounty.equalsIgnoreCase("F") && district.equalsIgnoreCase("15")){
			result = "三峽區";
		}else if(cityCounty.equalsIgnoreCase("F") && district.equalsIgnoreCase("16")){
			result = "鶯歌區";
		}else if(cityCounty.equalsIgnoreCase("F") && district.equalsIgnoreCase("17")){
			result = "樹林區";
		}else if(cityCounty.equalsIgnoreCase("F") && district.equalsIgnoreCase("18")){
			result = "中和區";
		}else if(cityCounty.equalsIgnoreCase("F") && district.equalsIgnoreCase("19")){
			result = "土城區";
		}else if(cityCounty.equalsIgnoreCase("F") && district.equalsIgnoreCase("21")){
			result = "瑞芳區";
		}else if(cityCounty.equalsIgnoreCase("F") && district.equalsIgnoreCase("22")){
			result = "平溪區";
		}else if(cityCounty.equalsIgnoreCase("F") && district.equalsIgnoreCase("23")){
			result = "雙溪區";
		}else if(cityCounty.equalsIgnoreCase("F") && district.equalsIgnoreCase("24")){
			result = "貢寮區";
		}else if(cityCounty.equalsIgnoreCase("F") && district.equalsIgnoreCase("25")){
			result = "金山區";
		}else if(cityCounty.equalsIgnoreCase("F") && district.equalsIgnoreCase("26")){
			result = "萬里區";
		}else if(cityCounty.equalsIgnoreCase("F") && district.equalsIgnoreCase("27")){
			result = "淡水區";
		}else if(cityCounty.equalsIgnoreCase("F") && district.equalsIgnoreCase("28")){
			result = "汐止區";
		}else if(cityCounty.equalsIgnoreCase("F") && district.equalsIgnoreCase("30")){
			result = "三芝區";
		}else if(cityCounty.equalsIgnoreCase("F") && district.equalsIgnoreCase("31")){
			result = "石門區";
		}else if(cityCounty.equalsIgnoreCase("F") && district.equalsIgnoreCase("32")){
			result = "八里區";
		}else if(cityCounty.equalsIgnoreCase("F") && district.equalsIgnoreCase("33")){
			result = "永和區";
		}else if(cityCounty.equalsIgnoreCase("G") && district.equalsIgnoreCase("1")){
			result = "宜蘭市";
		}else if(cityCounty.equalsIgnoreCase("G") && district.equalsIgnoreCase("2")){
			result = "頭城鎮";
		}else if(cityCounty.equalsIgnoreCase("G") && district.equalsIgnoreCase("3")){
			result = "礁溪鄉";
		}else if(cityCounty.equalsIgnoreCase("G") && district.equalsIgnoreCase("4")){
			result = "壯圍鄉";
		}else if(cityCounty.equalsIgnoreCase("G") && district.equalsIgnoreCase("5")){
			result = "員山鄉";
		}else if(cityCounty.equalsIgnoreCase("G") && district.equalsIgnoreCase("6")){
			result = "羅東鎮";
		}else if(cityCounty.equalsIgnoreCase("G") && district.equalsIgnoreCase("7")){
			result = "五結鄉";
		}else if(cityCounty.equalsIgnoreCase("G") && district.equalsIgnoreCase("8")){
			result = "冬山鄉";
		}else if(cityCounty.equalsIgnoreCase("G") && district.equalsIgnoreCase("9")){
			result = "蘇澳鎮";
		}else if(cityCounty.equalsIgnoreCase("G") && district.equalsIgnoreCase("10")){
			result = "三星鄉";
		}else if(cityCounty.equalsIgnoreCase("G") && district.equalsIgnoreCase("11")){
			result = "大同鄉";
		}else if(cityCounty.equalsIgnoreCase("G") && district.equalsIgnoreCase("12")){
			result = "南澳鄉";
		}else if(cityCounty.equalsIgnoreCase("H") && district.equalsIgnoreCase("1")){
			result = "桃園區";
		}else if(cityCounty.equalsIgnoreCase("H") && district.equalsIgnoreCase("2")){
			result = "大溪區";
		}else if(cityCounty.equalsIgnoreCase("H") && district.equalsIgnoreCase("3")){
			result = "中壢區";
		}else if(cityCounty.equalsIgnoreCase("H") && district.equalsIgnoreCase("4")){
			result = "楊梅區";
		}else if(cityCounty.equalsIgnoreCase("H") && district.equalsIgnoreCase("5")){
			result = "蘆竹區";
		}else if(cityCounty.equalsIgnoreCase("H") && district.equalsIgnoreCase("6")){
			result = "大園區";
		}else if(cityCounty.equalsIgnoreCase("H") && district.equalsIgnoreCase("7")){
			result = "龜山區";
		}else if(cityCounty.equalsIgnoreCase("H") && district.equalsIgnoreCase("8")){
			result = "八德區";
		}else if(cityCounty.equalsIgnoreCase("H") && district.equalsIgnoreCase("9")){
			result = "龍潭區";
		}else if(cityCounty.equalsIgnoreCase("H") && district.equalsIgnoreCase("10")){
			result = "平鎮區";
		}else if(cityCounty.equalsIgnoreCase("H") && district.equalsIgnoreCase("11")){
			result = "新屋區";
		}else if(cityCounty.equalsIgnoreCase("H") && district.equalsIgnoreCase("12")){
			result = "觀音區";
		}else if(cityCounty.equalsIgnoreCase("H") && district.equalsIgnoreCase("13")){
			result = "復興區";
		}else if(cityCounty.equalsIgnoreCase("I") && district.equalsIgnoreCase("1")){
			result = "嘉義市";
		}else if(cityCounty.equalsIgnoreCase("J") && district.equalsIgnoreCase("2")){
			result = "竹東鎮";
		}else if(cityCounty.equalsIgnoreCase("J") && district.equalsIgnoreCase("3")){
			result = "關西鎮";
		}else if(cityCounty.equalsIgnoreCase("J") && district.equalsIgnoreCase("4")){
			result = "新埔鎮";
		}else if(cityCounty.equalsIgnoreCase("J") && district.equalsIgnoreCase("5")){
			result = "竹北市";
		}else if(cityCounty.equalsIgnoreCase("J") && district.equalsIgnoreCase("6")){
			result = "湖口鄉";
		}else if(cityCounty.equalsIgnoreCase("J") && district.equalsIgnoreCase("8")){
			result = "橫山鄉";
		}else if(cityCounty.equalsIgnoreCase("J") && district.equalsIgnoreCase("9")){
			result = "新豐鄉";
		}else if(cityCounty.equalsIgnoreCase("J") && district.equalsIgnoreCase("10")){
			result = "芎林鄉";
		}else if(cityCounty.equalsIgnoreCase("J") && district.equalsIgnoreCase("11")){
			result = "寶山鄉";
		}else if(cityCounty.equalsIgnoreCase("J") && district.equalsIgnoreCase("12")){
			result = "北埔鄉";
		}else if(cityCounty.equalsIgnoreCase("J") && district.equalsIgnoreCase("13")){
			result = "峨眉鄉";
		}else if(cityCounty.equalsIgnoreCase("J") && district.equalsIgnoreCase("14")){
			result = "尖石鄉";
		}else if(cityCounty.equalsIgnoreCase("J") && district.equalsIgnoreCase("15")){
			result = "五峰鄉";
		}else if(cityCounty.equalsIgnoreCase("K") && district.equalsIgnoreCase("1")){
			result = "苗栗市";
		}else if(cityCounty.equalsIgnoreCase("K") && district.equalsIgnoreCase("2")){
			result = "苑裡鎮";
		}else if(cityCounty.equalsIgnoreCase("K") && district.equalsIgnoreCase("3")){
			result = "通霄鎮";
		}else if(cityCounty.equalsIgnoreCase("K") && district.equalsIgnoreCase("4")){
			result = "公館鄉";
		}else if(cityCounty.equalsIgnoreCase("K") && district.equalsIgnoreCase("5")){
			result = "銅鑼鄉";
		}else if(cityCounty.equalsIgnoreCase("K") && district.equalsIgnoreCase("6")){
			result = "三義鄉";
		}else if(cityCounty.equalsIgnoreCase("K") && district.equalsIgnoreCase("7")){
			result = "西湖鄉";
		}else if(cityCounty.equalsIgnoreCase("K") && district.equalsIgnoreCase("8")){
			result = "頭屋鄉";
		}else if(cityCounty.equalsIgnoreCase("K") && district.equalsIgnoreCase("9")){
			result = "竹南鎮";
		}else if(cityCounty.equalsIgnoreCase("K") && district.equalsIgnoreCase("10")){
			result = "頭份市";
		}else if(cityCounty.equalsIgnoreCase("K") && district.equalsIgnoreCase("11")){
			result = "造橋鄉";
		}else if(cityCounty.equalsIgnoreCase("K") && district.equalsIgnoreCase("12")){
			result = "後龍鎮";
		}else if(cityCounty.equalsIgnoreCase("K") && district.equalsIgnoreCase("13")){
			result = "三灣鄉";
		}else if(cityCounty.equalsIgnoreCase("K") && district.equalsIgnoreCase("14")){
			result = "南庄鄉";
		}else if(cityCounty.equalsIgnoreCase("K") && district.equalsIgnoreCase("15")){
			result = "大湖鄉";
		}else if(cityCounty.equalsIgnoreCase("K") && district.equalsIgnoreCase("16")){
			result = "卓蘭鎮";
		}else if(cityCounty.equalsIgnoreCase("K") && district.equalsIgnoreCase("17")){
			result = "獅潭鄉";
		}else if(cityCounty.equalsIgnoreCase("K") && district.equalsIgnoreCase("18")){
			result = "泰安鄉";
		}else if(cityCounty.equalsIgnoreCase("M") && district.equalsIgnoreCase("1")){
			result = "南投市";
		}else if(cityCounty.equalsIgnoreCase("M") && district.equalsIgnoreCase("2")){
			result = "埔里鎮";
		}else if(cityCounty.equalsIgnoreCase("M") && district.equalsIgnoreCase("3")){
			result = "草屯鎮";
		}else if(cityCounty.equalsIgnoreCase("M") && district.equalsIgnoreCase("4")){
			result = "竹山鎮";
		}else if(cityCounty.equalsIgnoreCase("M") && district.equalsIgnoreCase("5")){
			result = "集集鎮";
		}else if(cityCounty.equalsIgnoreCase("M") && district.equalsIgnoreCase("6")){
			result = "名間鄉";
		}else if(cityCounty.equalsIgnoreCase("M") && district.equalsIgnoreCase("7")){
			result = "鹿谷鄉";
		}else if(cityCounty.equalsIgnoreCase("M") && district.equalsIgnoreCase("8")){
			result = "中寮鄉";
		}else if(cityCounty.equalsIgnoreCase("M") && district.equalsIgnoreCase("9")){
			result = "魚池鄉";
		}else if(cityCounty.equalsIgnoreCase("M") && district.equalsIgnoreCase("10")){
			result = "國姓鄉";
		}else if(cityCounty.equalsIgnoreCase("M") && district.equalsIgnoreCase("11")){
			result = "水里鄉";
		}else if(cityCounty.equalsIgnoreCase("M") && district.equalsIgnoreCase("12")){
			result = "信義鄉";
		}else if(cityCounty.equalsIgnoreCase("M") && district.equalsIgnoreCase("13")){
			result = "仁愛鄉";
		}else if(cityCounty.equalsIgnoreCase("N") && district.equalsIgnoreCase("1")){
			result = "彰化市";
		}else if(cityCounty.equalsIgnoreCase("N") && district.equalsIgnoreCase("2")){
			result = "鹿港鎮";
		}else if(cityCounty.equalsIgnoreCase("N") && district.equalsIgnoreCase("3")){
			result = "和美鎮";
		}else if(cityCounty.equalsIgnoreCase("N") && district.equalsIgnoreCase("4")){
			result = "北斗鎮";
		}else if(cityCounty.equalsIgnoreCase("N") && district.equalsIgnoreCase("5")){
			result = "員林市";
		}else if(cityCounty.equalsIgnoreCase("N") && district.equalsIgnoreCase("6")){
			result = "溪湖鎮";
		}else if(cityCounty.equalsIgnoreCase("N") && district.equalsIgnoreCase("7")){
			result = "田中鎮";
		}else if(cityCounty.equalsIgnoreCase("N") && district.equalsIgnoreCase("8")){
			result = "二林鎮";
		}else if(cityCounty.equalsIgnoreCase("N") && district.equalsIgnoreCase("9")){
			result = "線西鄉";
		}else if(cityCounty.equalsIgnoreCase("N") && district.equalsIgnoreCase("10")){
			result = "伸港鄉";
		}else if(cityCounty.equalsIgnoreCase("N") && district.equalsIgnoreCase("11")){
			result = "福興鄉";
		}else if(cityCounty.equalsIgnoreCase("N") && district.equalsIgnoreCase("12")){
			result = "秀水鄉";
		}else if(cityCounty.equalsIgnoreCase("N") && district.equalsIgnoreCase("13")){
			result = "花壇鄉";
		}else if(cityCounty.equalsIgnoreCase("N") && district.equalsIgnoreCase("14")){
			result = "芬園鄉";
		}else if(cityCounty.equalsIgnoreCase("N") && district.equalsIgnoreCase("15")){
			result = "大村鄉";
		}else if(cityCounty.equalsIgnoreCase("N") && district.equalsIgnoreCase("16")){
			result = "埔鹽鄉";
		}else if(cityCounty.equalsIgnoreCase("N") && district.equalsIgnoreCase("17")){
			result = "埔心鄉";
		}else if(cityCounty.equalsIgnoreCase("N") && district.equalsIgnoreCase("18")){
			result = "永靖鄉";
		}else if(cityCounty.equalsIgnoreCase("N") && district.equalsIgnoreCase("19")){
			result = "社頭鄉";
		}else if(cityCounty.equalsIgnoreCase("N") && district.equalsIgnoreCase("20")){
			result = "二水鄉";
		}else if(cityCounty.equalsIgnoreCase("N") && district.equalsIgnoreCase("21")){
			result = "田尾鄉";
		}else if(cityCounty.equalsIgnoreCase("N") && district.equalsIgnoreCase("22")){
			result = "埤頭鄉";
		}else if(cityCounty.equalsIgnoreCase("N") && district.equalsIgnoreCase("23")){
			result = "芳苑鄉";
		}else if(cityCounty.equalsIgnoreCase("N") && district.equalsIgnoreCase("24")){
			result = "大城鄉";
		}else if(cityCounty.equalsIgnoreCase("N") && district.equalsIgnoreCase("25")){
			result = "竹塘鄉";
		}else if(cityCounty.equalsIgnoreCase("N") && district.equalsIgnoreCase("26")){
			result = "溪州鄉";
		}else if(cityCounty.equalsIgnoreCase("O") && district.equalsIgnoreCase("1")){
			result = "新竹市";
		}else if(cityCounty.equalsIgnoreCase("P") && district.equalsIgnoreCase("1")){
			result = "斗六市";
		}else if(cityCounty.equalsIgnoreCase("P") && district.equalsIgnoreCase("2")){
			result = "斗南鎮";
		}else if(cityCounty.equalsIgnoreCase("P") && district.equalsIgnoreCase("3")){
			result = "虎尾鎮";
		}else if(cityCounty.equalsIgnoreCase("P") && district.equalsIgnoreCase("4")){
			result = "西螺鎮";
		}else if(cityCounty.equalsIgnoreCase("P") && district.equalsIgnoreCase("5")){
			result = "土庫鎮";
		}else if(cityCounty.equalsIgnoreCase("P") && district.equalsIgnoreCase("6")){
			result = "北港鎮";
		}else if(cityCounty.equalsIgnoreCase("P") && district.equalsIgnoreCase("7")){
			result = "古坑鄉";
		}else if(cityCounty.equalsIgnoreCase("P") && district.equalsIgnoreCase("8")){
			result = "大埤鄉";
		}else if(cityCounty.equalsIgnoreCase("P") && district.equalsIgnoreCase("9")){
			result = "莿桐鄉";
		}else if(cityCounty.equalsIgnoreCase("P") && district.equalsIgnoreCase("10")){
			result = "林內鄉";
		}else if(cityCounty.equalsIgnoreCase("P") && district.equalsIgnoreCase("11")){
			result = "二崙鄉";
		}else if(cityCounty.equalsIgnoreCase("P") && district.equalsIgnoreCase("12")){
			result = "崙背鄉";
		}else if(cityCounty.equalsIgnoreCase("P") && district.equalsIgnoreCase("13")){
			result = "麥寮鄉";
		}else if(cityCounty.equalsIgnoreCase("P") && district.equalsIgnoreCase("14")){
			result = "東勢鄉";
		}else if(cityCounty.equalsIgnoreCase("P") && district.equalsIgnoreCase("15")){
			result = "褒忠鄉";
		}else if(cityCounty.equalsIgnoreCase("P") && district.equalsIgnoreCase("16")){
			result = "台西鄉";
		}else if(cityCounty.equalsIgnoreCase("P") && district.equalsIgnoreCase("17")){
			result = "元長鄉";
		}else if(cityCounty.equalsIgnoreCase("P") && district.equalsIgnoreCase("18")){
			result = "四湖鄉";
		}else if(cityCounty.equalsIgnoreCase("P") && district.equalsIgnoreCase("19")){
			result = "口湖鄉";
		}else if(cityCounty.equalsIgnoreCase("P") && district.equalsIgnoreCase("20")){
			result = "水林鄉";
		}else if(cityCounty.equalsIgnoreCase("Q") && district.equalsIgnoreCase("2")){
			result = "朴子市";
		}else if(cityCounty.equalsIgnoreCase("Q") && district.equalsIgnoreCase("3")){
			result = "布袋鎮";
		}else if(cityCounty.equalsIgnoreCase("Q") && district.equalsIgnoreCase("4")){
			result = "大林鎮";
		}else if(cityCounty.equalsIgnoreCase("Q") && district.equalsIgnoreCase("5")){
			result = "民雄鄉";
		}else if(cityCounty.equalsIgnoreCase("Q") && district.equalsIgnoreCase("6")){
			result = "溪口鄉";
		}else if(cityCounty.equalsIgnoreCase("Q") && district.equalsIgnoreCase("7")){
			result = "新港鄉";
		}else if(cityCounty.equalsIgnoreCase("Q") && district.equalsIgnoreCase("8")){
			result = "六腳鄉";
		}else if(cityCounty.equalsIgnoreCase("Q") && district.equalsIgnoreCase("9")){
			result = "東石鄉";
		}else if(cityCounty.equalsIgnoreCase("Q") && district.equalsIgnoreCase("10")){
			result = "義竹鄉";
		}else if(cityCounty.equalsIgnoreCase("Q") && district.equalsIgnoreCase("11")){
			result = "鹿草鄉";
		}else if(cityCounty.equalsIgnoreCase("Q") && district.equalsIgnoreCase("12")){
			result = "太保市";
		}else if(cityCounty.equalsIgnoreCase("Q") && district.equalsIgnoreCase("13")){
			result = "水上鄉";
		}else if(cityCounty.equalsIgnoreCase("Q") && district.equalsIgnoreCase("14")){
			result = "中埔鄉";
		}else if(cityCounty.equalsIgnoreCase("Q") && district.equalsIgnoreCase("15")){
			result = "竹崎鄉";
		}else if(cityCounty.equalsIgnoreCase("Q") && district.equalsIgnoreCase("16")){
			result = "梅山鄉";
		}else if(cityCounty.equalsIgnoreCase("Q") && district.equalsIgnoreCase("17")){
			result = "番路鄉";
		}else if(cityCounty.equalsIgnoreCase("Q") && district.equalsIgnoreCase("18")){
			result = "大埔鄉";
		}else if(cityCounty.equalsIgnoreCase("Q") && district.equalsIgnoreCase("20")){
			result = "阿里山鄉";
		}else if(cityCounty.equalsIgnoreCase("T") && district.equalsIgnoreCase("1")){
			result = "屏東市";
		}else if(cityCounty.equalsIgnoreCase("T") && district.equalsIgnoreCase("2")){
			result = "潮州鎮";
		}else if(cityCounty.equalsIgnoreCase("T") && district.equalsIgnoreCase("3")){
			result = "東港鎮";
		}else if(cityCounty.equalsIgnoreCase("T") && district.equalsIgnoreCase("4")){
			result = "恆春鎮";
		}else if(cityCounty.equalsIgnoreCase("T") && district.equalsIgnoreCase("5")){
			result = "萬丹鄉";
		}else if(cityCounty.equalsIgnoreCase("T") && district.equalsIgnoreCase("6")){
			result = "長治鄉";
		}else if(cityCounty.equalsIgnoreCase("T") && district.equalsIgnoreCase("7")){
			result = "麟洛鄉";
		}else if(cityCounty.equalsIgnoreCase("T") && district.equalsIgnoreCase("8")){
			result = "九如鄉";
		}else if(cityCounty.equalsIgnoreCase("T") && district.equalsIgnoreCase("9")){
			result = "里港鄉";
		}else if(cityCounty.equalsIgnoreCase("T") && district.equalsIgnoreCase("10")){
			result = "鹽埔鄉";
		}else if(cityCounty.equalsIgnoreCase("T") && district.equalsIgnoreCase("11")){
			result = "高樹鄉";
		}else if(cityCounty.equalsIgnoreCase("T") && district.equalsIgnoreCase("12")){
			result = "萬巒鄉";
		}else if(cityCounty.equalsIgnoreCase("T") && district.equalsIgnoreCase("13")){
			result = "內埔鄉";
		}else if(cityCounty.equalsIgnoreCase("T") && district.equalsIgnoreCase("14")){
			result = "竹田鄉";
		}else if(cityCounty.equalsIgnoreCase("T") && district.equalsIgnoreCase("15")){
			result = "新埤鄉";
		}else if(cityCounty.equalsIgnoreCase("T") && district.equalsIgnoreCase("16")){
			result = "枋寮鄉";
		}else if(cityCounty.equalsIgnoreCase("T") && district.equalsIgnoreCase("17")){
			result = "新園鄉";
		}else if(cityCounty.equalsIgnoreCase("T") && district.equalsIgnoreCase("18")){
			result = "崁頂鄉";
		}else if(cityCounty.equalsIgnoreCase("T") && district.equalsIgnoreCase("19")){
			result = "林邊鄉";
		}else if(cityCounty.equalsIgnoreCase("T") && district.equalsIgnoreCase("20")){
			result = "南州鄉";
		}else if(cityCounty.equalsIgnoreCase("T") && district.equalsIgnoreCase("21")){
			result = "佳冬鄉";
		}else if(cityCounty.equalsIgnoreCase("T") && district.equalsIgnoreCase("22")){
			result = "琉球鄉";
		}else if(cityCounty.equalsIgnoreCase("T") && district.equalsIgnoreCase("23")){
			result = "車城鄉";
		}else if(cityCounty.equalsIgnoreCase("T") && district.equalsIgnoreCase("24")){
			result = "滿州鄉";
		}else if(cityCounty.equalsIgnoreCase("T") && district.equalsIgnoreCase("25")){
			result = "枋山鄉";
		}else if(cityCounty.equalsIgnoreCase("T") && district.equalsIgnoreCase("26")){
			result = "三地門鄉";
		}else if(cityCounty.equalsIgnoreCase("T") && district.equalsIgnoreCase("27")){
			result = "霧臺鄉";
		}else if(cityCounty.equalsIgnoreCase("T") && district.equalsIgnoreCase("28")){
			result = "瑪家鄉";
		}else if(cityCounty.equalsIgnoreCase("T") && district.equalsIgnoreCase("29")){
			result = "泰武鄉";
		}else if(cityCounty.equalsIgnoreCase("T") && district.equalsIgnoreCase("30")){
			result = "來義鄉";
		}else if(cityCounty.equalsIgnoreCase("T") && district.equalsIgnoreCase("31")){
			result = "春日鄉";
		}else if(cityCounty.equalsIgnoreCase("T") && district.equalsIgnoreCase("32")){
			result = "獅子鄉";
		}else if(cityCounty.equalsIgnoreCase("T") && district.equalsIgnoreCase("33")){
			result = "牡丹鄉";
		}else if(cityCounty.equalsIgnoreCase("U") && district.equalsIgnoreCase("1")){
			result = "花蓮市";
		}else if(cityCounty.equalsIgnoreCase("U") && district.equalsIgnoreCase("2")){
			result = "光復鄉";
		}else if(cityCounty.equalsIgnoreCase("U") && district.equalsIgnoreCase("3")){
			result = "玉里鎮";
		}else if(cityCounty.equalsIgnoreCase("U") && district.equalsIgnoreCase("4")){
			result = "新城鄉";
		}else if(cityCounty.equalsIgnoreCase("U") && district.equalsIgnoreCase("5")){
			result = "吉安鄉";
		}else if(cityCounty.equalsIgnoreCase("U") && district.equalsIgnoreCase("6")){
			result = "壽豐鄉";
		}else if(cityCounty.equalsIgnoreCase("U") && district.equalsIgnoreCase("7")){
			result = "鳳林鎮";
		}else if(cityCounty.equalsIgnoreCase("U") && district.equalsIgnoreCase("8")){
			result = "豐濱鄉";
		}else if(cityCounty.equalsIgnoreCase("U") && district.equalsIgnoreCase("9")){
			result = "瑞穗鄉";
		}else if(cityCounty.equalsIgnoreCase("U") && district.equalsIgnoreCase("10")){
			result = "富里鄉";
		}else if(cityCounty.equalsIgnoreCase("U") && district.equalsIgnoreCase("11")){
			result = "秀林鄉";
		}else if(cityCounty.equalsIgnoreCase("U") && district.equalsIgnoreCase("12")){
			result = "萬榮鄉";
		}else if(cityCounty.equalsIgnoreCase("U") && district.equalsIgnoreCase("13")){
			result = "卓溪鄉";
		}else if(cityCounty.equalsIgnoreCase("V") && district.equalsIgnoreCase("1")){
			result = "台東市";
		}else if(cityCounty.equalsIgnoreCase("V") && district.equalsIgnoreCase("2")){
			result = "成功鎮";
		}else if(cityCounty.equalsIgnoreCase("V") && district.equalsIgnoreCase("3")){
			result = "關山鎮";
		}else if(cityCounty.equalsIgnoreCase("V") && district.equalsIgnoreCase("4")){
			result = "卑南鄉";
		}else if(cityCounty.equalsIgnoreCase("V") && district.equalsIgnoreCase("5")){
			result = "大武鄉";
		}else if(cityCounty.equalsIgnoreCase("V") && district.equalsIgnoreCase("6")){
			result = "太麻里鄉";
		}else if(cityCounty.equalsIgnoreCase("V") && district.equalsIgnoreCase("7")){
			result = "東河鄉";
		}else if(cityCounty.equalsIgnoreCase("V") && district.equalsIgnoreCase("8")){
			result = "長濱鄉";
		}else if(cityCounty.equalsIgnoreCase("V") && district.equalsIgnoreCase("9")){
			result = "鹿野鄉";
		}else if(cityCounty.equalsIgnoreCase("V") && district.equalsIgnoreCase("10")){
			result = "池上鄉";
		}else if(cityCounty.equalsIgnoreCase("V") && district.equalsIgnoreCase("11")){
			result = "綠島鄉";
		}else if(cityCounty.equalsIgnoreCase("V") && district.equalsIgnoreCase("12")){
			result = "延平鄉";
		}else if(cityCounty.equalsIgnoreCase("V") && district.equalsIgnoreCase("13")){
			result = "海端鄉";
		}else if(cityCounty.equalsIgnoreCase("V") && district.equalsIgnoreCase("14")){
			result = "達仁鄉";
		}else if(cityCounty.equalsIgnoreCase("V") && district.equalsIgnoreCase("15")){
			result = "金峰鄉";
		}else if(cityCounty.equalsIgnoreCase("V") && district.equalsIgnoreCase("16")){
			result = "蘭嶼鄉";
		}else if(cityCounty.equalsIgnoreCase("W") && district.equalsIgnoreCase("1")){
			result = "金湖鎮";
		}else if(cityCounty.equalsIgnoreCase("W") && district.equalsIgnoreCase("2")){
			result = "金沙鎮";
		}else if(cityCounty.equalsIgnoreCase("W") && district.equalsIgnoreCase("3")){
			result = "金城鎮";
		}else if(cityCounty.equalsIgnoreCase("W") && district.equalsIgnoreCase("4")){
			result = "金寧鄉";
		}else if(cityCounty.equalsIgnoreCase("W") && district.equalsIgnoreCase("5")){
			result = "烈嶼鄉";
		}else if(cityCounty.equalsIgnoreCase("W") && district.equalsIgnoreCase("6")){
			result = "烏坵鄉";
		}else if(cityCounty.equalsIgnoreCase("X") && district.equalsIgnoreCase("1")){
			result = "馬公市";
		}else if(cityCounty.equalsIgnoreCase("X") && district.equalsIgnoreCase("2")){
			result = "湖西鄉";
		}else if(cityCounty.equalsIgnoreCase("X") && district.equalsIgnoreCase("3")){
			result = "白沙鄉";
		}else if(cityCounty.equalsIgnoreCase("X") && district.equalsIgnoreCase("4")){
			result = "西嶼鄉";
		}else if(cityCounty.equalsIgnoreCase("X") && district.equalsIgnoreCase("5")){
			result = "望安鄉";
		}else if(cityCounty.equalsIgnoreCase("X") && district.equalsIgnoreCase("6")){
			result = "七美鄉";
		}else if(cityCounty.equalsIgnoreCase("Z") && district.equalsIgnoreCase("1")){
			result = "南竿鄉";
		}else if(cityCounty.equalsIgnoreCase("Z") && district.equalsIgnoreCase("2")){
			result = "北竿鄉";
		}else if(cityCounty.equalsIgnoreCase("Z") && district.equalsIgnoreCase("3")){
			result = "莒光鄉";
		}else if(cityCounty.equalsIgnoreCase("Z") && district.equalsIgnoreCase("4")){
			result = "東引鄉";
		}else {
			result = district;
			m_logger.info(WhiteBox.logForging("(cityCounty,district)無對應:("+cityCounty+","+district+")");
		}
		
		return result;
	}*/
	/*
	public static String getDistrict(String district) {//先轉換高雄的部分
		String result="";
		switch(district) { 
        case "01":
        	result = "鹽埕區";
            break; 
        case "02":
        	result = "鼓山區";
        	break;
        case "03":
        	result = "左營區";
        	break;
        case "04":
        	result = "楠梓區";
        	break;
        case "05":
        	result = "三民區";
        	break;
        case "06":
        	result = "新興區";
        	break;
        case "07":
        	result = "前金區";
        	break;
        case "08":
        	result = "苓雅區";
        	break;
        case "09":
        	result = "前鎮區";
        	break;
        case "10":
        	result = "旗津區";
			break;
		case "11":
        	result = "小港區";
            break; 
        case "12":
        	result = "鳳山區";
        	break;
        case "13":
        	result = "林園區";
        	break;
        case "14":
        	result = "大寮區";
        	break;
        case "15":
        	result = "大樹區";
        	break;
        case "16":
        	result = "大社區";
        	break;
        case "17":
        	result = "仁武區";
        	break;
        case "18":
        	result = "鳥松區";
        	break;
        case "19":
        	result = "岡山區";
        	break;
        case "20":
        	result = "橋頭區";
			break;
        case "21":
        	result = "燕巢區";
            break; 
        case "22":
        	result = "田寮區";
        	break;
        case "23":
        	result = "阿蓮區";
        	break;
        case "24":
        	result = "路竹區";
        	break;
        case "25":
        	result = "湖內區";
        	break;
        case "26":
        	result = "茄萣區";
        	break;
        case "27":
        	result = "永安區";
        	break;
        case "28":
        	result = "彌陀區";
        	break;
        case "29":
        	result = "梓官區";
        	break;
        case "30":
        	result = "旗山區";	
			break;
		case "31":
        	result = "美濃區";
            break; 
        case "32":
        	result = "六龜區";
        	break;
        case "33":
        	result = "甲仙區";
        	break;
        case "34":
        	result = "杉林區";
        	break;
        case "35":
        	result = "內門區";
        	break;
        case "36":
        	result = "茂林區";
        	break;
        case "37":
        	result = "桃源區";
        	break;
        case "38":
        	result = "那瑪夏區";
        	break;

        default: 
        	result = district;
        	m_logger.info(WhiteBox.logForging("district無對應:"+district);
        	break;
		}
		return result;
	}*/
	
	public static String getSituationCategory(String situationCategory) {
		String result="";
		switch(situationCategory) { 
        case "110001":
        	result = "呼吸問題(喘/呼吸急促)";
            break; 
        case "110002":
        	result = "呼吸道問題(異物哽塞)";
            break; 
		case "110003":
        	result = "昏迷(意識不清)";
            break; 
		case "110004":
        	result = "胸痛/悶";
            break; 
        case "110005":
        	result = "腹痛";
            break; 
		case "110006":
        	result = "頭痛/頭暈";
            break; 
		case "110007":
        	result = "昏倒/昏厥";
            break; 
        case "110008":
        	result = "發燒";
            break; 
		case "110009":
        	result = "噁心/嘔吐/腹瀉";
            break; 
		case "110010":
        	result = "肢體無力";
            break; 
        case "110011":
        	result = "疑似毒藥物中毒";
            break; 
		case "110012":
        	result = "疑似一氧化碳中毒";
            break; 
		case "110013":
        	result = "癲癇/抽搐";
            break; 
        case "110014":
        	result = "路倒";
            break; 
		case "110015":
        	result = "行為急症/精神異常";
            break; 
		case "110016":
        	result = "孕婦急產";
            break; 
        case "110017":
        	result = "溺水";
            break; 
		case "110018":
        	result = "頭部外傷";
            break; 
		case "110019":
        	result = "胸部外傷";
            break; 
        case "110020":
        	result = "腹部外傷";
            break; 
		case "110021":
        	result = "背部外傷";
            break; 
		case "110022":
        	result = "肢體外傷";
            break; 
        case "110023":
        	result = "交通事故";
            break; 
		case "110024":
        	result = "墜落傷";
            break; 
		case "110025":
        	result = "穿刺傷";
            break; 
        case "110026":
        	result = "燒燙傷";
            break; 
		case "110027":
        	result = "電擊傷";
            break; 
		case "110028":
        	result = "生物咬螫傷";
            break; 
        case "110029":
        	result = "到院前心肺功能停止";
            break; 
		case "110030":
        	result = "其他";
            break; 
		case "110031":
        	result = "急性腦中風";
            break; 
        case "110032":
        	result = "糖尿病問題";
            break; 
		case "110033":
        	result = "過敏/藥物反應";
            break; 
		case "110034":
        	result = "吐血/咳血/非外傷性出血";
            break; 
        case "110035":
        	result = "心臟問題";
            break; 
		case "110036":
        	result = "背痛";
            break; 
		case "110037":
        	result = "藥物過量";
            break; 
        case "110038":
        	result = "工業/機械意外事件";
            break; 
		case "110039":
        	result = "壓碾傷";
            break; 
		case "110040":
        	result = "出血/撕裂傷";
            break; 
        case "110041":
        	result = "摔跌傷";
            break; 
		case "110042":
        	result = "熱/冷急症";
            break; 
		case "110043":
        	result = "眼睛問題";
            break; 
        case "110044":
        	result = "肢體麻痺";
            break; 
		case "110045":
        	result = "肩痛";
            break; 
		case "110046":
        	result = "冒冷汗";
            break; 
        case "110047":
        	result = "血便/血尿";
            break; 
		case "110048":
        	result = "血腫";
            break; 
		case "110049":
        	result = "肢體疼痛";
            break; 
        case "110050":
        	result = "骨折/脫位";
            break; 
		case "110051":
        	result = "挫/擦傷";
            break; 
		case "110052":
        	result = "碎裂傷";
            break; 
        case "110053":
        	result = "斷肢";
            break; 
		case "110054":
        	result = "非創傷疼痛";
            break; 

        default: 
        	result = situationCategory;
        	m_logger.info(WhiteBox.logForging("situationCategory無對應:"+situationCategory));
        	break;
		}
		return result;
	}
	
	public static String getSymptom(String symptom) {
		String result="";
		switch(symptom) { 
		case "R06.02":
			result = "呼吸短促";
			break;
		case "R09.2":
			result = "呼吸停止";
			break;
		case "R05":
			result = "咳嗽";
			break;
		case "R06.4":
			result = "換氣過度";
			break;
		case "R04.2":
			result = "咳血";
			break;
		case "T17.990A":
			result = "呼吸道內異物";
			break;
		case "Z91.09":
			result = "過敏反應";
			break;
		case "I46.9":
			result = "心跳停止";
			break;
		case "R07.9":
			result = "胸痛/胸悶";
			break;
		case "R00.2":
			result = "心悸/不規則心跳";
			break;
		case "I10":
			result = "高血壓急症";
			break;
		case "R53.1":
			result = "全身虛弱/無力";
			break;
		case "R55":
			result = "暈厥";
			break;
		case "R60.1":
			result = "全身性水腫";
			break;
		case "R60.0":
			result = "肢體水腫";
			break;
		case "(無法對照)":
			result = "冰冷無脈搏的肢體";
			break;
//		case "(無法對照)":
//			result = "單側肢體紅熱";
//			break;
		case "R10.84":
			result = "腹痛";
			break;
		case "R63.0":
			result = "厭食";
			break;
		case "K59.00":
			result = "便秘";
			break;
		case "R19.7":
			result = "腹瀉";
			break;
		case "T18.5XXA":
			result = "直腸內異物";
			break;
		case "R11.0":
			result = "噁心";
			break;
		case "R11.10":
			result = "嘔吐";
			break;
		case "R10.2":
			result = "直腸會陰疼痛";
			break;
		case "K92.0":
			result = "吐血";
			break;
		case "K92.1":
			result = "血便/黑便";
			break;
		case "R17":
			result = "黃疸";
			break;
		case "R06.6":
			result = "打嗝";
			break;
		case "R14.0":
			result = "腹部腫塊/腹脹";
			break;
		case "T18.100A":
			result = "吞食異物";
			break;
		case "R41.82":
			result = "意識程度改變";
			break;
		case "R41.0":
			result = "混亂";
			break;
		case "R42":
			result = "眩暈/頭暈";
			break;
		case "R51":
			result = "頭痛";
			break;
		case "G40.3":
			result = "抽搐";
			break;
		case "R26.2":
			result = "步態不穩/運動失調";
			break;
		case "R25.1":
			result = "震顫";
			break;
//		case "R53.1":
//			result = "肢體無力";
//			break;
		case "R20.2":
			result = "知覺喪失/感覺異常";
			break;
		case "I63.9":
			result = "中風症狀(突發性口齒不清/單側肢體感覺異常)";
			break;
		case "M54.9":
			result = "背痛";
			break;
		case "M79.603":
			result = "上肢疼痛";
			break;
		case "M79.606":
			result = "下肢疼痛";
			break;
//		case "R22.9":
//			result = "關節腫脹";
//			break;
		case "M54.5":
			result = "腰痛";
			break;
		case "R31.9":
			result = "血尿";
			break;
//		case "(無法對照)":
//			result = "生殖器官分泌物/病變";
//			break;
		case "N48.9":
			result = "陰莖腫脹";
			break;
		case "N49.2":
			result = "陰囊疼痛/腫脹";
			break;
		case "R33.9":
			result = "尿滯留";
			break;
		case "N39.0":
			result = "泌尿道感染相關症狀(頻尿或解尿疼痛)";
			break;
		case "R34":
			result = "少尿";
			break;
		case "R35.8":
			result = "多尿";
			break;
//		case "(無法對照)":
//			result = "鼠蹊部疼痛/腫塊";
//			break;
		case "H92.09":
			result = "耳朵疼痛";
			break;
		case "T16.9XXA":
			result = "耳內異物";
			break;
		case "H91":
			result = "聽力改變";
			break;
		case "H93.19":
			result = "耳鳴";
			break;
//		case "(無法對照)":
//			result = "耳朵分泌物";
//			break;
//		case "(無法對照)":
//			result = "牙齒/牙齦問題";
//			break;
		case "J02":
			result = "喉嚨痛";
			break;
//		case "(無法對照)":
//			result = "頸部腫脹/疼痛";
//			break;
		case "R13.10":
			result = "吞嚥困難";
			break;
//		case "(無法對照)":
//			result = "顏面疼痛(無外傷/無牙齒問題)";
//			break;
		case "R04.0":
			result = "流鼻血";
			break;
		case "R09.81":
			result = "過敏或非特定因素引起的鼻塞";
			break;
		case "T17.1XXA":
			result = "鼻內異物";
			break;
		case "J06.9":
			result = "上呼吸道感染相關症狀(鼻塞、流鼻水、咳嗽、喉嚨痛)";
			break;
		case "H57.9":
			result = "眼睛分泌物";
			break;
		case "T15.90XA":
			result = "眼睛內異物";
			break;
		case "H53.9":
			result = "視覺障礙";
			break;
		case "H57.10":
			result = "眼睛疼痛";
			break;
//		case "(無法對照)":
//			result = "眼睛紅/癢";
//			break;
		case "H53.14":
			result = "畏光/光傷害";
			break;
		case "H53.2":
			result = "複視";
			break;
		case "H05.229":
			result = "眼眶腫脹";
			break;
//		case "(無法對照)":
//			result = "化學物質暴露眼睛";
//			break;
		case "L29.9":
			result = "搔癢";
			break;
		case "R21":
			result = "紅疹";
			break;
		case "R22.9":
			result = "局部紅腫";
			break;
//		case "(無法對照)":
//			result = "腫塊、長繭";
//			break;
		case "N64.4":
			result = "乳房紅腫";
			break;
//		case "(無法對照)":
//			result = "疑似傳染性皮膚病";
//			break;
		case "R23.0":
			result = "發紺";
			break;
		case "R23.3":
			result = "自發性淤斑";
			break;
		case "R23.8":
			result = "皮膚內異物";
			break;
//		case "(無法對照)":
//			result = "其他皮膚狀況";
//			break;
		case "N92.6":
			result = "月經問題";
			break;
		case "T19.2":
			result = "陰道內異物";
			break;
		case "N89.8":
			result = "陰道分泌物";
			break;
		case "T76":
			result = "確定或疑似性侵害";
			break;
		case "N93.9":
			result = "陰道出血";
			break;
//		case "(無法對照)":
//			result = "陰唇腫脹";
//			break;
//		case "(無法對照)":
//			result = "陰道疼痛/搔癢";
//			break;
//		case "(無法對照)":
//			result = "懷孕問題大於20周";
//			break;
//		case "(無法對照)":
//			result = "懷孕問題小於20周";
//			break;
		case "O72":
			result = "產後出血";
			break;
		case "F39":
			result = "憂鬱";
			break;
		case "R45.85":
			result = "自殺";
			break;
		case "F41.9":
			result = "焦慮/激動";
			break;
		case "R44.3":
			result = "幻覺/妄想";
			break;
		case "F51":
			result = "失眠";
			break;
		case "R45.6":
			result = "暴力行為/自傷/傷害他人";
			break;
		case "Z73.4":
			result = "社會/社交問題";
			break;
//		case "(無法對照)":
//			result = "怪異行為";
//			break;
		case "F19.120":
			result = "物質誤用/中毒";
			break;
		case "F19.93":
			result = "物質戒斷";
			break;
		case "T50.901":
			result = "藥物過量攝取";
			break;
//		case "(無法對照)":
//			result = "暴露於傳染性疾病";
//			break;
		case "R50.9":
			result = "發燒/畏寒";
			break;
		case "R73.9":
			result = "高血糖";
			break;
		case "E16.2":
			result = "低血糖";
			break;
//		case "(無法對照)":
//			result = "換藥";
//			break;
//		case "(無法對照)":
//			result = "拆線";
//			break;
//		case "(無法對照)":
//			result = "醫療裝置問題";
//			break;
//		case "(無法對照)":
//			result = "移除戒指";
//			break;
//		case "(無法對照)":
//			result = "檢驗/檢查結果異常";
//			break;
//		case "(無法對照)":
//			result = "手術後併發症";
//			break;
		case "R23.1":
			result = "蒼白/貧血";
			break;
		case "S00.93":
			result = "頭部鈍傷";
			break;
		case "S01":
			result = "頭部穿刺傷";
			break;
		case "S01.01":
			result = "頭部撕裂傷、擦傷";
			break;
		case "S00.83":
			result = "顏面部鈍傷";
			break;
		case "S01.8":
			result = "顏面部穿刺傷";
			break;
		case "S01.82":
			result = "顏面部撕裂傷、擦傷";
			break;
		case "S05.1":
			result = "眼睛鈍傷";
			break;
		case "S01.139A":
			result = "眼睛穿刺傷";
			break;
		case "S00.33":
			result = "鼻子鈍傷";
			break;
		case "S01.2":
			result = "鼻子撕裂傷、擦傷";
			break;
		case "S00.43":
			result = "耳朵鈍傷";
			break;
		case "S01.3":
			result = "耳朵撕裂傷、擦傷";
			break;
		case "S10.93":
			result = "頸部鈍傷";
			break;
		case "S11":
			result = "頸部穿刺傷";
			break;
		case "S16.2":
			result = "頸部撕裂傷、擦傷";
			break;
		case "S20.219":
			result = "胸部鈍傷";
			break;
		case "S21":
			result = "胸部穿刺傷";
			break;
		case "S21.11":
			result = "胸部撕裂傷、擦傷";
			break;
		case "S30":
			result = "腹部(含骨盆)腰、背部鈍傷";
			break;
		case "S31":
			result = "腹部(含骨盆)腰、背部穿刺傷";
			break;
		case "S31.11":
			result = "腹部(含骨盆)腰、背部撕裂傷、擦傷";
			break;
		case "S30.20":
			result = "會陰部及生殖器官鈍傷";
			break;
		case "S31.53":
			result = "會陰部及生殖器官穿刺傷";
			break;
		case "S31.51":
			result = "會陰部及生殖器官撕裂傷、擦傷";
			break;
		case "S40.029":
			result = "上肢鈍傷";
			break;
		case "S41":
			result = "上肢穿刺傷";
			break;
		case "S41.01":
			result = "上肢撕裂傷、擦傷";
			break;
		case "S63.8X9A":
			result = "上肢關節扭傷";
			break;
		case "S58":
			result = "上肢創傷性截肢";
			break;
		case "S80.1":
			result = "下肢鈍傷";
			break;
		case "S81":
			result = "下肢穿刺傷";
			break;
		case "S81.01":
			result = "下肢撕裂傷、擦傷";
			break;
		case "S93":
			result = "下肢關節扭傷";
			break;
		case "S98":
			result = "下肢創傷性截肢";
			break;
		case "T30.0":
			result = "燒燙傷";
			break;
		case "Y07.499":
			result = "家庭暴力";
			break;
		case "W57":
			result = "昆蟲螫傷";
			break;
//		case "(無法對照)":
//			result = "海洋生物螫咬";
//			break;
		case "W55.81XA":
			result = "動物咬傷";
			break;
		case "T63.0":
			result = "蛇咬傷";
			break;
		case "Z77.098":
			result = "化學物質暴露(疑似或確定化學、輻射或危害物質暴露)";
			break;
		case "T67":
			result = "中署/高體溫症";
			break;
		case "R68.0":
			result = "低體溫症";
			break;
		case "T59.94XA":
			result = "有毒氣體吸入/暴露";
			break;
		case "V90":
			result = "溺水";
			break;
		case "T34":
			result = "凍傷";
			break;
		case "T75.4":
			result = "電擊傷害";
			break;
			
        default: 
        	result = symptom;
        	m_logger.info(WhiteBox.logForging("symptom無對應:"+symptom));
        	break;
		}
		return result;
	}
}
