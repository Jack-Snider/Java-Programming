package kr.or.ddit.bank.service;

import java.util.List;

import kr.or.ddit.bank.dao.BankDaoImpl;
import kr.or.ddit.bank.dao.IBankDao;
import kr.or.ddit.bank.vo.BankInfoVO;

public class BankServiceImpl implements IBankService {
	
	private IBankDao dao;
	
	private static BankServiceImpl service;
	
	private BankServiceImpl () {
		dao = BankDaoImpl.getInstance();
	}
	
	public static BankServiceImpl getInstance() {
		if(service == null)
			service = new BankServiceImpl();
		
		return service;
	}
	
	@Override
	public int insertAccountNumber(BankInfoVO bankVo) {
		return dao.insertAccountNumber(bankVo);
	}

	@Override
	public int deleteAccountNumber(String bank_no) {
		return dao.deleteAccountNumber(bank_no);
	}

	@Override
	public int updateAccountNuber(BankInfoVO bankVo) {	
		return dao.updateAccountNuber(bankVo);
	}

	@Override
	public List<BankInfoVO> selectAllAccountNumber() {	
		return dao.selectAllAccountNumber();
	}

	@Override
	public int checkAccountNumber(String bank_no) {
		return dao.checkAccountNumber(bank_no);
	}

}
