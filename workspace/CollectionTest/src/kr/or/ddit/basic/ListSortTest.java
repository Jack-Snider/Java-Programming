package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;

public class ListSortTest {
	
	public static void main(String[] args) {
		
		ArrayList<String> list = new ArrayList<String>();
		
		list.add("일지매");
		list.add("홍길동");
		list.add("성춘향");
		list.add("변학도");
		list.add("이순신");
		
		
		System.out.println("정렬 전 : " + list);
		
		// 정렬은 Collections.sort()메소드를 이용하여 정렬한다.
		//★★★★★ Collections.sort()에소드는 기본적으로 내부 정렬기준을 정렬한다.
		
		Collections.sort(list);
		
		System.out.println("정렬 후 : " + list);
		
		
		
	}
	
}
