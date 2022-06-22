package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;


class Ddit{
	
	
	
}

public class VectorTest {

	public static void main(String[] args) {

		// 문제 1
		/*
		 * Ddit 클래스의 객체 10개를 만들고 그 객체들을 모두 백터에 집어 넣으시오.
		 */
		
		
		//Vector v = new Vector();
		
		//-------------------------------------------------------------
		/*
		 
		 제네릭 타입(Generic Type) ==> 클래스 내부에서 사용할 데이터의 데이터 타입을 외부에서
		 지정하는 기법으로 객체를 선언할 때 < > 안에 그 객체의 내부에서 사용할 데이터의 타입을 정해주는 것을 말한다.
		 이런식으로 선언하게되면 지정한 데이터 타입 이외의 다른 종류의 데이터를 저장할 수 없다. 
		 이 때  제네릭으로 선언될 수 있는 데이터 타입을 클래스형 이어여 한다.
		 int ==> Integer
		 boolean ==> Boolean
		 char ==> Charactor, ...
		 
		 ==> 제네릭 타입으로 선언하게 되면 데이터를 꺼내올 때 형변환 없이 꺼내올 수 있다.
		   
		 */
		Vector<String> v = new Vector<String>(); // ==> String만 저장할 수 있는 Vector
		Vector<Integer> vector = new Vector<Integer>();
		
		v.add("안녕하세요");
		//v.add(100); ==> 오루남
		
		//-----------------------------------------------------------------------
		System.out.println("------------------------------------------");
		
		// 전체 데이터 삭제하기 : clear()
		v.clear();
		System.out.println("v의 size => " + v.size());
		
		v.add("A");
		v.add("B");
		v.add("C");
		v.add("D");
		v.add("E");
		
		System.out.println("v의 size => " + v.size());
		
		// 데이터 삭제하기 : removeAll(Coolection객체)
		// => Collection객체가 가지고 있는 데이터를 모두 삭제한다.
		// ==> 반환값 : 성공(true), 실패(false)
		
		v.removeAll(vector);
		
		// 백터의 데이터를 순서대로 모두 가져와 사용하고 싶으면 반복문을 
		// 사용하면 된다. (주로 for문을 사용한다.)
	
		// 방법 1
		for(int i = 0; i < v.size(); i++) {
			System.out.println(v.get(i));
		}
		
		// 방법 2
		for(String str : v) {
			System.out.println(str);
		}
		
	}

}
