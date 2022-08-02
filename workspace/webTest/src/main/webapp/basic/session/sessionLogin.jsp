<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Session 로그인</title>
</head>
<%
     // session 처리 위해서 스크립트릿이라는 공간을 만들고...
     //JSP문서에서 세션은 'session'이라는 이름으로 이미 생성되어 저장되어 있다.  
     String loginId = (String)session.getAttribute("LOGINID");
     // 세션이 LOGINID안에 없으면 null값, 있으면 값이 아옴. null 여부 검사해야.
         
%>
<body>
<%
      if(loginId==null){            //로그인이 안되었을 때....
%>

<form action="<%=request.getContextPath()%>/sessionLogin.do">
<table border ="1">
   <tr>
      <td>ID : </td>
      <td> <input type="text" name = "userid" value="" placeholder="ID를 입력하세요">  </td>
   </tr>
   
   <tr>
      <td>PASS : </td>
      <td> <input type="password" name = "pass" value="" placeholder="password를 입력하세요">  </td>
   </tr>
   
   <tr>
      <td colspan="2" style="text-align: center;"> <input type="submit" value="Login"> </td>
   </tr>
</table>
</form>
<%
      }else{            //로그인 성공했을 때
%>

   <h3><%=loginId%> 님 반갑습니다</h3>
   <a href ="<%=request.getContextPath()%>/sessionLogout.do">로그아웃</a>
   
<%
      }
%>

</body>
</html>