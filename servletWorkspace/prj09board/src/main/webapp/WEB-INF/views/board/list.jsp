<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>리스트</h1>
	
	<hr>
	
	<a href="http://127.0.0.1:8888/app09/home">홈페이지 이동</a>
	
	<table>
		<tbody>
		<%--
			List<BoardVo> voList = (List<BoardVo>)request.getAttribute("boardVoList");
			for(BoardVo vo : voList){
				out.write("<tr>");
				out.write("<td>" + vo.getNo() + "</td>");
				out.write("<td>" + vo.getTitle() + "</td>");
				out.write("<td>" + vo.getWriterNick() + "</td>");
				out.write("</tr>");
			}
		--%>
		</tbody>
	</table>
	
	
	
	
</body>
</html>








