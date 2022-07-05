package kr.or.ddit.basic;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 
 	문제) 'd:/d_other'폴더에 저장되어 있는 '팽귄.jpg'파일을
 			'd:/d_other/연습용' 폴더에 '복사본_팽퀸.jpg' 파일로 복사
 			하는 프로그램을 작성하시오.
 
 
 */

public class FileCopy {

	/*
	 * 이미지를 가져오고, 그 가져온 이미지를 새로운 경로에 저장
	 * 
	 * 
	 */
	
	
	public static void main(String[] args) {

		try {
			
			FileInputStream  fis = new FileInputStream("d:/d_other/펭귄.jpg");
			FileOutputStream fos = new FileOutputStream("d:/d_other/연습용/복사본_펭귄.jpg");
			
			int c;
			while((c = fis.read()) != -1) {
				fos.write(c);
			}
			
			System.out.println("복사 끝!");
			
			fis.close();
			fos.close();
			
		} catch (IOException e) {
			// TODO: handle exception
		}
		

	}
}
