package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class BaseBallTest {
	private ArrayList<Integer> numList; // 컴퓨터의 난수를 저장할 List
	private ArrayList<Integer> userList; // 사용자가 입력한 값을 저장할 List

	private int strike; // 스트라이크 개수
	private int ball; // 볼의 개수

	Scanner sc = new Scanner(System.in);

	// 1~9 사이의 서로 다른 난수 3개를 만들어서 List에 저장하는 메서드
	// 난수는 중복되지 않아야 한다. (Set 이용)
	private void getNum() {
		Set<Integer> numSet = new HashSet<Integer>();

		// 서로다른 난수 3개 만들기
		while (numSet.size() < 3) {
			numSet.add((int) (Math.random() * 9 + 1));
		}
		// 만들어진 난수를 List에 저장하기
		numList = new ArrayList<Integer>(numSet);

		// List의 데이터를 섞어준다.
		Collections.shuffle(numList);
	}

	// 사용자로부터 3개의 정수를 입력받아서 List에 저장하는 메서드
	// 입력한 값은 중복되지 않아야 한다.
	private void inputData() {
		int n1, n2, n3; // 입력한 정수가 저장될 변수 선언

		do {
			System.out.println("숫자 입력 => ");
			n1 = sc.nextInt();
			n2 = sc.nextInt();
			n3 = sc.nextInt();
			if (n1 == n2 || n1 == n3 || n2 == n3) {
				System.out.println("중복되는 숫자는 입력 불가. 재입력.");
			}
		} while (n1 == n2 || n1 == n3 || n2 == n3);

		// 입력받은 데이터들을 List에 추가한다.
		userList = new ArrayList<Integer>();
		userList.add(n1);
		userList.add(n2);
		userList.add(n3);

	}

	// 스트라이크 볼의 개수를 구한 후 출력하는 메서드
	private void printBallCount() {
		strike = 0; // 스트라이크 개수와 볼의 개수 초기화
		ball = 0; //

		for (int i = 0; i < userList.size(); i++) {
			for (int j = 0; j < numList.size(); j++) {
				if (userList.get(i) == numList.get(j)) {
					if(i==j) {
						strike++;
					}else {
						ball++;
					}
				} 
			}
		}

		// 결과 출력
		System.out.println(userList.get(0) + "  " + userList.get(1) + " " + userList.get(2) + " => " + strike + " S "
				+ ball + " B ");

	}

	public void gameStart() {
		getNum();

		System.out.println("만들어진 난수 : " + numList);

		int cnt = 0; // 몇번만에 맞췄는지 여부를 저장
		do {
			cnt++;
			inputData(); // 사용자 입력

			// 볼카운트 처리
			printBallCount();
		} while (strike != 3); // 3스트라이크 될때까지 반복..

		System.out.println();
		System.out.println("축하합니다.");
		System.out.println("당신은" + cnt + "번째 만에 맞췄습니다.");

	}

	public static void main(String[] args) {
		new BaseBallTest().gameStart();
	}

}
