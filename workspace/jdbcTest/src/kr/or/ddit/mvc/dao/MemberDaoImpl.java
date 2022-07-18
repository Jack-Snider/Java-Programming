package kr.or.ddit.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import kr.or.ddit.mvc.vo.MemberVO;
import kr.or.ddit.util.DBUtil;

public class MemberDaoImpl implements IMemberDao {

	// 1번
	private static MemberDaoImpl dao;
	
	// 2번
	private MemberDaoImpl() {}
	
	// 3번
	public static MemberDaoImpl getInstance() {
		
		if(dao == null) dao = new MemberDaoImpl();
		
		return dao;
	}
	
	
	@Override
	public int insertMember(MemberVO memVo) {
		// TODO Auto-generated method stub
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		int cnt = 0; // 반환값이 저장될 변수 선언

		try {

			conn = DBUtil.getConnection();

			String sql = "INSERT INTO MYMEMBER " + "(MEM_ID, MEM_PASS, MEM_NAME, MEM_TEL, MEM_ADDR) "
					+ "VALUES (?, ?, ?, ?, ?)";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memVo.getMem_id());
			pstmt.setString(2, memVo.getMem_pass());
			pstmt.setString(3, memVo.getMem_name());
			pstmt.setString(4, memVo.getMem_tel());
			pstmt.setString(5, memVo.getMem_addr());

			cnt = pstmt.executeUpdate();

		} catch (SQLException e) {

			cnt = 0;
			e.printStackTrace();

		} finally {

			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}

		}

		return cnt;
	}

	@Override
	public int deleteMember(String id) {
		// TODO Auto-generated method stub

		Connection conn = null;
		PreparedStatement pstmt = null;
		int cnt = 0;

		try {

			conn = DBUtil.getConnection();

			String sql = "DELETE FROM MYMEMBER WHERE MEM_ID = ?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);

			cnt = pstmt.executeUpdate();

		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		} finally {

			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}

		}

		return 0;
	}

	@Override
	public int updateMember(MemberVO memVo) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		int cnt = 0;

		try {

			conn = DBUtil.getConnection();

			String sql = "UPDATE MYMEMBER SET " + " MEM_PASS = ? , MEM_NAME = ? " + " MEM_TEL = ? , MEM_ADDR = ?"
					+ " WHERE MEM_ID = ?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memVo.getMem_pass());
			pstmt.setString(2, memVo.getMem_name());
			pstmt.setString(3, memVo.getMem_tel());
			pstmt.setString(4, memVo.getMem_addr());
			pstmt.setString(5, memVo.getMem_id());

			cnt = pstmt.executeUpdate();

		} catch (SQLException e) {

			cnt = 0;
			e.printStackTrace();

		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}

		return 0;
	}

	@Override
	public List<MemberVO> getAllMember() {
		// TODO Auto-generated method stub

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		List<MemberVO> memList = null; // 반환값이 저장될 변수 선언

		try {

			conn = DBUtil.getConnection();
			String sql = "SELECT * FROM MYMEMBER";

			stmt = conn.createStatement();

			rs = stmt.executeQuery(sql);

			memList = new ArrayList<MemberVO>(); // List 객체 생성
			while (rs.next()) { // 레코드 개수만큼 반복
				MemberVO memVo = new MemberVO(); // 1개의 레코드가 저장될 변수 선언

				// VO 객체에 DB에서 가져온 컬럼값들을 저장한다.
				memVo.setMem_id(rs.getString("MEM_ID"));
				memVo.setMem_pass(rs.getString("MEM_PASS"));
				memVo.setMem_name(rs.getString("MEM_NAME"));
				memVo.setMem_tel(rs.getString("MEM_TEL"));
				memVo.setMem_addr(rs.getString("MEM_ADDR"));

				memList.add(memVo);

			}

		} catch (SQLException e) {
			memList = null;
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
				}
			}
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}

		return memList;
	}

	@Override
	public int getMemberIdCount(String id) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		int count = 0;
		try {

			conn = DBUtil.getConnection();

			String sql = " SELECT COUNT(*) CNT FROM MYMEMBER " + " WHERE MEM_ID = ? ";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				count = rs.getInt("CNT");
			}

		} catch (SQLException e) {
			// TODO: handle exception
		}

		return count;
	}

	@Override
	public int updateMember2(Map<String, String> paramMap) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		int cnt = 0;
		
		// key값 정보 : 회원ID(memid), 수정할 컬럼명(field), 수정할 데이터(data)
		try {
			conn = DBUtil.getConnection();
			
			// paramMap에 저장된 key값을 이용하여 쿼리문을 작성하고
			// 쿼리문에 들어갈 데이터를 세팅하는 작업을 진행한다.
			String sql = "UPDATE MYMEMBER SET " + paramMap.get("field") 
			+ " = ? WHERE MEM_ID = ? ";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, paramMap.get("data"));
			pstmt.setString(2, paramMap.get("memid"));
			
			cnt = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		}
		
		return cnt;
		
	}

}
