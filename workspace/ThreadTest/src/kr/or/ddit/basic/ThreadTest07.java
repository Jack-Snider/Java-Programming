package kr.or.ddit.basic;

import javax.swing.JOptionPane;

/*
 * 컴퓨터와 가위 바위 보를 진행하는 프로그램을 작성하시오
 * 
 * 컴퓨터의 가위 바위 보는 난수를 이용해서 구하고,
 * 사용자의 가위 바위 보는 showInputDialog()를 이용해서 입력 받는다.
 * 
 * 입력 시간은 5초로 제한하고 카운트 다운을 진행한다.
 * 5초안에 입력이 없으면 게임에 진것으로 처리
 * 
 * 5초안에 입력이 있으면 승패를 구해서 출력한다.
 * ----------------------------------------------------
 * 실행예시)      --> 5초안에 입력을 못했을 경우
 *            -- 결 과 --
 * 시간초과로 당신이 졌습니다.
 * 
 * 실행예시)      --> 5초안에 입력을 했을 경우
 *            -- 결 과 --
 * 컴퓨터 : 가위
 * 사용자 : 바위
 * 결과 : 당신이 이겼습니다.
 * 
 */

class TimeAttack implements Runnable {

	@Override
	public void run() {

		try {
			for (int i = 1; i <= 5; i++) {
				Thread.sleep(1000);
				System.out.println(i);
			}
		} catch (Exception e) {
		}

	}

}

class Input implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub

		String user = JOptionPane.showInputDialog("가위,바위,보 중 입력해주세요.");
		Game.setUser(user);
		
	}

}

class Game {

	static String user;

	public static String getUser() {
		return user;
	}

	public static void setUser(String user) {
		Game.user = user;
	}

	public void start() {
		
		boolean playable = false; // 제시간에 입력 했는지 검사
		
		Thread input = new Thread(new Input()); // 사용자가 입력하는 스레드
		Thread timeAttack = new Thread(new TimeAttack()); // 카운트하는 스레드

		input.start();
		timeAttack.start();

		// 사용자가 제시간에 입력을 했는지 판단하는 로직
		while(timeAttack.isAlive()) { // true
			if(user != null) {
				playable = true;
			}
		}
		
		if(playable) {
			play();
		}else {
			System.out.println("시간 초과로 당신이 졌습니다.");
		}
		
		
	}
	
	public void play() {
		
		/*
		 * 가위 : 0, 바위 : 1, 보 : 2
		 * 
		 */
		String user = Game.user;
		String computer = "";
		boolean userWin = false;
		boolean draw = false;
		
		int n = (int)(Math.random() * 2 + 1); // 0 ~ 2
		
		switch(n) {
		case 0:
			computer = "가위";
			break;
		case 1:
			computer = "바위";
			break;
		case 2:
			computer = "보";
			break;
		}
		
		if(user.equals("가위") && computer.equals("가위")) {
			draw = true;
		}else if(user.equals("가위") && computer.equals("바위")) {
			userWin = false;
		}else if(user.equals("가위") && computer.equals("보")) {
			userWin = true;
		}else if(user.equals("바위") && computer.equals("가위")) {
			userWin = false;
		}else if(user.equals("바위") && computer.equals("바위")) {
			draw = true;
		}else if(user.equals("바위") && computer.equals("보")) {
			userWin = false;
		}else if(user.equals("보") && computer.equals("가위")) {
			userWin = false;
		}else if(user.equals("보") && computer.equals("바위")) {
			userWin = true;
		}else if(user.equals("보") && computer.equals("보")) {
			draw = true;
		}
		
		if(userWin && !draw) {
			System.out.println("사용자 : " + user);
			System.out.println("컴퓨터 : " + computer);
			System.out.println("사용자가 이겼습니다.");
		}else if(!userWin && !draw) {
			System.out.println("사용자 : " + user);
			System.out.println("컴퓨터 : " + computer);
			System.out.println("컴퓨터가 이겼습니다.");
		}else if(draw) {
			System.out.println("사용자 : " + user);
			System.out.println("컴퓨터 : " + computer);
			System.out.println("무승부입니다.");
		}
		
	}

}

public class ThreadTest07 {

	public static void main(String[] args) {

		Game g = new Game();
		g.start();
		
		

	}
}
