package com.Physical.common;



import java.io.FileReader;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;




public class DAO {
	//1. Java-> DB 연결할 때 쓰는 객체(Connection)
	protected Connection conn = null;
	//2. Query문(SQL)을 가지고 해당 질의문 실행하는 객체
	protected PreparedStatement pstmt = null;
	//3. Query문(SQL)을 가지고 해당 질의문 실행하는 객체
	protected Statement stmt = null;
	//4. Select(조회) 결과 값을 반환 받는 객체 <- 즉 데이터 넘겨 받을 객체
	protected ResultSet rs = null;
	
	//hr 계정 접속[DB에 연결할 구문]
	Properties pro = new Properties();
	
	String driver = null;
	String url = null;
	String id = null;
	String pw = null;
	
	//DB연결메소드
	public void conn() {
		try {
			getProperties();
			
			Class.forName(driver);
			conn = DriverManager.getConnection(url,id,pw);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//DB 연결 해제
	public void disconn() {
		try {
			if(rs != null) {
				rs.close();
			}
			if(stmt != null) {
				stmt.close();
			}
			if(pstmt != null) {
				pstmt.close();
			}
			if(conn != null) {
				conn.close();
			}	
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	//DB 접속 정보 호출 메소드
	private void getProperties() {
		try {
			FileReader resource = new FileReader("src/config/db.properties");
			pro.load(resource);
			driver = pro.getProperty("driver");
			url = pro.getProperty("url");
			id = pro.getProperty("id");
			pw = pro.getProperty("pw");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
}
