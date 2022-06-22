package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListTest_question2 {
	
	public static boolean dupcheck(String[] array,String target) {
		
		String tmp = "";
		
		for(String str : array) {
			tmp += str + " ";
		}
		
		if(tmp.contains(target)) {
			return true;
		}else {
			return false;
		}
		
		
	}
	
	
	
	public static void main(String[] args) {
	
		
		String[] array = {"A","B","C","D","E","F","G"};
		System.out.println(dupcheck(array,"K"));
		
		
		/*
		 * 문제2)	5명의 별명을 입력 받아 ArrayList에 저장하고 이들 중에 별명의 길이가
		 *				제일 긴 별명을 출력하시오.
		 *				(단, 각 별명의 길이는 모두 다르게 입력한다.)         
		 */

		Scanner sc = new Scanner(System.in);
		
		ArrayList<String> alias =  new ArrayList<String>();
		
		for(int i = 0; i < 5; i++) {
			System.out.print((i + 1) + "번 째 별명 입력 : ");
			alias.add(sc.next());
		}
		
		int index = 0;
		int max = 0;
		for(String name : alias) {
			if(name.length() > max) {
				max = name.length();
				index = alias.indexOf(name);
			}
		}
		
		System.out.println("길이가 가장 긴 별명 : " +  alias.get(index));
		
		sc.close();
		
		
	}
}
