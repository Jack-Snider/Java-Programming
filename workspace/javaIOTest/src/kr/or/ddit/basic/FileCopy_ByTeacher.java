package kr.or.ddit.basic;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*

	문제) 'd:/d_other'폴더에 저장되어 있는 '팽귄.jpg'파일을
			'd:/d_other/연습용' 폴더에 '복사본_팽퀸.jpg' 파일로 복사
			하는 프로그램을 작성하시오.


*/

public class FileCopy_ByTeacher {
	
	public static void main(String[] args) {
	
		File file = new File("d:/d_other/펭귄.jpg");
		
		if(!file.exists()) {
			System.out.println(file.getName() + "파일이 없습니다.");
			System.out.println("복사 작업을 중단합니다.");
			return;
		}
		
		try {
			// 원본 파일을 읽어올 스트림 객체 생성
			// 문자를 다루는 텍스트 파일이나 그런것들은 문자 기반 스트림이 편하고 그 외에는 
			// 바이트 기반 스트림이 편함
			FileInputStream fin = new FileInputStream(file);
			
			//버퍼를 사용하는 방법
			BufferedInputStream bin = 
					new BufferedInputStream(fin);
			
			
			// 대상 파일에 출력한 스트림 객체 생성
			FileOutputStream fout = new FileOutputStream("d:/d_other/연습용/펭귄.jpg");
			
			
			BufferedOutputStream bout = 
					new BufferedOutputStream(fout);
			
			
			System.out.println("복사 시작...");
			
//----------------------------------------------			
//			int data;  // 읽어온 데이터를 저장할 변수
//			
//			while((data = fin.read()) != -1) {
//				fout.write(data);
//			}
//----------------------------------------------
			
			// 개선된 방법
//			byte[] temp = new byte[1024]; // 1KB 
//			int len = 0;
//			while((len = fin.read(temp)) > 0) { // 읽어온 개수가 0보다 크면
//				fout.write(temp, 0, len);
//			}

			fout.flush();
			
			byte[] temp = new byte[1024]; // 1KB 
			int len = 0;
			while((len = bin.read(temp)) > 0) { // 읽어온 개수가 0보다 크면
				bout.write(temp, 0, len);
			}
			bout.flush();
			
			// 스트림 닫기
			
			
			
			
			
//			fout.close();
//			fin.close();
			
			bout.close();
			bin.close();
			
			System.out.println("복사 작업 완료...");
			
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
}











