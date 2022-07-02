package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ListSortTest02 {

	public static void main(String[] args) {
		
		ArrayList<Member> memList = new ArrayList<Member>();
		
		memList.add(new Member(1,"홍길동","010-1111-1111"));
		memList.add(new Member(2,"이순신","010-2222-2222"));
		memList.add(new Member(3,"성춘향","010-3333-3333"));
		memList.add(new Member(1,"강감찬","010-4444-4444"));
		memList.add(new Member(1,"일지매","010-5555-5555"));
		memList.add(new Member(1,"변학도","010-6666-6666"));
		
		System.out.println("정렬 전 ...");
		for(Member mem : memList) {
			System.out.println(mem);
		}
		System.out.println("----------------------------------------------------");
		
		Collections.sort(memList);
		
		System.out.println("정렬 후 ...");
		for(Member mem : memList) {
			System.out.println(mem);
		}
		System.out.println("----------------------------------------------------");
	
		//	Member의 회원정보(num)의 내림차순으로 정렬하는
		// 외부 정렬 기준 클래스를 이용하여 정렬하시오.
		
		System.out.println("외부 정렬 후 ... ");
		Collections.sort(memList, new NumSort()); 
		for(Member mem : memList) {
			System.out.println(mem);
		}
		System.out.println("----------------------------------------------------");
		
	}
	
}

// 외부정렬 기준 : 외부정렬 ==>  Comparator<자료형>
class NumSort implements Comparator<Member>{

	@Override
	public int compare(Member mem1, Member mem2) {

		return  mem1.compareTo(mem2) * -1;
	}
	
}



// 회원 데이터를 처리할 class 작성하기
// ==>	Member클래스의 회원이름을 기준으로 오름차순 정렬이 되도록
//			내부 정렬 기준을 추가하기.	
// 내부 정렬은 Comparable<데이터 타입>
class Member implements Comparable<Member>{
	
	private int num; 				// 회원 번호
	private String name;		// 회원 이름
	private String tel;			// 전화번호
	
	
	
	
	@Override
	public String toString() {
		return "Member [num=" + num + ", name=" + name + ", tel=" + tel + "]";
	}

	public Member(int num, String name, String tel) {
		super();
		this.num = num;
		this.name = name;
		this.tel = tel;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	@Override
	public int compareTo(Member mem) {
		// 회원이름의 오름차순 정렬 기준 만들기
		return this.getName().compareTo(mem.getName());
		// 현재 클래스에 있는 이름을 가지고 와서 compareTo 메소드로 매개변수로 들어온 이름과 비교
	}



	
	
	
	
	
}