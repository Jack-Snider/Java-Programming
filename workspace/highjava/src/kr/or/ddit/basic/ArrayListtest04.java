package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListtest04 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		ArrayList<String> aliasList = new ArrayList<String>();
		int max = 0;
		for (int i = 1; i <= 5; i++) {
			System.out.println(i + "번째 별명 :  ");
			String alias = sc.nextLine();
			aliasList.add(alias);
		}

		for (int i = 0; i < aliasList.size(); i++) {
			if (aliasList.get(i).length() > max) {
				max = aliasList.get(i).length();
			}
		}
		for (String str : aliasList) {
			if (str.length() == max)
				System.out.println(str);
		}
	}
}
