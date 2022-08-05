package kr.or.ddit.file.service;

import java.util.List;

import kr.or.ddit.vo.FileinfoVO;

public interface IFileinfoService {
	/**
	 * FileinfoVo객체에 담겨진 자료를 DB에 INSERT하는 메소드 
	 * @param fileinfoVo DB에 INSERT할 자료가 저장된 FileinfoVO객체
	 * @return 작업 성공 : 1, 작업 실패 : 0
	 */
	public int insertFileinfo(FileinfoVO fileinfoVo);
	
	
	/**
	 * 전체 파일 목록을 가져와 List에 담아서 반환하는 메소드
	 * @return FileinfoVO객체가 저장된 List객체
	 */
	public List<FileinfoVO> getAllFileinfo();
	
	/**
	 * 파일 번호를 인수값으로 받아서 해당 파일 정보를 VO에 담아서 반환하는 메소드
	 * @param fileNo 가져올 file번호
	 * @return 검색된 파일 정보가 저장된 FileinfoVO객체
	 */
	public FileinfoVO getFileinfo(int fileNo);
}
