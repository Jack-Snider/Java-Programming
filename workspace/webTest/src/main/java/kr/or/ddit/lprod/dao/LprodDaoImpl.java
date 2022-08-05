package kr.or.ddit.lprod.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.util.SqlMapClientFactory;
import kr.or.ddit.vo.LprodVO;

public class LprodDaoImpl implements ILprodDao{

	private SqlMapClient smc;
	
	private static LprodDaoImpl dao;
	
	

	private LprodDaoImpl() {
		smc = SqlMapClientFactory.getsqlMapClient();
	}
	   
	public static LprodDaoImpl getInstance() {
		
	   if(dao == null) dao = new LprodDaoImpl();
	   return dao;
	      
	 }
	
	@Override
	public List<LprodVO> getAllLprod() {
		
		List<LprodVO> lprodList = null;
		try {
			lprodList = smc.queryForList("Lprod.getAllLprod");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lprodList;
	}

}
