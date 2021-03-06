package kr.or.ddit.bank.service;

import java.util.List;

import kr.or.ddit.bank.vo.BankInfoVO;

public interface IBankService {

	/**
	 * 
	 * @param bankVo 계좌번호 정보가 담긴 VO객체
	 * @return 성공 : 1, 실패 : 0
	 */
	public int insertAccountNumber(BankInfoVO bankVo);

	/**
	 * bank_no 계좌 정보를 삭제
	 * 
	 * @param bank_no
	 * @return 성공 : 1, 실패 : 0
	 */
	public int deleteAccountNumber(String bank_no);

	/**
	 * bank_no 제외한 계좌정보를 수정
	 * 
	 * @param bankVo 수정할 계좌정보가 담긴 VO객체
	 * @return 성공 : 1, 실패 : 0
	 */
	public int updateAccountNuber(BankInfoVO bankVo);

	/**
	 * 전체 계좌정보 출력
	 * 
	 * @return 계좌정보를 담은 List객체 반환
	 */
	public List<BankInfoVO> selectAllAccountNumber();

	/**
	 * 데이블에 계좌가 존재하는지 검사
	 * 
	 * @param bank_no 검색할 계좌번호
	 * @return 식별 : 1, 미식별 : 0
	 */
	public int checkAccountNumber(String bank_no);
}
