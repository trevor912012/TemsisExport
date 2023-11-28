package com.cht.temsis.rest;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cht.tl.csv.CsvExport;
import com.cht.tl.jdbc.dao.TemsisDaoImpl;
import com.cht.tl.model.ParseTemsis;
import com.cht.tl.vo.TemsisVo;

@RestController
@RequestMapping("/temsis")
public class TemsisResource {
	
	@Value("${spring.datasource.url}")
    private  String url;
	@Value("${spring.datasource.username}")
    private  String user;
	@Value("${spring.datasource.password}")
    private  String password;
	
	TemsisDaoImpl temsisDaoImpl;
	
	@GetMapping("/exportCsv")
	public ResponseEntity<?> exportCsv(@RequestParam("area") String area, 
												@RequestParam("startCreatedTime") String startCreatedTime, 
												@RequestParam("endCreatedTime") String endCreatedTime) throws Exception{
		temsisDaoImpl = new TemsisDaoImpl(url, user, password);
		if(StringUtils.isBlank(area)) {
			//throw new Exception("地區欄位不可為空值");
			 return ResponseEntity
		                .status(HttpStatus.BAD_REQUEST)
		                .body("地區欄位不可為空值");
			 
		}
		if(StringUtils.isBlank(startCreatedTime)) {
			//throw new Exception("起始日期不可為空值");
			return ResponseEntity
	                .status(HttpStatus.BAD_REQUEST)
	                .body("起始日期不可為空值");
		}
		if(StringUtils.isBlank(endCreatedTime)) {
			//throw new Exception("終止日期不可為空值");
			return ResponseEntity
	                .status(HttpStatus.BAD_REQUEST)
	                .body("終止日期不可為空值");
		}
		if(!checkDataFormat(startCreatedTime)) {
			//throw new Exception("起始日期格式錯誤，格式dd/mm/yyyy。");
			return ResponseEntity
	                .status(HttpStatus.BAD_REQUEST)
	                .body("起始日期格式錯誤，格式dd/mm/yyyy。");
		}
		if(!checkDataFormat(endCreatedTime)) {
			//throw new Exception("終止日期格式錯誤，格式dd/mm/yyyy。");
			return ResponseEntity
					.status(HttpStatus.BAD_REQUEST)
					.body("終止日期格式錯誤，格式dd/mm/yyyy。");
		}
		ArrayList<String> xmlList = temsisDaoImpl.getXmlsByCreatedTime(area, startCreatedTime, endCreatedTime);
		ParseTemsis pts = new ParseTemsis();
//		System.out.println("Temsis record parse start");
		List<TemsisVo> trList = new ArrayList<TemsisVo>();
		
		for(String xml : xmlList) {
			TemsisVo vo = pts.parseTemsis(xml);
			trList.add(vo);
		}
		
		CsvExport exoprt = new CsvExport();
		String filename = null;
		try {
			filename = exoprt.beanToCSVWithCustomHeaderAndPositionStrategy(trList);
//			System.out.println("filename:" + filename);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		File csvFile = new File(filename);
		InputStreamResource resource = new InputStreamResource(new FileInputStream(csvFile));
		
		HttpHeaders headers = new HttpHeaders();
        headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
        headers.add("Pragma", "no-cache");
        headers.add("Expires", "0");
		
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + filename + "\"")
		        .contentLength(csvFile.length())
		        .contentType(MediaType.APPLICATION_OCTET_STREAM)
		        .body(resource);
		
	}
	
	@GetMapping("/sayHello")
	public String sayHello(){
		return "hello temsis";
	}
	
	private static boolean checkDataFormat(String date){
		String regex = "[0-9]{2}/[0-9]{2}/[0-9]{4}";
        Pattern pattern = Pattern.compile(regex);
        Matcher m = pattern.matcher(date);
        boolean dateFlag = m.matches();
        return dateFlag;
	}
	
}
