package kr.or.ddit.basic.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UdpServer {

	public static void main(String[] args) {
		new UdpServer().serverStart();

	}
	public void serverStart() {
		try {
			//통신할 포트 번호를 지정하여 소켓을 생성한다
			DatagramSocket socket = new DatagramSocket(8888);
			
			//수신용 패킷변수와 송신용 패킷변수 선언
			DatagramPacket inpacket, outpacket;
			System.out.println("서버 실행 중 . . .");
			
			while(true) {
				// 데이터가 저장될 byte형 배열 선언 및 생성
				byte[] bMsg = new byte[512];
				
				// 수신용 패킷객체 생성
				// ==> 수신데이터가 저장될 byte형 배열, 배열의 길이를
				//		지정하여 생성한다.
				inpacket = new DatagramPacket(bMsg, bMsg.length);
				
				// 데이터를 수신한다. ==> receive()메서드 이용
				// 이 메서드는 데이터가 올 때까지 기다린다.
				// 수신된 데이터의 패킷정보는 지정한 패킷변수에 저장된다.
				socket.receive(inpacket);
				
				// 수신 받은 패킷에서 상대방의 주소, 포트번호등을 알 수 있다.
				InetAddress address = inpacket.getAddress();
				int port = inpacket.getPort();
				
				System.out.println("상대방의 IP정보 : " + address);
				System.out.println("상대방의 Port번호 : " + port);
				System.out.println();
				
				// 상대방이 보낸 메시지 출력하기
				// 상대방이 보낸 메시지 내용은
				// '수신용 패킷객체변수.getData()'또는
				// 수신용 패킷 객체를 생성할 때 지정한 byte형 배열에 저장된다.
				
				// '수신용 패킷객체변수.getLength()'
				// ==> 실제 읽어오는 데이터의 길이
				
				String msg = new String(inpacket.getData(), 
						0, inpacket.getLength(), "utf-8");
				
				if("/end".equals(msg)) {
					break; //반복문 탈출
				}
				
				System.out.println("상대방이 보낸 메시지 : " + msg);
				System.out.println();
				//----------------------------------------------
				
				// 상대방에게 메시지 보내기 (수신받은 메시지 그대로 전송)
				
				// 송신할 메시지를 byte배열로 변환한다.
				byte[] sendMsg = msg.getBytes("utf-8");
				
				// 송신용 패킷객체 생성
				// ==> 전송할 데이터가 저장된 byte형배열,
				//		전송할 자료의 길이(배열의 길이),
				//		상대방 주소 정보, 상대방 포트 번호
				//		생성의 인수값으로 지정하여 생성한다.
				outpacket = 
						new DatagramPacket(sendMsg, sendMsg.length,
								address, port);
				
				// 송신하기 ==> send() 메서드 이용
				socket.send(outpacket);
				System.out.println("송신 완료 ! ! !");
				System.out.println();
				
				
			}
		} catch (Exception e) {
			
		}
	}
}
