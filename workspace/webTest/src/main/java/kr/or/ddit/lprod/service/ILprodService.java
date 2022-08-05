package kr.or.ddit.lprod.service;

import java.util.List;

import kr.or.ddit.vo.LprodVO;

public interface ILprodService {
	/*
	 * DB의 LPROD테이블의 전체 내용으 ㄹ가져와 List에 담아서 반환하는 메소드
	 * 
	 * @request내장객체 
	 * 
	 */
	
	public List<LprodVO> getAllLprod();
}
