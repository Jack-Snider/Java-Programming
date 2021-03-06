package kr.or.ddit.bank.controller;

import java.util.List;
import java.util.Scanner;

import kr.or.ddit.bank.service.BankServiceImpl;
import kr.or.ddit.bank.service.IBankService;
import kr.or.ddit.bank.vo.BankInfoVO;

public class BankController {

	private IBankService service;
	Scanner sc = new Scanner(System.in);
	
	public BankController() {
		service = BankServiceImpl.getInstance();
	}
	
	public static void main(String[] args) {
		
		BankController bc = new BankController();
		bc.display();

	}
	
	public void display() {
		
		while(true) {
			System.out.println("=======War Bank=======");
			System.out.println(">> 1. 계좌번호 추가");
			System.out.println(">> 2. 계좌번호 삭제");
			System.out.println(">> 3. 계좌번호 수정");
			System.out.println(">> 4. 전체 계좌번호 출력");
			System.out.println(">> 0. 작업끝");
			System.out.println("======================");
			int input = Integer.parseInt(sc.nextLine());
			
			switch(input) {
			case 1:
				insertAccount();
				break;
			case 2:
				deleteAccountNumber();
				break;
			case 3:
				updateAccountNumber();
				break;
			case 4:
				selectAllAccountNumber();
				break;
			case 0:
				System.out.println("War Bank System Out");
				System.exit(0);
			default :
				System.out.println("error ! !");
				break;
			}
		}
		
		
	}
	
	public void insertAccount() {
		System.out.println("추가하려는 계좌번호를 입력하세요.");
		String bank_no = sc.nextLine();
		if(service.checkAccountNumber(bank_no)==1) {
			System.out.println("이미 있는 번호입니다.");
			return;
		}
		
		System.out.println("추가하려는 은행명을 입력하세요.");
		String bank_name = sc.nextLine();
		System.out.println("추가하려는 이름을 입력하세요.");
		String bank_user_name = sc.nextLine();
		
		BankInfoVO bankVo = new BankInfoVO();
		
		bankVo.setBank_no(bank_no);
		bankVo.setBank_name(bank_name);
		bankVo.setBank_user_name(bank_user_name);
		
		int result = service.insertAccountNumber(bankVo);
		
		if(result == 1)
			System.out.println("추가 성공 ! ! !");
		else
			System.out.println("추가 실패 . . .");
	}
	
	public void deleteAccountNumber() {
		System.out.println("삭제하려는 계좌번호를 입력하세요.");
		String bank_no = sc.nextLine();
		
		if(service.checkAccountNumber(bank_no)==0) {
			System.out.println("삭제할 계좌번호가 없습니다.");
			return;
		}
		
		int result = service.deleteAccountNumber(bank_no);
		
		if(result==1)
			System.out.println("삭제 성공 ! ! !");
		else
			System.out.println("삭제 실패 . . .");
	}
	
	public void updateAccountNumber() {
		System.out.println("수정할 계좌번호를 입력하세요.");
		String bank_no = sc.nextLine();
		
		if(service.checkAccountNumber(bank_no)==0) {
			System.out.println("수정할 번호가 존재하지 않습니다.");
			return;
		}
		
		System.out.println("수정할 내용.");
		System.out.println("은행명 : ");
		String bank_name = sc.nextLine();
		System.out.println("예금주명 : ");
		String bank_user_name = sc.nextLine();
		
		BankInfoVO bankVo = new BankInfoVO();
		
		bankVo.setBank_no(bank_no);
		bankVo.setBank_name(bank_name);
		bankVo.setBank_user_name(bank_user_name);
		
		int result = service.updateAccountNuber(bankVo);
		
		if(result == 1)
			System.out.println("수정 성공 ! ! !");
		else
			System.out.println("수정 실패 . . .");
	}
	
	public void selectAllAccountNumber() {
		System.out.println("전체 계좌번호를 출력합니다.");
		
		List<BankInfoVO> list = service.selectAllAccountNumber();
		
		System.out.println("------------------------------------");
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i).getBank_no() + " " + list.get(i).getBank_name()
					+ " " + list.get(i).getBank_user_name() + " " + list.get(i).getBank_date());
		}
	}
			

}
