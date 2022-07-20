package kr.or.ddit.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.ResourceBundle;

//dbinfo.properties파일의 내용을 이용하여 셋팅하는 ㅂ아법
//방법2
public class DBUtil3 {
static ResourceBundle bundle;   //properties객체 생성
   
   
   // static 초기화 블럭
   static {
      bundle = ResourceBundle.getBundle("kr.or.ddit.config.dbinfo");
      
      try {

         Class.forName(bundle.getString("driver"));
         
      } catch (ClassNotFoundException e) {
         System.out.println("드라이버 로딩 실패쓰~");
         e.printStackTrace();
      } 
   }
   public static Connection getConnection() {
      try {
         return DriverManager.getConnection(
               bundle.getString("url"),
               bundle.getString("user"),
               bundle.getString("pass"));
               
      } catch (SQLException e) {
         System.out.println("DB 연결 실패~~");
         return null;
      }
   }
   

}