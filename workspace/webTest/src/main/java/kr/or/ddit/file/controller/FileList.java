package kr.or.ddit.file.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.file.service.FileinfoServiceImpl;
import kr.or.ddit.file.service.IFileinfoService;
import kr.or.ddit.vo.FileinfoVO;

/**
 * Servlet implementation class FileList
 */
@WebServlet("/fileList.do")
public class FileList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// DB에서 파일 목록 정보를 가져와 view페이지로 넘겨준다.
		
	      // service객체 생성
	      IFileinfoService service = FileinfoServiceImpl.getInstance();
	      
	      // DB에서 파일 목록 정보를 가져온다.
	      List<FileinfoVO> fileList = service.getAllFileinfo();
	      
	      // 가져온 파일 목록 정보를 포워딩으로 View페이지에 보내준다.
	      request.setAttribute("fileList", fileList);
	      
	      request.getRequestDispatcher("/basic/fileupload/fileList.jsp").forward(request, response);
	      
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
