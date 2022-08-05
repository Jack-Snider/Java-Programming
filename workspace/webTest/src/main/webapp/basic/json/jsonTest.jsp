<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-3.6.0.min.js"></script>
		<script>
			$(function(){
			    $("#strBtn").on("click", function(){
			      
			       $.ajax({
			      
			          url : "<%=request.getContextPath()%>/jsonServlet.do",  // 요청할 URL주소
			          type : "POST",    // 전송방식 (GET 또는 POST)
			          data : "choice=str",    // 전송할 데이터 (choice : 파라미터, str = 값)
			          success : function(resData){    // 응답 성공시 처리하는 함수
			            // 응답데이터는 'resData'변수에 자동으로 저장된다. 
			            $("#result").html(resData);
			            
			          },
			          error : function(xhr) {  // 오류 발생시 처리하는 함수
			             alert("오류 발생");
			             
			          },
			          dataType : "json"     // 응답 데이터의 종류 지정 (text, html, xml 등을 지정할 수 있다.)
			       });
			       
			       
			       
			       
			    });
			    //-------------------------------------------------
			    $("#arrayBtn").on("click", function(){
			       $.ajax({
			            
			          url : "<%=request.getContextPath()%>/jsonServlet.do",  // 요청할 URL주소
			          type : "POST",    // 전송방식 (GET 또는 POST)
			          data : "choice=array",    // 전송할 데이터 (choice : 파라미터, str = 값)
			          success : function(resData){    // 응답 성공시 처리하는 함수
			             
			            let htmlCode = "";
			          
			                $.each(resData, function(i,v){
			                  // 변수 isms index값, 변수 v는 데이터값이 저장된다.
			                  htmlCode += i + "번째 데이터 : " + v + "<br>";
			                   
			                });
			             
			             $("#result").html(htmlCode);
			          
			            
			          },
			          error : function(xhr) {  // 오류 발생시 처리하는 함수
			             alert("오류 발생");
			             
			          },
			          dataType : "json"     // 응답 데이터의 종류 지정 (text, html, xml 등을 지정할 수 있다.)
			       });
			       
			       
			    });
			    //-------------------------------------------------
			    $("#objBtn").on("click", function(){
			       $.ajax({
			            
			          url : "<%=request.getContextPath()%>/jsonServlet.do",  // 요청할 URL주소
			          type : "POST",    // 전송방식 (GET 또는 POST)
			          data : "choice=obj",    // 전송할 데이터 (choice : 파라미터, str = 값)
			          success : function(resData){    // 응답 성공시 처리하는 함수
			             // {"id":101, "name":"홍길동"}
			              let htmlCode = "";
			              htmlCode += "ID : " + resData.id + "<br>";
			              htmlCode += "NAME : " + resData.name + "<br>";
			              
			              $("#result").html(htmlCode);
			                
			            
			          },
			          error : function(xhr) {  // 오류 발생시 처리하는 함수
			             alert("오류 발생");
			             
			          },
			          dataType : "json"     // 응답 데이터의 종류 지정 (text, html, xml 등을 지정할 수 있다.)
			       });
			       
			       
			    });
			    
			    //-------------------------------------------------
			    $("#listBtn").on("click", function(){
			       $.ajax({
			            
			          url : "<%=request.getContextPath()%>/jsonServlet.do",  // 요청할 URL주소
			          type : "POST",    // 전송방식 (GET 또는 POST)
			          data : "choice=list",    // 전송할 데이터 (choice : 파라미터, str = 값)
			          success : function(resData){    // 응답 성공시 처리하는 함수
			             // [{"id" :201, "name":"이순신"},{"id" :202, "name":"강감찬"},
			             // {"id" :203, "name":"변학도"}, {"id" :204, "name":"일지매"}]
			              let htmlCode = "";
			              $.each(resData, function(i,v){
			                 
			                 htmlCode += i + "번째 데이터<br>";
			                 htmlCode += "ID : " + v.id + "<br>";
			                 htmlCode += "NAME : " + v.name + "<hr>";
			                 
			                 
			              });
			          
			          
			                $("#result").html(htmlCode);
			                
			            
			          },
			          error : function(xhr) {  // 오류 발생시 처리하는 함수
			             alert("오류 발생");
			             
			          },
			          dataType : "json"     // 응답 데이터의 종류 지정 (text, html, xml 등을 지정할 수 있다.)
			       });
			       
			       
			    });
			   
			  //-------------------------------------------------
			   
			  $("#mapBtn").on("click",function(){
				 $.ajax({
					url : "<%=request.getContextPath()%>/jsonServlet.do",  // 요청할 URL주소
			        type : "POST",    // 전송방식 (GET 또는 POST)
			        data : "choice=map",    // 전송할 데이터 (choice : 파라미터, str = 값)
			        
			        success : function(resData){
			        	let htmlCode = "이 름 : " + resData.name + "<br>";
			        	htmlCode = "전 화 : " + resData.tel + "<br>";
			        	htmlCode = "주 소 : " + resData.addr + "<br>";
			        	
			        	$("#result").html(htmlCode);
			        }
			        
				 }); // ajax 끝
			  });
			  
			  
			});
			
		</script>
	</head>
	<body>
		  <form>
		     <input type="button" id="strBtn" value="문자열">
		     <input type="button" id="arrayBtn" value="배 열">
		     <input type="button" id="objBtn" value="객 체">
		     <input type="button" id="listBtn" value="List객체">
		     <input type="button" id="mapBtn" value="Map객체">
		  </form>
		<hr>
		<h3>Ajax응답결과</h3>
		<div id="result"></div>
	</body>
</html>