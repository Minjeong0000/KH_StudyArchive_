package com.kh.app.board.vo;

public class BoardVo {
	
	
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public String toString() {
		return "BoardVo [title=" + title + ", content=" + content + "]";
	}
	public BoardVo(String title, String content) {
		super();
		this.title = title;
		this.content = content;
	}
	public BoardVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	private String title;
	private String content;

}
