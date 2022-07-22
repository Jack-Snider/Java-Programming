package kr.or.ddit.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.mvc.vo.MemberVO;
import kr.or.ddit.util.DBUtil3;
import kr.or.ddit.util.SqlMapClientFactory;

public class MemberDaoImpl implements IMemberDao{
   
   //1번
   private static MemberDaoImpl dao;
   //2번
   private MemberDaoImpl() {
   }
   //3번
   public static MemberDaoImpl getInstance() {
      if(dao==null) dao = new MemberDaoImpl();
      
      return dao;
   }
   
   
   

   @Override
   public int insertMember(MemberVO memVo) {
      int cnt = 0; // 반환값이 저장될 변수
      SqlMapClient smc = null;
      try {
         smc = SqlMapClientFactory.getsqlMapClient();
         Object obj = smc.insert("Member.insertMember",memVo);
         if(obj==null) {
        	 cnt++;
         }
         
         
      } catch (SQLException e) {
         cnt = 0;
         e.printStackTrace(); 
      } 
      
      return cnt;
   }

   @Override
   public int deleteMember(String memId) {
      int cnt = 0;
      SqlMapClient smc = null;
      try {
         smc = SqlMapClientFactory.getsqlMapClient();
         
         cnt = smc.delete("Member.deleteMember",memId);
         
      } catch (SQLException e) {
         e.printStackTrace();
      } 
      
      return cnt;
   }

   @Override
   public int updateMember(MemberVO memVo) {
      int cnt = 0;
      SqlMapClient smc = null;
      
      
      try {
         smc = SqlMapClientFactory.getsqlMapClient();
         cnt = smc.update("Member.updateMember",memVo);   
         
      } catch (SQLException e) {
         e.printStackTrace();
      } 
      
      return cnt;
   }

   @Override
   public List<MemberVO> getAllMemberList() {  //반환값이 저장될 변수 선언
      List<MemberVO> memList;
      
      SqlMapClient smc = null;
      try {
         smc = SqlMapClientFactory.getsqlMapClient();
         
         memList = smc.queryForList("Member.selectAll");
         
      } catch (SQLException e) {
         memList = null;
         e.printStackTrace();
      } 
      
      return memList;
      
      /*
      List<MemberVo> list = new ArrayList<MemberVo>();
      Connection conn = null;
      Statement stmt = null;
      ResultSet rs = null;
      
      try {
         conn = DBUtil3.getConnection();
         String sql = "select * from mymember";
         stmt = conn.createStatement();
         rs = stmt.executeQuery(sql);
         
         while(rs.next()) {
            String memId = rs.getString("mem_id");
             String memPass = rs.getString("mem_pass");
             String memName = rs.getString("mem_name");
             String memTel = rs.getString("mem_tel");
             String memAddr = rs.getString("mem_addr");
             list.add(new MemberVO(memId, memPass, memName, memTel, memAddr));
         }
         
      } catch (SQLException e) {
         e.printStackTrace();
      } finally { 
         if(rs!=null) try { rs.close(); } catch(SQLException e) {}
         if(stmt!=null) try { stmt.close(); } catch(SQLException e) {}
         if(conn!=null) try { conn.close(); } catch(SQLException e) {}
      }
      
      return list;
      */
   }

   @Override
   public int getMemberCount(String memId) {
      int cnt = 0;
      SqlMapClient smc = null;
      
      try {
        smc = SqlMapClientFactory.getsqlMapClient();
        cnt = (int)smc.queryForObject("Member.checkMember",memId);
        
      } catch (SQLException e) {
         e.printStackTrace();
      } 
      
      return cnt;
   }

   @Override
   public int memberUpdate2(Map<String, String> paramMap) {
      //  Key값 정보 ==> 회원ID(memId), 수정할컬럼명(field), 수정할데이터(data)
      int cnt = 0;
      Connection conn = null;
      PreparedStatement pstmt = null;
      
      try {
         conn = DBUtil3.getConnection();
         
         String sql = "update mymember set " + paramMap.get("field") + " = ? "
                  + " where mem_id= ?";
            
         pstmt = conn.prepareStatement(sql);
         pstmt.setString(1, paramMap.get("data"));
         pstmt.setString(2, paramMap.get("memId"));
         
         cnt = pstmt.executeUpdate();
         
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         if(pstmt!=null) try { pstmt.close(); } catch(SQLException e) {}
         if(conn!=null) try { conn.close(); } catch(SQLException e) {}
      }
      
      return cnt;
   }
}

   /*
   @Override
   public int updateMember2(String memId, String updateField, String updateData) {
      int cnt = 0;
      Connection conn = null;
      PreparedStatement pstmt = null;
      
      try {
         conn = DBUtil3.getConnection();
         
         String sql = "update mymember set " + updateField + " = ? "
                  + " where mem_id= ?";
            
         pstmt = conn.prepareStatement(sql);
         pstmt.setString(1, updateData);
         pstmt.setString(2, memId);
         
         cnt = pstmt.executeUpdate();
         
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         if(pstmt!=null) try { pstmt.close(); } catch(SQLException e) {}
         if(conn!=null) try { conn.close(); } catch(SQLException e) {}
      }
      
      return cnt;
   }
   */