package kr.or.ddit.basic;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Lotto {
	public static void LottoBuy() {
		System.out.println("로또 한 장의 금액 : 1000원");

		System.out.println("현재 소지한 금액 입력.");
		Scanner sc = new Scanner(System.in);
		int user = sc.nextInt();
		if(user > 100000){
			System.out.println("하루 구매 한도를 초과했습니다.");
			return;
		}

		if (user > 1000) {
			System.out.println("로또 번호");
			;
			System.out.println();
			for (int i = 1; i <= user / 1000; i++) {
				Set<Integer> lotto = new HashSet<>();
				while (lotto.size() < 6) {
					int random = (int) (Math.random() * 45 + 1);
					lotto.add(random);
				}
				System.out.println(lotto);
			}
			System.out.println();
			System.out.println("받은 금액은" + user + "원이고" + "거스름 돈은" + user %1000 + "입니다.");
			System.out.println("===============================");
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("===============================");
		System.out.println("Lotto 프로그램");

		
	
		while (true) {
			System.out.println("1. Lotto 구입");
			System.out.println("2. 프로그램 종료");
			int input = sc.nextInt();
			switch (input) {
			case 1:
				LottoBuy();
				break;
			case 2:
				System.exit(0);
			default:
				System.out.println("잘못된 입력");
				break;
			}
		}

	}

}
