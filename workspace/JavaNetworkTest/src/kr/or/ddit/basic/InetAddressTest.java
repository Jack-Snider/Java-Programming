package kr.or.ddit.basic;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressTest {

	public static void main(String[] args) throws UnknownHostException {
		
		// InetAddress 클래스 ==> IP주소를 다루기 위한 클래스
		
		// 객체 생성
		// 형식) InetAddress.getByName("도메인명 또는 IP주소");
		

		// www.naver.com의 IP정보를 가져오기
		InetAddress naverIP = InetAddress.getByName("www.naver.com");

		System.out.println("HostName : " + naverIP.getHostName());
		System.out.println("HostAddress : " + naverIP.getHostAddress());
		System.out.println("toString : " + naverIP.toString());
		
		
		// 자신의 컴퓨터의 IP정보 가져오기
		InetAddress localIP = InetAddress.getLocalHost(); // 현재 컴퓨터의 ip정보 가져오는 메소드
		System.out.println("내 컴퓨터의 HostName : " + localIP.getHostName());
		System.out.println("내 컴퓨터의 HostAddress : " + localIP.getHostAddress());
		System.out.println("내 컴퓨터의 toString : " + localIP.toString());
		
		System.out.println();
		
		// IP주소가 여러개인 호스트의 IP정보 가져오기
		// getAllByName(도메인 주소) ==> 여러개의 IP정보를 반환
		InetAddress[] naverArr = InetAddress.getAllByName("www.naver.com");
		for(InetAddress ip : naverArr) {
			System.out.println(ip.toString());
		}
		
	}

}
