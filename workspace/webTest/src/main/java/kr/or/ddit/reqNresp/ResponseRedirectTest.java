package kr.or.ddit.reqNresp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ResponseRedirectTest
 */
// redirect방식으로 이동될 서블릿
@WebServlet("/responseRedirectTest.do")
public class ResponseRedirectTest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*
		// 파라미터 값
		String userName = request.getParameter("username");

		// setAttribute()메소드로 셋팅한 데이터 받기
		// ==> getAttribute()메소드 이용
		// 형식) Request객체변수.getAttribute("키값", 데이터값)
		String tel = (String) request.getAttribute("tel");
		*/
		
		String userName = request.getParameter("username");
		String tel = request.getParameter("tel");
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset = utf-8");

		PrintWriter out = response.getWriter();

		out.println("<html><head><meta = charset='utf-8'>");
		out.println("<title> Forward방식 연습</title></head>");
		out.println("<body>");
		out.println("<h3>Redirect 처리 결과</h3>");
		out.println("<table border = '1'>");
		out.println("<tr><td>이름</td><td>" + userName + "</td></tr>");
		out.println("<tr><td>전화번호</td><td>" + tel + "</td></tr>");
		out.println("</table></body></html>");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
