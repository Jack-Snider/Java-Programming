package kr.or.ddit.reqNresp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RequestTest01
 */
@WebServlet("/requestTest01.do")
public class RequestTest01 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// POST방식으로 전달되는 데이터의 문자 인코딩 방식 지정하기
		request.setCharacterEncoding("utf-8");
		
		// 클라이언트가 보낸 데이터 받기
		// Request객체의 getParameter()메소드를 이용한다.
		// 형식) request객체변수.getParameter("파라미터명")
		// 		==> 해당 '파라미터명'에 설정된 '데이터값'을 가져온다.
		//		==> 가져오는 '데이터값'의 자료형은 String이다.
		//		==> '파라미터명'은 form태그 안의 하위 객체의 name속성값과 같다. ( ★★★★★ )
		//		==> 
		String userName = request.getParameter( "uesername" );	// input태그 	
		String job = request.getParameter( "job" ); // selection:option태그
		
		// '파라미터명'이 같은 것이 여러개일 경우(ex. checkbox같은 경우(다중선택 가능하니까~) 
		//  ==> getParameterValues()메소드 사용
		//	형식) request객체변수.getParameterValues( "파라미터명" );
		//	==> 가져오는 '데이터값'의 자료형은 'String[]'이다.
		
		//	'form의 체크박스 값들을 모두 읽어오기 ( name속성이 'hobby'일 때 )
		String[] hobbies = request.getParameterValues( "hobby" ); // 여러개의 input태그( 체크박스 )
		
		response.setCharacterEncoding( "utf-8" );
		response.setContentType( "text/html; charset=utf-8" );
		PrintWriter out = response.getWriter();
		
		out.println( "<html><head><meta charset = 'utf-8'>" );
		out.println( "<title>Request객체 연습</title></head>" );
		out.println( "<body>" );
		
		out.println( "<h3>request 테스트 결과</h3>");
		out.println( "<table border = '1'>");
		out.println( "<tr><td>이 름</td>");
		out.println( "<td>" + userName + "</td></tr>");
		out.println( "<tr><td>직 업</td>");
		out.println( "<td>" + job + "</td></tr>" );
		
		out.println( "<tr><td>취 미</td>" );
		out.println( "<td>" );
		if( hobbies != null ) {
			// 배열 개수만큼 반복해서 처리한다.
			for( String hobby : hobbies ) {
				out.println( hobby + "<br>" );
			}
		}
		out.println( "</td></tr>" );
		out.println( "</table>" );
		out.println( "</body></html>" );
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
