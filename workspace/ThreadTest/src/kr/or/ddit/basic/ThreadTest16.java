package kr.or.ddit.basic;

public class ThreadTest16 {
	
	private int balance; // 잔액이 저장 될 변수

	public synchronized int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	// 입금을 처리하는 메서드
	public synchronized void deposit(int money) {
		balance += money;
	}

	// 출금을 처리하는 메서드 (반환값 : 출금 성공 = true, 실패 = false)
	// 동기화 영역에서 호출하는 메소드는 동기화 처리를 해 주어야 안전한다.
	public synchronized boolean withdraw(int money) {
		if(balance >= money) { // 출금 가능
			
			for(int i = 1; i <= 100000000; i++) {} // 시간 지연용
			
			balance -= money;
			System.out.println("메소드 안에서 balance = " + getBalance());
			return true;
		}else { // 출금불가
			return false;
		}
	}
	
	public static void main(String[] args) {
		
		ThreadTest16 account  = new ThreadTest16();
		account.setBalance(10000); // 잔액을 10000원으로 설정
	
		// 익명 구현체로 쓰레드 구현
		Runnable r = new Runnable() {
			@Override
			public void run() {
				boolean result = account.withdraw(6000); // 6000원 출금
				System.out.println("쓰레드에서 result = " + result
						+ ", balance = " + account.getBalance());
				
			}
		};
		//-------------------------------------------------
		
		Thread th1 = new Thread(r);
		Thread th2 = new Thread(r);
		
		th1.start();
		th2.start();
		
		
		
	}
	
}
