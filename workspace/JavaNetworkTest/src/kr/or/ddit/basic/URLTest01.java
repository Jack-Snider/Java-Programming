package kr.or.ddit.basic;

import java.net.MalformedURLException;
import java.net.URL;

public class URLTest01 {
	
	public static void main(String[] args) throws MalformedURLException {
	
		// URL 클래스 ==>		인터넷에 존재하는 서벌들의 자원에 접근할 수 있는
		//								주소를 다루는 클래스
		
		// URL주소 구성
		// 프로토콜 : // 호스트명 : 포트번호/경로명/파일명?쿼리스트링#참조
		// httpys://www.ddit.or.kr/index.php?test=1234
		
		// 방법 1
//		URL url = 
//				new URL("httpys://www.ddit.or.kr/index.php?test=1234");
		
		// 방법 2
		URL url = 
				new URL("https","www.ddit.or.kr",80,"index.php?test = 1234");
		
		System.out.println("Protocol : " + url.getProtocol());
		System.out.println("Host : " + url.getHost());
		System.out.println("Port : " + url.getPort());
		System.out.println("File : " + url.getFile());
		System.out.println("Path : " + url.getPath());
		System.out.println("query : " + url.getQuery());
		
		System.out.println(url.toExternalForm());
		
	}
	
}











