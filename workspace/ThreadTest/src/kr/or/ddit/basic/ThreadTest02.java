package kr.or.ddit.basic;

import java.io.DataInput;

public class ThreadTest02 {

	public static void main(String[] args) {

		// 멀티스레드
		// '*' 문자를 200개 출력하는 부분과 '$' 문자를 200개
		// 출력하는 프로그램을 작성하려고 한다.

		// Thread를 작성하고 사용하는 방법

		// 방법1
		// Thread 클래스를 상속한 class를 작성 후 이 class의
		// 인스턴스를 생성한 후 이 인스턴스의 start() 메소드를 호출해서 실행한다.

		

	}

}

// 방법 1 - Thread 클래스를 상속한 class 작성하기
class MyThread1 extends Thread {

	@Override
	public void run() {



	}
}

class MyThread2 implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 1; i <= 100; i++) {
			try {
				Thread.sleep(100);
				System.out.print("♥");
			} catch (Exception e) {
			}

		}
	}
}
