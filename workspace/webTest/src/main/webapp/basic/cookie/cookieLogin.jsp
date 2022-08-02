<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
   form{
      border : 1px solid;
      width : 200px;
      height : 150px;
   }
</style>
</head>
<body>
   <%   
      // 이 JSP영역에서 쿠키는 서블릿에서와 같은 방법으로 사용하면 된다.
      String cookieUserId = ""; // 쿠키값이 저장될 변수
      String chk = ""; // 체크박스 체크용 변수
      Cookie[] cookies = request.getCookies(); // 쿠키정보 가져오기
      if(cookies != null){
         for(Cookie cookie : cookies){
            String name = cookie.getName();
            if("id".equals(name)){ // 내가 원하는 쿠키가 있으면 ...
               cookieUserId = cookie.getValue();
               chk = "checked";
            }
         }
      }
   %>
   <form action="<%= request.getContextPath() %>/cookieLoginServlet.do">
      <label>ID : </label>
      <input type="text" value="<%=cookieUserId %>" name="id"><br>
      <label>PASS : </label>
      <input type="text" name="pw"><br>
      <input type="checkbox" value="check" <%=chk %> name="check">id 기억하기<br>
      <input type="submit" value="Login">
   </form>
</body>
</html>