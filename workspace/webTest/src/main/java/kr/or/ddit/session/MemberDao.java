package kr.or.ddit.session;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberDao {
	
	private static MemberDao dao;
	
	private MemberDao() {}
	
	public static MemberDao getInstance() {
		if(dao == null) dao = new MemberDao();
		return dao;
	}
	
	public MemberVO getLoginMember(MemberVO paramvo) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		MemberVO memVo = null;
		
		try {
			
			conn = DBUtil.getConnection();
			
			String sql = "SELECT * FROM MYMEMBER WHERE MEM_ID = ? "
					+ "AND MEM_PASS = ? ";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, paramvo.getMem_id());
			pstmt.setString(2, paramvo.getMem_pass());
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				memVo = new MemberVO();
				memVo.setMem_id(rs.getString("MEM_ID"));
				memVo.setMem_pass(rs.getString("MEM_PASS"));
				memVo.setMem_name(rs.getString("MEM_NAME"));
				memVo.setMem_tel(rs.getString("MEM_TEL"));
				memVo.setMem_addr(rs.getString("MEM_ADDR"));
			}
			
		} catch (SQLException e) {
			memVo = null;
			e.printStackTrace();
		} finally {
			if(rs!=null) try {rs.close();} catch(SQLException e) {}
	         if(pstmt!=null) try {pstmt.close();} catch(SQLException e) {}
	         if(conn!=null) try {conn.close();} catch(SQLException e) {}
		}
		
		return memVo;
		
	}
	
}
