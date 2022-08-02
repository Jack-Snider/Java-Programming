package kr.or.ddit.basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 이 예제는 애노테이션(@WebServlet)을 이용하여 Servlet을 등록하여 처리하는 예제
// 애노테이션(@WebServlet)은 Servlet버전 3.0이상에서 사용할 수 있다.

/*
 
	- @WebServlet 애노테이션의 속성들
	1. name : 서블릿의 이름을 설정한다. (기본값 : 빈문자열(""))
	2. urlPatterns : 서블릿의 URL패턴의 목록을 설정한다.(기본값 : 빈배열( {} ) )
		예1) urlPatterns = "/url" 또는 urlPatterns = {"/url1"}
 				==> 패턴이 1개일 경우
 		예2) urlPatterns = {"/url1", "/url2", ...}
 				==> 패턴이 여러개일 경우
 	3. value : urlPatterns와 동일한 기능을 한다.
 	4. description : 주석(설명글)을 설정한다.
 
*/

@WebServlet(	description = "애노테이션을 이용한 서블릿.",
				urlPatterns = {"/servletTest02.do"})
public class ServletTest02 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setCharacterEncoding("UTF-8"); // 응답문서의 인코딩방식 지정
		response.setContentType("text/html; charset = utf-8"); // 응답문서의 
		
		// 처리한 내용을 응답으로 보내기 위해서 printWriter객체를 생성한다.
		PrintWriter out = response.getWriter();
		
		// 처리한 내용을 출력한다. ( 응답문서 작성하기 )
		// 방법2 ) print()메소드 또는 println()메소드 이용하기
		out.println("<html><head><meta charset = utf-8>");
		out.println("<title> 두번째 서블릿 </title></head>");
		out.println("<body>");
		out.println("<h1 style = 'text-align:center'>");
		out.println("반갑습니다 @WebServlet을 이용한 서블릿 등록입니다. <br>");
		out.println("실행 위치 : " + request.getContextPath());
		out.println("</h1></body></html>");
		
		
	}
	
	
	
	
	
}
