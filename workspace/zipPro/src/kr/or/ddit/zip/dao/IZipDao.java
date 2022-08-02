package kr.or.ddit.zip.dao;

import java.util.List;

import kr.or.ddit.zip.vo.ZipVo;

public interface IZipDao {
	/**
	 * 주소 중 '동'을 검색하고 해당하는 zipVO객체를 List로 반환.
	 * @param dong	검색할 '동'의 이름
	 * @return	해당되는 '동'의 List
	 */
	public List<ZipVo> searchDong(String dong);
	
	
	
	
}
