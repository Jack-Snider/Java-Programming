package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Scanner;

/*
 * 문제) 5명의 사람 이름을 입력 받아 ArrayList에 저장한 후에
 * 이들 중 '김'씨 성의 이름을 모두 출력하시오.
 * (단, 입력은 Scanner객체를 이용한다.)
 */
public class ArrayListTest02 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		ArrayList<String> nlist = new ArrayList<String>();
		nlist.add("김덕배");
		nlist.add("김춘배");
		nlist.add("오용택");
		nlist.add("최지훈");
		nlist.add("강명범");
		for(int i=0; i<5; i++) {
		System.out.println("이름을 입력하세요 : ");
		nlist.add(sc.nextLine());								//charat -> 문자열 가져오기 
		}																	// if(nameList.get(i).charAt(0) =='김'
		for(int i=0; i<5; i++) {									// println(nameList.get(i));
			String str = nlist.get(i);
			str=str.substring(0,1);
			if(str.equals("김")) System.out.println(nlist.get(i));
		}
	}

}
