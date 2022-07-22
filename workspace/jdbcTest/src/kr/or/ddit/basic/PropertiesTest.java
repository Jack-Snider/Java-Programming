package kr.or.ddit.basic;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

//dbinfor.properties에 있는 내용을 불러오자

public class PropertiesTest {

   public static void main(String[] args) {
      //properties 파일의 내용을 읽어와 화면에 출력하기
      
      //읽어온 정보를 저장할 Properties 객체 생성
      Properties prop = new Properties();
      
      //읽어올 파일명을 이용한 File 객체 생성
      File f = new File("res/kr/or/ddit/config/dbinfor.properties");      //dbinfor.properties의 경로 입력, 상대경로, 절대경로      앞에 슬래쉬? 쩜? 안들어가면 절대경로 아님
      
      if(!f.exists()) {      //파일이 없으면....
         System.out.println("dbinfo.properties 파일이 없습니다.");
         System.out.println("작업 종료...");
         return;
      }
      
      FileInputStream fin = null;      //파일 입력용 스트림 객체 변수 선언
      
      try {
         //파일 내용을 읽어올 스트림객체 생성
         fin = new FileInputStream(f);
         
         //위에서 생성한 입력용 스트림을 이용하여 파일 내용을 읽어와 Properties객체에 저장하기
         
         //파일 내용을 읽어와 key 값과 value 값을 분류한 후 Properties 객체에 추가한다. 
         prop.load(fin);
         
         // 읽어온 정보 출력하기
         System.out.println("driver : "+ prop.getProperty("driver"));
         System.out.println("url : "+ prop.getProperty("url"));
         System.out.println("user : "+ prop.getProperty("user"));
         System.out.println("pass : "+ prop.getProperty("pass"));
         
      } catch (IOException e) {
         System.out.println("입출력 오류....");
         e.printStackTrace();
      } finally {
         if(fin!=null) try {fin.close(); }catch (IOException e) {};
      }
      
      
   }
}