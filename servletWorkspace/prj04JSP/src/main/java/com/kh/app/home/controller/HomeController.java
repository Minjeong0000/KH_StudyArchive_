package com.kh.app.home.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/home")
public class HomeController extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//데이터 받기
		String name = req.getParameter("name");
		
		//문자열 내보내기
//		resp.setContentType("text/html; charset=UTF-8");
//		PrintWriter out = resp.getWriter();
//		out.write("<h1>홈페이지</h1>");
//		if(name != null) {
//			out.write("<h1>" + name + " 님 환영합니다.</h1>");
//		}else {
//			out.write("<h1>게스트 님 환영합니다.</h1>");
//		}
		req.getRequestDispatcher("/WEB-INF/views/test.jsp").forward(req, resp);
	}

}













