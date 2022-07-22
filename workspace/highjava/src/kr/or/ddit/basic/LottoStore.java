package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

public class LottoStore {
	Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		new LottoStore().lottoStart();

	}

	public void lottoStart() {
		while(true) {
			int choice = displayMenu();
			switch(choice){
				case 1 :
					buyLotto();
					break;
				case 2 : 
					System.out.println();
					System.out.println("감사합니다.");
					return;
				default :
					System.out.println("번호를 잘못 입력했습니다.");
					System.out.println("'1' 또는 '2'만 입력하세요.");
			}
		}
		
		
	}
	
	// 로또 구매 메서드
	private void buyLotto() {
		System.out.println();
		System.out.println("로또 구입 시작");
		System.out.println();
		System.out.println("(1000원에 로또번호 하나입니다.)");
		System.out.println("금액입력");
		int money = sc.nextInt();
		if(money<1000) {
			System.out.println("입력 금액이 너무 적습니다. 로또 구입실패 !!");
			return;
		}
		if(money>=101000) {
			System.out.println("입력 금액이 너무 많습니다. 로또 구입실패 !!");
			return;
		}
		
		//구매할 수 있는 로또 장 수 계산
		int  count = money / 1000;
		createLottoNum(count);
		
		System.out.println("받은 금액은 " + money + "원이고, " + "거스름 돈은" + (money%1000) + "원 입니다.");
	}
	
	//로또 개수룰 안수로 받아서 로또번호를 생성하여 출력하는 메서드
	private void createLottoNum(int cnt) {
		HashSet<Integer>lottoSet = new HashSet<Integer>();
		System.out.println();
		System.out.println("행운의 번호");
		for(int i=1; i<=cnt; i++) {
			// 1~45사이의 서로 중복되지 않는 난수 6개 만들기
			while(lottoSet.size()<6) {
				lottoSet.add((int)(Math.random() * 45 + 1));
			}
			ArrayList<Integer>lottoList=
						new ArrayList<Integer>(lottoSet);
			Collections.sort(lottoList);
			System.out.println("로또번호" + i + " : " + lottoList);
			lottoSet.clear(); //기존에 만들어진 번호를 모두 삭제한다.
		}
	}
	
	// 메뉴를 출력하고 작업할 메뉴 번호를 입력받아 반환하는 메서드
	private int displayMenu() {
		System.out.println();
		System.out.println("======================");
		System.out.println("Lotto 프로그램");
		System.out.println("--------------------------------------");
		System.out.println("1. Lotto 구입");
		System.out.println("2. 프로그램 종료");
		System.out.println("--------------------------------------");
		return sc.nextInt();
		
		
		
	}
	
	
}
