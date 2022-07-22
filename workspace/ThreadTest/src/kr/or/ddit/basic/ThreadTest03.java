package kr.or.ddit.basic;

public class ThreadTest03 {

	public static void main(String[] args) {
		// 쓰레드가 수행되는 시간 체크해 보기
		
		
		Thread th = new Thread(new MyRunner2());
		
		// 1970년 1월 1일 0시0분0초(표준시간)로 부터 경과한 시간
		// 밀리세컨드(1/1000)단위로 반환한다.
		// 3000 ==> 1970년 1월 1일 0시0분3초 라는 뜻이다.
		long startTime = System.currentTimeMillis();
		
		th.start(); // 쓰레드 실행ㅋ
		try {
			th.join();	//현재 실행중인 쓰레드에서 대상이 되는 쓰레드
		}catch(InterruptedException e) {}
		
		long endTime = System.currentTimeMillis();
		
		System.out.println("경과시간 : " + (endTime - startTime));
	}

}


class MyRunner2 implements Runnable{

	@Override
	public void run() {
		long sum = 0L;
		for(long i=1L; i<=100000000L; i++) {
			sum+=i;
		}
		System.out.println("합계 : " + sum);
	}
	
}