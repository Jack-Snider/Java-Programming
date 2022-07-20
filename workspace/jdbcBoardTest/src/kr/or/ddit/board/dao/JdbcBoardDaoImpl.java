package kr.or.ddit.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.or.ddit.board.vo.JdbcBoardVO;
import kr.or.ddit.util.DBUtil3;

/**
 * IJdbcBoardDao의 구현체
 * @author PC-04
 *
 */
public class JdbcBoardDaoImpl implements IJdbcBoardDao{

	private static JdbcBoardDaoImpl dao;
	
	private JdbcBoardDaoImpl() {}
	
	public static JdbcBoardDaoImpl getInstance() {
		if(dao == null) dao = new JdbcBoardDaoImpl();
		
		return dao;
	}
	
	@Override
	public int insertBoard(JdbcBoardVO boardVo) {
		// TODO Auto-generated method stub
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		int cnt = 0;
		
		try {
			conn = DBUtil3.getConnection();
			
			String sql = "INSERT INTO jdbc_board (BOARD_NO, BOARD_TITLE, BOARD_WRITER ,"
					+ "BOARD_DATE, BOARD_CNT, BOARD_CONTENT) "
					+ "VALUES(BOARD_SEQ.NEXTVAL, ?, ?, SYSDATE, 0, ?) ";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, boardVo.getBoard_title());
			pstmt.setString(2, boardVo.getBoard_writer());
			pstmt.setString(3, boardVo.getBoard_content());
			
			cnt  = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO: handle exception
			cnt = 0;
			e.printStackTrace();
		} finally {
			if(pstmt != null) try { pstmt.close(); } catch(SQLException e) {}
			if(conn != null) try { conn.close(); } catch(SQLException e) {}
		}
		
		return cnt;
	}

	@Override
	public int deleteBoard(int boardNo) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		int cnt = 0;
		
		try {
			conn = DBUtil3.getConnection();
			
			String sql = "DELETE FROM jdbc_board WHERE BOARD_NO = ? "; 
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNo);
			
			cnt  = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO: handle exception
			cnt = 0;
			e.printStackTrace();
		} finally {
			if(pstmt != null) try { pstmt.close(); } catch(SQLException e) {}
			if(conn != null) try { conn.close(); } catch(SQLException e) {}
		}
		
		return cnt;
	}

	@Override
	public int updateBoard(JdbcBoardVO boardVo) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		int cnt = 0;
		
		try {
			conn = DBUtil3.getConnection();
			
			String sql = "UPDATE jdbc_board SET BOARD_TITLE = ? , "
					+ "BOARD_DATE = SYSDATE, BOARD_CONTENT = ? "
					+ "WHERE BOARD_NO = ? ";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, boardVo.getBoard_title());
			pstmt.setString(2, boardVo.getBoard_content());
			pstmt.setInt(3, boardVo.getBoard_no());
			
			cnt  = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO: handle exception
			cnt = 0;
			e.printStackTrace();
		} finally {
			if(pstmt != null) try { pstmt.close(); } catch(SQLException e) {}
			if(conn != null) try { conn.close(); } catch(SQLException e) {}
		}
		
		return cnt;
	}

	@Override
	public JdbcBoardVO getBoard(int boardNo) {
	      Connection conn = null;
	      PreparedStatement pstmt = null;
	      ResultSet rs = null;
	      JdbcBoardVO boardVo = null;
	      
	      try {
	         String sql = "select"
	               +"board_no, board_title, board_writer,"
	               +"to_char(board_date, 'YYYY-MM-DD') board_date,"
	               + "board_cnt, board_content"
	               +"from jdbc_board where board_no = ?";
	         pstmt = conn.prepareStatement(sql);
	         pstmt.setInt(1, boardNo);
	         
	         rs = pstmt.executeQuery();
	         
	         if(rs.next()) {
	            boardVo = new JdbcBoardVO();
	            boardVo.setBoard_no(rs.getInt("board_no"));
	            boardVo.setBoard_title(rs.getString("board_title"));
	            boardVo.setBoard_writer(rs.getString("board_writer"));
	            boardVo.setBoard_date(rs.getString("board_date"));
	            boardVo.setBoard_cnt(rs.getInt("board_cnt"));
	            boardVo.setBoard_content(rs.getString("board_contet"));
	            
	            
	         }
	         
	         
	      } catch (SQLException e) {
	         boardVo = null;
	         e.printStackTrace();
	      }finally {
	         if(rs!=null)try {rs.close();}catch(SQLException e) {}
	         if(pstmt!=null)try {pstmt.close();}catch(SQLException e) {}
	         if(conn!=null)try {conn.close();}catch(SQLException e) {}
	      }
	      
	      return boardVo;
	   }

	@Override
	public List<JdbcBoardVO> getAllBoardList() {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<JdbcBoardVO> boardList = null;
		
		try {
			
			String sql = "SELECT "
					+ "BOARD_NO, BOARD_TITLE, BOARD_WRITER. "
					+ "to_char(BOARD_DATE, 'YYYY-MM-DD') BOARD_dATE, "
					+ "BOARD_CNT, BOARD_CONTENT "
					+ "FROM jdbc_board"
					+ "ORDER BY BOARD_NO DESC ";
			
			pstmt = conn.prepareStatement(sql);
			
			
			
			rs = pstmt.executeQuery();
			
			boardList = new ArrayList<JdbcBoardVO>();
			
			 while(rs.next()) {
				 	JdbcBoardVO dvo = new JdbcBoardVO();
				 	dvo.setBoard_no(rs.getInt("board_no"));
				 	dvo.setBoard_title(rs.getString("board_title"));
				 	dvo.setBoard_writer(rs.getString("board_writer"));
				 	dvo.setBoard_date(rs.getString("board_date"));
				 	dvo.setBoard_cnt(rs.getInt("board_cnt"));
				 	dvo.setBoard_content(rs.getString("board_contet"));
		            
				 	boardList.add(dvo);
		            
		         }
					
		} catch (Exception e) {
			// TODO: handle exception
			boardList = null;
		} finally {
	         if(rs!=null)try {rs.close();}catch(SQLException e) {}
	         if(pstmt!=null)try {pstmt.close();}catch(SQLException e) {}
	         if(conn!=null)try {conn.close();}catch(SQLException e) {}
	      }
		
		return boardList;
		
	}

	@Override
	public List<JdbcBoardVO> getSearchBoardList(String title) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<JdbcBoardVO> boardList = null;
		
		if(title == null) title = "";
		
		try {
			
			String sql = "SELECT "
					+ "BOARD_NO, BOARD_TITLE, BOARD_WRITER. "
					+ "to_char(BOARD_DATE, 'YYYY-MM-DD') BOARD_dATE, "
					+ "BOARD_CNT, BOARD_CONTENT "
					+ "FROM jdbc_board "
					+ "WHERE BOARD_TITLE LIKE '%' || ? || '%' "
					+ "ORDER BY BOARD_NO DESC ";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, title);
			
			rs = pstmt.executeQuery();
			
			boardList = new ArrayList<JdbcBoardVO>();
			
			 while(rs.next()) {
				 	JdbcBoardVO dvo = new JdbcBoardVO();
				 	dvo.setBoard_no(rs.getInt("board_no"));
				 	dvo.setBoard_title(rs.getString("board_title"));
				 	dvo.setBoard_writer(rs.getString("board_writer"));
				 	dvo.setBoard_date(rs.getString("board_date"));
				 	dvo.setBoard_cnt(rs.getInt("board_cnt"));
				 	dvo.setBoard_content(rs.getString("board_contet"));
		            
				 	boardList.add(dvo);
		            
		         }
					
		} catch (Exception e) {
			// TODO: handle exception
			boardList = null;
		} finally {
	         if(rs!=null)try {rs.close();}catch(SQLException e) {}
	         if(pstmt!=null)try {pstmt.close();}catch(SQLException e) {}
	         if(conn!=null)try {conn.close();}catch(SQLException e) {}
	      }
		
		return boardList;
		
	}

	@Override
	public int boardCountIncrement(int boardNo) {
		// TODO Auto-generated method stub
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		int cnt = 0; // 반환값이 저장될 변수
		
		try {
			conn = DBUtil3.getConnection();
			
			String sql =	"UPDATE jdbc_board SET BOARD_CNT = BOARD_CNT + 1 "
							+	"WHERE BOARD_NO = ? ";
					
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNo);
			
			cnt = pstmt.executeUpdate();
			
			
			
		} catch (SQLException e) {
			// TODO: handle exception
			cnt = 0;
			e.printStackTrace();
		} finally {
	         if(pstmt!=null)try {pstmt.close();}catch(SQLException e) {}
	         if(conn!=null)try {conn.close();}catch(SQLException e) {}
		}
		
		return cnt;
	}

}

















