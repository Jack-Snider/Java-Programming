package kr.or.ddit.zip.service;

import java.util.List;

import kr.or.ddit.zip.dao.ZipDaoImpl;
import kr.or.ddit.zip.vo.ZipVo;

public class ZipServiceImpl implements IZipService {
	private ZipDaoImpl dao;
	
	private static ZipServiceImpl service;
	
	private ZipServiceImpl() {
		dao=ZipDaoImpl.getInstance();
	}
	public static ZipServiceImpl getInstance() {
		if(service==null) service = new ZipServiceImpl();
		return service;
	}
	
	
	
	@Override
	public List<ZipVo> searchDong(String dong) {
		System.out.println("going...");
		return dao.searchDong(dong);
	}

}
