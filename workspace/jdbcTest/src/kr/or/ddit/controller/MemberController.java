package kr.or.ddit.controller;

import java.util.Scanner;

import kr.or.ddit.mvc.service.IMemberService;
import kr.or.ddit.mvc.service.MemberServiceImpl;

public class MemberController {
	
	private IMemberService service; // Service 객체가 저장될 변수 선언
	
	private Scanner scan = new Scanner(System.in);
	
	// 생성자
	public MemberController() {
		service = new MemberServiceImpl(); // Service객체 생성
	}
	
	public static void main(String[] args) {
		
		
		
	}
	
	public void memberStart() {
		
	}
	
}
