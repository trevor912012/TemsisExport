package com.cht.tl.model;

import java.io.IOException;
import java.io.StringReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import com.cht.tl.csv.CsvExport;
import com.cht.tl.db.obj.FdkcTemsisInfo;
import com.cht.tl.db.obj.TemsisRecord;
import com.cht.tl.util.Convert;
import com.cht.tl.util.WhiteBox;
import com.cht.tl.vo.TemsisVo;


public class ParseTemsis {
	private final Logger m_logger = LogManager.getLogger(ParseTemsis.class);
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssz");
	private SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private SimpleDateFormat sdf3 = new SimpleDateFormat("yyyyMMdd");
	private SimpleDateFormat sdf4 = new SimpleDateFormat("yyyyMMddHHmmssSSS");
	private SimpleDateFormat sdf5 = new SimpleDateFormat("yyyyMMddHHmmss");
	private SimpleDateFormat sdf6 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
	
	private boolean dataCheckIsOk = true;
	public TemsisVo parseTemsis(String xmlString) {
		String result = "";		
		FdkcTemsisInfo fti = new FdkcTemsisInfo();
		TemsisRecord tr = new TemsisRecord();
		
		//
		Document doc = null;
		doc = loadXMLFromString(xmlString);
		if(doc != null) {
			doc.getDocumentElement().normalize();
		}else {
			dataCheckIsOk = false;
		}
		//TODO:2021/10/14 TEMSIS改版，新增file
		String fileIncidents = "";
		String fileVitalSigns = "";
		String fileTemsiss = "";
		
		
		if(doc != null) {
			tr.setTemsisContent(xmlString);
			if(doc.getElementsByTagName("eRecord.T01").getLength()>0 && !doc.getElementsByTagName("eRecord.T01").item(0).getTextContent().equalsIgnoreCase("")) {
				tr.setRecordNumber(doc.getElementsByTagName("eRecord.T01").item(0).getTextContent());
				tr.setMsgId(doc.getElementsByTagName("eRecord.T01").item(0).getTextContent());
				fti.setRecordNumber(doc.getElementsByTagName("eRecord.T01").item(0).getTextContent());
				fti.setMsgId(doc.getElementsByTagName("eRecord.T01").item(0).getTextContent());
				
			}
			if(tr.getRecordNumber() == null || tr.getRecordNumber().contentEquals("")) {
				m_logger.error("缺少救護編號");
				if(result.equalsIgnoreCase("")) {
					result += "缺少救護編號\n";
				}else {
					result += ",缺少救護編號\n";
				}
				dataCheckIsOk = false;
			}else {//TODO:2021/10/14 TEMSIS改版，新增file
//				String fileIncidents = "";
//				String fileVitalSigns = "";
//				String fileTemsis = "";
				String fileSavePath = "";
				String sDate  = null;
				String fileTime = null;
				String fileName = "";
				synchronized (sdf3) {
		            sDate = renderTime3(new Date());
		        }
				
				m_logger.info(WhiteBox.logForging("fileSavePath="+fileSavePath));
				fileTime = sdf4.format(new Date());
				//2021/12/17:修改檔案規範:{119案件ID}_{TEMSIS_ID}_{媒體檔類型}_{檔案類別}_{流水號}
				String incidentId = "";
				if(doc.getElementsByTagName("eDispatch.T05").getLength()>0 && !doc.getElementsByTagName("eDispatch.T05").item(0).getTextContent().equalsIgnoreCase("")) {
					incidentId = doc.getElementsByTagName("eDispatch.T05").item(0).getTextContent();
				}
				
				if(!fileIncidents.equalsIgnoreCase("")) {
					fileIncidents = fileIncidents.substring(0,fileIncidents.length()-1);
				}
				if(!fileVitalSigns.equalsIgnoreCase("")) {
					fileVitalSigns = fileVitalSigns.substring(0,fileVitalSigns.length()-1);
				}
				if(!fileTemsiss.equalsIgnoreCase("")) {
					fileTemsiss = fileTemsiss.substring(0,fileTemsiss.length()-1);
				}
				m_logger.info(WhiteBox.logForging("fileIncidents="+fileIncidents));
				m_logger.info(WhiteBox.logForging("fileVitalSigns="+fileVitalSigns));
				m_logger.info(WhiteBox.logForging("fileTemsis="+fileTemsiss));
				tr.setFileIncidents(fileIncidents);
				tr.setFileVitalSigns(fileVitalSigns);
				tr.setFileTemsis(fileTemsiss);
				//
			}
			if(doc.getElementsByTagName("eRecord.T02").getLength()>0 && !doc.getElementsByTagName("eRecord.T02").item(0).getTextContent().equalsIgnoreCase("")) {
				tr.setArea(Convert.getArea(doc.getElementsByTagName("eRecord.T02").item(0).getTextContent()));
				fti.setArea(Convert.getArea(doc.getElementsByTagName("eRecord.T02").item(0).getTextContent()));
//				tr.setArea(doc.getElementsByTagName("eRecord.T02").item(0).getTextContent());
//				fti.setArea(doc.getElementsByTagName("eRecord.T02").item(0).getTextContent());
			}
			if(doc.getElementsByTagName("eRecord.T03").getLength()>0 && !doc.getElementsByTagName("eRecord.T03").item(0).getTextContent().equalsIgnoreCase("")){
				fti.setSoftwareName(doc.getElementsByTagName("eRecord.T03").item(0).getTextContent());
			}
			if(doc.getElementsByTagName("eRecord.T04").getLength()>0 && !doc.getElementsByTagName("eRecord.T04").item(0).getTextContent().equalsIgnoreCase(""))
				fti.setSoftwareVersion(doc.getElementsByTagName("eRecord.T04").item(0).getTextContent());
			if(doc.getElementsByTagName("eRecord.T05").getLength()>0 && !doc.getElementsByTagName("eRecord.T05").item(0).getTextContent().equalsIgnoreCase("")){
				fti.setTemsisVersion(doc.getElementsByTagName("eRecord.T05").item(0).getTextContent());
			}
			if(doc.getElementsByTagName("eResponse.T01").getLength()>0 && !doc.getElementsByTagName("eResponse.T01").item(0).getTextContent().equalsIgnoreCase("")){
				tr.setEmsAgentCode(doc.getElementsByTagName("eResponse.T01").item(0).getTextContent());
				fti.setEmsAgentNumber(doc.getElementsByTagName("eResponse.T01").item(0).getTextContent());
			}
			if(doc.getElementsByTagName("eResponse.T02").getLength()>0 && !doc.getElementsByTagName("eResponse.T02").item(0).getTextContent().equalsIgnoreCase("")) {
				tr.setEmsVehicleCode(doc.getElementsByTagName("eResponse.T02").item(0).getTextContent());
				fti.setEmsVehicleNumber(doc.getElementsByTagName("eResponse.T02").item(0).getTextContent());
			}
			if(doc.getElementsByTagName("eResponse.T03").getLength()>0 && !doc.getElementsByTagName("eResponse.T03").item(0).getTextContent().equalsIgnoreCase("")) {
				tr.setEmsUnit(doc.getElementsByTagName("eResponse.T03").item(0).getTextContent());
				fti.setEmsUnit(doc.getElementsByTagName("eResponse.T03").item(0).getTextContent());
			}
			if(doc.getElementsByTagName("eResponse.T04").getLength()>0 && !doc.getElementsByTagName("eResponse.T04").item(0).getTextContent().equalsIgnoreCase(""))
				fti.setVehicleDispatchLocation(doc.getElementsByTagName("eResponse.T04").item(0).getTextContent());
			if(doc.getElementsByTagName("eResponse.T05").getLength()>0 && !doc.getElementsByTagName("eResponse.T05").item(0).getTextContent().equalsIgnoreCase(""))
				fti.setVehicleDispatchGpsLocation(doc.getElementsByTagName("eResponse.T05").item(0).getTextContent());
			if(doc.getElementsByTagName("eResponse.T06").getLength()>0 && !doc.getElementsByTagName("eResponse.T06").item(0).getTextContent().equalsIgnoreCase(""))
				fti.setVehicleDispatchCityCounty(Convert.getVehicleDispatchCityCounty(doc.getElementsByTagName("eResponse.T06").item(0).getTextContent()));
			if(doc.getElementsByTagName("eResponse.T07").getLength()>0 && !doc.getElementsByTagName("eResponse.T07").item(0).getTextContent().equalsIgnoreCase("")) {
				if(doc.getElementsByTagName("ePatient.T06").getLength()<0) {
					fti.setVehicleDispatchDistrict(Convert.getVehicleDispatchDistrict(null, doc.getElementsByTagName("eResponse.T07").item(0).getTextContent()));
				}else {
					fti.setVehicleDispatchDistrict(Convert.getVehicleDispatchDistrict(doc.getElementsByTagName("eResponse.T06").item(0).getTextContent(), doc.getElementsByTagName("eResponse.T07").item(0).getTextContent()));
				}
			}
			if(doc.getElementsByTagName("eResponse.T08").getLength()>0 && !doc.getElementsByTagName("eResponse.T08").item(0).getTextContent().equalsIgnoreCase(""))
				fti.setDispatchType(Convert.getDispatchType(doc.getElementsByTagName("eResponse.T08").item(0).getTextContent()));
//				fti.setDispatchType(doc.getElementsByTagName("eResponse.T08").item(0).getTextContent());
			if(doc.getElementsByTagName("eResponse.T09").getLength()>0 && !doc.getElementsByTagName("eResponse.T09").item(0).getTextContent().equalsIgnoreCase(""))
				fti.setOtherSupportUnit(doc.getElementsByTagName("eResponse.T09").item(0).getTextContent());
			
			if(doc.getElementsByTagName("eDispatch.T01").getLength()>0 && !doc.getElementsByTagName("eDispatch.T01").item(0).getTextContent().equalsIgnoreCase(""))
				fti.setDispatchComplaint(Convert.getDispatchComplaint(doc.getElementsByTagName("eDispatch.T01").item(0).getTextContent()));
			if(doc.getElementsByTagName("eDispatch.T02").getLength()>0 && !doc.getElementsByTagName("eDispatch.T02").item(0).getTextContent().equalsIgnoreCase(""))
				fti.setDispatcherId(doc.getElementsByTagName("eDispatch.T02").item(0).getTextContent());
			if(doc.getElementsByTagName("eDispatch.T03").getLength()>0 && !doc.getElementsByTagName("eDispatch.T03").item(0).getTextContent().equalsIgnoreCase(""))
				fti.setDispatchLevel(Convert.getDispatchLevel(doc.getElementsByTagName("eDispatch.T03").item(0).getTextContent()));
			if(doc.getElementsByTagName("eDispatch.T04").getLength()>0 && !doc.getElementsByTagName("eDispatch.T04").item(0).getTextContent().equalsIgnoreCase(""))
				fti.setDispatchResponseMode(Convert.getDispatchResponseMode(doc.getElementsByTagName("eDispatch.T04").item(0).getTextContent()));	
			if(doc.getElementsByTagName("eDispatch.T05").getLength()>0 && !doc.getElementsByTagName("eDispatch.T05").item(0).getTextContent().equalsIgnoreCase("")) {
				fti.setIncidentId(doc.getElementsByTagName("eDispatch.T05").item(0).getTextContent());	
				tr.setIncidentId(doc.getElementsByTagName("eDispatch.T05").item(0).getTextContent());
			}

			NodeList eCrewCrewGroupNodeList = doc.getElementsByTagName("eCrew.CrewGroup");
			for(int i=0; i<eCrewCrewGroupNodeList.getLength(); i++) {
				Node eCrewCrewGroupNode = eCrewCrewGroupNodeList.item(i);
				if(i==0) {
					fti.setCrewId("");
					fti.setCrewLevel("");
					fti.setCrewTeamOrder("");
					fti.setCrewTeamType("");
				}else {
					fti.setCrewId(fti.getCrewId()+";");
					fti.setCrewLevel(fti.getCrewLevel()+";");
					fti.setCrewTeamOrder(fti.getCrewTeamOrder()+";");
					fti.setCrewTeamType(fti.getCrewTeamType()+";");
				}
				for(int j=0; j<eCrewCrewGroupNode.getChildNodes().getLength(); j++) {
					Node eCrewCrewGroupChildNode = eCrewCrewGroupNode.getChildNodes().item(j);					
					if(eCrewCrewGroupChildNode.getNodeName().equalsIgnoreCase("eCrew.T01") && !eCrewCrewGroupChildNode.getTextContent().equalsIgnoreCase("")) {						
						fti.setCrewId(fti.getCrewId()+eCrewCrewGroupChildNode.getTextContent());						
					}						
					if(eCrewCrewGroupChildNode.getNodeName().equalsIgnoreCase("eCrew.T02") && !eCrewCrewGroupChildNode.getTextContent().equalsIgnoreCase("")) {					
						fti.setCrewLevel(fti.getCrewLevel()+Convert.getCrewLevel(eCrewCrewGroupChildNode.getTextContent()));				
					}						
					if(eCrewCrewGroupChildNode.getNodeName().equalsIgnoreCase("eCrew.T03") && !eCrewCrewGroupChildNode.getTextContent().equalsIgnoreCase("")) {					
						fti.setCrewTeamOrder(fti.getCrewTeamOrder()+eCrewCrewGroupChildNode.getTextContent());
					}
					if(eCrewCrewGroupChildNode.getNodeName().equalsIgnoreCase("eCrew.T04") && !eCrewCrewGroupChildNode.getTextContent().equalsIgnoreCase("")) {						
						fti.setCrewTeamType(fti.getCrewTeamType()+eCrewCrewGroupChildNode.getTextContent());
					}
				}
			}
//				m_logger.info(WhiteBox.logForging(fti.getCrewId());
			if(eCrewCrewGroupNodeList.getLength()>0) {
				tr.setCrewId(fti.getCrewId());	
			}
			if(doc.getElementsByTagName("eTimes.T01").getLength()>0 && !doc.getElementsByTagName("eTimes.T01").item(0).getTextContent().equalsIgnoreCase("")) {
				synchronized (sdf) {
			        tr.setPsapDatetime(renderTime(doc.getElementsByTagName("eTimes.T01").item(0).getTextContent()));
					fti.setPsapDatetime(renderTime(doc.getElementsByTagName("eTimes.T01").item(0).getTextContent()));
			    }
			}
			if(doc.getElementsByTagName("eTimes.T02").getLength()>0 && !doc.getElementsByTagName("eTimes.T02").item(0).getTextContent().equalsIgnoreCase("")) {
				synchronized (sdf) {
			        tr.setUnitNotifiedDatetime(renderTime(doc.getElementsByTagName("eTimes.T02").item(0).getTextContent()));
					fti.setUnitNotifiedDatetime(renderTime(doc.getElementsByTagName("eTimes.T02").item(0).getTextContent()));
			    }
			}
			if(doc.getElementsByTagName("eTimes.T03").getLength()>0 && !doc.getElementsByTagName("eTimes.T03").item(0).getTextContent().equalsIgnoreCase("")) {
				synchronized (sdf) {
			        tr.setEnRouteDatetime(renderTime(doc.getElementsByTagName("eTimes.T03").item(0).getTextContent()));
					fti.setEnRouteDatetime(renderTime(doc.getElementsByTagName("eTimes.T03").item(0).getTextContent()));
			    }
			}
			if(doc.getElementsByTagName("eTimes.T04").getLength()>0 && !doc.getElementsByTagName("eTimes.T04").item(0).getTextContent().equalsIgnoreCase("")) {
				synchronized (sdf) {
			        tr.setArriveSceneDatetime(renderTime(doc.getElementsByTagName("eTimes.T04").item(0).getTextContent()));
					fti.setArriveSceneDatetime(renderTime(doc.getElementsByTagName("eTimes.T04").item(0).getTextContent()));
			    }
			}
			if(doc.getElementsByTagName("eTimes.T05").getLength()>0 && !doc.getElementsByTagName("eTimes.T05").item(0).getTextContent().equalsIgnoreCase("")) {
				synchronized (sdf) {
			        tr.setArriveAtPatientDatetime(renderTime(doc.getElementsByTagName("eTimes.T05").item(0).getTextContent()));
					fti.setArriveAtPatientDatetime(renderTime(doc.getElementsByTagName("eTimes.T05").item(0).getTextContent()));
			    }
			}
			if(doc.getElementsByTagName("eTimes.T06").getLength()>0 && !doc.getElementsByTagName("eTimes.T06").item(0).getTextContent().equalsIgnoreCase("")) {
				synchronized (sdf) {
			        tr.setLeaveSceneDatetime(renderTime(doc.getElementsByTagName("eTimes.T06").item(0).getTextContent()));
					fti.setLeaveSceneDatetime(renderTime(doc.getElementsByTagName("eTimes.T06").item(0).getTextContent()));
			    }
			}
			if(doc.getElementsByTagName("eTimes.T07").getLength()>0 && !doc.getElementsByTagName("eTimes.T07").item(0).getTextContent().equalsIgnoreCase("")) {
				synchronized (sdf) {
			        tr.setArriveHospitalDatetime(renderTime(doc.getElementsByTagName("eTimes.T07").item(0).getTextContent()));
					fti.setArriveHospitalDatetime(renderTime(doc.getElementsByTagName("eTimes.T07").item(0).getTextContent()));
			    }
			}
			if(doc.getElementsByTagName("eTimes.T08").getLength()>0 && !doc.getElementsByTagName("eTimes.T08").item(0).getTextContent().equalsIgnoreCase("")) {
				synchronized (sdf) {
			        tr.setLeaveHospitalDatetime(renderTime(doc.getElementsByTagName("eTimes.T08").item(0).getTextContent()));
					fti.setLeaveHospitalDatetime(renderTime(doc.getElementsByTagName("eTimes.T08").item(0).getTextContent()));
			    }
			}
			if(doc.getElementsByTagName("eTimes.T09").getLength()>0 && !doc.getElementsByTagName("eTimes.T09").item(0).getTextContent().equalsIgnoreCase("")) {
				synchronized (sdf) {
			        tr.setBackStationDatetime(renderTime(doc.getElementsByTagName("eTimes.T09").item(0).getTextContent()));
					fti.setBackStationDatetime(renderTime(doc.getElementsByTagName("eTimes.T09").item(0).getTextContent()));
			    }
			}
			if(doc.getElementsByTagName("ePatient.T01").getLength()>0 && !doc.getElementsByTagName("ePatient.T01").item(0).getTextContent().equalsIgnoreCase("")) {
				fti.setPatientName(doc.getElementsByTagName("ePatient.T01").item(0).getTextContent());
			}
			
			if(doc.getElementsByTagName("ePatient.T02").getLength()>0 && !doc.getElementsByTagName("ePatient.T02").item(0).getTextContent().equalsIgnoreCase("")) {
				tr.setPatientId(doc.getElementsByTagName("ePatient.T02").item(0).getTextContent());
				fti.setPatientId(doc.getElementsByTagName("ePatient.T02").item(0).getTextContent());
			}
			if(doc.getElementsByTagName("ePatient.T03").getLength()>0 && !doc.getElementsByTagName("ePatient.T03").item(0).getTextContent().equalsIgnoreCase(""))
				fti.setPatientGender(Convert.getPpatientGender(doc.getElementsByTagName("ePatient.T03").item(0).getTextContent()));
			if(doc.getElementsByTagName("ePatient.T04").getLength()>0 && !doc.getElementsByTagName("ePatient.T04").item(0).getTextContent().equalsIgnoreCase(""))
				fti.setPatientAge(Integer.parseInt(doc.getElementsByTagName("ePatient.T04").item(0).getTextContent()));
			if(doc.getElementsByTagName("ePatient.T05").getLength()>0 && !doc.getElementsByTagName("ePatient.T05").item(0).getTextContent().equalsIgnoreCase(""))
				fti.setPatientAgeUnit(Convert.getPatientAgeUnit(doc.getElementsByTagName("ePatient.T05").item(0).getTextContent()));
			if(doc.getElementsByTagName("ePatient.T06").getLength()>0 && !doc.getElementsByTagName("ePatient.T06").item(0).getTextContent().equalsIgnoreCase(""))
				fti.setPatientDateOfBirth(doc.getElementsByTagName("ePatient.T06").item(0).getTextContent());
			if(doc.getElementsByTagName("ePatient.T07").getLength()>0 && !doc.getElementsByTagName("ePatient.T07").item(0).getTextContent().equalsIgnoreCase(""))
				fti.setPatientHomeLocation(doc.getElementsByTagName("ePatient.T07").item(0).getTextContent());
			if(doc.getElementsByTagName("ePatient.T08").getLength()>0 && !doc.getElementsByTagName("ePatient.T08").item(0).getTextContent().equalsIgnoreCase("")) {
				tr.setPatientHomeCityCounty(Convert.getPatientHomeCityCounty(doc.getElementsByTagName("ePatient.T08").item(0).getTextContent()));
				fti.setPatientHomeCityCounty(Convert.getPatientHomeCityCounty(doc.getElementsByTagName("ePatient.T08").item(0).getTextContent()));
			}
			if(doc.getElementsByTagName("ePatient.T09").getLength()>0 && !doc.getElementsByTagName("ePatient.T09").item(0).getTextContent().equalsIgnoreCase("")) {
				if(doc.getElementsByTagName("ePatient.T08").getLength()<0) {
					tr.setPatientHomeDistrict(Convert.getPatientHomeDistrict(null, doc.getElementsByTagName("ePatient.T09").item(0).getTextContent()));
					fti.setPatientHomeDistrict(Convert.getPatientHomeDistrict(null, doc.getElementsByTagName("ePatient.T09").item(0).getTextContent()));
				}else {
					tr.setPatientHomeDistrict(Convert.getPatientHomeDistrict(doc.getElementsByTagName("ePatient.T08").item(0).getTextContent(), doc.getElementsByTagName("ePatient.T09").item(0).getTextContent()));
					fti.setPatientHomeDistrict(Convert.getPatientHomeDistrict(doc.getElementsByTagName("ePatient.T08").item(0).getTextContent(), doc.getElementsByTagName("ePatient.T09").item(0).getTextContent()));
				}
			}

			NodeList ePaymentPaymentGroupNodeList = doc.getElementsByTagName("ePayment.PaymentGroup");
			for(int i=0; i<ePaymentPaymentGroupNodeList.getLength(); i++) {
				Node ePaymentPaymentGroupNode = ePaymentPaymentGroupNodeList.item(i);
				if(i==0) {
					fti.setSupplyItem("");
					fti.setNumberSupplyItem("");;
				}else {
					fti.setSupplyItem(fti.getSupplyItem()+";");
					fti.setNumberSupplyItem(fti.getNumberSupplyItem()+";");
				}
				for(int j=0; j<ePaymentPaymentGroupNode.getChildNodes().getLength(); j++) {
					Node ePaymentPaymentGroupChildNode = ePaymentPaymentGroupNode.getChildNodes().item(j);					
					if(ePaymentPaymentGroupChildNode.getNodeName().equalsIgnoreCase("ePayment.T01") && !ePaymentPaymentGroupChildNode.getTextContent().equalsIgnoreCase("")) {						
						fti.setSupplyItem(fti.getSupplyItem()+ePaymentPaymentGroupChildNode.getTextContent());						
					}						
					if(ePaymentPaymentGroupChildNode.getNodeName().equalsIgnoreCase("ePayment.T02") && !ePaymentPaymentGroupChildNode.getTextContent().equalsIgnoreCase("")) {					
						fti.setNumberSupplyItem(fti.getNumberSupplyItem()+ePaymentPaymentGroupChildNode.getTextContent());						
					}						
				}
			}
			
			if(doc.getElementsByTagName("eScene.T01").getLength()>0 && !doc.getElementsByTagName("eScene.T01").item(0).getTextContent().equalsIgnoreCase("")) {
				tr.setSceneLocation(doc.getElementsByTagName("eScene.T01").item(0).getTextContent());
				fti.setSceneLocation(doc.getElementsByTagName("eScene.T01").item(0).getTextContent());
			}
			if(doc.getElementsByTagName("eScene.T02").getLength()>0 && !doc.getElementsByTagName("eScene.T02").item(0).getTextContent().equalsIgnoreCase("")) {
				tr.setSceneGpsLocation(doc.getElementsByTagName("eScene.T02").item(0).getTextContent());
				fti.setSceneGpsLocation(doc.getElementsByTagName("eScene.T02").item(0).getTextContent());
			}
			if(doc.getElementsByTagName("eScene.T03").getLength()>0 && !doc.getElementsByTagName("eScene.T03").item(0).getTextContent().equalsIgnoreCase("")) {
				tr.setSceneCityCounty(Convert.getSceneCityCounty(doc.getElementsByTagName("eScene.T03").item(0).getTextContent()));
				fti.setSceneCityCounty(Convert.getSceneCityCounty(doc.getElementsByTagName("eScene.T03").item(0).getTextContent()));
			}
			if(doc.getElementsByTagName("eScene.T04").getLength()>0 && !doc.getElementsByTagName("eScene.T04").item(0).getTextContent().equalsIgnoreCase("")) {
				if(doc.getElementsByTagName("ePatient.T03").getLength()<0) {
					tr.setSceneDistrict(Convert.getSceneDistrict(null, doc.getElementsByTagName("eScene.T04").item(0).getTextContent()));
					fti.setSceneDistrict(Convert.getSceneDistrict(null, doc.getElementsByTagName("eScene.T04").item(0).getTextContent()));
				}else {
					tr.setSceneDistrict(Convert.getSceneDistrict(doc.getElementsByTagName("eScene.T03").item(0).getTextContent(), doc.getElementsByTagName("eScene.T04").item(0).getTextContent()));
					fti.setSceneDistrict(Convert.getSceneDistrict(doc.getElementsByTagName("eScene.T03").item(0).getTextContent(), doc.getElementsByTagName("eScene.T04").item(0).getTextContent()));
				}
			}	
			if(doc.getElementsByTagName("eScene.T05").getLength()>0 && !doc.getElementsByTagName("eScene.T05").item(0).getTextContent().equalsIgnoreCase("")) {
				try {
					tr.setIsMci(Convert.getIsMCI(doc.getElementsByTagName("eScene.T05").item(0).getTextContent()));	
				}catch(Exception e) {
					m_logger.error(e.toString());
					e.printStackTrace();
				}
				fti.setIsMci(Convert.getIsMCIString(doc.getElementsByTagName("eScene.T05").item(0).getTextContent()));

			}
			if(doc.getElementsByTagName("eSituation.T01").getLength()>0 && !doc.getElementsByTagName("eSituation.T01").item(0).getTextContent().equalsIgnoreCase("")) {
//				try {
//					tr.setIsTrauma(Convert.getIsTrauma(doc.getElementsByTagName("eSituation.T01").item(0).getTextContent()));
//					tm.setIsTrauma(Convert.getIsTrauma(doc.getElementsByTagName("eSituation.T01").item(0).getTextContent()));
//				}catch(Exception e) {
//					m_logger.error(e.toString());
//					e.printStackTrace();
//				}
				fti.setIsPossibleTrauma(Convert.getIsPossibleTrauma(doc.getElementsByTagName("eSituation.T01").item(0).getTextContent()));
			}
			if(doc.getElementsByTagName("eSituation.T02").getLength()>0 && !doc.getElementsByTagName("eSituation.T02").item(0).getTextContent().equalsIgnoreCase("")){
				tr.setSituationCategory(Convert.getSituationPrimaryCategory(doc.getElementsByTagName("eSituation.T02").item(0).getTextContent()));
				fti.setSituationPrimaryCategory(Convert.getSituationPrimaryCategory(doc.getElementsByTagName("eSituation.T02").item(0).getTextContent()));
			}
			if(doc.getElementsByTagName("eSituation.T03").getLength()>0 && !doc.getElementsByTagName("eSituation.T03").item(0).getTextContent().equalsIgnoreCase(""))
				fti.setSituationOtherAssociatedCategories(Convert.getSituationOtherAssociatedCategories(doc.getElementsByTagName("eSituation.T03").item(0).getTextContent()));
			if(doc.getElementsByTagName("eSituation.T04").getLength()>0 && !doc.getElementsByTagName("eSituation.T04").item(0).getTextContent().equalsIgnoreCase(""))
				fti.setPrimarySymptom(Convert.getPrimarySymptom(doc.getElementsByTagName("eSituation.T04").item(0).getTextContent()));
			if(doc.getElementsByTagName("eSituation.T05").getLength()>0 && !doc.getElementsByTagName("eSituation.T05").item(0).getTextContent().equalsIgnoreCase(""))
				fti.setOtherAssociatedSymptoms(Convert.getOtherAssociatedSymptoms(doc.getElementsByTagName("eSituation.T05").item(0).getTextContent()));
			if(doc.getElementsByTagName("eSituation.T06").getLength()>0 && !doc.getElementsByTagName("eSituation.T06").item(0).getTextContent().equalsIgnoreCase(""))
				fti.setChiefComplaint(doc.getElementsByTagName("eSituation.T06").item(0).getTextContent());
			if(doc.getElementsByTagName("eSituation.T07").getLength()>0 && !doc.getElementsByTagName("eSituation.T07").item(0).getTextContent().equalsIgnoreCase("")) {
				synchronized (sdf) {
			        fti.setLastNormalDatetime(renderTime(doc.getElementsByTagName("eSituation.T07").item(0).getTextContent()));
			    }
			}
			if(doc.getElementsByTagName("eInjury.T01").getLength()>0 && !doc.getElementsByTagName("eInjury.T01").item(0).getTextContent().equalsIgnoreCase(""))
				fti.setInjuryCause(Convert.getInjuryCause(doc.getElementsByTagName("eInjury.T01").item(0).getTextContent()));
			if(doc.getElementsByTagName("eInjury.T02").getLength()>0 && !doc.getElementsByTagName("eInjury.T02").item(0).getTextContent().equalsIgnoreCase(""))
				fti.setInjuryMechanism(Convert.getInjuryMechanism(doc.getElementsByTagName("eInjury.T02").item(0).getTextContent()));
			if(doc.getElementsByTagName("eInjury.T03").getLength()>0 && !doc.getElementsByTagName("eInjury.T03").item(0).getTextContent().equalsIgnoreCase(""))
				fti.setTraumaCenterCriteria(Convert.getTraumaCenterCriteria(doc.getElementsByTagName("eInjury.T03").item(0).getTextContent()));
			if(doc.getElementsByTagName("eInjury.T04").getLength()>0 && !doc.getElementsByTagName("eInjury.T04").item(0).getTextContent().equalsIgnoreCase(""))
				fti.setUseSafetyEquipment(Convert.getUseSafetyEquipment(doc.getElementsByTagName("eInjury.T04").item(0).getTextContent()));
			if(doc.getElementsByTagName("eInjury.T05").getLength()>0 && !doc.getElementsByTagName("eInjury.T05").item(0).getTextContent().equalsIgnoreCase(""))
				fti.setHeightOfFallMeter(Integer.parseInt(doc.getElementsByTagName("eInjury.T05").item(0).getTextContent()));
			
		
			if(doc.getElementsByTagName("eArrest.T01").getLength()>0 && !doc.getElementsByTagName("eArrest.T01").item(0).getTextContent().equalsIgnoreCase("")) {
				try {
					tr.setIsOhca(Convert.getIsOhca(doc.getElementsByTagName("eArrest.T01").item(0).getTextContent()));
				}catch(Exception e) {
					m_logger.error(e.toString());
					e.printStackTrace();
				}
				fti.setIsCardiacArrest(Convert.getIsCardiacArrest(doc.getElementsByTagName("eArrest.T01").item(0).getTextContent()));
			}
			if(doc.getElementsByTagName("eArrest.T02").getLength()>0 && !doc.getElementsByTagName("eArrest.T02").item(0).getTextContent().equalsIgnoreCase(""))
				fti.setPossibleOhcaEtiology(Convert.getPossibleOHCAEtiology(doc.getElementsByTagName("eArrest.T02").item(0).getTextContent()));
			if(doc.getElementsByTagName("eArrest.T03").getLength()>0 && !doc.getElementsByTagName("eArrest.T03").item(0).getTextContent().equalsIgnoreCase(""))
				fti.setResuscitationAttemptedByEms(Convert.getResuscitationAttemptedByEMS(doc.getElementsByTagName("eArrest.T03").item(0).getTextContent()));
			if(doc.getElementsByTagName("eArrest.T04").getLength()>0 && !doc.getElementsByTagName("eArrest.T04").item(0).getTextContent().equalsIgnoreCase(""))
				fti.setArrestWitnessedBy(Convert.getArrestWitnessedBy(doc.getElementsByTagName("eArrest.T04").item(0).getTextContent()));
			if(doc.getElementsByTagName("eArrest.T05").getLength()>0 && !doc.getElementsByTagName("eArrest.T05").item(0).getTextContent().equalsIgnoreCase(""))
				fti.setIsCprPriorEmsArrival(Convert.getIsCPRPriorEMSArrival(doc.getElementsByTagName("eArrest.T05").item(0).getTextContent()));
			if(doc.getElementsByTagName("eArrest.T06").getLength()>0 && !doc.getElementsByTagName("eArrest.T06").item(0).getTextContent().equalsIgnoreCase(""))
				fti.setIsUsePadPriorEmsArrival(Convert.getIsUsePADPriorEMSArrival(doc.getElementsByTagName("eArrest.T06").item(0).getTextContent()));
			if(doc.getElementsByTagName("eArrest.T07").getLength()>0 && !doc.getElementsByTagName("eArrest.T07").item(0).getTextContent().equalsIgnoreCase(""))
				fti.setIsRosc(Convert.getIsROSC(doc.getElementsByTagName("eArrest.T07").item(0).getTextContent()));
			if(doc.getElementsByTagName("eArrest.T08").getLength()>0 && !doc.getElementsByTagName("eArrest.T08").item(0).getTextContent().equalsIgnoreCase(""))
				fti.setOhcatLocationType(Convert.getOHCAtLocationType(doc.getElementsByTagName("eArrest.T08").item(0).getTextContent()));
			if(doc.getElementsByTagName("eArrest.T09").getLength()>0 && !doc.getElementsByTagName("eArrest.T09").item(0).getTextContent().equalsIgnoreCase(""))
				fti.setWhoCprPriorEmsArrival(Convert.getWhoCPRPriorEMSArrival(doc.getElementsByTagName("eArrest.T09").item(0).getTextContent()));
			if(doc.getElementsByTagName("eArrest.T10").getLength()>0 && !doc.getElementsByTagName("eArrest.T10").item(0).getTextContent().equalsIgnoreCase(""))
				fti.setTypeCprPriorEmsArrival(Convert.getTypeCPRPriorEMSArrival(doc.getElementsByTagName("eArrest.T10").item(0).getTextContent()));
			if(doc.getElementsByTagName("eArrest.T11").getLength()>0 && !doc.getElementsByTagName("eArrest.T11").item(0).getTextContent().equalsIgnoreCase(""))
				fti.setFirstArrestRhythm(Convert.getFirstArrestRhythm(doc.getElementsByTagName("eArrest.T11").item(0).getTextContent()));
			if(doc.getElementsByTagName("eArrest.T12").getLength()>0 && !doc.getElementsByTagName("eArrest.T12").item(0).getTextContent().equalsIgnoreCase(""))
				fti.setArrivalArrestRhythm(Convert.getAarrivalArrestRhythm(doc.getElementsByTagName("eArrest.T12").item(0).getTextContent()));
			if(doc.getElementsByTagName("eArrest.T13").getLength()>0 && !doc.getElementsByTagName("eArrest.T13").item(0).getTextContent().equalsIgnoreCase(""))
				fti.setDefibrillationCount(Integer.parseInt(doc.getElementsByTagName("eArrest.T13").item(0).getTextContent()));
//				
			if(doc.getElementsByTagName("eHistory.T01").getLength()>0 && !doc.getElementsByTagName("eHistory.T01").item(0).getTextContent().equalsIgnoreCase(""))
				fti.setIsMedicationAllergies(Convert.getIsMedicationAllergies(doc.getElementsByTagName("eHistory.T01").item(0).getTextContent()));
			if(doc.getElementsByTagName("eHistory.T02").getLength()>0 && !doc.getElementsByTagName("eHistory.T02").item(0).getTextContent().equalsIgnoreCase(""))
				fti.setMedicationAllergies(Convert.getMedicationAllergies(doc.getElementsByTagName("eHistory.T02").item(0).getTextContent()));
			if(doc.getElementsByTagName("eHistory.T03").getLength()>0 && !doc.getElementsByTagName("eHistory.T03").item(0).getTextContent().equalsIgnoreCase(""))
				fti.setIsFoodAllergies(Convert.getIsFoodAllergies(doc.getElementsByTagName("eHistory.T03").item(0).getTextContent()));
			if(doc.getElementsByTagName("eHistory.T04").getLength()>0 && !doc.getElementsByTagName("eHistory.T04").item(0).getTextContent().equalsIgnoreCase(""))
				fti.setFoodAllergies(Convert.getFoodAllergies(doc.getElementsByTagName("eHistory.T04").item(0).getTextContent()));
			if(doc.getElementsByTagName("eHistory.T05").getLength()>0 && !doc.getElementsByTagName("eHistory.T05").item(0).getTextContent().equalsIgnoreCase(""))
				fti.setIsOtherAllergies(Convert.getIsOtherAllergies(doc.getElementsByTagName("eHistory.T05").item(0).getTextContent()));
			if(doc.getElementsByTagName("eHistory.T06").getLength()>0 && !doc.getElementsByTagName("eHistory.T06").item(0).getTextContent().equalsIgnoreCase(""))
				fti.setOtherAllergies(Convert.getOtherAllergies(doc.getElementsByTagName("eHistory.T06").item(0).getTextContent()));
//			if(doc.getElementsByTagName("eHistory.T07").getLength()>0 && !doc.getElementsByTagName("eHistory.T07").item(0).getTextContent().equalsIgnoreCase(""))
//				fti.setPastMedicalSurgicalHistory(Convert.getPastMedicalSurgicalHistory(doc.getElementsByTagName("eHistory.T07").item(0).getTextContent()));
			//2022/2/17:過去病史
			NodeList pastMedicalSurgicalHistoryNodeList = doc.getElementsByTagName("eHistory.T07");
			for(int i=0; i<pastMedicalSurgicalHistoryNodeList.getLength(); i++) {
				Node pastMedicalSurgicalHistoryNode = pastMedicalSurgicalHistoryNodeList.item(i);
				if(i==0) {
					fti.setPastMedicalSurgicalHistory(Convert.getPastMedicalSurgicalHistory(pastMedicalSurgicalHistoryNode.getTextContent()));
				}else {
					fti.setPastMedicalSurgicalHistory(fti.getPastMedicalSurgicalHistory()+","+Convert.getPastMedicalSurgicalHistory(pastMedicalSurgicalHistoryNode.getTextContent()));
				}
			}
			//
			if(doc.getElementsByTagName("eHistory.T08").getLength()>0 && !doc.getElementsByTagName("eHistory.T08").item(0).getTextContent().equalsIgnoreCase("")) {
				synchronized (sdf) {
			        fti.setLastOralIntake(renderTime(doc.getElementsByTagName("eHistory.T08").item(0).getTextContent()));
			    }
			}
			
			if(doc.getElementsByTagName("eNarrative.T01").getLength()>0 && !doc.getElementsByTagName("eNarrative.T01").item(0).getTextContent().equalsIgnoreCase("")){
				tr.setNarrative(doc.getElementsByTagName("eNarrative.T01").item(0).getTextContent());
				fti.setNarrative(doc.getElementsByTagName("eNarrative.T01").item(0).getTextContent());
				//m_logger.info(WhiteBox.logForging(fti.getNarrative());
				if(tr.getNarrative().indexOf("OHCA")>=0 || tr.getNarrative().indexOf("ohca")>=0) {
					m_logger.info(WhiteBox.logForging("Narrative含\"OHCA\"字串，設定isOhca=1"));
					tr.setIsOhca(1);
				}
				if(tr.getNarrative().indexOf("重大外傷")>=0) {
					m_logger.info(WhiteBox.logForging("Narrative含\"重大外傷\"字串，設定isTrauma=1"));
					tr.setIsTrauma(1);
				}else {
					tr.setIsTrauma(0);
				}
			}
			
			
			NodeList eVitalsVitalGroupNodeList = doc.getElementsByTagName("eVitals.VitalGroup");
			for(int i=0; i<eVitalsVitalGroupNodeList.getLength(); i++) {
				Node eVitalsVitalGroupNode = eVitalsVitalGroupNodeList.item(i);
				if(i==0) {
					fti.setVitalSignsTakenDatetime("");
					fti.setVitalSignsTakenPhase("");
					fti.setResponsivenessLevel("");
					fti.setGcsEye("");
					fti.setGcsVerbal("");
					fti.setGcsMotor("");
					fti.setRespiratoryRate("");
					fti.setHeartRate("");
					fti.setHeartRateMeasureMethod("");
					fti.setSbp("");
					fti.setDbp("");
					fti.setBpMeasureMethod("");
					fti.setPulseOximetry("");
					fti.setPupilLightReflexLeft("");
					fti.setPupilLightReflexRight("");
					fti.setPupilSizeLeft("");
					fti.setPupilSizeRight("");
					fti.setSkin("");
					fti.setTemperature("");
					fti.setTemperatureMethod("");
					fti.setBloodGlucoseLevel("");
				}else {
					fti.setVitalSignsTakenDatetime(fti.getVitalSignsTakenDatetime()+";");
					fti.setVitalSignsTakenPhase(fti.getVitalSignsTakenPhase()+";");
					fti.setResponsivenessLevel(fti.getResponsivenessLevel()+";");
					fti.setGcsEye(fti.getGcsEye()+";");
					fti.setGcsVerbal(fti.getGcsVerbal()+";");
					fti.setGcsMotor(fti.getGcsMotor()+";");
					fti.setRespiratoryRate(fti.getRespiratoryRate()+";");
					fti.setHeartRate(fti.getHeartRate()+";");
					fti.setHeartRateMeasureMethod(fti.getHeartRateMeasureMethod()+";");
					fti.setSbp(fti.getSbp()+";");
					fti.setDbp(fti.getDbp()+";");
					fti.setBpMeasureMethod(fti.getBpMeasureMethod()+";");
					fti.setPulseOximetry(fti.getPulseOximetry()+";");
					fti.setPupilLightReflexLeft(fti.getPupilLightReflexLeft()+";");
					fti.setPupilLightReflexRight(fti.getPupilLightReflexRight()+";");
					fti.setPupilSizeLeft(fti.getPupilSizeLeft()+";");
					fti.setPupilSizeRight(fti.getPupilSizeRight()+";");
					fti.setSkin(fti.getSkin()+";");
					fti.setTemperature(fti.getTemperature()+";");
					fti.setTemperatureMethod(fti.getTemperatureMethod()+";");
					fti.setBloodGlucoseLevel(fti.getBloodGlucoseLevel()+";");
				}
				for(int j=0; j<eVitalsVitalGroupNode.getChildNodes().getLength(); j++) {
					Node eVitalsVitalGroupChildNode = eVitalsVitalGroupNode.getChildNodes().item(j);					
					if(eVitalsVitalGroupChildNode.getNodeName().equalsIgnoreCase("eVitals.T01") && !eVitalsVitalGroupChildNode.getTextContent().equalsIgnoreCase("")) {						
						synchronized (sdf) {
				            fti.setVitalSignsTakenDatetime(fti.getVitalSignsTakenDatetime()+sdf2.format(renderTime(eVitalsVitalGroupChildNode.getTextContent())));
				        }
					}			
					if(eVitalsVitalGroupChildNode.getNodeName().equalsIgnoreCase("eVitals.T02") && !eVitalsVitalGroupChildNode.getTextContent().equalsIgnoreCase("")) {					
						fti.setVitalSignsTakenPhase(fti.getVitalSignsTakenPhase()+Convert.getVitalSignsTakenPhase(eVitalsVitalGroupChildNode.getTextContent()));						
					}						
					if(eVitalsVitalGroupChildNode.getNodeName().equalsIgnoreCase("eVitals.T03") && !eVitalsVitalGroupChildNode.getTextContent().equalsIgnoreCase("")) {					
						fti.setResponsivenessLevel(fti.getResponsivenessLevel()+Convert.getResponsivenessLevel(eVitalsVitalGroupChildNode.getTextContent()));
					}
					if(eVitalsVitalGroupChildNode.getNodeName().equalsIgnoreCase("eVitals.T04") && !eVitalsVitalGroupChildNode.getTextContent().equalsIgnoreCase("")) {						
						fti.setGcsEye(fti.getGcsEye()+Convert.getGCSEye(eVitalsVitalGroupChildNode.getTextContent()).replaceAll(";", ""));
					}
					if(eVitalsVitalGroupChildNode.getNodeName().equalsIgnoreCase("eVitals.T05") && !eVitalsVitalGroupChildNode.getTextContent().equalsIgnoreCase("")) {						
						fti.setGcsVerbal(fti.getGcsVerbal()+Convert.getGCSVerbal(eVitalsVitalGroupChildNode.getTextContent()).replaceAll(";", ""));
					}
					if(eVitalsVitalGroupChildNode.getNodeName().equalsIgnoreCase("eVitals.T06") && !eVitalsVitalGroupChildNode.getTextContent().equalsIgnoreCase("")) {						
						fti.setGcsMotor(fti.getGcsMotor()+Convert.getGCSMotor(eVitalsVitalGroupChildNode.getTextContent()).replaceAll(";", ""));
					}
					if(eVitalsVitalGroupChildNode.getNodeName().equalsIgnoreCase("eVitals.T07") && !eVitalsVitalGroupChildNode.getTextContent().equalsIgnoreCase("")) {						
						fti.setRespiratoryRate(fti.getRespiratoryRate()+eVitalsVitalGroupChildNode.getTextContent());
					}
					if(eVitalsVitalGroupChildNode.getNodeName().equalsIgnoreCase("eVitals.T08") && !eVitalsVitalGroupChildNode.getTextContent().equalsIgnoreCase("")) {						
						fti.setHeartRate(fti.getHeartRate()+eVitalsVitalGroupChildNode.getTextContent());
					}
					if(eVitalsVitalGroupChildNode.getNodeName().equalsIgnoreCase("eVitals.T09") && !eVitalsVitalGroupChildNode.getTextContent().equalsIgnoreCase("")) {						
						fti.setHeartRateMeasureMethod(fti.getHeartRateMeasureMethod()+Convert.getHeartRateMeasureMethod(eVitalsVitalGroupChildNode.getTextContent()));
					}
					if(eVitalsVitalGroupChildNode.getNodeName().equalsIgnoreCase("eVitals.T10") && !eVitalsVitalGroupChildNode.getTextContent().equalsIgnoreCase("")) {						
						fti.setSbp(fti.getSbp()+eVitalsVitalGroupChildNode.getTextContent());
					}
					if(eVitalsVitalGroupChildNode.getNodeName().equalsIgnoreCase("eVitals.T11") && !eVitalsVitalGroupChildNode.getTextContent().equalsIgnoreCase("")) {						
						fti.setDbp(fti.getDbp()+eVitalsVitalGroupChildNode.getTextContent());
					}
					if(eVitalsVitalGroupChildNode.getNodeName().equalsIgnoreCase("eVitals.T12") && !eVitalsVitalGroupChildNode.getTextContent().equalsIgnoreCase("")) {						
						fti.setBpMeasureMethod(fti.getBpMeasureMethod()+Convert.getBPMeasureMethod(eVitalsVitalGroupChildNode.getTextContent()));
					}
					if(eVitalsVitalGroupChildNode.getNodeName().equalsIgnoreCase("eVitals.T13") && !eVitalsVitalGroupChildNode.getTextContent().equalsIgnoreCase("")) {						
						fti.setPulseOximetry(fti.getPulseOximetry()+eVitalsVitalGroupChildNode.getTextContent());
					}
					if(eVitalsVitalGroupChildNode.getNodeName().equalsIgnoreCase("eVitals.T14") && !eVitalsVitalGroupChildNode.getTextContent().equalsIgnoreCase("")) {						
						fti.setPupilLightReflexLeft(fti.getPupilLightReflexLeft()+Convert.getPupilLightReflexLeft(eVitalsVitalGroupChildNode.getTextContent()));
					}
					if(eVitalsVitalGroupChildNode.getNodeName().equalsIgnoreCase("eVitals.T15") && !eVitalsVitalGroupChildNode.getTextContent().equalsIgnoreCase("")) {						
						fti.setPupilLightReflexRight(fti.getPupilLightReflexRight()+Convert.getPupilLightReflexRight(eVitalsVitalGroupChildNode.getTextContent()));
					}
					if(eVitalsVitalGroupChildNode.getNodeName().equalsIgnoreCase("eVitals.T16") && !eVitalsVitalGroupChildNode.getTextContent().equalsIgnoreCase("")) {						
						fti.setPupilSizeLeft(fti.getPupilSizeLeft()+eVitalsVitalGroupChildNode.getTextContent());
					}
					if(eVitalsVitalGroupChildNode.getNodeName().equalsIgnoreCase("eVitals.T17") && !eVitalsVitalGroupChildNode.getTextContent().equalsIgnoreCase("")) {						
						fti.setPupilSizeRight(fti.getPupilSizeRight()+eVitalsVitalGroupChildNode.getTextContent());
					}
					if(eVitalsVitalGroupChildNode.getNodeName().equalsIgnoreCase("eVitals.T18") && !eVitalsVitalGroupChildNode.getTextContent().equalsIgnoreCase("")) {						
						fti.setSkin(fti.getSkin()+Convert.getSkin(eVitalsVitalGroupChildNode.getTextContent()));
					}
					if(eVitalsVitalGroupChildNode.getNodeName().equalsIgnoreCase("eVitals.T19") && !eVitalsVitalGroupChildNode.getTextContent().equalsIgnoreCase("")) {						
						fti.setTemperature(fti.getTemperature()+eVitalsVitalGroupChildNode.getTextContent());
					}
					if(eVitalsVitalGroupChildNode.getNodeName().equalsIgnoreCase("eVitals.T20") && !eVitalsVitalGroupChildNode.getTextContent().equalsIgnoreCase("")) {						
						fti.setTemperatureMethod(fti.getTemperatureMethod()+Convert.getTemperatureMethodemperature(eVitalsVitalGroupChildNode.getTextContent()));
					}
					if(eVitalsVitalGroupChildNode.getNodeName().equalsIgnoreCase("eVitals.T21") && !eVitalsVitalGroupChildNode.getTextContent().equalsIgnoreCase("")) {						
						fti.setBloodGlucoseLevel(fti.getBloodGlucoseLevel()+eVitalsVitalGroupChildNode.getTextContent());
					}
				}				
			}

			
			if(doc.getElementsByTagName("eExam.T01").getLength()>0 && !doc.getElementsByTagName("eExam.T01").item(0).getTextContent().equalsIgnoreCase(""))
				fti.setNeurologicalAssessment(Convert.getNeurologicalAssessment(doc.getElementsByTagName("eExam.T01").item(0).getTextContent()));		
			
			NodeList eMedicationsMedicationGroupNodeList = doc.getElementsByTagName("eMedications.MedicationGroup");
			for(int i=0; i<eMedicationsMedicationGroupNodeList.getLength(); i++) {
				Node eMedicationsMedicationGroupNode = eMedicationsMedicationGroupNodeList.item(i);
				if(i==0) {
					fti.setMedicationGiven("");
					fti.setMedicationAdministeredRoute("");
					fti.setMedicationDosage("");
					fti.setMedicationDosageUnits("");
				}else {
					fti.setMedicationGiven(fti.getMedicationGiven()+";");
					fti.setMedicationAdministeredRoute(fti.getMedicationAdministeredRoute()+";");
					fti.setMedicationDosage(fti.getMedicationDosage()+";");
					fti.setMedicationDosageUnits(fti.getMedicationDosageUnits()+";");
				}
				for(int j=0; j<eMedicationsMedicationGroupNode.getChildNodes().getLength(); j++) {
					Node eMedicationsMedicationGroupChildNode = eMedicationsMedicationGroupNode.getChildNodes().item(j);					
					if(eMedicationsMedicationGroupChildNode.getNodeName().equalsIgnoreCase("eMedications.T01") && !eMedicationsMedicationGroupChildNode.getTextContent().equalsIgnoreCase("")) {						
						fti.setMedicationGiven(fti.getMedicationGiven()+Convert.getMedicationGiven(eMedicationsMedicationGroupChildNode.getTextContent()));						
					}						
					if(eMedicationsMedicationGroupChildNode.getNodeName().equalsIgnoreCase("eMedications.T02") && !eMedicationsMedicationGroupChildNode.getTextContent().equalsIgnoreCase("")) {					
						fti.setMedicationAdministeredRoute(fti.getMedicationAdministeredRoute()+Convert.getMedicationAdministeredRoute(eMedicationsMedicationGroupChildNode.getTextContent()));						
					}						
					if(eMedicationsMedicationGroupChildNode.getNodeName().equalsIgnoreCase("eMedications.T03") && !eMedicationsMedicationGroupChildNode.getTextContent().equalsIgnoreCase("")) {					
						fti.setMedicationDosage(fti.getMedicationDosage()+eMedicationsMedicationGroupChildNode.getTextContent());
					}
					if(eMedicationsMedicationGroupChildNode.getNodeName().equalsIgnoreCase("eMedications.T04") && !eMedicationsMedicationGroupChildNode.getTextContent().equalsIgnoreCase("")) {						
						fti.setMedicationDosageUnits(fti.getMedicationDosageUnits()+Convert.getMedicationDosageUnits(eMedicationsMedicationGroupChildNode.getTextContent()));
					}
				}
			}

			NodeList eProceduresProcedureGroupNodeList = doc.getElementsByTagName("eProcedures.ProcedureGroup");
			for(int i=0; i<eProceduresProcedureGroupNodeList.getLength(); i++) {
				Node eProceduresProcedureGroupNode = eProceduresProcedureGroupNodeList.item(i);
				if(i==0) {
					fti.setProcedure("");
					fti.setEquipmentSize("");
				}else {
					fti.setProcedure(fti.getProcedure()+";");
					fti.setEquipmentSize(fti.getEquipmentSize()+";");
				}
				for(int j=0; j<eProceduresProcedureGroupNode.getChildNodes().getLength(); j++) {
					Node eProceduresProcedureGroupChildNode = eProceduresProcedureGroupNode.getChildNodes().item(j);					
					if(eProceduresProcedureGroupChildNode.getNodeName().equalsIgnoreCase("eProcedures.T01") && !eProceduresProcedureGroupChildNode.getTextContent().equalsIgnoreCase("")) {						
						fti.setProcedure(fti.getProcedure()+Convert.getProcedure(eProceduresProcedureGroupChildNode.getTextContent()));						
					}						
					if(eProceduresProcedureGroupChildNode.getNodeName().equalsIgnoreCase("eProcedures.T02") && !eProceduresProcedureGroupChildNode.getTextContent().equalsIgnoreCase("")) {					
						fti.setEquipmentSize(fti.getEquipmentSize()+eProceduresProcedureGroupChildNode.getTextContent());						
					}
				}
			}
			
			if(doc.getElementsByTagName("eDisposition.T01").getLength()>0 && !doc.getElementsByTagName("eDisposition.T01").item(0).getTextContent().equalsIgnoreCase("")){
				tr.setDestinationLocation(doc.getElementsByTagName("eDisposition.T01").item(0).getTextContent());
				fti.setDestinationLocation(doc.getElementsByTagName("eDisposition.T01").item(0).getTextContent());
			}
			if(doc.getElementsByTagName("eDisposition.T02").getLength()>0 && !doc.getElementsByTagName("eDisposition.T02").item(0).getTextContent().equalsIgnoreCase("")) {
				tr.setFacilityId(doc.getElementsByTagName("eDisposition.T02").item(0).getTextContent());
				fti.setHospitalFacilityId(doc.getElementsByTagName("eDisposition.T02").item(0).getTextContent());
			}
			if(doc.getElementsByTagName("eDisposition.T03").getLength()>0 && !doc.getElementsByTagName("eDisposition.T03").item(0).getTextContent().equalsIgnoreCase("")){
				tr.setDestinationGpsLocation(doc.getElementsByTagName("eDisposition.T03").item(0).getTextContent());
				fti.setDestinationGpsLocation(doc.getElementsByTagName("eDisposition.T03").item(0).getTextContent());
			}
			if(doc.getElementsByTagName("eDisposition.T04").getLength()>0 && !doc.getElementsByTagName("eDisposition.T04").item(0).getTextContent().equalsIgnoreCase("")){
				tr.setDestinationCityCounty(Convert.getDestinationCityCounty(doc.getElementsByTagName("eDisposition.T04").item(0).getTextContent()));
				fti.setDestinationCityCounty(Convert.getDestinationCityCounty(doc.getElementsByTagName("eDisposition.T04").item(0).getTextContent()));
			}
			if(doc.getElementsByTagName("eDisposition.T05").getLength()>0 && !doc.getElementsByTagName("eDisposition.T05").item(0).getTextContent().equalsIgnoreCase("")){
				if(doc.getElementsByTagName("eDisposition.T04").getLength()<0) {
					tr.setDestinationDistrict(Convert.getDestinationDistrict(null, doc.getElementsByTagName("eDisposition.T05").item(0).getTextContent()));	
					fti.setDestinationDistrict(Convert.getDestinationDistrict(null, doc.getElementsByTagName("eDisposition.T05").item(0).getTextContent()));
				}else {
					tr.setDestinationDistrict(Convert.getDestinationDistrict(doc.getElementsByTagName("eDisposition.T04").item(0).getTextContent(), doc.getElementsByTagName("eDisposition.T05").item(0).getTextContent()));	
					fti.setDestinationDistrict(Convert.getDestinationDistrict(doc.getElementsByTagName("eDisposition.T04").item(0).getTextContent(), doc.getElementsByTagName("eDisposition.T05").item(0).getTextContent()));
				}
			}
			if(doc.getElementsByTagName("eDisposition.T06").getLength()>0 && !doc.getElementsByTagName("eDisposition.T06").item(0).getTextContent().equalsIgnoreCase(""))
				fti.setDestinationChoice(Convert.getDestinationChoice(doc.getElementsByTagName("eDisposition.T06").item(0).getTextContent()));
			if(doc.getElementsByTagName("eDisposition.T07").getLength()>0 && !doc.getElementsByTagName("eDisposition.T07").item(0).getTextContent().equalsIgnoreCase("")){
				tr.setPatientDisposition(Convert.getPatientDisposition(doc.getElementsByTagName("eDisposition.T07").item(0).getTextContent()));
				fti.setPatientDisposition(Convert.getPatientDisposition(doc.getElementsByTagName("eDisposition.T07").item(0).getTextContent()));
			}
			if(doc.getElementsByTagName("eDisposition.T08").getLength()>0 && !doc.getElementsByTagName("eDisposition.T08").item(0).getTextContent().equalsIgnoreCase(""))
				fti.setWayMovedToAmbulance(Convert.getWayMovedToAmbulance(doc.getElementsByTagName("eDisposition.T08").item(0).getTextContent()));
			if(doc.getElementsByTagName("eDisposition.T09").getLength()>0 && !doc.getElementsByTagName("eDisposition.T09").item(0).getTextContent().equalsIgnoreCase("")) {
				try {
					tr.setIsAls(Convert.getIsALS(doc.getElementsByTagName("eDisposition.T09").item(0).getTextContent()));
				}catch(Exception e) {
					m_logger.error(e.toString());
					e.printStackTrace();
				}
				fti.setIsAls(Convert.getIsALSString(doc.getElementsByTagName("eDisposition.T09").item(0).getTextContent()));
			}
			if(doc.getElementsByTagName("eDisposition.T10").getLength()>0 && !doc.getElementsByTagName("eDisposition.T10").item(0).getTextContent().equalsIgnoreCase("")) {
				tr.setSceneAcuityLevel(Convert.getSceneAcuityLevel(doc.getElementsByTagName("eDisposition.T10").item(0).getTextContent()));	
				fti.setSceneAcuityLevel(Convert.getSceneAcuityLevel(doc.getElementsByTagName("eDisposition.T10").item(0).getTextContent()));		
				
			}
			
			if(doc.getElementsByTagName("eOutcome.T01").getLength()>0 && !doc.getElementsByTagName("eOutcome.T01").item(0).getTextContent().equalsIgnoreCase("")) {
				tr.setErTriageLevel(Convert.getERTriageLevel(doc.getElementsByTagName("eOutcome.T01").item(0).getTextContent()));
				fti.setErTriageLevel(Convert.getERTriageLevel(doc.getElementsByTagName("eOutcome.T01").item(0).getTextContent()));
			}
			if(doc.getElementsByTagName("eOutcome.T02").getLength()>0 && !doc.getElementsByTagName("eOutcome.T02").item(0).getTextContent().equalsIgnoreCase(""))
				fti.setErDisposition(Convert.getERDisposition(doc.getElementsByTagName("eOutcome.T02").item(0).getTextContent()));
			if(doc.getElementsByTagName("eOutcome.T03").getLength()>0 && !doc.getElementsByTagName("eOutcome.T03").item(0).getTextContent().equalsIgnoreCase(""))
				fti.setHospitalDisposition(Convert.getHospitalDisposition(doc.getElementsByTagName("eOutcome.T03").item(0).getTextContent()));
			if(doc.getElementsByTagName("eOutcome.T04").getLength()>0 && !doc.getElementsByTagName("eOutcome.T04").item(0).getTextContent().equalsIgnoreCase(""))
				fti.setIsDischargedAlive(Convert.getIsDischargedAlive(doc.getElementsByTagName("eOutcome.T04").item(0).getTextContent()));
			if(doc.getElementsByTagName("eOutcome.T05").getLength()>0 && !doc.getElementsByTagName("eOutcome.T05").item(0).getTextContent().equalsIgnoreCase(""))
				fti.setCpcLevel(Convert.getCPCLevel(doc.getElementsByTagName("eOutcome.T05").item(0).getTextContent()));
			if(doc.getElementsByTagName("eOutcome.T06").getLength()>0 && !doc.getElementsByTagName("eOutcome.T06").item(0).getTextContent().equalsIgnoreCase(""))
				fti.setDnrInEr(Convert.getDNRInER(doc.getElementsByTagName("eOutcome.T06").item(0).getTextContent()));
			
		}else {
			if(result.equalsIgnoreCase("")) {
				result += "無法取得document物件\n";
			}else {
				result += ",無法取得document物件\n";
			}
			dataCheckIsOk = false;
		}
		
		
		TemsisVo vo = new TemsisVo();
		vo.setRecordNumber_A(tr.getRecordNumber()== null ? "" : tr.getRecordNumber().replace(",", "，"));
		vo.setArea_B(tr.getArea()== null ? "" : tr.getArea().replace(",", "，"));
		vo.setEmsAgentCode_C(tr.getEmsAgentCode()== null ? "" : tr.getEmsAgentCode());
		vo.setVehicleDispatchLocation_D(String.valueOf(fti.getVehicleDispatchLocation()== null ? "" :fti.getVehicleDispatchLocation()).replace(",", "，"));
		vo.setVehicleDispatchGPSLocation_E(String.valueOf(fti.getVehicleDispatchGpsLocation()== null ? "" :fti.getVehicleDispatchGpsLocation()).replace(",", "，"));
		vo.setVehicleDispatchCityCounty_F(String.valueOf(fti.getVehicleDispatchCityCounty()== null ? "" :fti.getVehicleDispatchCityCounty()).replace(",", "，"));
		vo.setVehicleDispatchDistrict_G(String.valueOf(fti.getVehicleDispatchDistrict()== null ? "" :fti.getVehicleDispatchDistrict()).replace(",", "，"));
		vo.setDispatchComplaint_H(String.valueOf(fti.getDispatchComplaint()== null ? "" :fti.getDispatchComplaint()).replace(",", "，"));
		vo.setDispatchLevel_I(String.valueOf(fti.getDispatchLevel()== null ? "" :fti.getDispatchLevel()).replace(",", "，"));
		vo.setCrewLevel_J(String.valueOf(fti.getCrewLevel()== null ? "" :fti.getCrewLevel()).replace(",", "，"));
		vo.setPsapDatetime_K(fti.getPsapDatetime());
		vo.setUnitNotifiedDateTime_L(fti.getUnitNotifiedDatetime());
		vo.setEnRouteDateTime_M(fti.getEnRouteDatetime());
		vo.setArriveSceneDateTime_N(fti.getArriveSceneDatetime());
		vo.setArriveAtPatientDatetime_O(fti.getArriveAtPatientDatetime());
		vo.setLeaveSceneDatetime_P(fti.getLeaveSceneDatetime());
		vo.setArriveHospitalDateTime_Q(fti.getArriveHospitalDatetime());
		vo.setLeaveHospitalDateTime_R(fti.getLeaveHospitalDatetime());
		vo.setPatientID_S(String.valueOf(fti.getPatientId()== null ? "" :fti.getPatientId()).replace(",", "，"));
		vo.setPatientGender_T(String.valueOf(fti.getPatientGender()== null ? "" :fti.getPatientGender()).replace(",", "，"));
		vo.setPatientAge_U(fti.getPatientAge());
		vo.setPatientAgeUnit_V(String.valueOf(fti.getPatientAgeUnit()== null ? "" :fti.getPatientAgeUnit()).replace(",", "，"));
		vo.setPatientDateOfBirth_W(String.valueOf(fti.getPatientDateOfBirth()== null ? "" :fti.getPatientDateOfBirth()).replace(",", "，"));
		vo.setPatientHomeLocation_X(String.valueOf(fti.getPatientHomeLocation()== null ? "" :fti.getPatientHomeLocation()).replace(",", "，"));
		vo.setPatientHomeCityCounty_Y(String.valueOf(fti.getPatientHomeCityCounty()== null ? "" :fti.getPatientHomeCityCounty()).replace(",", "，"));
		vo.setPatientHomeDistrict_Z(String.valueOf(fti.getPatientHomeDistrict()== null ? "" :fti.getPatientHomeDistrict()).replace(",", "，"));
		
		vo.setSceneLocation_AA(String.valueOf(fti.getSceneLocation()== null ? "" :fti.getSceneLocation()).replace(",", "，"));
		vo.setSceneGpsLocation_AB(String.valueOf(fti.getSceneGpsLocation()== null ? "" :fti.getSceneGpsLocation()).replace(",", "，"));
		vo.setSceneCityCounty_AC(String.valueOf(fti.getSceneCityCounty()== null ? "" :fti.getSceneCityCounty()).replace(",", "，"));
		vo.setSceneDistrict_AD(String.valueOf(fti.getSceneDistrict()== null ? "" :fti.getSceneDistrict()).replace(",", "，"));
		vo.setIsPossibleTrauma_AE(String.valueOf(fti.getIsPossibleTrauma()== null ? "" :fti.getIsPossibleTrauma()).replace(",", "，"));
		vo.setSituationPrimaryCategory_AF(String.valueOf(fti.getSituationPrimaryCategory()== null ? "" :fti.getSituationPrimaryCategory()).replace(",", "，"));
		vo.setPrimarySymptom_AG(String.valueOf(fti.getPrimarySymptom()== null ? "" :fti.getPrimarySymptom()).replace(",", "，"));
		vo.setInjuryCause_AH(String.valueOf(fti.getInjuryCause()== null ? "" :fti.getInjuryCause()).replace(",", "，"));
		vo.setTraumaCenterCriteria_AI(String.valueOf(fti.getTraumaCenterCriteria()== null ? "" :fti.getTraumaCenterCriteria()).replace(",", "，"));
		vo.setIsCardiacArrest_AJ(String.valueOf(fti.getIsCardiacArrest()== null ? "" :fti.getIsCardiacArrest()).replace(",", "，"));
		vo.setPossibleOhcaEtiology_AK(String.valueOf(fti.getPossibleOhcaEtiology()== null ? "" :fti.getPossibleOhcaEtiology()).replace(",", "，"));
		vo.setArrestWitnessedBy_AL(String.valueOf(fti.getArrestWitnessedBy()== null ? "" :fti.getArrestWitnessedBy()).replace(",", "，"));
		vo.setOhcatLocationType_AM(String.valueOf(fti.getOhcatLocationType()== null ? "" :fti.getOhcatLocationType()).replace(",", "，"));
		vo.setPastMedicalSurgicalHistory_AN(String.valueOf(fti.getPastMedicalSurgicalHistory()== null ? "" :fti.getPastMedicalSurgicalHistory()).replace(",", "，"));
		vo.setResponsivenessLevel_AO(String.valueOf(fti.getResponsivenessLevel()== null ? "" :fti.getResponsivenessLevel()).replace(",", "，"));
		vo.setGcsEye_AP(String.valueOf(fti.getGcsEye()== null ? "" :fti.getGcsEye()).replace(",", "，"));
		vo.setGcsVerbal_AQ(String.valueOf(fti.getGcsVerbal()== null ? "" :fti.getGcsVerbal()).replace(",", "，"));
		vo.setGcsMotor_AR(String.valueOf(fti.getGcsMotor()== null ? "" :fti.getGcsMotor()).replace(",", "，"));
		vo.setRespiratoryRate_AS(String.valueOf(fti.getRespiratoryRate()== null ? "" :fti.getRespiratoryRate()).replace(",", "，"));
		vo.setHeartRate_AT(String.valueOf(fti.getHeartRate()== null ? "" :fti.getHeartRate()).replace(",", "，"));
		vo.setHeartRateMeasureMethod_AU(String.valueOf(fti.getHeartRateMeasureMethod()== null ? "" :fti.getHeartRateMeasureMethod()).replace(",", "，"));
		vo.setSbp_AV(String.valueOf(fti.getSbp()== null ? "" :fti.getSbp()).replace(",", "，"));
		vo.setDbp_AW(String.valueOf(fti.getDbp()== null ? "" :fti.getDbp()).replace(",", "，"));
		vo.setBpMeasureMethod_AX(String.valueOf(fti.getBpMeasureMethod()== null ? "" :fti.getBpMeasureMethod()).replace(",", "，"));
		vo.setPulseOximetry_AY(String.valueOf(fti.getPulseOximetry()== null ? "" :fti.getPulseOximetry()).replace(",", "，"));
		vo.setTemperature_AZ(String.valueOf(fti.getTemperature()== null ? "" :fti.getTemperature()).replace(",", "，"));
		
		vo.setTemperatureMethod_BA(String.valueOf(fti.getTemperatureMethod() == null ? "" :fti.getTemperatureMethod()).replace(",", "，"));
		vo.setBloodGlucoseLevel_BB(String.valueOf(fti.getBloodGlucoseLevel() == null ? "" :fti.getBloodGlucoseLevel()).replace(",", "，"));
		vo.setMedicationGiven_BC(String.valueOf(fti.getMedicationGiven() == null ? "" :fti.getMedicationGiven()).replace(",", "，"));
		vo.setMedicationAdministeredRoute_BD(String.valueOf(fti.getMedicationAdministeredRoute() == null ? "" :fti.getMedicationAdministeredRoute()).replace(",", "，"));
		vo.setProcedure_BE(String.valueOf(fti.getProcedure() == null ? "" :fti.getProcedure()).replace(",", "，"));
		vo.setDestinationLocation_BF(String.valueOf(fti.getDestinationLocation() == null ? "" :fti.getDestinationLocation()).replace(",", "，"));
		vo.setHospitalFacilityId_BG(String.valueOf(fti.getHospitalFacilityId() == null ? "" :fti.getHospitalFacilityId()).replace(",", "，"));
		vo.setDestinationGpsLocation_BH(String.valueOf(fti.getDestinationGpsLocation() == null ? "" :fti.getDestinationGpsLocation()).replace(",", "，"));
		vo.setDestinationCityCounty_BI(String.valueOf(fti.getDestinationCityCounty() == null ? "" :fti.getDestinationCityCounty()).replace(",", "，"));
		vo.setDestinationDistrict_BJ(String.valueOf(fti.getDestinationDistrict() == null ? "" :fti.getDestinationDistrict()).replace(",", "，"));
		vo.setDestinationChoice_BK(String.valueOf(fti.getDestinationChoice() == null ? "" :fti.getDestinationChoice()).replace(",", "，"));
		vo.setWayMovedToAmbulance_BL(String.valueOf(fti.getWayMovedToAmbulance() == null ? "" :fti.getWayMovedToAmbulance()).replace(",", "，"));
		vo.setIsAls_BM(String.valueOf(fti.getIsAls() == null ? "" :fti.getIsAls()).replace(",", "，"));
		vo.setSceneAcuityLevel_BN(String.valueOf(fti.getSceneAcuityLevel() == null ? "" :fti.getSceneAcuityLevel()).replace(",", "，"));
		vo.setErTriageLevel_BO(String.valueOf(fti.getErTriageLevel() == null ? "" :fti.getErTriageLevel()).replace(",", "，"));
		vo.setErDisposition_BP(String.valueOf(fti.getErDisposition() == null ? "" :fti.getErDisposition()).replace(",", "，"));
		vo.setHospitalDisposition_BQ(String.valueOf(fti.getHospitalDisposition() == null ? "" :fti.getHospitalDisposition()).replace(",", "，"));
		vo.setIsDischargedAlive_BR(String.valueOf(fti.getIsDischargedAlive() == null ? "" :fti.getIsDischargedAlive()).replace(",", "，"));
		vo.setDnrInEr_BS(String.valueOf(fti.getDnrInEr() == null ? "" : fti.getDnrInEr()).replace(",", "，"));
		
		return vo;
	
	}
	
	public Document loadXMLFromString(String xml){
		Document document = null;
		try {
		    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		    factory.setFeature("http://xml.org/sax/features/external-general-entities", false);
		    factory.setFeature("http://xml.org/sax/features/external-parameter-entities", false);
		    factory.setFeature("http://javax.xml.XMLConstants/feature/secure-processing", true);
		    factory.setValidating(false);
		    DocumentBuilder builder = factory.newDocumentBuilder();
		    InputSource is = new InputSource(new StringReader(xml));			
			document= builder.parse(is);
		}catch(ParserConfigurationException e1) {
			m_logger.error(e1.toString());
			dataCheckIsOk = false;
		}catch (SAXException | IOException e2) {
			m_logger.error(e2.toString());
			dataCheckIsOk = false;
		}
	    return document;
	}
	
	private synchronized Date renderTime(String dateString) {
		String dateStringTmp = dateString;
        try {
        	dateStringTmp = dateString.replaceAll(":[^:]*$", "00");
			return sdf.parse(dateStringTmp);
		} catch (ParseException e) {
			try {
				return sdf6.parse(dateString);
			} catch (ParseException e2) {
				m_logger.error(e2.toString());
				return null;
			}
		}
    }
	
	private synchronized String renderTime3(Date date) {
        return sdf3.format(date);
    }
}
