package com.kh.app.board.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.app.board.service.BoardService;
import com.kh.app.board.vo.BoardVo;

@WebServlet("/board/list")
public class BoardListController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			BoardService bs = new BoardService();
			List<BoardVo> voList = bs.getBoardList();
			
			//문자열 내보내기 (서블릿 직접 ㄴㄴ JSP한테 부탁 ㄱㄱ)
			req.setAttribute("voList", voList);
			req.getRequestDispatcher("/WEB-INF/views/list.jsp").forward(req, resp);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
	}//method
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

}//class
































