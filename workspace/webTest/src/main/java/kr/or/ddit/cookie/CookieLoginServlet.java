package kr.or.ddit.cookie;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cookieLoginServlet.do")
public class CookieLoginServlet extends HttpServlet {

   private static final long serialVersionUID = 1L;

   protected void doGet(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
      request.setCharacterEncoding("utf-8");
      response.setCharacterEncoding("utf-8");
      response.setContentType("text/html; charset=utf-8");
      
      // id, pw, check 정보 받아오기
      String check = request.getParameter("check"); 
      // checkbox가 체크 되었을 때 value 값이 넘어오고 체크 안되었을 때 null 값이 넘어온다.
      String id = request.getParameter("id");
      String pw = request.getParameter("pw");
      
      // id를 값으로 저장하는 cookie 객체 생성
      Cookie cookie = new Cookie("id", id);
      
      // 체크박스의 체크 여부를 확인하여 쿠키를 저장하거나 삭제한다.
      if (check != null) { // 체크박스가 체크되었을 때...
         // 쿠키를 저장한다.
         response.addCookie(cookie);
      } else { // 체크박스가 해제되었을 때...
         // 쿠키를 삭제한다.
         cookie.setMaxAge(0);
         response.addCookie(cookie);
         }
      // -----------------------------------------------------------------------------------
      // 로그인 성공 여부를 확인하여 처리한다.
      // id, pw의 null 값 여부를 체크한다.
      if(id != null && pw != null) {
         if("test".equals(id) && "1234".equals(pw)) { // 로그인 성공
            // cookieMain.jsp 문서로 이동
            response.sendRedirect(request.getContextPath() + "/basic/cookie/cookieMain.jsp");
         }else { // 로그인 실패
            // cookieLogin.jsp 문서로 이동
            response.sendRedirect(request.getContextPath() + "/basic/cookie/cookieLogin.jsp");
         }
      }
      
   }

   protected void doPost(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
      doGet(request, response);
   }

}