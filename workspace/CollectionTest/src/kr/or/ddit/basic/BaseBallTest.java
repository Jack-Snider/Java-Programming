package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/*
 
 문제)	Set을 이용하여 숫자 야구 게임 프로그램을 작성하시오
 			컴퓨터의 숫자는 난수를 이용하여 구한다.
 			(스트라이크는 S, 볼은 B로 나타낸다.)
 			
 			
 			예시) 컴퓨터의 난수 => 9 5 7
 			
 			실행예시)
 					숫자입력 ==> 3 5 6
 					3 5 6 -> 1S 0B
 					숫자입력 ==> 7 8 9
 					7 8 9 -> 0S 2B
 					숫자입력 ==> 9 7 5
 					9 7 5 -> 3S 0B
 					
 					축하합니다.
 					당신은 4번만 맞혔습니다.
 					 
 					
 
 */

public class BaseBallTest {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		Set<Integer> set = new HashSet<Integer>();
		
		for(int i = 0; set.size() < 3; i++) {
			set.add((int)(Math.random() * 9 + 1));
		}
		
		System.out.println("컴퓨터가 만든 숫자 : " + set);

		
		List<Integer> com_nums = new ArrayList<Integer>(set);
		
		int s = 0; // strike
		int b = 0; //  ball
		
		int count = 1;
		boolean flag = false; // if user wins, it turns to true
		while(true) {
			s = 0;
			b = 0;
			if(flag) {
				System.out.println("축하합니다, 당신은 " + count + "번만에 성공 하셨네요.");
				break;
			}
			
			System.out.print("사용자 숫자 입력 : ");
			String numbers = sc.nextLine();
			count += 1;
			
			String[] nums = numbers.split(" ");
			
			for(int i = 0; i < com_nums.size(); i++) {
				if(com_nums.contains(Integer.parseInt(nums[i])) && com_nums.get(i) == Integer.parseInt(nums[i])) {
					// com_nums가 nums[i]의 번호를 초함 하고 있으면서 해당 인덱스의 있는 값이 서로 같을 때
					s += 1;
				}else if(com_nums.contains(Integer.parseInt(nums[i]))) {
					b += 1;
				}
			}
			
			System.out.println(s + "S " + b + "B");
			
			if(s == 3) {
				flag = true;
			}
			
		}
		
		
		sc.close();
	}
}
