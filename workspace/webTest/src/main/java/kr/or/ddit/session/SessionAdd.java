package kr.or.ddit.session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

// Session정보를 추가하는 서블릿
@WebServlet("/sessionAdd.do")
public class SessionAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Session정보 저장하는 방법
		
		// 1. Session객체 생성하거나 현재 세션 정보 가져오기
		// 형식) Request객체변수.getSession(); 또는 Request객체변수.getSession(true);
		// 	=> 현재 세션이 존재하면 현재 세션을 반한하고, 존재하지 않으면 새로운 세션을 생성한다.
		// 형식2) Request객체변수.getSession(false)
		//	=>	현재 세션이 존재하면 현재 세션을 반환하고 존재하지 않으면
		//		새로운 세션을 생성하지 않고 null을 반환한다.
		
		HttpSession session = request.getSession();
		
		// 2. setAttribute()메소드로 Session에 필요한 데이터를 저장한다.
		// 형식) session객체변수.setAttribute("키값", 데어터값);
		//		==> '키값'은 문자열, '데이터값'은 자바의 모든 자료형을 사용할 수 있다.
		
		session.setAttribute("testSession", "연습용 세션입니다.");
		session.setAttribute("userName", "홍길동");
		session.setAttribute("age", 30);
		
		//------------------------------------------------------
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset = utf-8");
		PrintWriter out = response.getWriter();
		
		out.println("<html><head><meta charset = 'utf-8'>");
		out.println("<title> 세션 엽습 </title>");
		out.println("<body>");
		
		out.println("<h3>Session 데이터가 저장되었습니다.</h3><br><br>");
		
		out.println("<a href = '" + request.getContextPath() + "/basic"
				+ "/session/sessionTest.jsp'> 시작문서로 돌아가기 </a>");
		
		out.println("</body></html>");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
