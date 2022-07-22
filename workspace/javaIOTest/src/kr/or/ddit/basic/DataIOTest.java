package kr.or.ddit.basic;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class DataIOTest {

	public static void main(String[] args) {
		try {
			FileOutputStream fout = 
					new FileOutputStream("d:/d_other/test.dat");
			// 자료형 단위로 출력할 DataOutputStream객체 생성
			DataOutputStream dout = 
					new DataOutputStream(fout);
			
			//자료 출력하기
			dout.writeInt(200);	// 정수형으로 데이터 출력
			dout.writeFloat(123.45f);
			dout.writeBoolean(false);
			dout.writeUTF("ABCDabcd");
			
			System.out.println("출력 완료 ! ! ! !");
			
			dout.close(); 	//스트림 닫기
			
			//----------------------------------------------------------
			
			// 출력했던 자료 읽어오기
			DataInputStream din = 
					new DataInputStream(new FileInputStream("d:/d_other/test.dat"));
			
			// DataInputStream으로 자료를 일겅올 때는
			// 출력할 때의 순서와 같은 순서로 읽어와야 된다.
			System.out.println("정수형 : " + din.readInt());
			System.out.println("실수형 : " + din.readFloat());
			System.out.println("논리형 : " + din.readBoolean());
			System.out.println("문자열 : " + din.readUTF());
			
			System.out.println();
			System.out.println("읽기 작업 완료 . . .");
			
			
		} catch (Exception e) {
			
		}

	}

}
