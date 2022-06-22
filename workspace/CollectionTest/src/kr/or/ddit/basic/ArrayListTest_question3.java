package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListTest_question3 {
	
	public static void main(String[] args) {
	
		/*
		 * 문제3) 5명의 별명을 입력받아 ArrayList에 저장하고 이들 중에 별명의
		 * 길이가 제일 긴 별명들을 출력하시오.
		 * (단, 각 별명의 길이가 같은 것이 존재 할 수 있다.) 
		 */
		
		
		Scanner sc = new Scanner(System.in);
		ArrayList<String> alias = new ArrayList<String>();
	
		for(int  i = 0; i < 5; i ++) {
			System.out.print((i + 1) + "번 째 별명 입력 : ");
			alias.add(sc.next());
		}
		
		int max = 0;
		for(String name :  alias) {
			if(name.length() > max) {
				max = name.length();
			}
		}
		
		
		for(String name : alias) {
			if(name.length() == max) {
				System.out.println(name);
			}
		}
		
		sc.close();
				
	}
}
