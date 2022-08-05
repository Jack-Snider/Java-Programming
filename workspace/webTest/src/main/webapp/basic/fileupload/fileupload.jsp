<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<h3>File Upload 연습</h3>
		<!--
		 File을 업로드할 form은 반드시 POST방식
		 enctype속성에 'multipart/form-data'를 지정해야 한다.
		-->
		<form method = "post" enctype = "multipart/form-data"
			action = "<%=request.getContextPath() %>/fileUpload.do">
		
		-작성자 이름 : <input type = 'text' name = 'username'> <br> <br>
		- 한 개 파일 선택 : <input type = 'file' name = "uploadfile1"> <br> <br>
		- 여러개 파일 선택 : <input type = 'file' name = "uploadfile2" multiple> <br> <br>
		
		<input type = "submit" value = "전송하기">
			
		</form>
		
		<br><br>
		<a href = "<%=request.getContextPath()%>/fileList.do">전체 파일 목록 보기</a>
		
	</body>
</html>