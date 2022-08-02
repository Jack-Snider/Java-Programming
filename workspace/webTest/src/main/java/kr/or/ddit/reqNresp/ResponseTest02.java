package kr.or.ddit.reqNresp;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ResponseTest02
 */
//redirect방식 연습용 서블릿
@WebServlet("/responseTest02.do")
public class ResponseTest02 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 
		 	- redirect방식
		 		단순히 다른 페이지로 이동할 때 사용한다.
		 			(직접 파라미터를 넘길 수 없다. ==> 
		 			Request객체와 Response객체를 공유하지 않는다.
		 			응답시 브라우저에게 '이동할 URL'을 전송하여 브라우저가 해당 URL로
		 			이동하는 방식이다. 이 때는 GET방식으로 요청하기 때문에 URL의 길이에 제한이 있다.
		 
		 */
		
		/*
		// redirect는 Request객체를 유지하지 못한다.
		// (이유 : 브라우저에서 새롭게 요청하기 때문에...)
		
		request.setAttribute("tel", "010-9999-8888");
		
		// redirect방식으로 이동하기
		//	==> 이동할 URL의 전체 주소를 기술한다.
		response.sendRedirect(request.getContextPath() + "/responseRedirectTest.do");
		*/
		
		// 이 페이지에서 만들어진 데이터를 redirect페이지로 보내려면 
		// GET방식으로 URL주소를 구성해서 보낼 수 있다.[]
		
		String userName = request.getParameter("username");
		String tel = "010-9999-8888";
		
		response.sendRedirect(
				request.getContextPath() +
				"/responseRedirectTest.do?username=" + userName
				+ "&tel=" + tel);
	
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
