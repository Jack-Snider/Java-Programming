package kr.or.ddit.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;
// 사용할 곳에 conn = DBUtil.getConnection(); 입력
public class DBUtil3 {
   // static 초기화 블럭
   static ResourceBundle bundle=null;
   static {
      bundle =ResourceBundle.getBundle("kr.or.ddit.config.dbinfo");
      try {
         //Class.forName("oracle.jdbc.driver.OracleDriver");
         Class.forName(bundle.getString("driver"));
         
      } catch (ClassNotFoundException e) {
         System.out.println("드라이버 로딩 실패~~~");
         e.printStackTrace();
      }
   }

   // DB에 접속하고 접속이 성공하면 Connection객체를 반환하는 메서드
   
   public static Connection getConnection() {
      try {
         //return DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "ddit", "java");
         return DriverManager.getConnection(bundle.getString("url"),bundle.getString("user"),bundle.getString("pass"));
      } catch (SQLException e) {
         System.out.println("DB 연결 실패~~~");
         return null;
      }

   }
}