package kr.or.ddit.basic.tcp;

import java.net.Socket;

public class TcpClient02 {
	
	public static void main(String[] args) {
			
		try {
			// 소켓 객체를 생성해서 서버에 접속 요청을 하고 서버와 접속이 완료되면
			// 메세지를 받는 스레드와 메세지를 보내는 스레드에
			// 이 소켓을 넘겨준다.
			Socket socket = new Socket("192.168.143.7",7777);
	
			Sender sender = new Sender(socket);
			Receiver receiver = new Receiver(socket);
			
			sender.start();
			receiver.start();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
	}
}
