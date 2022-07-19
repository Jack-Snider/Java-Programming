package kr.or.ddit.board.service;

import java.util.List;

import kr.or.ddit.board.dao.IJdbcBoardDao;
import kr.or.ddit.board.dao.JdbcBoardDaoImpl;
import kr.or.ddit.board.vo.JdbcBoardVO;

// Service 구현체
public class JdbcBoardServiceImpl implements IJdbcBoardService{

	private IJdbcBoardDao dao;
	
	private static JdbcBoardServiceImpl service;
	
	private JdbcBoardServiceImpl() {
		dao = JdbcBoardDaoImpl.getInstance();
	}
	
	public static JdbcBoardServiceImpl getInstance() {
		if(service == null) service = new JdbcBoardServiceImpl();
		
		return service;
	}
	
	@Override
	public int insertBoard(JdbcBoardVO boardVo) {
		// TODO Auto-generated method stub
		return dao.insertBoard(boardVo);
	}

	@Override
	public int deleteBoard(int boardNo) {
		// TODO Auto-generated method stub
		return dao.deleteBoard(boardNo);
	}

	@Override
	public int updateBoard(JdbcBoardVO boardVo) {
		// TODO Auto-generated method stub
		return dao.updateBoard(boardVo);
	}

	@Override
	public JdbcBoardVO getBoard(int boardNo) {
		// TODO Auto-generated method stub
		int cnt = dao.boardCountIncrement(boardNo); 	// 조회수 증가
		if(cnt == 0) {		// 조회수 증가 실패
			return null;
		}
		return dao.getBoard(boardNo);
	}

	@Override
	public List<JdbcBoardVO> getAllBoardList() {
		// TODO Auto-generated method stub
		return dao.getAllBoardList();
	}

	@Override
	public List<JdbcBoardVO> getSearchBoardList(String title) {
		// TODO Auto-generated method stub
		return dao.getSearchBoardList(title);
	}

	@Override
	public int boardCountIncrement(int boardNo) {
		// TODO Auto-generated method stub
		return dao.boardCountIncrement(boardNo);
	}

}
