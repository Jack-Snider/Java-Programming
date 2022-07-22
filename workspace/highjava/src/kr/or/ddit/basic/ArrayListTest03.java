package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Scanner;

/* 문제2) 5명의 별명을 입력 받아 ArrayList에 저장하고 이들 중에 별명의
 * 길이가 제일 긴 별명을 출력하시오.
 * (단, 각 별명의 길이는 모두 다르게 입력한다.)
 * 
 * 문제3) 5명의 별명을 입력받아 ArrayList에 저장하고 이들 중에 별명의
 * 길이가 제일 긴 별명들을 출력하시오
 * (단, 각 별명으 ㅣ길이가 같은 것이 존재 할 수 있다.)
 */
public class ArrayListTest03 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<String> nlist2 = new ArrayList<String>();
		nlist2.add("김초롱하늘");
		nlist2.add("강아지고양이쥐");
		nlist2.add("코끼리돼지");
		nlist2.add("악어새");
		nlist2.add("제일긴별명입니다");
		int a = 0;
		int ind = 0;
		for(int i=0; i<nlist2.size(); i++) {
			if(nlist2.get(i).length()>a) {			
				a=nlist2.get(i).length();				
				ind = i;										
			} 
		}System.out.println("가장 긴 별명 : " + nlist2.get(ind));
		
	}
}
