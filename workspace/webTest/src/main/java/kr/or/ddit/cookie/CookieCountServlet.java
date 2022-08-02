package kr.or.ddit.cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cookieCountServlet.do")
public class CookieCountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();

		int cnt = 1;
		Cookie[] cookieArr = request.getCookies();

		for (Cookie cookie : cookieArr) {
			if ("count".equals(cookie.getName())) {
				cnt = Integer.parseInt(cookie.getValue()) + 1;
			}
		}
		Cookie cookieCount = new Cookie("count", Integer.toString(cnt));
		response.addCookie(cookieCount);

		out.println("<html><head><meta charset='utf-8'>");
		out.println("<title>Cookie연습</title></head>");
		out.println("<body>");
		out.println("어서오세요. 당신은 " + cnt + "번째 방문입니다.<br>");
		out.println("<a href=' " + request.getContextPath() + "/cookieCountServlet.do'>카운트 증가하기</a>");
		out.println("<a href=' " + request.getContextPath() + "/basic/cookie/cookieTest02.jsp'>시작문서로 이동하기</a>");
		out.println("</body></html>");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}