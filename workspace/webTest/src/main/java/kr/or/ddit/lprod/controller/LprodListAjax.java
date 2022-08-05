package kr.or.ddit.lprod.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import kr.or.ddit.lprod.service.ILprodService;
import kr.or.ddit.lprod.service.LprodServiceImpl;
import kr.or.ddit.vo.LprodVO;

/**
 * Servlet implementation class LprodListAjax
 */
@WebServlet("/lprodListAjax.do")
public class LprodListAjax extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Lprod 데이터의 목록을 가져와서 JSON형식으로 변환하여 응답으로 보내는 서블릿
		request.setCharacterEncoding("utf-8");
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		
		// service객체 생성
		ILprodService service = LprodServiceImpl.getInstance();
		
		Gson gson = new Gson();
		
		String jsonData = null; // JSON구조의 문자열 데이터를 저장할 변수
		
		// LPROD테이블 목록을 가져온다.
		List<LprodVO> lprodList = service.getAllLprod();
		
		// 가져온 목록을 JSON문자열로 변환한다.
		jsonData = gson.toJson(lprodList);
		
		// JSON문자열을 응답으로 전송한다.
		out.write(jsonData);
		response.flushBuffer();
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
