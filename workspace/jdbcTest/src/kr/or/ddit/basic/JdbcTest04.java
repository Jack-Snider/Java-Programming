package kr.or.ddit.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JdbcTest04 {
	
	public static void main(String[] args) {
	
		Scanner scan = new Scanner(System.in);
		
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(
					
					"jdbc:oracle:thin:@192.168.143.14.1521:xe",
					"ddit",
					"java"
					
					);
			
			System.out.println("계좌번호 정부 추가하기");
			System.out.println("계좌번호 : ");
			String bankNo = scan.next();
			
			System.out.println("은행이름 : ");
			String bankName = scan.next();
			
			System.out.println("예금주명 : ");
			String bankUser = scan.next();
			
			// Statement객체를 이용하여 데이터 추가하기
			
//			String sql = "INSERT INTO BANKINFO "
//					+ "(BANK_NO, BANK_NAME, BANK_USER_NAME, BANK_DATE) "
//					+ "VALUES ( '" + bankNo + "' , '" + bankName + "' , '" bankUser + "'  ,"
//					+ " SYSDATE)";
//			
//			System.out.println("SQL => " + sql);
//			
//			stmt = conn.createStatement();
//			
//			int cnt = stmt.executeUpdate(sql);
					
			// PreparedStatement 객체 이용하여 데이터 추가하기
			// 쿼리문에서 데이터가 들어갈 자리를 물음표(?)로 표시해서 작성한다.
			String sql = "INSERT INTO BANKINFO "
					+ "(BANK_NO, BANK_NAME, BANK_USER_NAME, BANK_DATE) "
					+ "VALUES (?, ?, ?, SYSDATE)";
			
			// PreparedStatement객체 생성 ==> 이 때 사용할 쿼리문을 인수값으로 넘겨준다.
			pstmt = conn.prepareStatement(sql);
			
			// 쿼리문의 물음표(?)자리에 들어갈 데이터를 세팅한다.
			// 형식) pstmt.set 자료형이름(물음표 순번, 세팅할 데이터);
			//			==> 물음표번호는 1번부터 시작...
			
			pstmt.setString(1, bankNo);
			pstmt.setString(2, bankName);
			pstmt.setString(3, bankUser);
			
			// 데이터 세팅이 완료되면 쿼리문을 실행하여 결과를 얻어온다.
			int cnt = pstmt.executeUpdate();
			
			System.out.println("반환 값 : " + cnt);
			
		} catch (SQLException e) {
			// TODO: handle exception
		} catch (ClassNotFoundException e) {}
		
	}
}



















