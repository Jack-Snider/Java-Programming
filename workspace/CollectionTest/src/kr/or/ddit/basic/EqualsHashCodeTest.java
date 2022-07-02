package kr.or.ddit.basic;

import java.util.HashSet;

public class EqualsHashCodeTest {
	public static void main(String[] args) {

		Person p1 = new Person();
		p1.setNum(1);
		p1.setName("홍길동");
		
		Person p2 = new Person();
		p2.setNum(2);
		p2.setName("일지매");
		
		System.out.println(p1 == p2);
		System.out.println(p1.equals(p2));
		
		HashSet<Person> testSet = new HashSet<Person>();
		testSet.add(p1);
		testSet.add(p2);
		System.out.println("set의 크기 : " + testSet.size());
		
		/*
		 * equals() 메소드 ==> 객체의 내용이 같은지 검사하는 메소드
		 * hashCode() 메소드 ==> 두 객체의 동일성을 검사하는 메소드
		 * 
		 * HashSet, HashTable, HashMap과 같이 Hash로 시작하는
		 * 컬렉션객체들은 객체의 의미상 돌일성을 비교하기 위해서 hashCode()
		 * 메소드를 호출하여 비교한다.
		 * 그러므로, 객체가 같은지 여부를 결정하려면 hashCode()메소드를 재정의 해야 한다.
		 * 
		 * hashCode()메소드에서 사용하는 '해싱 알고리즘'은 서로 다른 객체들대 대해서 같은 hashCode가
		 * 나타날 수 있다.
		 * 
		 * 
		 */
		
	}
}

class Person{
	
	private int num;
	private String name;
	
	
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if(obj == null) return false;
		
		// 참조값이 같은지 검사
		if(this == null) return true;
		
		// 같은 종류의 class인지 검사
		if(this.getClass() != obj.getClass()) {
			return false;
		}
		
		// 매개변수의 값을 현재 객체 유형으로 형변환한다.
		Person that = (Person)obj;
		
		if(this.name == null && that.name != null) {
			return false;
		}
		
		if(this.num == that.num && this.name == that.name) {
			return true;
		}
		
		if(this.num == that.num && this.name.equals(that.name)) {
			return true;
		}
	
		return false;
		
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
	
}