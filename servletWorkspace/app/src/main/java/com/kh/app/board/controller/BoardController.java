package com.kh.app.board.controller;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("board")
public class BoardController {
	
	//게시글 목록 조회 (화면)
	@GetMapping("list")
	public String getBoardList() {
		return "board/list";
	}
	
	

}
