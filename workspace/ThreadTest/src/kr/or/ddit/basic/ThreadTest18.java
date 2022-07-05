package kr.or.ddit.basic;

/*
 
 		wait(), notify()를 이용하 두 쓰레드에서 
 		번갈아 한 번씩 실행하는 예제
 		
 		wait(), notify(), notifyAll()은 동기화 영역에서만 사용 가능하다.
 
 */
public class ThreadTest18 {
	public static void main(String[] args) {

		WorkObject work = new WorkObject();
		
		Thread th1 = new ThreadA(work);
		Thread th2 = new ThreadB(work);
		
		th1.start();
		th2.start();
		
		
		
		
	}
}

// 공통으로 사용할 객체
class WorkObject {

	public synchronized void testMethod1() {
		System.out.println("testMethod1()메소드 실행중...");
		
		notify();
		try {
			wait();
		} catch (InterruptedException e) {}
	}
	public synchronized void testMethod2() {
		System.out.println("testMethod2()메소드 실행중...");

		notify();
		try {
			wait();
		} catch (InterruptedException e) {

		}

	}

}

// WorkObject의 testMethod1()에서만 호출하는 스레드
class ThreadA extends Thread {

	private WorkObject workObj;

	public ThreadA(WorkObject workObj) {
		this.workObj = workObj;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 10; i++) {
			workObj.testMethod1();
		}
		
		synchronized (workObj) {
			workObj.notify();
		}
		
	}
}

class ThreadB extends Thread {

	private WorkObject workObj;

	public ThreadB(WorkObject workObj) {
		this.workObj = workObj;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 10; i++) {
			workObj.testMethod2();
		}
		
		synchronized (workObj) {
			workObj.notify();
		}
		
	}
}



