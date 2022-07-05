package kr.or.ddit.basic;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

// FileIOTest01
// 파일의 데이터를 읽어와서 출력하기
public class FileIO_Reader_byte {
	
	public static void main(String[] args) {
	
		/*
		 
		 InputStream, outputStream ==> byte기반의 I/O
		 
		 */
		
		// 파일 내용을 바이트 기반의 스트림으로 읽어와 화면에 출력하는 예제
		// ==> FileInputStream 객체 이용
		try {
			
			// 읽어올 파일 정보를 인수값으로 받는 FileInputStream객체 생성
			
			// 방법 1
//			FileInputStream fin = 
//					new FileInputStream("d:/d_other/test.txt");
			
			// 방법2 ==> 파일 정보를 File객체로 지정하는 방법
			File f = new File("d:/d_other/test.txt");
			FileInputStream fin = 
					new FileInputStream(f);
			
			
			int c; // 읽어올 데이터를 저장할 변수
			while((c = fin.read()) != -1) { // 읽기
				System.out.print((char)c); // 화면에 출력
			}
			
			fin.close(); 		// 스트림 닫기
			
			
		} catch (IOException e) {
			System.out.println("입출력 오류입니다. ==> " + e.getMessage());
		}
		
	}
}






