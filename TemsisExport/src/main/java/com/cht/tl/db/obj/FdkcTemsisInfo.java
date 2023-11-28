package com.cht.tl.db.obj;

import java.util.Date;

public class FdkcTemsisInfo {
	long sn = 0;
	String recordNumber = null;
	String msgId = null;
	String incidentId = null;
	String area = null;
	String softwareName = null;
	String softwareVersion = null;
	String temsisVersion = null;
	String emsAgentNumber = null;
	String emsVehicleNumber = null;
	String emsUnit = null;
	String vehicleDispatchLocation = null;
	String vehicleDispatchGpsLocation = null;
	String vehicleDispatchCityCounty = null;
	String vehicleDispatchDistrict = null;
	String dispatchType  = null;
	String otherSupportUnit = null;
	String dispatchComplaint = null;
	String dispatcherId = null;
	String dispatchLevel = null;
	String dispatchResponseMode = null;
	String crewId = null;
	String crewLevel = null;
	String crewTeamOrder = null;
	String crewTeamType = null;
	Date psapDatetime = null;
	Date unitNotifiedDatetime = null;
	Date enRouteDatetime = null;
	Date arriveSceneDatetime = null;
	Date arriveAtPatientDatetime = null;
	Date leaveSceneDatetime = null;
	Date arriveHospitalDatetime = null;
	Date leaveHospitalDatetime = null;
	Date backStationDatetime = null;
	String patientName = null;
	String patientId = null;
	String patientGender = null;
	int patientAge = 0;
	String patientAgeUnit = null;
	String patientDateOfBirth = null;
	String patientHomeLocation = null;
	String patientHomeCityCounty = null;
	String patientHomeDistrict = null;
	String supplyItem = null;
	String numberSupplyItem = null;
	String sceneLocation = null;
	String sceneGpsLocation = null;
	String sceneCityCounty = null;
	String sceneDistrict = null;
	String isMci = null;
	String isPossibleTrauma = null;
	String situationPrimaryCategory = null;
	String situationOtherAssociatedCategories = null;
	String primarySymptom = null;
	String otherAssociatedSymptoms = null;
	String chiefComplaint = null;
	Date lastNormalDatetime = null;
	String injuryCause = null;
	String injuryMechanism = null;
	String traumaCenterCriteria = null;
	String useSafetyEquipment = null;
	int heightOfFallMeter = 0;
	String isCardiacArrest = null;
	String possibleOhcaEtiology = null;
	String resuscitationAttemptedByEms = null;
	String arrestWitnessedBy = null;
	String isCprPriorEmsArrival = null;
	String isUsePadPriorEmsArrival = null;
	String isRosc = null;
	String ohcatLocationType = null;
	String whoCprPriorEmsArrival = null;
	String typeCprPriorEmsArrival = null;
	String firstArrestRhythm = null;
	String arrivalArrestRhythm = null;
	int defibrillationCount = 0;
	String isMedicationAllergies = null;
	String medicationAllergies = null;
	String isFoodAllergies = null;
	String foodAllergies = null;
	String isOtherAllergies = null;
	String otherAllergies = null;
	String pastMedicalSurgicalHistory = null;
	Date lastOralIntake = null;
	String narrative = null;
	String vitalSignsTakenDatetime = null;
	String vitalSignsTakenPhase = null;
	String responsivenessLevel = null;
	String gcsEye = null;
	String gcsVerbal = null;
	String gcsMotor = null;
	String respiratoryRate = null;
	String heartRate = null;
	String heartRateMeasureMethod = null;
	String sbp = null;
	String dbp = null;
	String bpMeasureMethod = null;
	String pulseOximetry = null;
	String pupilLightReflexLeft = null;
	String pupilLightReflexRight = null;
	String pupilSizeLeft = null;
	String pupilSizeRight = null;
	String skin = null;
	String temperature = null;
	String temperatureMethod = null;
	String bloodGlucoseLevel = null;
	String neurologicalAssessment = null;
	String medicationGiven = null;
	String medicationAdministeredRoute = null;
	String medicationDosage = null;
	String medicationDosageUnits = null;
	String procedure = null;
	String equipmentSize = null;
	String destinationLocation = null;
	String hospitalFacilityId = null;
	String destinationGpsLocation = null;
	String destinationCityCounty = null;
	String destinationDistrict = null;
	String destinationChoice = null;
	String patientDisposition = null;
	String wayMovedToAmbulance = null;
	String isAls = null;
	String sceneAcuityLevel = null;
	String erTriageLevel = null;
	String erDisposition = null;
	String hospitalDisposition = null;
	String isDischargedAlive = null;
	String cpcLevel = null;
	String dnrInEr = null;
	Date updateTime = null;
	Date createdTime = null;
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
	public String getSoftwareName() {
		return softwareName;
	}
	public void setSoftwareName(String softwareName) {
		this.softwareName = softwareName;
	}
	public String getSoftwareVersion() {
		return softwareVersion;
	}
	public void setSoftwareVersion(String softwareVersion) {
		this.softwareVersion = softwareVersion;
	}
	public String getTemsisVersion() {
		return temsisVersion;
	}
	public void setTemsisVersion(String temsisVersion) {
		this.temsisVersion = temsisVersion;
	}
	public String getEmsAgentNumber() {
		return emsAgentNumber;
	}
	public void setEmsAgentNumber(String emsAgentNumber) {
		this.emsAgentNumber = emsAgentNumber;
	}
	public String getEmsVehicleNumber() {
		return emsVehicleNumber;
	}
	public void setEmsVehicleNumber(String emsVehicleNumber) {
		this.emsVehicleNumber = emsVehicleNumber;
	}
	public String getEmsUnit() {
		return emsUnit;
	}
	public void setEmsUnit(String emsUnit) {
		this.emsUnit = emsUnit;
	}
	public String getVehicleDispatchLocation() {
		return vehicleDispatchLocation;
	}
	public void setVehicleDispatchLocation(String vehicleDispatchLocation) {
		this.vehicleDispatchLocation = vehicleDispatchLocation;
	}
	public String getVehicleDispatchGpsLocation() {
		return vehicleDispatchGpsLocation;
	}
	public void setVehicleDispatchGpsLocation(String vehicleDispatchGpsLocation) {
		this.vehicleDispatchGpsLocation = vehicleDispatchGpsLocation;
	}
	public String getVehicleDispatchCityCounty() {
		return vehicleDispatchCityCounty;
	}
	public void setVehicleDispatchCityCounty(String vehicleDispatchCityCounty) {
		this.vehicleDispatchCityCounty = vehicleDispatchCityCounty;
	}
	public String getVehicleDispatchDistrict() {
		return vehicleDispatchDistrict;
	}
	public void setVehicleDispatchDistrict(String vehicleDispatchDistrict) {
		this.vehicleDispatchDistrict = vehicleDispatchDistrict;
	}
	public String getDispatchType() {
		return dispatchType;
	}
	public void setDispatchType(String dispatchType) {
		this.dispatchType = dispatchType;
	}
	public String getOtherSupportUnit() {
		return otherSupportUnit;
	}
	public void setOtherSupportUnit(String otherSupportUnit) {
		this.otherSupportUnit = otherSupportUnit;
	}
	public String getDispatchComplaint() {
		return dispatchComplaint;
	}
	public void setDispatchComplaint(String dispatchComplaint) {
		this.dispatchComplaint = dispatchComplaint;
	}
	public String getDispatcherId() {
		return dispatcherId;
	}
	public void setDispatcherId(String dispatcherId) {
		this.dispatcherId = dispatcherId;
	}
	public String getDispatchLevel() {
		return dispatchLevel;
	}
	public void setDispatchLevel(String dispatchLevel) {
		this.dispatchLevel = dispatchLevel;
	}
	public String getDispatchResponseMode() {
		return dispatchResponseMode;
	}
	public void setDispatchResponseMode(String dispatchResponseMode) {
		this.dispatchResponseMode = dispatchResponseMode;
	}
	public String getCrewId() {
		return crewId;
	}
	public void setCrewId(String crewId) {
		this.crewId = crewId;
	}
	public String getCrewLevel() {
		return crewLevel;
	}
	public void setCrewLevel(String crewLevel) {
		this.crewLevel = crewLevel;
	}
	public String getCrewTeamOrder() {
		return crewTeamOrder;
	}
	public void setCrewTeamOrder(String crewTeamOrder) {
		this.crewTeamOrder = crewTeamOrder;
	}
	public String getCrewTeamType() {
		return crewTeamType;
	}
	public void setCrewTeamType(String crewTeamType) {
		this.crewTeamType = crewTeamType;
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
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public String getPatientId() {
		return patientId;
	}
	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}
	public String getPatientGender() {
		return patientGender;
	}
	public void setPatientGender(String patientGender) {
		this.patientGender = patientGender;
	}
	public int getPatientAge() {
		return patientAge;
	}
	public void setPatientAge(int patientAge) {
		this.patientAge = patientAge;
	}
	public String getPatientAgeUnit() {
		return patientAgeUnit;
	}
	public void setPatientAgeUnit(String patientAgeUnit) {
		this.patientAgeUnit = patientAgeUnit;
	}
	public String getPatientDateOfBirth() {
		return patientDateOfBirth;
	}
	public void setPatientDateOfBirth(String patientDateOfBirth) {
		this.patientDateOfBirth = patientDateOfBirth;
	}
	public String getPatientHomeLocation() {
		return patientHomeLocation;
	}
	public void setPatientHomeLocation(String patientHomeLocation) {
		this.patientHomeLocation = patientHomeLocation;
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
	public String getSupplyItem() {
		return supplyItem;
	}
	public void setSupplyItem(String supplyItem) {
		this.supplyItem = supplyItem;
	}
	public String getNumberSupplyItem() {
		return numberSupplyItem;
	}
	public void setNumberSupplyItem(String numberSupplyItem) {
		this.numberSupplyItem = numberSupplyItem;
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
	public String getIsMci() {
		return isMci;
	}
	public void setIsMci(String isMci) {
		this.isMci = isMci;
	}
	public String getIsPossibleTrauma() {
		return isPossibleTrauma;
	}
	public void setIsPossibleTrauma(String isPossibleTrauma) {
		this.isPossibleTrauma = isPossibleTrauma;
	}
	public String getSituationPrimaryCategory() {
		return situationPrimaryCategory;
	}
	public void setSituationPrimaryCategory(String situationPrimaryCategory) {
		this.situationPrimaryCategory = situationPrimaryCategory;
	}
	public String getSituationOtherAssociatedCategories() {
		return situationOtherAssociatedCategories;
	}
	public void setSituationOtherAssociatedCategories(String situationOtherAssociatedCategories) {
		this.situationOtherAssociatedCategories = situationOtherAssociatedCategories;
	}
	public String getPrimarySymptom() {
		return primarySymptom;
	}
	public void setPrimarySymptom(String primarySymptom) {
		this.primarySymptom = primarySymptom;
	}
	public String getOtherAssociatedSymptoms() {
		return otherAssociatedSymptoms;
	}
	public void setOtherAssociatedSymptoms(String otherAssociatedSymptoms) {
		this.otherAssociatedSymptoms = otherAssociatedSymptoms;
	}
	public String getChiefComplaint() {
		return chiefComplaint;
	}
	public void setChiefComplaint(String chiefComplaint) {
		this.chiefComplaint = chiefComplaint;
	}
	public Date getLastNormalDatetime() {
		return lastNormalDatetime;
	}
	public void setLastNormalDatetime(Date lastNormalDatetime) {
		this.lastNormalDatetime = lastNormalDatetime;
	}
	public String getInjuryCause() {
		return injuryCause;
	}
	public void setInjuryCause(String injuryCause) {
		this.injuryCause = injuryCause;
	}
	public String getInjuryMechanism() {
		return injuryMechanism;
	}
	public void setInjuryMechanism(String injuryMechanism) {
		this.injuryMechanism = injuryMechanism;
	}
	public String getTraumaCenterCriteria() {
		return traumaCenterCriteria;
	}
	public void setTraumaCenterCriteria(String traumaCenterCriteria) {
		this.traumaCenterCriteria = traumaCenterCriteria;
	}
	public String getUseSafetyEquipment() {
		return useSafetyEquipment;
	}
	public void setUseSafetyEquipment(String useSafetyEquipment) {
		this.useSafetyEquipment = useSafetyEquipment;
	}
	public int getHeightOfFallMeter() {
		return heightOfFallMeter;
	}
	public void setHeightOfFallMeter(int heightOfFallMeter) {
		this.heightOfFallMeter = heightOfFallMeter;
	}
	public String getIsCardiacArrest() {
		return isCardiacArrest;
	}
	public void setIsCardiacArrest(String isCardiacArrest) {
		this.isCardiacArrest = isCardiacArrest;
	}
	public String getPossibleOhcaEtiology() {
		return possibleOhcaEtiology;
	}
	public void setPossibleOhcaEtiology(String possibleOhcaEtiology) {
		this.possibleOhcaEtiology = possibleOhcaEtiology;
	}
	public String getResuscitationAttemptedByEms() {
		return resuscitationAttemptedByEms;
	}
	public void setResuscitationAttemptedByEms(String resuscitationAttemptedByEms) {
		this.resuscitationAttemptedByEms = resuscitationAttemptedByEms;
	}
	public String getArrestWitnessedBy() {
		return arrestWitnessedBy;
	}
	public void setArrestWitnessedBy(String arrestWitnessedBy) {
		this.arrestWitnessedBy = arrestWitnessedBy;
	}
	public String getIsCprPriorEmsArrival() {
		return isCprPriorEmsArrival;
	}
	public void setIsCprPriorEmsArrival(String isCprPriorEmsArrival) {
		this.isCprPriorEmsArrival = isCprPriorEmsArrival;
	}
	public String getIsUsePadPriorEmsArrival() {
		return isUsePadPriorEmsArrival;
	}
	public void setIsUsePadPriorEmsArrival(String isUsePadPriorEmsArrival) {
		this.isUsePadPriorEmsArrival = isUsePadPriorEmsArrival;
	}
	public String getIsRosc() {
		return isRosc;
	}
	public void setIsRosc(String isRosc) {
		this.isRosc = isRosc;
	}
	public String getOhcatLocationType() {
		return ohcatLocationType;
	}
	public void setOhcatLocationType(String ohcatLocationType) {
		this.ohcatLocationType = ohcatLocationType;
	}
	public String getWhoCprPriorEmsArrival() {
		return whoCprPriorEmsArrival;
	}
	public void setWhoCprPriorEmsArrival(String whoCprPriorEmsArrival) {
		this.whoCprPriorEmsArrival = whoCprPriorEmsArrival;
	}
	public String getTypeCprPriorEmsArrival() {
		return typeCprPriorEmsArrival;
	}
	public void setTypeCprPriorEmsArrival(String typeCprPriorEmsArrival) {
		this.typeCprPriorEmsArrival = typeCprPriorEmsArrival;
	}
	public String getFirstArrestRhythm() {
		return firstArrestRhythm;
	}
	public void setFirstArrestRhythm(String firstArrestRhythm) {
		this.firstArrestRhythm = firstArrestRhythm;
	}
	public String getArrivalArrestRhythm() {
		return arrivalArrestRhythm;
	}
	public void setArrivalArrestRhythm(String arrivalArrestRhythm) {
		this.arrivalArrestRhythm = arrivalArrestRhythm;
	}
	public int getDefibrillationCount() {
		return defibrillationCount;
	}
	public void setDefibrillationCount(int defibrillationCount) {
		this.defibrillationCount = defibrillationCount;
	}
	public String getIsMedicationAllergies() {
		return isMedicationAllergies;
	}
	public void setIsMedicationAllergies(String isMedicationAllergies) {
		this.isMedicationAllergies = isMedicationAllergies;
	}
	public String getMedicationAllergies() {
		return medicationAllergies;
	}
	public void setMedicationAllergies(String medicationAllergies) {
		this.medicationAllergies = medicationAllergies;
	}
	public String getIsFoodAllergies() {
		return isFoodAllergies;
	}
	public void setIsFoodAllergies(String isFoodAllergies) {
		this.isFoodAllergies = isFoodAllergies;
	}
	public String getFoodAllergies() {
		return foodAllergies;
	}
	public void setFoodAllergies(String foodAllergies) {
		this.foodAllergies = foodAllergies;
	}
	public String getIsOtherAllergies() {
		return isOtherAllergies;
	}
	public void setIsOtherAllergies(String isOtherAllergies) {
		this.isOtherAllergies = isOtherAllergies;
	}
	public String getOtherAllergies() {
		return otherAllergies;
	}
	public void setOtherAllergies(String otherAllergies) {
		this.otherAllergies = otherAllergies;
	}
	public String getPastMedicalSurgicalHistory() {
		return pastMedicalSurgicalHistory;
	}
	public void setPastMedicalSurgicalHistory(String pastMedicalSurgicalHistory) {
		this.pastMedicalSurgicalHistory = pastMedicalSurgicalHistory;
	}
	public Date getLastOralIntake() {
		return lastOralIntake;
	}
	public void setLastOralIntake(Date lastOralIntake) {
		this.lastOralIntake = lastOralIntake;
	}
	public String getNarrative() {
		return narrative;
	}
	public void setNarrative(String narrative) {
		this.narrative = narrative;
	}
	public String getVitalSignsTakenDatetime() {
		return vitalSignsTakenDatetime;
	}
	public void setVitalSignsTakenDatetime(String vitalSignsTakenDatetime) {
		this.vitalSignsTakenDatetime = vitalSignsTakenDatetime;
	}
	public String getVitalSignsTakenPhase() {
		return vitalSignsTakenPhase;
	}
	public void setVitalSignsTakenPhase(String vitalSignsTakenPhase) {
		this.vitalSignsTakenPhase = vitalSignsTakenPhase;
	}
	public String getResponsivenessLevel() {
		return responsivenessLevel;
	}
	public void setResponsivenessLevel(String responsivenessLevel) {
		this.responsivenessLevel = responsivenessLevel;
	}
	public String getGcsEye() {
		return gcsEye;
	}
	public void setGcsEye(String gcsEye) {
		this.gcsEye = gcsEye;
	}
	public String getGcsVerbal() {
		return gcsVerbal;
	}
	public void setGcsVerbal(String gcsVerbal) {
		this.gcsVerbal = gcsVerbal;
	}
	public String getGcsMotor() {
		return gcsMotor;
	}
	public void setGcsMotor(String gcsMotor) {
		this.gcsMotor = gcsMotor;
	}
	public String getRespiratoryRate() {
		return respiratoryRate;
	}
	public void setRespiratoryRate(String respiratoryRate) {
		this.respiratoryRate = respiratoryRate;
	}
	public String getHeartRate() {
		return heartRate;
	}
	public void setHeartRate(String heartRate) {
		this.heartRate = heartRate;
	}
	public String getHeartRateMeasureMethod() {
		return heartRateMeasureMethod;
	}
	public void setHeartRateMeasureMethod(String heartRateMeasureMethod) {
		this.heartRateMeasureMethod = heartRateMeasureMethod;
	}
	public String getSbp() {
		return sbp;
	}
	public void setSbp(String sbp) {
		this.sbp = sbp;
	}
	public String getDbp() {
		return dbp;
	}
	public void setDbp(String dbp) {
		this.dbp = dbp;
	}
	public String getBpMeasureMethod() {
		return bpMeasureMethod;
	}
	public void setBpMeasureMethod(String bpMeasureMethod) {
		this.bpMeasureMethod = bpMeasureMethod;
	}
	public String getPulseOximetry() {
		return pulseOximetry;
	}
	public void setPulseOximetry(String pulseOximetry) {
		this.pulseOximetry = pulseOximetry;
	}
	public String getPupilLightReflexLeft() {
		return pupilLightReflexLeft;
	}
	public void setPupilLightReflexLeft(String pupilLightReflexLeft) {
		this.pupilLightReflexLeft = pupilLightReflexLeft;
	}
	public String getPupilLightReflexRight() {
		return pupilLightReflexRight;
	}
	public void setPupilLightReflexRight(String pupilLightReflexRight) {
		this.pupilLightReflexRight = pupilLightReflexRight;
	}
	public String getPupilSizeLeft() {
		return pupilSizeLeft;
	}
	public void setPupilSizeLeft(String pupilSizeLeft) {
		this.pupilSizeLeft = pupilSizeLeft;
	}
	public String getPupilSizeRight() {
		return pupilSizeRight;
	}
	public void setPupilSizeRight(String pupilSizeRight) {
		this.pupilSizeRight = pupilSizeRight;
	}
	public String getSkin() {
		return skin;
	}
	public void setSkin(String skin) {
		this.skin = skin;
	}
	public String getTemperature() {
		return temperature;
	}
	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}
	public String getTemperatureMethod() {
		return temperatureMethod;
	}
	public void setTemperatureMethod(String temperatureMethod) {
		this.temperatureMethod = temperatureMethod;
	}
	public String getBloodGlucoseLevel() {
		return bloodGlucoseLevel;
	}
	public void setBloodGlucoseLevel(String bloodGlucoseLevel) {
		this.bloodGlucoseLevel = bloodGlucoseLevel;
	}
	public String getNeurologicalAssessment() {
		return neurologicalAssessment;
	}
	public void setNeurologicalAssessment(String neurologicalAssessment) {
		this.neurologicalAssessment = neurologicalAssessment;
	}
	public String getMedicationGiven() {
		return medicationGiven;
	}
	public void setMedicationGiven(String medicationGiven) {
		this.medicationGiven = medicationGiven;
	}
	public String getMedicationAdministeredRoute() {
		return medicationAdministeredRoute;
	}
	public void setMedicationAdministeredRoute(String medicationAdministeredRoute) {
		this.medicationAdministeredRoute = medicationAdministeredRoute;
	}
	public String getMedicationDosage() {
		return medicationDosage;
	}
	public void setMedicationDosage(String medicationDosage) {
		this.medicationDosage = medicationDosage;
	}
	public String getMedicationDosageUnits() {
		return medicationDosageUnits;
	}
	public void setMedicationDosageUnits(String medicationDosageUnits) {
		this.medicationDosageUnits = medicationDosageUnits;
	}
	public String getProcedure() {
		return procedure;
	}
	public void setProcedure(String procedure) {
		this.procedure = procedure;
	}
	public String getEquipmentSize() {
		return equipmentSize;
	}
	public void setEquipmentSize(String equipmentSize) {
		this.equipmentSize = equipmentSize;
	}
	public String getDestinationLocation() {
		return destinationLocation;
	}
	public void setDestinationLocation(String destinationLocation) {
		this.destinationLocation = destinationLocation;
	}
	public String getHospitalFacilityId() {
		return hospitalFacilityId;
	}
	public void setHospitalFacilityId(String hospitalFacilityId) {
		this.hospitalFacilityId = hospitalFacilityId;
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
	public String getDestinationChoice() {
		return destinationChoice;
	}
	public void setDestinationChoice(String destinationChoice) {
		this.destinationChoice = destinationChoice;
	}
	public String getPatientDisposition() {
		return patientDisposition;
	}
	public void setPatientDisposition(String patientDisposition) {
		this.patientDisposition = patientDisposition;
	}
	public String getWayMovedToAmbulance() {
		return wayMovedToAmbulance;
	}
	public void setWayMovedToAmbulance(String wayMovedToAmbulance) {
		this.wayMovedToAmbulance = wayMovedToAmbulance;
	}
	public String getIsAls() {
		return isAls;
	}
	public void setIsAls(String isAls) {
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
	public String getErDisposition() {
		return erDisposition;
	}
	public void setErDisposition(String erDisposition) {
		this.erDisposition = erDisposition;
	}
	public String getHospitalDisposition() {
		return hospitalDisposition;
	}
	public void setHospitalDisposition(String hospitalDisposition) {
		this.hospitalDisposition = hospitalDisposition;
	}
	public String getIsDischargedAlive() {
		return isDischargedAlive;
	}
	public void setIsDischargedAlive(String isDischargedAlive) {
		this.isDischargedAlive = isDischargedAlive;
	}
	public String getCpcLevel() {
		return cpcLevel;
	}
	public void setCpcLevel(String cpcLevel) {
		this.cpcLevel = cpcLevel;
	}
	public String getDnrInEr() {
		return dnrInEr;
	}
	public void setDnrInEr(String dnrInEr) {
		this.dnrInEr = dnrInEr;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public Date getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}
	
}