package com.kh.app.member.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@MultipartConfig(
	maxFileSize = 1024*1024*10 ,
	maxRequestSize = 1024*1024*50 ,
	fileSizeThreshold = 1024*1024*10
)
@WebServlet("/member/join")
public class MemberJoinController extends HttpServlet {
	
	//회원가입 화면
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/member/join.jsp").forward(req, resp);
	}
	
	//회원가입
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		String pwd = req.getParameter("pwd");
		String nick = req.getParameter("nick");
		Part f = req.getPart("f");
		
		System.out.println("id : " + id);
		System.out.println("pwd : " + pwd);
		System.out.println("nick : " + nick);
		System.out.println("f(part) : " + f);
		
		//파일객체(Part)로부터 필요한 데이터들 꺼냄
		String originName = f.getSubmittedFileName();
		InputStream is = f.getInputStream();
		
		//파일아웃풋 스트림 준비
		String path = "D:\\dev\\servletWorkspace\\prj14upload\\src\\main\\webapp\\resources\\upload\\";
		String random = UUID.randomUUID().toString();
		String ext = originName.substring(originName.lastIndexOf("."));
		String changeName = System.currentTimeMillis() + "_" + random + ext;
		FileOutputStream fos = new FileOutputStream(path + changeName);
		
		byte[] buf = new byte[1024];
		int size = 0;
		while( (size=is.read(buf)) != -1 ) {
			fos.write(buf , 0, size);
		}
		
		is.close();
		fos.close();
		
	}//method

}//class
































