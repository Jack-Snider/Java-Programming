package kr.or.ddit.basic;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.reflect.Array;

public class ByteArrayIOTest01 {

	public static void main(String[] args) {
		byte[] inSrc = {1,2,3,4,5,6,7,8,9};
		byte[]outSrc = null;
		
		// 입력용과 출력용 스트림 객체 생성
		ByteArrayInputStream input = new ByteArrayInputStream(inSrc);
		
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		
		int data; // 읽어온 자료가 저장될 변수
		
		while((data=input.read()) !=-1) {
			output.write(data);
		}
		
		outSrc = output.toByteArray();
		
		try {
			input.close();
			output.close();
		}catch(IOException e) {
			
		}
		
	
	}

}
