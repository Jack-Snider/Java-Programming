package kr.or.ddit.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class jdbcTest03 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		System.out.print("첫 번째 Lprod_id 값  입력 : ");
		int num1 = scan.nextInt();

		System.out.print("두 번째 Lprod_id값 입력 : ");
		int num2 = scan.nextInt();

		// 큰 값과 작은 값 찾기
		int max, min;
		max = num1 > num2 ? num1 : num2;
		min = num1 > num2 ? num2 : num1;

		// DB관련 객체 변수 선언
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");

			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@192.168.143.14",
					"ddit",
					"java"
					);

			//String sql = "SELECT * FROM LPROD " + "WHERE lprod_id >= " + min + " AND lprod_id <= " + max;
			String sql = "SELECT * FROM LPROD " + "WHERE lprod_id >= ? AND lprod_id <= ?";
			
			//stmt = conn.createStatement();

			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, min);
			pstmt.setInt(2, max);
			
			rs = pstmt.executeQuery();
			
			//rs = stmt.executeQuery(sql);

			System.out.println();
			System.out.println(" == 결과 출력 == ");
			while (rs.next()) {
				System.out.println("ID : " + rs.getInt("LPROD_ID"));
				System.out.println("GU : " + rs.getString("LPROD_GU"));
				System.out.println("NM : " + rs.getString("LPROD_NM"));
				System.out.println("------------------------------");
			}

		} catch (SQLException e) {
			// TODO: handle exception
		} catch (ClassNotFoundException e) {

		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException e) {
				}
			if (stmt != null)
				try {
					stmt.close();
				} catch (SQLException e) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException e) {
				}
		}

	}
}
