package com.cht.tl.jdbc.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;

@Repository
public class TemsisDaoImpl extends JdbcDaoSupport{
	
    private  String url;
    private  String user;
    private  String password;
	
	
	private SQLServerDataSource dataSource = new SQLServerDataSource();

	@PostConstruct
	private void initialize() throws SQLException{
//		System.out.println("dataSource:" + dataSource.getConnection().toString());
		setDataSource(dataSource);
	}
	
	public TemsisDaoImpl(String url, String user, String password){
		this.url = url;
		this.user = user;
		this.password = password;
//		try (InputStream input = new FileInputStream(".\\src\\main\\resources\\application.properties")) {
//				// /resources/application.properties
//	            Properties prop = new Properties();
//	            // load a properties file
//	            prop.load(input);
//	            url =  prop.getProperty("spring.datasource.url");
//	            user= prop.getProperty("spring.datasource.username");
//	            password = prop.getProperty("spring.datasource.password");	           
//	      }catch (IOException ex) {
//	            ex.printStackTrace();
//	      }
	}

	public ArrayList<String> getXmlsByCreatedTime(String area, String startCreatedTime, String endCreatedTime) {
		String query = "select a.temsis_content from temsis_record a where a.area=? and a.created_time >= convert(datetime, ?, 101) and a.created_time <= convert(datetime, ? , 101)";
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		ArrayList<String> xmlList = new ArrayList<String>();
		try{
//			dataSource.setURL("jdbc:sqlserver://localhost:1433;DatabaseName=datahubqa;characterEncoding=utf-8");
//			dataSource.setUser("SA");
//			dataSource.setPassword("Trevor242433");
//			System.out.println("url:" + url);
			dataSource.setURL(url);
			dataSource.setUser(user);
			dataSource.setPassword(password);
			con = dataSource.getConnection();
			ps = con.prepareStatement(query);
			ps.setString(1, area);
			ps.setString(2, startCreatedTime + " 00:00:00.000");
			ps.setString(3, endCreatedTime +" 23:59:59.999");
			rs = ps.executeQuery();
			while(rs.next()){
				String temsis_content = rs.getString("temsis_content");
				xmlList.add(temsis_content);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try {
				rs.close();
				ps.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return xmlList;
	}
}
