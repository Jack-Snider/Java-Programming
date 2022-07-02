package kr.or.ddit.basic;

import java.util.Scanner;

public class Note {
	
	public static void main(String[] args) {

	Scanner sc = new Scanner(System.in);
	
	String tmp = sc.nextLine();
	
	String[] arr = tmp.split(" ");
	
	for(String str : arr) {
		System.out.print(str + " ");
	}
		
	}
}
