package kr.or.ddit.basic;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class StackQueueTest {
/*	
	
	Stack - (Last In First Out) 후입선출	
	Queue - (First In First Out) 선입선출
	Stack , Queue는 LinkedLiSㅅ를 이용해서 사용할 수 있다.
	
	
	
*/	
	public static void main(String[] args) {
	
		/*
	
			Stack 명령
			1.  자료 입력 : push(입력값)
			2.  자료 출력 :	pop() ==> 자료를 꺼내온 후 꺼내온 자료를 Stack에서 삭제한다.
								peek() ==> 삭제없이 자료를 꺼내온다.
							
		 */
		
		// Stack 생성
		Stack<String> stack = new Stack<String>();
		
		//LinkedList<Stack> s = new LinkedList<Stack>();
		
		stack.push("홍길동"); // 데이터 추가
		stack.push("일지매");
		stack.push("이순신");
		stack.push("강감찬");
		
		// Stack값 출력
		System.out.println("stack ==> " + stack);
	
		
		// Stack에서 데이터 추출 (Stack안에 데이터를 삭제하고 꺼내옴) 
		String data = stack.pop();
		System.out.println("꺼내온 값 1 : " + data);
		System.out.println("꺼내온 값 2 : " + stack.pop());
		
		// Stack값 출력
		System.out.println("stack ==> " + stack);
		
		
		stack.push("성춘향");
		
		// Stack값 출력
		System.out.println("stack ==> " + stack);
	
		
		
	System.out.println();
	System.out.println("---------------------------------------");
	System.out.println();
	
	/*
		Queue 명령
		1. 자료 입력 : offer(입력값)
		2. 자료 출력 : poll() ==> 자료를 꺼내오고 꺼내온 자료를 Queue에서 삭제한다.
							peek() ==> 삭제없이 자료를 꺼내온다
		
	 */
	
	// Queue에서 생성
	Queue<String> queue = new LinkedList<String>();
	
	// 자료입력
	queue.offer("홍길동");
	queue.offer("일지매");
	queue.offer("이순신");
	queue.offer("강감찬");
	
	
	System.out.println("queue ==> " + queue);
	
	// 데이터 추출
	String temp = queue.poll();
	System.out.println("꺼내온 값 1 : " + temp);
	System.out.println("queue ==> " + queue);
	System.out.println("꺼내온 값 2 : " + queue.poll());



	queue.offer("성춘향");
	System.out.println("queue ==> " + queue);
	
	System.out.println("꺼내온 값 3 : " + queue.poll());
	System.out.println("queue ==> " + queue);
	
	System.out.println("삭제 없이 꺼내온 값 : " + queue.peek());
	System.out.println("queue ==> " + queue);
	
	}
	
	
}