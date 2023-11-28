package com.cht.tl.db.obj;

import java.util.Date;

public class TemsisRecord {
	long sn = 0;//流水號
	String recordNumber = null;//救護紀錄表編號
	String msgId = null;//訊息編號
	String incidentId = null;//事件識別碼
	String area = null;//區域
	String emsAgentCode = null;//出勤分隊編號(全國)
	String emsVehicleCode = null;//出勤車輛車牌
	String emsUnit = null;//出勤車輛代號
	String crewId = null;//救護人員識別碼
	Date psapDatetime = null;//報案時間
	Date unitNotifiedDatetime = null;//派遣時間
	Date enRouteDatetime = null;//出勤時間
	Date arriveSceneDatetime = null;//到達現場時間
	Date arriveAtPatientDatetime = null;//接觸患者時間
	Date leaveSceneDatetime = null;//離開現場時間
	Date arriveHospitalDatetime = null;//arrive_hospital_datetime
	Date leaveHospitalDatetime = null;//leave_hospital_datetime
	Date backStationDatetime = null;//back_station_datetime
	String patientId = null;//傷病患身分證字號
	String patientHomeCityCounty = null;//傷病患住址-縣市
	String patientHomeDistrict = null;//傷病患住址-鄉鎮市區
	String sceneLocation = null;//發生地點
	String sceneGpsLocation = null;//發生地點GPS 例如：22.593765,120.389781
	String sceneGpsGeom = null;//發生地點GPS
	String sceneCityCounty = null;//發生地點-縣市
	String sceneDistrict = null;//發生地點-鄉鎮市區
	int isMci = 0;//是否大傷事件
	int isTrauma = 0;//是否重大創傷
	String situationCategory = null;//狀況主要分類
	int isOhca = 0;//是否到院前心肺功能停止
	String narrative = null;//補述
	String destinationLocation = null;//送醫地點
	String facilityId = null;//機構代碼	emergency_medical_hospital_info.facility_id
	String destinationGpsLocation = null;//送醫地點GPS
	String destinationCityCounty = null;//送醫地點-縣市
	String destinationDistrict = null;//送醫地點-鄉鎮市區
	String patientDisposition = null;//送醫/未送醫原因
	int isAls = 0;//現場是否為危急個案
	String sceneAcuityLevel = null;//現場檢傷分級
	String erTriageLevel = null;//急診檢傷分級
	String temsisContent = null;//救護紀錄表全文內容
	Date createdTime = null;//建立時間
	Date updateTime = null;//更新時間
	String fileIncidents = null;//檔案類別：災情(01)
	String fileVitalSigns = null;//檔案類別：生命特徵(02)
	String fileTemsis = null;//檔案類別：救護紀錄表(03)
	String receiveMsg = null;//TEMSIS來源資料
	Date recoverTime = null;//回補資料時間
	String natsSyncMsg = null;//NATS同步通知訊息內容
	Date natsSynTime = null;//NATS同步通時間
	Date temsisReceivedDatetime = null;//接獲TEMSIS資料時間
	Date temsisFirstReceivedDatetime = null;//第一次接獲TEMSIS資料時間
	
	public long getSn() {
		return sn;
	}
	public void setSn(long sn) {
		this.sn = sn;
	}
	public String getRecordNumber() {
		return recordNumber;
	}
	public void setRecordNumber(String recordNumber) {
		this.recordNumber = recordNumber;
	}
	public String getMsgId() {
		return msgId;
	}
	public void setMsgId(String msgId) {
		this.msgId = msgId;
	}
	public String getIncidentId() {
		return incidentId;
	}
	public void setIncidentId(String incidentId) {
		this.incidentId = incidentId;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getEmsAgentCode() {
		return emsAgentCode;
	}
	public void setEmsAgentCode(String emsAgentCode) {
		this.emsAgentCode = emsAgentCode;
	}
	public String getEmsVehicleCode() {
		return emsVehicleCode;
	}
	public void setEmsVehicleCode(String emsVehicleCode) {
		this.emsVehicleCode = emsVehicleCode;
	}
	public String getEmsUnit() {
		return emsUnit;
	}
	public void setEmsUnit(String emsUnit) {
		this.emsUnit = emsUnit;
	}
	public String getCrewId() {
		return crewId;
	}
	public void setCrewId(String crewId) {
		this.crewId = crewId;
	}
	public Date getPsapDatetime() {
		return psapDatetime;
	}
	public void setPsapDatetime(Date psapDatetime) {
		this.psapDatetime = psapDatetime;
	}
	public Date getUnitNotifiedDatetime() {
		return unitNotifiedDatetime;
	}
	public void setUnitNotifiedDatetime(Date unitNotifiedDatetime) {
		this.unitNotifiedDatetime = unitNotifiedDatetime;
	}
	public Date getEnRouteDatetime() {
		return enRouteDatetime;
	}
	public void setEnRouteDatetime(Date enRouteDatetime) {
		this.enRouteDatetime = enRouteDatetime;
	}
	public Date getArriveSceneDatetime() {
		return arriveSceneDatetime;
	}
	public void setArriveSceneDatetime(Date arriveSceneDatetime) {
		this.arriveSceneDatetime = arriveSceneDatetime;
	}
	public Date getArriveAtPatientDatetime() {
		return arriveAtPatientDatetime;
	}
	public void setArriveAtPatientDatetime(Date arriveAtPatientDatetime) {
		this.arriveAtPatientDatetime = arriveAtPatientDatetime;
	}
	public Date getLeaveSceneDatetime() {
		return leaveSceneDatetime;
	}
	public void setLeaveSceneDatetime(Date leaveSceneDatetime) {
		this.leaveSceneDatetime = leaveSceneDatetime;
	}
	public Date getArriveHospitalDatetime() {
		return arriveHospitalDatetime;
	}
	public void setArriveHospitalDatetime(Date arriveHospitalDatetime) {
		this.arriveHospitalDatetime = arriveHospitalDatetime;
	}
	public Date getLeaveHospitalDatetime() {
		return leaveHospitalDatetime;
	}
	public void setLeaveHospitalDatetime(Date leaveHospitalDatetime) {
		this.leaveHospitalDatetime = leaveHospitalDatetime;
	}
	public Date getBackStationDatetime() {
		return backStationDatetime;
	}
	public void setBackStationDatetime(Date backStationDatetime) {
		this.backStationDatetime = backStationDatetime;
	}
	public String getPatientId() {
		return patientId;
	}
	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}
	public String getPatientHomeCityCounty() {
		return patientHomeCityCounty;
	}
	public void setPatientHomeCityCounty(String patientHomeCityCounty) {
		this.patientHomeCityCounty = patientHomeCityCounty;
	}
	public String getPatientHomeDistrict() {
		return patientHomeDistrict;
	}
	public void setPatientHomeDistrict(String patientHomeDistrict) {
		this.patientHomeDistrict = patientHomeDistrict;
	}
	public String getSceneLocation() {
		return sceneLocation;
	}
	public void setSceneLocation(String sceneLocation) {
		this.sceneLocation = sceneLocation;
	}
	public String getSceneGpsLocation() {
		return sceneGpsLocation;
	}
	public void setSceneGpsLocation(String sceneGpsLocation) {
		this.sceneGpsLocation = sceneGpsLocation;
	}
	public String getSceneGpsGeom() {
		return sceneGpsGeom;
	}
	public void setSceneGpsGeom(String sceneGpsGeom) {
		this.sceneGpsGeom = sceneGpsGeom;
	}
	public String getSceneCityCounty() {
		return sceneCityCounty;
	}
	public void setSceneCityCounty(String sceneCityCounty) {
		this.sceneCityCounty = sceneCityCounty;
	}
	public String getSceneDistrict() {
		return sceneDistrict;
	}
	public void setSceneDistrict(String sceneDistrict) {
		this.sceneDistrict = sceneDistrict;
	}
	public int getIsMci() {
		return isMci;
	}
	public void setIsMci(int isMci) {
		this.isMci = isMci;
	}
	public int getIsTrauma() {
		return isTrauma;
	}
	public void setIsTrauma(int isTrauma) {
		this.isTrauma = isTrauma;
	}
	public String getSituationCategory() {
		return situationCategory;
	}
	public void setSituationCategory(String situationCategory) {
		this.situationCategory = situationCategory;
	}
	public int getIsOhca() {
		return isOhca;
	}
	public void setIsOhca(int isOhca) {
		this.isOhca = isOhca;
	}
	public String getNarrative() {
		return narrative;
	}
	public void setNarrative(String narrative) {
		this.narrative = narrative;
	}
	public String getDestinationLocation() {
		return destinationLocation;
	}
	public void setDestinationLocation(String destinationLocation) {
		this.destinationLocation = destinationLocation;
	}
	public String getFacilityId() {
		return facilityId;
	}
	public void setFacilityId(String facilityId) {
		this.facilityId = facilityId;
	}
	public String getDestinationGpsLocation() {
		return destinationGpsLocation;
	}
	public void setDestinationGpsLocation(String destinationGpsLocation) {
		this.destinationGpsLocation = destinationGpsLocation;
	}
	public String getDestinationCityCounty() {
		return destinationCityCounty;
	}
	public void setDestinationCityCounty(String destinationCityCounty) {
		this.destinationCityCounty = destinationCityCounty;
	}
	public String getDestinationDistrict() {
		return destinationDistrict;
	}
	public void setDestinationDistrict(String destinationDistrict) {
		this.destinationDistrict = destinationDistrict;
	}
	public String getPatientDisposition() {
		return patientDisposition;
	}
	public void setPatientDisposition(String patientDisposition) {
		this.patientDisposition = patientDisposition;
	}
	public int getIsAls() {
		return isAls;
	}
	public void setIsAls(int isAls) {
		this.isAls = isAls;
	}
	public String getSceneAcuityLevel() {
		return sceneAcuityLevel;
	}
	public void setSceneAcuityLevel(String sceneAcuityLevel) {
		this.sceneAcuityLevel = sceneAcuityLevel;
	}
	public String getErTriageLevel() {
		return erTriageLevel;
	}
	public void setErTriageLevel(String erTriageLevel) {
		this.erTriageLevel = erTriageLevel;
	}
	public String getTemsisContent() {
		return temsisContent;
	}
	public void setTemsisContent(String temsisContent) {
		this.temsisContent = temsisContent;
	}
	public Date getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public String getFileIncidents() {
		return fileIncidents;
	}
	public void setFileIncidents(String fileIncidents) {
		this.fileIncidents = fileIncidents;
	}
	public String getFileVitalSigns() {
		return fileVitalSigns;
	}
	public void setFileVitalSigns(String fileVitalSigns) {
		this.fileVitalSigns = fileVitalSigns;
	}
	public String getFileTemsis() {
		return fileTemsis;
	}
	public void setFileTemsis(String fileTemsis) {
		this.fileTemsis = fileTemsis;
	}
	public String getReceiveMsg() {
		return receiveMsg;
	}
	public void setReceiveMsg(String receiveMsg) {
		this.receiveMsg = receiveMsg;
	}
	public Date getRecoverTime() {
		return recoverTime;
	}
	public void setRecoverTime(Date recoverTime) {
		this.recoverTime = recoverTime;
	}
	public String getNatsSyncMsg() {
		return natsSyncMsg;
	}
	public void setNatsSyncMsg(String natsSyncMsg) {
		this.natsSyncMsg = natsSyncMsg;
	}
	public Date getNatsSynTime() {
		return natsSynTime;
	}
	public void setNatsSynTime(Date natsSynTime) {
		this.natsSynTime = natsSynTime;
	}
	public Date getTemsisReceivedDatetime() {
		return temsisReceivedDatetime;
	}
	public void setTemsisReceivedDatetime(Date temsisReceivedDatetime) {
		this.temsisReceivedDatetime = temsisReceivedDatetime;
	}
	public Date getTemsisFirstReceivedDatetime() {
		return temsisFirstReceivedDatetime;
	}
	public void setTemsisFirstReceivedDatetime(Date temsisFirstReceivedDatetime) {
		this.temsisFirstReceivedDatetime = temsisFirstReceivedDatetime;
	}
	
}
