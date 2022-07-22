package kr.or.ddit.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JdbcTest04 {

   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);

      Connection conn = null;
      Statement stmt = null;
      PreparedStatement pstmt = null;

      try {

         // 1.드라이버 생성
         Class.forName("oracle.jdbc.driver.OracleDriver");

         // 2. DB연결
         conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "ddit", "java");

         System.out.println("계좌번호 정보 추가하기");
         System.out.print("계좌번호 : ");
         String bankNo = sc.next();

         System.out.print("은행이름 : ");
         String bankName = sc.next();

         System.out.print("예금주 이름 : ");
         String bankUser = sc.next();

         // Statement 객체를 이용하여 데이터 추가하기
//         String sql = "insert into bankinfo (bank_no,bank_name,bank_user_name,bank_date)" + "values('" + bankNo
//               + "','" + bankName + "','" + bankUser + "',sysdate)";

         stmt = conn.createStatement(); // Statement객체 생성

         // 쿼리문을 실행할때 쿼리문이 SELECT문일 경우에는
         // executeQuery()메서드를 사용하고,
         // 실행할 쿼리문이 SELECT문이 아닐 경우에는
         // (insert update delete문 등...)
         // executeUpdate()메서드를 사용한다.
         // executeUpdate()메서드의 반환값은 작업에 성공한 레코드 수를 반환한다.

//         int cnt = stmt.executeUpdate(sql);
         
         //PreparedStatement객체 이용하여 데이터 추가하기
         
         //쿼리문에서 데이터가 들어갈 자리를 물음표(?)로 표시해서 작성한다. 
         
         String sql = "insert into bankinfo (bank_no,bank_name,bank_user_name,bank_date)" + "values(?,?,?,sysdate)";
         
         //prepareStatement객체 생성 ==> 이때 사용할 쿼리문을 인수값으로 넘겨준다.
         pstmt=conn.prepareStatement(sql);
         
         // 쿼리문의 물음표(?) 자리에 들어갈 데이터를 셋팅한다.
         // 형식) pstmt.set 자료형이름(물음표순번, 셋팅할데이터);
         //     ==> 물음표 번호는 1번부터 시작...
         
         pstmt.setString(1, bankNo);
         pstmt.setString(2, bankName);
         pstmt.setString(3, bankUser);
         
         //데이터 셋팅이 완료되면 쿼리문을 실행하여 결과를 얻어온다.
         int cnt = pstmt.executeUpdate();
         System.out.println("반환값 : " + cnt);
         
         


      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         if (pstmt != null)
            try {
               pstmt.close();
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