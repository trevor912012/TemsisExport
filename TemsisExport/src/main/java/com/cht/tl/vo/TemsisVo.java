package com.cht.tl.vo;

import java.util.Date;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvBindByPosition;

import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter
public class TemsisVo{
    @CsvBindByPosition(position = 0)
    @CsvBindByName(column = "救護紀錄表編號")
    private String recordNumber_A;
	
    @CsvBindByPosition(position = 1)
    @CsvBindByName(column = "區域")
    private String area_B;
	
    @CsvBindByPosition(position = 2)
    @CsvBindByName(column = "出勤分隊編號(全國)")
    private String emsAgentCode_C;
    
    @CsvBindByPosition(position = 3)
    @CsvBindByName(column = "出勤車輛地點")
    private String vehicleDispatchLocation_D;
    
    @CsvBindByPosition(position = 4)
    @CsvBindByName(column = "出勤車輛GPS")
    private String vehicleDispatchGPSLocation_E;
    
    @CsvBindByPosition(position = 5)
    @CsvBindByName(column = "出勤車輛地點-縣市")
    private String vehicleDispatchCityCounty_F ;
    
    @CsvBindByPosition(position = 6)
    @CsvBindByName(column = "出勤車輛地點-鄉鎮市區")
    private String vehicleDispatchDistrict_G;
    
    @CsvBindByPosition(position = 7)
    @CsvBindByName(column = "派遣通報狀況")
    private String dispatchComplaint_H;
    
    @CsvBindByPosition(position = 8)
    @CsvBindByName(column = "派遣層級")
    private String dispatchLevel_I;
    
    @CsvBindByPosition(position = 9)
    @CsvBindByName(column = "救護人員等級")
    private String crewLevel_J;
    
    @CsvBindByPosition(position = 10)
    @CsvBindByName(column = "報案時間")
    private Date psapDatetime_K;
    
    @CsvBindByPosition(position = 11)
    @CsvBindByName(column = "派遣時間")
    private Date unitNotifiedDateTime_L;
    
    @CsvBindByPosition(position = 12)
    @CsvBindByName(column = "出勤時間")
    private Date enRouteDateTime_M;
    
    @CsvBindByPosition(position = 13)
    @CsvBindByName(column = "到達現場時間")
    private Date arriveSceneDateTime_N;
    
    @CsvBindByPosition(position = 14)
    @CsvBindByName(column = "接觸患者時間")
    private Date arriveAtPatientDatetime_O;
    
    @CsvBindByPosition(position = 15)
    @CsvBindByName(column = "離開現場時間")
    private Date leaveSceneDatetime_P;
    
    @CsvBindByPosition(position = 16)
    @CsvBindByName(column = "送達醫院時間")
    private Date arriveHospitalDateTime_Q;
    
    @CsvBindByPosition(position = 17)
    @CsvBindByName(column = "離開醫院時間")
    private Date leaveHospitalDateTime_R;
    
    @CsvBindByPosition(position = 18)
    @CsvBindByName(column = "傷病患身分證字號")
    private String patientID_S;
    
    @CsvBindByPosition(position = 19)
    @CsvBindByName(column = "傷病患性別")
    private String patientGender_T;
    
    @CsvBindByPosition(position = 20)
    @CsvBindByName(column = "傷病患年齡")
    private int patientAge_U;
    
    @CsvBindByPosition(position = 21)
    @CsvBindByName(column = "傷病患年齡單位")
    private String patientAgeUnit_V;
    
    @CsvBindByPosition(position = 22)
    @CsvBindByName(column = "傷病患出生年月日")
    private String patientDateOfBirth_W;
    
    @CsvBindByPosition(position = 23)
    @CsvBindByName(column = "傷病患住址")
    private String patientHomeLocation_X;
    
    @CsvBindByPosition(position = 24)
    @CsvBindByName(column = "傷病患住址-縣市")
    private String patientHomeCityCounty_Y;
    
    @CsvBindByPosition(position = 25)
    @CsvBindByName(column = "傷病患住址-鄉鎮市區")
    private String patientHomeDistrict_Z;
    
    @CsvBindByPosition(position = 26)
    @CsvBindByName(column = "發生地點")
    private String sceneLocation_AA;
    
    @CsvBindByPosition(position = 27)
    @CsvBindByName(column = "發生地點GPS")
    private String sceneGpsLocation_AB;
    
    @CsvBindByPosition(position = 28)
    @CsvBindByName(column = "發生地點-縣市")
    private String sceneCityCounty_AC;
    
    @CsvBindByPosition(position = 29)
    @CsvBindByName(column = "發生地點-鄉鎮市區")
    private String sceneDistrict_AD;
    
    @CsvBindByPosition(position = 30)
    @CsvBindByName(column = "是否為創傷(創傷/非創傷)")
    private String isPossibleTrauma_AE;
    
    @CsvBindByPosition(position = 31)
    @CsvBindByName(column = "狀況主要分類")
    private String situationPrimaryCategory_AF;
    
    @CsvBindByPosition(position = 32)
    @CsvBindByName(column = "主要症狀")
    private String primarySymptom_AG;
    
    @CsvBindByPosition(position = 33)
    @CsvBindByName(column = "創傷外因")
    private String injuryCause_AH;
    
    @CsvBindByPosition(position = 34)
    @CsvBindByName(column = "創傷不穩定指標")
    private String traumaCenterCriteria_AI;
    
    @CsvBindByPosition(position = 35)
    @CsvBindByName(column = "是否到院前心肺功能停止")
    private String isCardiacArrest_AJ;
    
    @CsvBindByPosition(position = 36)
    @CsvBindByName(column = "到院前心肺功能停止可能原因")
    private String possibleOhcaEtiology_AK;
    
    @CsvBindByPosition(position = 37)
    @CsvBindByName(column = "到院前心肺功能停止被誰目擊")
    private String arrestWitnessedBy_AL;
    
    @CsvBindByPosition(position = 38)
    @CsvBindByName(column = "OHCA事故地點型態")
    private String ohcatLocationType_AM;
    
    @CsvBindByPosition(position = 39)
    @CsvBindByName(column = "過去病史")
    private String pastMedicalSurgicalHistory_AN;
    
    @CsvBindByPosition(position = 40)
    @CsvBindByName(column = "意識狀態(AVPU)")
    private String responsivenessLevel_AO;
    
    @CsvBindByPosition(position = 41)
    @CsvBindByName(column = "GCS睜眼反應")
    private String gcsEye_AP;
    
    @CsvBindByPosition(position = 42)
    @CsvBindByName(column = "GCS言語反應")
    private String gcsVerbal_AQ;
    
    @CsvBindByPosition(position = 43)
    @CsvBindByName(column = "GCS動作反應")
    private String gcsMotor_AR;
    
    @CsvBindByPosition(position = 44)
    @CsvBindByName(column = "呼吸次數(每分鐘)")
    private String respiratoryRate_AS;
    
    @CsvBindByPosition(position = 45)
    @CsvBindByName(column = "脈搏次數(每分鐘)")
    private String heartRate_AT;
    
    @CsvBindByPosition(position = 46)
    @CsvBindByName(column = "脈搏測量方式")
    private String heartRateMeasureMethod_AU;
    
    @CsvBindByPosition(position = 47)
    @CsvBindByName(column = "收縮壓")
    private String sbp_AV;
    
    @CsvBindByPosition(position = 48)
    @CsvBindByName(column = "舒張壓")
    private String dbp_AW;
    
    @CsvBindByPosition(position = 49)
    @CsvBindByName(column = "血壓測量方式")
    private String bpMeasureMethod_AX;
    
    @CsvBindByPosition(position = 50)
    @CsvBindByName(column = "血氧濃度")
    private String pulseOximetry_AY;
    
    @CsvBindByPosition(position = 51)
    @CsvBindByName(column = "體溫")
    private String temperature_AZ;
    
    @CsvBindByPosition(position = 52)
    @CsvBindByName(column = "體溫測量方式")
    private String temperatureMethod_BA;
    
    @CsvBindByPosition(position = 53)
    @CsvBindByName(column = "血糖(mg/dl)")
    private String bloodGlucoseLevel_BB;
    
    @CsvBindByPosition(position = 54)
    @CsvBindByName(column = "藥物處置")
    private String medicationGiven_BC;
    
    @CsvBindByPosition(position = 55)
    @CsvBindByName(column = "給藥途徑")
    private String medicationAdministeredRoute_BD;
    
    @CsvBindByPosition(position = 56)
    @CsvBindByName(column = "處置")
    private String procedure_BE;
    
    @CsvBindByPosition(position = 57)
    @CsvBindByName(column = "送醫地點")
    private String destinationLocation_BF;
    
    @CsvBindByPosition(position = 58)
    @CsvBindByName(column = "送醫地點醫事機構代碼")
    private String hospitalFacilityId_BG;
    
    @CsvBindByPosition(position = 59)
    @CsvBindByName(column = "送醫地點GPS")
    private String destinationGpsLocation_BH;
    
    @CsvBindByPosition(position = 60)
    @CsvBindByName(column = "送醫地點-縣市")
    private String destinationCityCounty_BI;
    
    @CsvBindByPosition(position = 61)
    @CsvBindByName(column = "送醫地點-鄉鎮市區")
    private String destinationDistrict_BJ;
    
    @CsvBindByPosition(position = 62)
    @CsvBindByName(column = "送醫地點選擇決策")
    private String destinationChoice_BK;
    
    @CsvBindByPosition(position = 63)
    @CsvBindByName(column = "搬運方式")
    private String wayMovedToAmbulance_BL;
    
    @CsvBindByPosition(position = 64)
    @CsvBindByName(column = "現場是否為危急個案")
    private String isAls_BM;
    
    @CsvBindByPosition(position = 65)
    @CsvBindByName(column = "現場檢傷分級")
    private String sceneAcuityLevel_BN;
    
    @CsvBindByPosition(position = 66)
    @CsvBindByName(column = "急診檢傷分級")
    private String erTriageLevel_BO;
    
    @CsvBindByPosition(position = 67)
    @CsvBindByName(column = "急診後續處置")
    private String erDisposition_BP;
    
    @CsvBindByPosition(position = 68)
    @CsvBindByName(column = "醫院後續處置")
    private String hospitalDisposition_BQ;
    
    @CsvBindByPosition(position = 69)
    @CsvBindByName(column = "是否存活出院")
    private String isDischargedAlive_BR;
    
    @CsvBindByPosition(position = 70)
    @CsvBindByName(column = "到院後DNR")
    private String dnrInEr_BS;
    
   
	
}
