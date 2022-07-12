package kr.or.ddit.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

// 문제1)	사용자로부터 Lprod_id값을 입력받아서 입력한 값보다
//				Lprod_id가 큰 자료들을 출력하시오.

public class jdbcTest02 {
	
	public static void main(String[] args) {
	
		//DB작업에 필요한 객체 변수 선언
	      Connection conn = null;
	      Statement stmt = null;
	      ResultSet rs = null;
	      Scanner sc = null;
	      
	      try {
	         // 1. 드라이버 로딩
	         Class.forName("oracle.jdbc.driver.OracleDriver");
	         
	         //2.DB연결 --> Connection 객체 생성
	         conn = DriverManager.getConnection(
	               "jdbc:oracle:thin:@localhost:1521:xe", "ddit", "java");
	         
	         //3.쿼리문 작성
	         
	         sc = new Scanner(System.in);
	         System.out.print("아이디 입력 >> ");
	         int id = sc.nextInt();
	          
	   	     //String sql = "select * from lprod";
	         String sql = "SELECT * FROM LPROD WHERE LPROD_ID > " + id;
	         
	         //4-1. 질의 --> Statement 객체 또는 PreparedStatement 객체 생성
	         stmt = conn.createStatement();   // Statement 객체 생성하기
	         
	         //4-2. 쿼리문을 db서버로 보내서 결과를 얻어온다.
	         // (실행할 쿼리문이 select문이기 떄문에 결과가 resultset객체에 저장되어 반환된다.)
	         rs = stmt.executeQuery(sql);
	         
	         //5 . 결과 처리하기
	         // --> select한 결과를 한 레코드씩 화면에 출력하기
	         // (반복문과 next()메소드를 이용해서 처리한다.)
	         System.out.println("---쿼리문 처리 결과 ---");
	         
	         //rs.next() --> ResultSet 객체의 데이터를 가리키는 포인터를 
	         //다음 번째 레코드 위치로 이동시키고 그곳에 데이터가 있으면 true, 없으면 false를 반환한다.
	         while(rs.next()) {
	            //포인터가 가리키는 곳의 자료를 가져오는 방법
	            // 형식 1) rs.get자료형이름("컬럼명" 또는 "alias명");
	            // 형식 2) rs.get자료형이름(컬럼번호); --> 컬럼번호는 1부터 시작
	            System.out.println("Lprod_id : " + rs.getInt("lprod_id"));
	            System.out.println("Lprod_gu : " + rs.getString(2));
	            System.out.println("Lprod_nm : " + rs.getString("LPROD_NM"));
	            System.out.println("----------------------------------------");
	         }
	         
	         
	         
	      } catch (SQLException e) {
	         e.printStackTrace();
	         
	      } catch (ClassNotFoundException e) {
	         e.printStackTrace();
	      } finally {
	         if(rs!=null) try {rs.close();}catch(SQLException e) {}
	         if(stmt!=null) try {stmt.close();}catch(SQLException e) {}
	         if(conn!=null) try {conn.close();}catch(SQLException e) {}
	      }
		
	}
}
