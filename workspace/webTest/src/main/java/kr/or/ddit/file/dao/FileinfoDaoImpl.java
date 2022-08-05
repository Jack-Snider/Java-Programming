package kr.or.ddit.file.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.util.SqlMapClientFactory;
import kr.or.ddit.vo.FileinfoVO;

public class FileinfoDaoImpl implements IFileinfoDao {
   private SqlMapClient smc;
   
   private static FileinfoDaoImpl dao;
   
   private FileinfoDaoImpl() {
      smc = SqlMapClientFactory.getsqlMapClient();
      
   }
   
   public static FileinfoDaoImpl getInstance() {
      if(dao==null) dao = new FileinfoDaoImpl();
      
      return dao;
   }

   @Override
   public int insertFileinfo(FileinfoVO fileinfoVo) {
      
      int cnt = 0;   // 변환값이 저장될 변수
      
      try {
        if(smc.insert("fileinfo.insertFileinfo",fileinfoVo)==null)   
        cnt = 1;
        
      } catch (SQLException e) {
         cnt = 0;
         e.printStackTrace();
      }
      return cnt;
   }

   @Override
   public List<FileinfoVO> getAllFileinfo() {
      List<FileinfoVO> fileList = null;   // 변환값이 저장될 변수 
      
      try {
         fileList = smc.queryForList("fileinfo.getAllFileinfo");
      } catch (SQLException e) {
         fileList = null;
         e.printStackTrace();
         
      }
      return fileList;
   }

   @Override
   public FileinfoVO getFileinfo(int fileNo) {
      FileinfoVO fileVo = null;   // 반환값이 저장될 변수
      
      try {
         fileVo = (FileinfoVO)smc.queryForObject("fileinfo.getFileinfo", fileNo);
      } catch (Exception e) {
         fileVo = null;
         e.printStackTrace();
      }
      
      
      return fileVo;
   }

}