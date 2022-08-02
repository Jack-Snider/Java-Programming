package kr.or.ddit.session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

// 세션 정보를 삭제하는 서블릿
@WebServlet("/sessionDelete.do")
public class SessionDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Session 정보 삭제하기
		
		// 1. Session객체를 생성하거나 현재 세션 가져오기
		HttpSession session = request.getSession();
		
		// 2. Session정보 삭제하기
		// 2-1. 세션 자체는 삭제하지 않고 개별적인 세션값만 삭제하기
		// 		==> removeAttribute()메소드 이용
		// 형식) session객체변수.removeAttribute("삭제할 key값");
		session.removeAttribute("testSession");
		
		// 2-2. 세션 자체를 삭제하기 ==> 세션의 모든 정보가 삭제된다.
		//		==> invalidate
		// 형식) session객체변수.invalidate();
		//session.invalidate();
		
		
		
//-------------------------------------------------------------------		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.println("<html><head><meta charset = 'utf-8'>");
		out.println("<title> 세션 연습 </title>");
		out.println("<body>");
		out.println("<h3> 저장된 Session 삭제하기 </h3>");
		
		
		out.println("<a href='"+request.getContextPath()+"/basic/session/sessionTest.jsp'>시작문서로 가기</a>");
		out.println("</body></html>");
		
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
