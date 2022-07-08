package kr.or.ddit.basic.tcp;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

// 서버
public class TcpServer01 {
	
	public static void main(String[] args) throws IOException {
		
		// TCP 소켓 통신을 위해서 ServerSocket 객체를 생성한다
		// 클라이언트는 서버의 ServerSocket과 통신하고
		// 서버가 accept를 하면 Socket 객체를 만들어 클라이언트와 연결해준다.
		
		ServerSocket server = new ServerSocket(7777); // 포트번호 7777
		
		System.out.println("서버가 접속을 기다립니다...");
		
		// accept() 메소드 ==> 
		// ==>	클라이언트의 연결 요청이 올 때까지 계속 기다린다.
		// ==>	연결 요청이 오면 Socket 객체를 생성해서 클라이언트의
		// 		Socket객체와 연결한다.
		Socket socket = server.accept();
		
		// accept() 메소드 명령 이후에는 연결이 완료 되어야 실행된다.
		System.out.println("클라이언트와 연결 되었습니다.");
		System.out.println();
		
		System.out.println("접속한 상대방의 정보");
		System.out.println("IP 주소 : "
					+ socket.getInetAddress().getHostAddress());
		
		System.out.println("PORT 번호 : " + socket.getPort());
		System.out.println();
		
		System.out.println("접속한 현재 컴퓨터의 정보 ");
		System.out.println("IP주소 : " + socket.getLocalAddress());
		System.out.println("PORT 번호 : " + socket.getLocalPort());
		System.out.println();
		
		
		// 클라이언트에게 메세지 보내기
		//  ==> OutputStream은 Socket의 getOutputStream()메서드를 이용해서 구할 수 있다.
	      OutputStream out = socket.getOutputStream();
	      DataOutputStream dout = new DataOutputStream(out);
	      
	      // 클라이언트에게 메시지 보내기 ==> OutputStream을 이용해서
	      //                      출력하는 작업을 말한다.
	      
	      dout.writeUTF("환영합니다. 어서오세요");
	      System.out.println("메시지를 보냈습니다.");
	      
	      // 소켓과 스트림 닫기
	      dout.close();
	      socket.close();
	      server.close();
				
		
	}
	
}













