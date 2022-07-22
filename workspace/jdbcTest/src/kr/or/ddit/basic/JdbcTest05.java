package kr.or.ddit.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

/*
   LPROD 테이블에 새로운 데이터 추가하기

   상품분류코드(LPROD_GU), 상품분류명(LPROD_NM)은 직접 입력받아서 처리하고,
   LPROD_ID는 현재의 LPROD_ID 중 제일 큰 값보다 1크게 한다.
   그리고 입력받은 상품분류코드(LPROD_GU)가 이미 등록되어 있으면 다시 입력받아서 처리한다.
 */

public class JdbcTest05 {
   public static void main(String[] args) {
      Scanner scan = new Scanner(System.in);

      Connection conn = null;
      PreparedStatement pstmt = null;
      ResultSet rs = null;

      try {
         Class.forName("oracle.jdbc.driver.OracleDriver");

         conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe" , "ddit" , "java");

         String sql = "select nvl(max(lprod_id),0) max from lprod";
         pstmt = conn.prepareStatement(sql);
         rs = pstmt.executeQuery();

         int max = 0;
         
         if(rs.next()) { 
            max = rs.getInt("max");
         }
         max++;

         String gu; 
         int count = 0;
         String sql2 = "select count(*) cnt from lprod where lprod_gu=?";
         pstmt = conn.prepareStatement(sql2);
         do {
            System.out.print("상품 분류 코드 입력 : ");
            gu = scan.next();
            pstmt.setString(1, gu); 
            rs = pstmt.executeQuery();
            if(rs.next()) {
               count = rs.getInt("cnt");
            }
            if(count>0) {
               System.out.println("다시 입력하세요.");
            }
         }while(count>0);

         //-----------------------------------------------------------------------------------------------
         System.out.print("상품 분류명 입력 : ");
         String nm = scan.next();

         String sql3 = "insert into lprod (lprod_id, lprod_gu, lprod_nm) values(?,?,?)";
         pstmt = conn.prepareStatement(sql3);
         pstmt.setInt(1, max);
         pstmt.setString(2, gu);
         pstmt.setString(3, nm);

         int result=pstmt.executeUpdate();

         if(result==1) {
            System.out.println("등록성공");
         }else {
            System.out.println("등록실패");
         }
        
      } catch (SQLException e) {
         e.printStackTrace();
      } catch (ClassNotFoundException e) {
         e.printStackTrace();
      }finally {
         if(rs!=null) try {rs.close();}catch(SQLException e) {}
         if(pstmt!=null) try {pstmt.close();}catch(SQLException e) {}
         if(conn!=null) try {conn.close();}catch(SQLException e) {}
      }


   }
}