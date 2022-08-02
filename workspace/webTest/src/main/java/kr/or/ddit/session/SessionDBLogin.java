package kr.or.ddit.session;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SessionDBLogin
 */
@WebServlet("/sessionDBLogin.do")
public class SessionDBLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		// 사용자가 입력한 userid와 pass값을 얻어온다.
		String userId = request.getParameter("userid");
		String pass = request.getParameter("pass");
		
		// id와 pass를 VO에 저장한다.
		MemberVO paramVo = new MemberVO();
		paramVo.setMem_id(userId);
		paramVo.setMem_pass(pass);
		
		// Dao의 로그인 관련 메소드를 호출하여 결과를 받아온다.
		MemberDao dao = MemberDao.getInstance(); // DAO객체 설정
		
		MemberVO memVo = dao.getLoginMember(paramVo);
		
		HttpSession session = request.getSession();
		
		if(memVo != null) { // 로그인 성송
			session.setAttribute("loginMember", memVo);
			
		}
		
		
		response.sendRedirect(request.getContextPath()
				+ "/basic/session/sessionDBLogin.jsp");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
