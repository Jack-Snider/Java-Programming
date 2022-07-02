package NotePad;

class Time implements Runnable{

	public void delay(int second) {
		try {
			Thread.sleep(second);
		}catch(InterruptedException e) {}
	}
	
	
	@Override
	public void run() {
		
		for(int i = 100; i >= 1; i--) {
			System.out.println(i);
			delay(1);
		}
		
	}
	
}

public class ThreadTest {
	
	public static void main(String[] args) {
		
			Thread t = new Thread(new Time());
			
			t.start();
		
		
	}
}
