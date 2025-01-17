package com.kh.app.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.kh.app.board.vo.BoardVo;
import com.kh.app.db.JDBCTemplate;

public class BoardDao {
	
	//게시글 작성
	public int insertBoard(SqlSession ss , BoardVo vo) throws Exception {
		return ss.insert("BoardMapper.insertBoard" , vo);
	}//method
	
	//게시글 목록 조회
	public List<BoardVo> getBoardList(SqlSession ss) throws Exception{
		return ss.selectList("BoardMapper.selectBoardList");
	}//method
	

}//class









































