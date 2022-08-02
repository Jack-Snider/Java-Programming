package kr.or.ddit.zip.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.zip.config.SqlMapClientFactory;
import kr.or.ddit.zip.vo.ZipVo;

public class ZipDaoImpl implements IZipDao {
	SqlMapClient smc=SqlMapClientFactory.getSqlMapClient();
	private static ZipDaoImpl dao;
	
	public static ZipDaoImpl getInstance() {
		if(dao==null) dao=new ZipDaoImpl();
		return dao;
	}
	
	public static ZipDaoImpl getZipDao() {
		if(dao==null) dao=new ZipDaoImpl();
		return dao;
	}
	
	
	@Override
	public List<ZipVo> searchDong(String dong) {
		List<ZipVo> zipList =null;
		try {
			System.out.println("searching...");
			zipList=smc.queryForList("zipVo.searchDong",dong);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return zipList;
	}

}
