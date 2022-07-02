package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class SetTest {

	public static void main(String[] args) {

		/*
		
		List와 Set의 차이점
		
		1. list
			-데이터의 순서(index)가 있다.
			-중복되는 데이터를 저장할 수 있다.
			
		2. Set
			-데이터의 순서(index)가 없다
			-중복되는 데이터를 저장할 수 없다.
			

		 */
		
		HashSet hs1 = new HashSet();
		
		// Set에 데이터를 추가할 때도 add()메소드를 사요한다.
		hs1.add("DD");
		hs1.add("AA");
		hs1.add(2);
		hs1.add("CC");
		hs1.add("BB");
		hs1.add(1);
		hs1.add(3);
		
		System.out.println("Set 데이터 ==> " + hs1);
		System.out.println("Set 의 갯수 ==> " + hs1.size());
		
		// Set에 중복되는 데이터를 추가하면 false를 반환하고
		// 데이터는 추가되지 않는다.
		
		boolean isAdd = hs1.add("FF");
		System.out.println("중복되지 않을 때 : " + isAdd);
		System.out.println("set 데이터 : " + hs1);
		
		isAdd = hs1.add("CC");
		System.out.println("중복될  때 : " + isAdd);
		System.out.println("set 데이터 : " + hs1);
		System.out.println();
		
		// Set은 데이터를 수정하는 명령이 따로 없기 떄문에 해당자료를 삭제한 후에 추가해주는 방법을 사용한다.
		
		// 반환하는 메소드 : remove(삭제할 데이터)
		//			==> 반환값 : 삭제완료(true), 삭제실패(false)
	
		// "FF" 데이터를 "EE"로 변경하기
		hs1.remove("FF");
		System.out.println("삭제 후 Set 데이터 : " + hs1);
		hs1.add("EE");
		System.out.println("Set 데이터 : " + hs1);
		
		// hs1.clear()
		
		/*
		
		Set의 데이터는 순서(index)가 없기 떄문에 list처럼 index값으로
		데이터를 하나의 불러올 수 없다.
		그러나 데이터를 하나씩 얻기 위해서는 Iterator를 객체로 반환해야 한다.
		
		-Iterator() 메소드 ==> Set형의 데이터들을 Iterator형으로 변환해 주는 메소드
		 */
		Iterator it = hs1.iterator();
		
		/*
		Iterator에서 데이터를 하나씩 차례로 꺼내올 때 사용되는 메소드
		1.	hasNext() 메소드 ==>	Iterator의 포인터가 라리키는 곳의 다음번째 위치에 데이터가 있는지 
												검사하는 메소드.
												(데이터가 있다면 true, 없으면 false 반환)
		2. next() 메소드 ==>	Iterator의 포인터를 다음번째 위치로 이동한 후 그 곳의 데이터를 반환하는 메소드
		
		
		
		
		
		 */
		
		
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
		// 우리반 학생들 중 번호를 이용하여 추첨하는 프로그램을 작성해 보자.
		// 번호는 1번부터 25번까지 있고, 추첨할 인원은 3명이다.
		// 당첨자 번호를 출력해 보자.
		
		// 최소값부터 최대값 사이의 난수 만들기
		// ==> (int)(Math.random() * (최대값 - 최소값 + 1) + 최소값);
		
		HashSet<Integer> testSet = new HashSet<Integer>();
		for(int i = testSet.size(); i < 3; i++) {
			testSet.add((int)(Math.random() * 25 + 1));
		}
		
		System.out.println("당첨자 번호 : " + testSet);
		 
		// Set유형의 자료를 List형으로 변환하기
		ArrayList<Integer> testList = new ArrayList<Integer>(testSet);
		
		System.out.println("List 데이터 출력");
		for(int i = 0; i < testList.size(); i++) {
			System.out.println(testList.get(i));
		}
		
	}

	
}
