package kr.or.ddit.util;

import java.net.ConnectException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// JDBC들아ㅣ버를 로딩하고 Connection객체를 생성하여 반환하는 메소드로 구성된 class이다.
public class DBUtil {
	// static 초기화
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.err.println("드라이버 로딩 실패");
			e.printStackTrace();
		}
	}

	// DB에 접속하고 접속이 성공하면 Connection객체를 반환하는 메소드
	public static Connection getConnection() {
		try {
			return DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521", "ddit", "java");

		} catch (SQLException e) {
			System.err.println("DB연결 실패");
			return null;
		}
	}

}