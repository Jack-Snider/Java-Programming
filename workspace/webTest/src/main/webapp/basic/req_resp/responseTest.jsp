<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Jack Snider</title>
	</head>
	<body>
		
		<h3>forward, sendRedirect 연습</h3>
		<form action="/webTest/responseTest01.do" method = "post">
			forward action : <input type = "text" name = "username">
			<input type = "submit" value = "확인">	
		</form>
		
		<hr>
		
			<form action="/webTest/responseTest02.do" method = "post">
			forward action : <input type = "text" name = "username">
			<input type = "submit" value = "확인">	
		</form>
		
	</body>
</html>