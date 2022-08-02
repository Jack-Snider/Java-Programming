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
 * Servlet implementation class CookieDelete
 */
@WebServlet("/cookieDelete.do")
public class CookieDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		// 저장된 쿠키 삭제하기
		
		// 1.	쿠키 데이터의 삭제는 쿠키의 유지 시간을 0으로 설정하는 방법을 사용한다.
		//		쿠키의 수명은 쿠키를 저장하는 addCookie()메소드를 호출하기 전에
		//		해당 쿠키 객체의 setMaxAge()메소드를 호출해서 설정한다.
		
		// 형식) cookie변수.setMaxAge(0);
		
		Cookie[] cookieArr = request.getCookies();
		
		out.println("<html><head><meta charset = 'utf-8>");
		out.println("<title>Cookie 연습</title></head>");
		out.println("<body>");
		out.println("<h3>저장된 쿠키 삭제하기</h3>");
		
		if(cookieArr == null || cookieArr.length == 0) {
			out.println("<h3>저장된 쿠키가 하나도 없습니다.");
		}else {
			// 2. 쿠키 배열에서 삭제할 쿠키 정보를 구해온다.
			for(Cookie cookie : cookieArr) {
				String name = cookie.getName(); // 쿠키이름 구하기
				
				// 삭제하려는 쿠키인지 여부를 확인하여 삭제한다.
				if("gender".equals(name)) {
					cookie.setMaxAge(0); // 삭제하려는 쿠키의 유지시간을 0으로
										// 설정한다.
					
					response.addCookie(cookie);
					
				}
				
			}
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
