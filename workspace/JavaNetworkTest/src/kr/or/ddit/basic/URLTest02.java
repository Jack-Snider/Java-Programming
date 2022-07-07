package kr.or.ddit.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

public class URLTest02 {
	public static void main(String[] args) throws IOException {
		
		// URLConnection 클래스 ==> 애플리케이션과 URL간의 통신 연결을 위한 클래스
		
		
		// 특정 서버의 정보와 파일 내용을 가져와 출력하는 예제
		URL url = new URL("https://www.ddit.or.kr:443/index.php");
		
		// URL 객체를 통해서 URLConnection객체 구하기
		URLConnection urlCon = url.openConnection();
		
		// Header 정보 가져오기
		Map<String, List<String>> headerMap = 
				urlCon.getHeaderFields();
		
		// headerMap의 key값과 value값 출력하기
		for(String key : headerMap.keySet()) {
			System.out.println(key + " : " + headerMap.get(key));
		}
		System.out.println("-------------------------------------------------");	
		
		// URL에 지정된 해당 문서의 내용을 가여조기
		// (index.php 문서의 내용 가져오기
		
		// 방법1 ==> URLConnection객체를 이용하는 방법
		// 파일 내용을 읽어오기 위한 입력용 스트림 객체 생성
		/*
		InputStream is = urlCon.getInputStream(); // 바이트기반으로 읽어들이고
		InputStreamReader isr = new InputStreamReader(is, "UTF-8"); // 그걸 문자기반으로 다시 읽음
		
		// 보조스트림인 버퍼드리더에 매개변수로 isr을 넣어서 좀더 효율적으로 사용
		BufferedReader br = new BufferedReader(isr);
		
		while(true) {
			String str = br.readLine(); // 한 줄씩 읽어오기
			if(str == null) { 
				// 읽어온게 null이면 더 이상 읽을게 없음으로 루프 종료
				break;
			}
			System.out.println(str);
		}
		
		br.close();
		*/
		
		// 방법 2 ==> URL객체의 openStream() 메소드 이용하기
		InputStream is2 = url.openStream();
		
		BufferedReader br2 = new BufferedReader(
				new InputStreamReader(is2, "UTF-8")
				);
		
		// 자료를 읽어와 출력하기
		String str;
		while((str = br2.readLine()) != null) {
			str = br2.readLine(); // 한 줄씩 읽어오기
			if(str == null) {
				break;
			}
			System.out.println(str);
		}
				
		
		
		
	}
}







