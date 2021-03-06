package kr.or.ddit.bank.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.bank.vo.BankInfoVO;
import kr.or.ddit.util.SqlMapClientFactory;

public class BankDaoImpl implements IBankDao {

	private static BankDaoImpl dao;
	
	private BankDaoImpl() {}
	
	public static BankDaoImpl getInstance() {
		if(dao==null)
			dao = new BankDaoImpl();
		return dao;
	}
	
	
	@Override
	public int insertAccountNumber(BankInfoVO bankVo) {
		
		SqlMapClient smc = null;
		int result = 0;
		
		try {
			smc = SqlMapClientFactory.getsqlMapClient();
			Object obj = smc.insert("BankInfo.insertAccountNumber", bankVo);
			
			if(obj==null)
				result = 1;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int deleteAccountNumber(String bank_no) {
		SqlMapClient smc = null;
		int result = 0;
		
		try {
			smc = SqlMapClientFactory.getsqlMapClient();
			result = smc.delete("BankInfo.deleteAccountNumber", bank_no);
			
			if(result > 0)
				result = 1;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int updateAccountNuber(BankInfoVO bankVo) {
		SqlMapClient smc = null;
		int result = 0;
		
		try {
			smc = SqlMapClientFactory.getsqlMapClient();
			result = smc.update("BankInfo.updateAccountNumber", bankVo);
			
			if(result > 0)
				result = 1;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<BankInfoVO> selectAllAccountNumber() {
		
		SqlMapClient smc = null;
		List<BankInfoVO> list = null;
		
		try {
			
			smc = SqlMapClientFactory.getsqlMapClient();
			
			list = smc.queryForList("BankInfo.selectAllAccountNumber");
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public int checkAccountNumber(String bank_no) {
		
		SqlMapClient smc = null;
		int result = 0;
		
		try {
			
			smc = SqlMapClientFactory.getsqlMapClient();
			result = (int)smc.queryForObject("BankInfo.checkAccountNumber", bank_no);
			
			if(result > 0)
				result = 1;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
}
