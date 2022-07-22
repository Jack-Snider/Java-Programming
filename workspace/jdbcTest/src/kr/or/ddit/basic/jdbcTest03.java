package kr.or.ddit.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

// 문제) 사용자로부터 Lprod_id값을 입력받아 입력받은 값보다 lprod_id가 큰 자료들을 출력하시오.
public class JDBCTest03 {
   public static void main(String[] args) {
      
      Connection conn=null;
      Statement stmt = null;
      ResultSet rs= null;
      int min=0;
      int max=0;
      Scanner sc = new Scanner(System.in);
      System.out.print("number1: ");
      int input1=sc.nextInt();
      System.out.print("number2: ");
      int input2=sc.nextInt();
      if(input1>input2) {
         max = input1;
         min = input2;
      }else if (input1<input2) {
         max = input2;
         min = input1;
      }else {
         System.out.println("같은 수는 입력할 수 없습니다.");
         System.out.println("다시 입력하세요.");
         JDBCTest03.main(args);
         
         
      }
      try {
         Class.forName("oracle.jdbc.driver.OracleDriver");
         conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","ddit","java");
         String sql = "select * from lprod where lprod_id > "+min+" and lprod_id < "+max;
         System.out.println(sql);
         stmt=conn.createStatement();
         rs=stmt.executeQuery(sql);
         System.out.println("===결과===");
         while(rs.next()) {
            System.out.println("lprod_id: "+rs.getInt("lprod_id"));
            System.out.println("lprod_gu: "+rs.getString("lprod_gu"));
            System.out.println("lprod_nm: "+rs.getString("lprod_nm"));
            System.out.println("----------");
         }
      }catch (SQLException e) {
         e.printStackTrace();
      }catch (ClassNotFoundException e) {
         e.printStackTrace();
      }finally {
         sc.close();
         if(rs!=null)try {rs.close();}catch(SQLException e) {}
         if(stmt!=null)try {stmt.close();}catch(SQLException e) {}
         if(conn!=null)try {conn.close();}catch(SQLException e) {}
      }
   }
}