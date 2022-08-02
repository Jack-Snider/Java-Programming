package kr.or.ddit.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;

// 사용할 곳에 conn = DBUtil.getConnection(); 입력
public class DBUtil3 {

	// 로거 객체 생성(로그를 남기기 위해 2022.07.28 수업시작)
	static Logger logger = Logger.getLogger(DBUtil3.class);

	// static 초기화 블럭
	static ResourceBundle bundle = null;
	static {

		bundle = ResourceBundle.getBundle("kr.or.ddit.config.dbinfo");
		logger.info("ResourceBundle객체 생성 - dbinfo.properties파일 읽기");
		
		try {
			// Class.forName("oracle.jdbc.driver.OracleDriver");
			Class.forName(bundle.getString("driver"));
			logger.info("DB 드라이버 로딩 성공~~");
			
		} catch (ClassNotFoundException e) {
			//System.out.println("드라이버 로딩 실패~~~");
			//e.printStackTrace();
			logger.error("드라이버 로딩 실패!! - " + e);
			e.printStackTrace();
		}
	}

	// DB에 접속하고 접속이 성공하면 Connection객체를 반환하는 메서드

	public static Connection getConnection() {
		
		Connection conn = null;
		
		try {
			// return DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",
			// "ddit", "java");
			conn =	DriverManager.getConnection(bundle.getString("url"), bundle.getString("user"),
					bundle.getString("pass"));
			
			
			logger.info("DB 연결 성공~~");
			
		} catch (SQLException e) {
			//System.out.println("DB 연결 실패~~~");
			logger.error("DB연결 실패~~", e);
			
		}

		return conn;
		
	}
}