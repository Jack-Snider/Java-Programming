package kr.or.ddit.file.service;

import java.util.List;

import kr.or.ddit.file.dao.FileinfoDaoImpl;
import kr.or.ddit.file.dao.IFileinfoDao;
import kr.or.ddit.vo.FileinfoVO;

public class FileinfoServiceImpl implements IFileinfoService {
   
   private IFileinfoDao dao;
   
   private static IFileinfoService service;
   
   private FileinfoServiceImpl() {
      dao = FileinfoDaoImpl.getInstance();
   }
   
   public static IFileinfoService getInstance() {
      if(service==null) service = new FileinfoServiceImpl();
      return service;
   }
   
   @Override
   public int insertFileinfo(FileinfoVO fileinfoVo) {
      return dao.insertFileinfo(fileinfoVo);
   }

   @Override
   public List<FileinfoVO> getAllFileinfo() {
      return dao.getAllFileinfo();
   }

   @Override
   public FileinfoVO getFileinfo(int fileNo) {
      return dao.getFileinfo(fileNo);
   }

}