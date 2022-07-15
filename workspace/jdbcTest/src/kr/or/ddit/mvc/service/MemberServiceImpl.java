package kr.or.ddit.mvc.service;

import java.util.List;

import kr.or.ddit.mvc.dao.IMemberDao;
import kr.or.ddit.mvc.dao.MemberDaoImpl;
import kr.or.ddit.mvc.vo.MemberVO;

public class MemberServiceImpl implements IMemberService {

	private IMemberDao dao; // DAO객체가 저장될 변수 선언
	
	// 생성자
	public MemberServiceImpl(){
		dao = new MemberDaoImpl(); // DAO객체 생성
	}
	
	@Override
	public int insertMember(MemberVO memVo) {
		// TODO Auto-generated method stub
		return dao.insertMember(memVo);
	}

	@Override
	public int deleteMember(String id) {
		// TODO Auto-generated method stub
		return dao.deleteMember(id);
	}

	@Override
	public int updateMember(MemberVO memVo) {
		// TODO Auto-generated method stub
		return dao.updateMember(memVo);
	}

	@Override
	public List<MemberVO> getAllMember() {
		// TODO Auto-generated method stub
		return dao.getAllMember();
	}

	@Override
	public int getMemberIdCount(String id) {
		// TODO Auto-generated method stub
		return dao.getMemberIdCount(id);
	}

}
