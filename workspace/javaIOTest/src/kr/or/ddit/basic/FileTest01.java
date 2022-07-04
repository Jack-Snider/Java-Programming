package kr.or.ddit.basic;

import java.io.File;

public class FileTest01 {
	
	public static void main(String[] args) {
	
		// File객체 만들기 연습
		
		// 1. new File(String 파일 또는 경로)
		// ==>	디렉토리와 디렉토리 사이 또는 디렉토리와 파일명 사이의 
		// 		구분문자는 '\' 르 사용하거나 '/'를 사용할 수 있다.
		File file1 = new File("d:/d_other/test.txt"); // 구분문자로 '/'를 사용한 경우
		//File file2 = new File("d:\\d_other\\test.txt"); // 역슬래쉬로 구분할 땐 2개씩 써줘야함
		
		System.out.println("파일명 : " + file1.getName());
		System.out.println("디렉토리 여부 : " + file1.isDirectory());
		System.out.println("파일 여부 : " + file1.isFile());
		System.out.println();
		
				
	}
}
