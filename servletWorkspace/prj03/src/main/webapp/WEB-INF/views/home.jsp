<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>홈페이지ㅋㅋㅋ 여기는 JSP ~~~</h1>
	
	<% String x = request.getParameter("name"); %>
	
	<% if(x != null){ %>
		<h2><%= x %>님 환영합니다 ~</h2>
	<% }else{ %>
		<h2>게스트님 환영합니다 ~</h2>
	<% } %>
</body>
</html>







