package kr.or.ddit.basic.tcp;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.Socket;

public class TcpFileClient {
   private Socket socket;
   private BufferedInputStream bin;
   private BufferedOutputStream bout;
   private DataOutputStream dout;
   
   public static void main(String[] args) {
      new TcpFileClient().clientStart();
   }
   
   public void clientStart() {
      //전송할 파일 정보를 갖는 File객체 생성
      File file = new File("d:/d_other/펭귄.jpg");
      String fileName = file.getName();
      if(!file.exists()) {   //작업할 파일이 없으면 서버랑 연결도 안됨~~
         System.out.println(fileName+"파일이 없습니다");
         System.out.println("작업종료");
         return;
      }
      try {
         socket = new Socket("localhost",7777);
         
         System.out.println("파일 전송 시작..");
         
         dout = new DataOutputStream(socket.getOutputStream());
         
         //서버와 접속이 완료되면 전송할 파일 이름을 제일먼저 전송
         dout.writeUTF(fileName);
         
         //파일 읽기용 스트림 객체 생성
         bin = new BufferedInputStream(new FileInputStream(file));
         
         // 서버로 출력(전송)하기 위한 출력용 스트림 객체 생성
         bout = new BufferedOutputStream(socket.getOutputStream());
         
         byte[] temp = new byte[1024];
         int len =0;
         while ((len=bin.read(temp))>0) {
            bout.write(temp, 0, len);
         }
         
         bout.flush();
         
         System.out.println("파일 전송 완료..");
         
      } catch (Exception e) {
         System.out.println("파일 전송 실패!!");
         e.printStackTrace();
      } finally {
         if(dout!=null) {try {dout.close();} catch (IOException e) {}}
         if(bin!=null) {   try {bin.close();} catch (IOException e) {}}
         if(bout!=null) {try {bout.close();} catch (IOException e) {}}
         if(socket!=null) {   try {socket.close();} catch (IOException e) {}}
      }
   }

}