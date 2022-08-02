package kr.or.ddit.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import javax.print.attribute.standard.MediaSize.Engineering;
// 사용할 곳에 conn = DBUtil.getConnection(); 입력
public class DBUtil2 {
   static Properties prop;
   // static 초기화 블럭
   static {
      try {
         prop=new Properties();
         
          File f=new File("res/kr/or/ddit/config/dbinfo.properties");
          FileInputStream fin=null;
          
          try {
         fin=new FileInputStream(f);
         
         prop.load(fin);
         Class.forName(prop.getProperty("driver"));
      } catch (IOException e) {
         System.out.println("입출력오류...");
         System.out.println("드라이버로딩실패~~~");
         e.printStackTrace();
      }
          
         Class.forName("oracle.jdbc.driver.OracleDriver");
      } catch (ClassNotFoundException e) {
         System.out.println("드라이버 로딩 실패~~~");
         e.printStackTrace();
      }
   }

   // DB에 접속하고 접속이 성공하면 Connection객체를 반환하는 메서드
   
   public static Connection getConnection() {
      try {
        // return DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "ddit", "java");
         return DriverManager.getConnection(prop.getProperty("url"),prop.getProperty("user"),prop.getProperty("pass"));
      } catch (SQLException e) {
         System.out.println("DB 연결 실패~~~");
         return null;
      }

   }
}