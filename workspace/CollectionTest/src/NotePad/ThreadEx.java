package NotePad;

class Lucky implements Runnable {

	@Override
	public void run() {
		
		for(int i = 0; i < 1000; i++) {
			try {
				System.out.println("LUCKY : " + i);
				Thread.sleep(1000);
			}catch(Exception e) {}
		}

	}

}

class HD implements Runnable {

	@Override
	public void run() {

		for(int i = 0; i < 1000; i++) {
			try {
				System.out.println("HD : " + i);
				Thread.sleep(1000);
			}catch(Exception e) {}
		}

	}

}

public class ThreadEx {
	public static void main(String[] args) {

		Thread hd = new Thread(new HD());
		Thread lucky = new Thread(new Lucky());

		hd.start();
		lucky.start();

	}

}
