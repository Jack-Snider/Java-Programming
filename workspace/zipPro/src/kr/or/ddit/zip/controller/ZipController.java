package kr.or.ddit.zip.controller;

import java.util.List;
import java.util.Scanner;

import kr.or.ddit.zip.service.ZipServiceImpl;
import kr.or.ddit.zip.vo.ZipVo;

public class ZipController {
	Scanner sc;
	public static void main(String[] args) {
		new ZipController().searchDong();
	}
	
	public void searchDong() {
		sc=new Scanner(System.in);
		System.out.println("Write dong to Searching...");
		System.out.print(">>");
		String dong = sc.next();
		
		ZipServiceImpl service=ZipServiceImpl.getInstance();
		List<ZipVo> dongList =  service.searchDong(dong);
		System.out.println("Result");
		System.out.println("-------------------------------------------------------------------------------------------");
		System.out.println("No.\t ZipCode\t Zip\t\t\t\t\t\t Bunji\t");
		System.out.println("-------------------------------------------------------------------------------------------");
		for(ZipVo vo : dongList){
			System.out.println(vo.getSeq()+"\t"+vo.getZipcode()+"\t\t"+vo.getSido()+"\t"
							  +vo.getGugun()+"\t"+vo.getDong()+"\t"+vo.getRi()+"\t"
							  +vo.getBldg()+"\t"+vo.getBunji());
			System.out.println("-------------------------------------------------------------------------------------------");
		}
		
		
	}
	
	
}
