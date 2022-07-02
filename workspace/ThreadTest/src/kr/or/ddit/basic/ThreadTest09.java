package kr.or.ddit.basic;

public class ThreadTest09 {
	
	public static void main(String[] args) {
	
		
		
	}
}

class TargetThread extends Thread{

	@Override
	public void run() {
	
		for(long i = 1; i < 20000000000L; i++) {}
		
		try {
			Thread.sleep(1000);
		}catch(InterruptedException e) {}
		
	}
	
	
	
}
