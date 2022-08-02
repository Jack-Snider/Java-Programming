package kr.or.ddit.cookie;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// Cookie를 추가하는 서블릿
@WebServlet("/cookieAdd.do")
public class CookieAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset = utf-8");
		PrintWriter out = response.getWriter();

		// Cookie 저장하는 방법
		// 1. Cookie객체를 생성한다. => 쿠키의 'name값'과 '데이터값'은 묹열로 지정한다.
		// 형식) Cookie cookie변수 = new Cookie("쿠키이름", "쿠키값");
		// => '쿠키값'에 한글을 사용 할 경우 URIEncoder.encode()메서드로
		// 인코딩한 후 저장한다.
		Cookie nameCookie = new Cookie("name", URLEncoder.encode("잭 스나이더", "utf-8"));
		Cookie ageCookie = new Cookie("age", "23");
		Cookie genederCookie = new Cookie("gender", "Male");

		// 2. 쿠키 속서어 설졍
		// 쿠키변수.setPart("적응경로"); =>지정한 경로와 그 하위 경초에서 가용가능
		// 쿠키변수.setMaxAge(유지기간); => 단위(초)
		// => (-1 : 브라우저가 종료될 때까지만 유지된다.
		// 0 : 즉시 쿠키가 삭제된다.)
		// 쿠키변수.setDomain("적용도메인명");
		// 예) ".ddit.or.kr" => www.ddit.or.kr, mail.ddit.or.kr
		// 쿠키변수.setSecure(보안여부); => true(보안적용), false(보안 미적용)

		// 3.	response객체를 이용하여 쿠키를 웹브라우저로 보내면 웹브라우저가 이
		//		쿠키를 받아서 저장한다.
		// 형식)	response.addCookie( 1번에서 만든 쿠키변수 )
		
		response.addCookie(nameCookie);
		response.addCookie(ageCookie);
		response.addCookie(genederCookie);
		
		out.println("<html><head><meta charset = 'utf-8'>");
		out.println("<title>Cookie연습</title></head>");
		out.println("<body>");
		out.println("<h3>Cookie 데이터가 저장되었습니다.</h3><br><br>");
		out.println("<a href = '" + request.getContextPath() + ""
				+ "/basic/cookie/cookieTest.jsp'> 시작문서로 이동하기 </a>");
		out.println("</body></html>");
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}