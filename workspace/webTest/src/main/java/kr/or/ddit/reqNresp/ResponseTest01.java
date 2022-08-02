package kr.or.ddit.reqNresp;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ResponseTest01
 */
// forward방식 연습용 서블릿
@WebServlet("/responseTest01.do")
public class ResponseTest01 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 
	 	- forward
	 		특정 서블릿에 대한 요청을 다른 서블릿이나 JSP로 넘겨준다.
	 		(이 때 파라미터를 넘길 수 있다.)
	 		URL주소는 처음 요청할 때의 값이 바뀌지 않으며 서버 내부에서만 
	 		접근이 가능하다.
	 		
	 */
	
	
	//	현재 페이지에서 만들어진 데이터를 이용되는 페이지로 넘기려면 
	//	Request객체의 setAttribute()메소드를 사용한다.
	//	형식) Request객체변수.setAttribute("키값", 데이터값)
	//		==> 키값은 문자열이고 데이터값은 자바에서 사용되는 모든 자료형을 사용할 수 있다.
	
	request.setAttribute("tel", "010-1234-5678");
	
	// forward방식으로 이동하기
	// ==> 이동할 서블릿이나 JSP의 주소는 ContextPath이후의 경로를 기술한다.
	// 이동할 원래의 주소가 '/webTest/responseForwardTest.do'일 경우
	//		==> '/reponseForwardTest.do'만 기술한다.
	RequestDispatcher rd = 
			request.getRequestDispatcher("/responseForwardTest.do");
	
	rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
