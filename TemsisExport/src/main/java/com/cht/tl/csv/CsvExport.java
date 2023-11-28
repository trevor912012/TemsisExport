package com.cht.tl.csv;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import com.cht.tl.vo.TemsisVo;

public class CsvExport {
	public static String beanToCSVWithCustomHeaderAndPositionStrategy(List<TemsisVo> temsisVos)
			  throws IOException, CsvRequiredFieldEmptyException, CsvDataTypeMismatchException {
				Calendar calendar = Calendar.getInstance();
				Date currentDate = calendar.getTime();
				String currentDateTime = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
				//String currentDateTime = currentDate.toString();
			
				String filename = "temsis-"+currentDateTime+".csv";
				try (FileWriter writer = new FileWriter(filename)){
			    	CustomColumnPositionStrategy mappingStrategy = new CustomColumnPositionStrategy<TemsisVo>();
			        mappingStrategy.setType(TemsisVo.class);
			        String[] columns = new String[] { "救護紀錄表編號", "區域", "出勤分隊編號(全國)","出勤車輛地點", "出勤車輛GPS" ,
			        		                          "出勤車輛地點-縣市", "出勤車輛地點-鄉鎮市區" , "派遣通報狀況", "派遣層級", "救護人員等級",
			        		                          "報案時間", "派遣時間", "出勤時間", "到達現場時間", "接觸患者時間",
			        		                          "離開現場時間", "送達醫院時間", "離開醫院時間", "傷病患身分證字號", "傷病患性別",
			        		                          "傷病患年齡", "傷病患年齡單位", "傷病患出生年月日", "傷病患住址", "傷病患住址-縣市", 
			        		                          "傷病患住址-鄉鎮市區",
			        		                          "發生地點", "發生地點GPS", "發生地點-縣市", "發生地點-鄉鎮市區", "是否為創傷(創傷/非創傷)",
			        		                          "狀況主要分類", "主要症狀", "創傷外因", "創傷不穩定指標", "是否到院前心肺功能停止",
			        		                          "到院前心肺功能停止可能原因", "到院前心肺功能停止被誰目擊", "OHCA事故地點型態", "過去病史", "意識狀態(AVPU)",
			        		                          "GCS睜眼反應", "GCS言語反應", "GCS動作反應", "呼吸次數(每分鐘)", "脈搏次數(每分鐘)", 
			        		                          "脈搏測量方式", "收縮壓", "舒張壓", "血壓測量方式", "血氧濃度", 
			        		                          "體溫",
			        		                          "體溫測量方式", "血糖(mg/dl)", "藥物處置", "給藥途徑", "處置",
			        		                          "送醫地點", "送醫地點醫事機構代碼", "送醫地點GPS", "送醫地點-縣市", "送醫地點-鄉鎮市區",
			        		                          "送醫地點選擇決策", "搬運方式", "現場是否為危急個案", "現場檢傷分級", "急診檢傷分級",
			        		                          "急診後續處置", "醫院後續處置", "是否存活出院", "到院後DNR"
			        		                          };
			        mappingStrategy.setColumnMapping(columns);
			        StatefulBeanToCsv builder = new StatefulBeanToCsvBuilder<TemsisVo>(writer).withQuotechar(CSVWriter.NO_QUOTE_CHARACTER).withMappingStrategy(mappingStrategy).build();
//			        var builder = new StatefulBeanToCsvBuilder<TemsisVo>(writer)
//			          //.withApplyQuotesToAll(false)	
//			          .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER)
//			          .withMappingStrategy(mappingStrategy)
//			          .build();
			        builder.write(temsisVos);
			        
			    }
				return filename;
			}
}
