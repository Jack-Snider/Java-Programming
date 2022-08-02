<%@page import="kr.or.ddit.session.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	
		<%
		
			// JSP문서에서 세션은 'session'이라는 이름으로 이미 생성되어 저장되어 있다.
			MemberVO memVo = (MemberVO)session.getAttribute("loginMember");
		
		
		%>	
		
	</head>
	<body>
		
		<%
		
			if(memVo == null){ // 로그인이 안되었을 때...
				
			
		
		%>
		
	
		<form action="<%= request.getContextPath() %>/sessionDBLogin.do">
		
		
			<table border = "1">
			
				<tr>
				
					<td>
						<label>ID : </label> 
					</td>
					<td>
						<input type = "text" name = "userid" placeholder = "ID를 입력하세요">
					</td>
					
				
				</tr>
				
				<tr>
					<td>
						<label>PASS : </label> 
					</td>
					<td>
						<input type = "text" name = "pass" placeholder = "PASSWORD를 입력하세요">
					</td>
				</tr>
			
				<tr>
					<td colspan = "2" style = "text-align:center;">
						<input type = "submit" value = "Login">
					</td>
				</tr>
			
			
			</table>
			
		
		</form>
	
	<%
	
			}else{ // 로그인 성공했을 때
	
	%>
	
		<h3><%= memVo.getMem_name() %>님 반갑습니다.</h3>
		<a href = "<%= request.getContextPath() %>/sessionDBLogout.do">로그아웃</a>
	<%
	
			}
	
	%>
	
	</body>
</html>