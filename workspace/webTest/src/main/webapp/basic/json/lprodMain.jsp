<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		
			<!--  
			   DB의 LPROD테이블의 목록을 출력하는 웹페이지를 2가지 방식으로 작성하시오.
			
			   하나는 Ajax를 이용한 비동기방식으로 작성하고,
			   다른 하나는 Ajax를 이용하지 않는 동기방식으로 작성하시오.
			      
			-->
		
		
		<script src="<%=request.getContextPath() %>/js/jquery-3.6.0.min.js"></script>
		
		<script>
			$(function(){
			   
				$( "#lprodBtn1" ).on( "click",function(){
					$.ajax({
						url : "<%=request.getContextPath()%>/lprodListAjax.do",
						type : "get",
						// data : // 전송할 데이터가 없으므로 생략
						success : function( resData ){
							let htmlCode = "<table border = '1'>";
							htmlCode += "<tr><td>LPROD_ID</td><td>LPROD_GU</td><td>LPROD_NM</td></tr>";
							$.each( resData, function( i,v ){
								htmlCode += "<tr><td>" + v.lprod_id + "</td>";
								htmlCode += "<td>" + v.lprod_gu + "</td>";
								htmlCode += "<td>" + v.lprod_nm + "</td></tr>";
								
							} ); // .each 끝
							
							htmlCode += "</table>";
							
							$( "#result" ).html( htmlCode );
							
						},
						
						error : function( xhr ){
							alert("오류 : " + xhr.code);
						},
						
						dataType : "json"
					});
				});
			   
			});
		</script>
	</head>
	<body>
		<form>
		   <input type="button" id="lprodBtn1" value="Lprod자료 가져오기(Ajax이용)">
		   <input type="button" id="lprodBtn2" value="Lprod자료 가져오기(Non Ajax)">
		</form>
		
		<h3>LPROD자료 목록</h3>
		<div id="result"></div>
		
	</body>
</html>