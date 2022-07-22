package kr.or.ddit.basic.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

/*
 * UDP방식 : 비연결지향, 신뢰성이 없다. 데이터가 순서대로 도착한다는 보장이 없다.
 * 			그렇지만 TCP방식보다 상대적으로 빠르다.
 * 
 * - DatagramSocket객체와 DatagramPacket객체를 이용하여 통신한다.
 * - DatagramSocket : 데이터의 송수신과 관련된 작업을 수행한다. (우체부)
 * - DatagramPacket : 주고 받는 데이터와 관련된 작업을 수행한다. (소포)
 * 		==> 수신을 위한 생성자와 송신을 위한 생성자를 따로 제공한다.
 * 
 * - TCP의 경우에는 스트림을 이용하여 송수신하지만
 * 	 UDP의 경우에는 Datagram을 이용해서 송수신한다.
 * 
 */

public class UdpClient {

	public static void main(String[] args) {
		new UdpClient().clientStart();

	}

	public void clientStart() {
		Scanner sc = new Scanner(System.in);

		// 송신용, 수신용 패킷 객체변수 선언
		DatagramPacket inpacket, outpacket;

		// 수신 받은 데이터가 저장될 byte형 배열 선언
		byte[] bMsg = new byte[512];

		try {
			DatagramSocket socket = new DatagramSocket();

			// 접속할 곳의 주소 정보 객체 생성
			InetAddress address = InetAddress.getByName("localhost");

			while (true) {
				// 전송할 메시지 입력
				System.out.println("보낼 메시지 입력 : ");
				String msg = sc.nextLine();

				// 전송용 패킷객체 생성
				outpacket = new DatagramPacket(msg.getBytes("utf-8"), msg.getBytes("utf-8").length, address, 8888);
				// 전송
				socket.send(outpacket);

				if ("/end".equals(msg)) {
					break;
				}
				// ------------------------------------

				// 서버에서 보내온 메시지를 받아서 화면에 출력하기
				
				// 수신용 패킷객체 생성
				inpacket = new DatagramPacket(bMsg, bMsg.length);
				
				//수신
				socket.receive(inpacket);
				
				System.out.println("서버의 응답 메시지 : " +
				new String(inpacket.getData(),
						0,inpacket.getLength(),"utf-8"));
				System.out.println();
			}
			
			System.out.println("통신 끝 . . .");
			socket.close();

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
