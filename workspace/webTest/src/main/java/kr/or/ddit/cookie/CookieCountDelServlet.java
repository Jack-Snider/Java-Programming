package kr.or.ddit.cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CookieCountDelServlet
 */
@WebServlet("/cookieCountDelServlet.do")
public class CookieCountDelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();

		Cookie[] cookies = request.getCookies();

		if (cookies != null) {
			for (Cookie cookie : cookies) {
				String name = cookie.getName();
				// 쿠키이름이 'count'인 쿠키정보를 찾는다.
				if ("count".equals(name)) {
					cookie.setMaxAge(0); // 유지시간을 9으로 설정
					response.addCookie(cookie); // 쿠키를 추가하면 쿠키가 삭제된다.
				}
			}
		}

		out.println("<html><head><meta charset='utf-8'>");
		out.println("<title>Cookie 연습</title></head>");
		out.println("<body>");
		out.println("<h3>count가 초기화 되었습니다.</h3>");
		out.println("<br><br><br>");
		out.println("<a href=' " + request.getContextPath() + "/basic/cookie/cookieTest02.jsp'>시작문서로 이동하기</a>");
		out.println("</body></html>");

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
