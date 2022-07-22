package kr.or.ddit.basic;
/*
 문제 ) 사용자로 부터 Lprod_id을 입력 받아서 입력한 값보다
       Lprod_id가 큰 자료들을 출력하시오.
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class JdbcTest02 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");

			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "ddit", "java"); 
			String sql = "select * from lprod";
			stmt = conn.createStatement(); 
			rs = stmt.executeQuery(sql);

			System.out.println("=== 쿼리문 처리 결과 ===");

			while (rs.next()) {
				System.out.println("Lprod_id : " + rs.getInt("lprod_id"));
				System.out.println("LPROD_GU : " + rs.getString(2));
				System.out.println("Lprod_nm : " + rs.getString("LPROD_NM"));
				System.out.println("--------------------------------------------");
			}

			int input = sc.nextInt();
			String sql2 = "select * from lprod where lprod_id > " + input;

			rs = stmt.executeQuery(sql2);
			while (rs.next()) {
				System.out.println("Lprod_id : " + rs.getInt("lprod_id"));
				System.out.println("LPROD_GU : " + rs.getString(2));
				System.out.println("Lprod_nm : " + rs.getString("LPROD_NM"));
				System.out.println("--------------------------------------------");
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
