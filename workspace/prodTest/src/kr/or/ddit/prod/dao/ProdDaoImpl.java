package kr.or.ddit.prod.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.ibatis.config.SqlMapClientFactory;
import kr.or.ddit.prod.vo.ProdVO;

public class ProdDaoImpl implements IProdDao {

	// SqlMapClient 객체 필요
	// 자기 자신의 객체를 생성해서 리턴
	private SqlMapClient smc;
	private static IProdDao dao;

	// 생성자 - 변수 초기화
	private ProdDaoImpl() {
		// TODO Auto-generated constructor stub
		smc = SqlMapClientFactory.getsqlMapClient();
	}

	public static IProdDao getDaoInstance() {

		if (dao == null)
			dao = new ProdDaoImpl();
		return dao;
	}

	@Override
	public List<ProdVO> selectAll() {
		
		List<ProdVO> list = null; // 변수선언

		try {
			list = smc.queryForList("prod.selectAll");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // 실행

		return list; // 리턴
	}

}
