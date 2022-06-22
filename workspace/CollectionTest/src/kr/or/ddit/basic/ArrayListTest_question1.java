package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Scanner;

/*

 	문제)	5명의 사람 이름을 입력 받아 ArrayList에 저장한 후에
 			 	이들 중 '김'씨 성의 이름을 모두 출력하시오
 			 	(단, 입력은 Scanner 객체를 이용한다.)

 */
public class ArrayListTest_question1 {

	public static void main(String[] args) {

		ArrayList<String> names = new ArrayList<String>();

		Scanner sc = new Scanner(System.in);

		// 5명의 사람 이름을 입력받음
		for (int i = 0; i < 5; i++) {
			System.out.print((i + 1) + "번  이름 입력 : ");
			names.add(sc.next());
		}

		// solution 1
		System.out.println("----------------------------------");
		for (String name : names) {
			if (name.charAt(0) == '김') {
				System.out.println(name);
			}
		}
		System.out.println("----------------------------------");

		// solution 2
		System.out.println("----------------------------------");
		for (String name : names) {
			if (name.startsWith("김")) {
				System.out.println(name);
			}
		}
		System.out.println("----------------------------------");

		// solution 3
		System.out.println("----------------------------------");
		for (String name : names) {
			if (name.substring(0, 1).equals("김")) {
				System.out.println(name);
			}
		}
		System.out.println("----------------------------------");

		// solution 4
		System.out.println("----------------------------------");
		for (String name : names) {
			if(name.indexOf("김") == 0) {
				System.out.println(name);
			}
		}
		System.out.println("----------------------------------");

		
		
		
		sc.close();

	}
}