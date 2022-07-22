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
 * 실행예시)		--> 5초안에 입력을 못했을 경우
 * 			  -- 결 과 --
 * 시간초과로 당신이 졌습니다.
 * 
 * 실행예시)		--> 5초안에 입력을 했을 경우
 * 			  -- 결 과 --
 * 컴퓨터 : 가위
 * 사용자 : 바위
 * 결과 : 당신이 이겼습니다.
 * 
 */

public class ThreadTest07 {

	public static void main(String[] args) {
		Thread ga1 = new TypeInput();
		Thread ga2 = new Count();

		ga1.start();
		ga2.start();

	}

}

class TypeInput extends Thread {
	public static boolean inputCheck = false;

	@Override
	public void run() {
		String str = JOptionPane.showInputDialog("가위, 바위, 보를 입력하세요.");
		inputCheck = true;

		System.out.println("입력한 값 : " + str);

		int computerInput = (int) (Math.random() * 3 +1);
		int userNum = changeUserInput(str);
		
		printGame(str, computerStr(computerInput), 
				resultGame(computerInput,userNum));
	}

	int changeUserInput(String userInput) {
		switch (userInput) {

		case "가위":
			return 1;
		case "바위":
			return 2;
		case "보":
			return 3;
		}
		return 0;
	}

	String computerStr(int computerInput) {
		switch (computerInput) {

		case 1:
			return "가위";
		case 2:
			return "바위";
		case 3:
			return "보";
		}
		return "";
	}
	
String resultGame(int computerInput, int userNum) {
	if(userNum - computerInput == 1) {
		return "당신이 이겼습니다.";
	}else if(userNum - computerInput == 0) {
		return "비겼습니다.";
	}else if(userNum - computerInput == -2) {
		return "당신이 이겼습니다.";
	}else {
		return "당신이 졌습니다.";
	}
}
void printGame(String userInput, String computerInput, String gameResult) {
	System.out.println("-- 결과 --");
	System.out.println("컴퓨터 : "+computerInput);
	System.out.println("사용자 : "+userInput);
	System.out.println("승패 : " + gameResult);
}

}

class Count extends Thread {
	@Override
	public void run() {
		for (int i = 5; i > 0; i--) {
			if (TypeInput.inputCheck == true) {
				return;
			}
			System.out.println(i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {

			}
		}
		System.out.println("5초가 지났습니다. 당신이 졌습니다.");
		System.exit(0);
	}
}
