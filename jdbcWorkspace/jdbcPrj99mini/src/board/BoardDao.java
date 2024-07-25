package board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.JDBCTemplate;

public class BoardDao {
	
	// 게시글 상세조회 SQL
	public BoardVo selectBoardByNo(Connection conn , String no) throws Exception {
		
		//SQL
		String sql ="SELECT B.NO , TITLE , CONTENT , HIT , NICK AS WRITER_NO , TO_CHAR(B.ENROLL_DATE , 'YYYY\"년\"MM\"월\"DD\"일\" HH24\"시\"MI\"분\"SS\"초\"') AS ENROLL_DATE FROM BOARD B JOIN MEMBER M ON B.WRITER_NO = M.NO WHERE B.NO = ? AND DEL_YN = 'N'";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, no);
		ResultSet rs = pstmt.executeQuery();
		
		//rs -> data -> obj
		BoardVo vo = null;
		if(rs.next()) {
			//String no = rs.getString("NO");
			String title = rs.getString("TITLE");
			String content = rs.getString("CONTENT");
			String writerNo = rs.getString("WRITER_NO");
			String hit = rs.getString("HIT");
			String enrollDate = rs.getString("ENROLL_DATE");
			
			vo = new BoardVo();
			vo.setNo(no);
			vo.setTitle(title);
			vo.setContent(content);
			vo.setWriterNo(writerNo);
			vo.setHit(hit);
			vo.setEnrollDate(enrollDate);
		}
		return vo;
	}//method
	
	//조회수 증가 SQL
	public int increaseHit(Connection conn , String no) throws Exception {
		//SQL
		String sql = "UPDATE BOARD SET HIT = HIT+1 WHERE NO = ? AND DEL_YN = 'N'";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, no);
		int result = pstmt.executeUpdate();
		return result;
	}
	
	// 게시글 검색 (제목) SQL
	public List<BoardVo> searchBoardByTitle(Connection conn , String str) throws Exception {
		//sql
		String sql = "SELECT * FROM BOARD WHERE TITLE LIKE '%' || ? || '%' AND DEL_YN = 'N' ORDER BY NO DESC";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, str);
		ResultSet rs = pstmt.executeQuery();
		
		//rs -> var -> obj
		ArrayList<BoardVo> voList = new ArrayList<BoardVo>();
		while( rs.next() ) {
			String title = rs.getString("TITLE");
			String writerNo = rs.getString("WRITER_NO");
			String enrolldate = rs.getString("ENROLL_DATE");
			String hit = rs.getString("HIT");
			
			BoardVo vo = new BoardVo();
			vo.setTitle(title);
			vo.setWriterNo(writerNo);
			vo.setEnrollDate(enrolldate);
			vo.setHit(hit);
			
			voList.add(vo);
		}
		return voList;
	}
	

}//class















