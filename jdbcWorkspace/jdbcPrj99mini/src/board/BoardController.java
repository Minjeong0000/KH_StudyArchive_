package board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import db.JDBCTemplate;
import main.Main;

public class BoardController {
	
	// 메뉴
	public void printMenu() throws Exception {
		System.out.println("1. 게시글 작성");
		System.out.println("2. 게시글 목록 조회(최신순)");
		System.out.println("3. 게시글 목록 조회(오래된순)");
		System.out.println("4. 게시글 목록 조회(조회수 높은 순)");
		System.out.println("5. 게시글 상세 조회 ");
		System.out.println("6. 게시글 검색 (제목)");
		System.out.println("7. 게시글 검색 (내용)");
		System.out.println("8. 게시글 수정 (작성자 또는 관리자 만 가능)");
		System.out.println("9. 게시글 삭제 (작성자 또는 관리자 만 가능)");
		System.out.println("0. 돌아가기");
		String num = Main.SC.nextLine();
		
		switch(num){
		case "1" : write(); break;
		case "2" : selectBoardOrderByNoDesc(); break;
//		case "3" : ~~~; break;
//		case "4" : ~~~; break;
		case "5" : selectBoardByNo(); break;
		case "6" : searchBoardByTitle(); break;
//		case "7" : ~~~; break;
//		case "8" : ~~~; break;
//		case "9" : ~~~; break;
		case "0" : System.out.println("돌아가기..."); return;
		default: System.out.println("잘못 누르셨습니다.");
		}
	}//method
	
	// 게시글 작성
	public void write() throws Exception {
		//validate
		if(Main.loginMember == null) {
			System.out.println("로그인 하고 오세요");
			return;
		}
		
		//conn
		Connection conn = JDBCTemplate.getConn();

		System.out.print("제목 : ");
		String title = Main.SC.nextLine();
		System.out.print("내용 : ");
		String content = Main.SC.nextLine();
		
		//SQL
		String sql = "INSERT INTO BOARD(NO, TITLE, CONTENT, WRITER_NO) VALUES(SEQ_BOARD_NO.NEXTVAL , ?, ?, ?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, title);
		pstmt.setString(2, content);
		pstmt.setString(3, Main.loginMember.getNo());
		int result = pstmt.executeUpdate();
		
		//result
		if(result != 1) {
			System.out.println("게시글 작성 실패 ... ");
			return;
		}
		conn.commit();
		System.out.println("게시글 작성 성공 ! ");
	}//class

	// 게시글 목록 조회(최신순)
	public void selectBoardOrderByNoDesc() throws Exception {
		//conn
		Connection conn = JDBCTemplate.getConn();
		
		//sql
		String sql = "SELECT B.NO , B.TITLE , M.NICK , B.HIT FROM BOARD B JOIN MEMBER M ON B.WRITER_NO = M.NO ORDER BY B.NO DESC";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		//rs
		ArrayList<BoardVo> voList = new ArrayList<BoardVo>();
		while(rs.next()) {
			String no = rs.getString("NO");
			String title = rs.getString("TITLE");
//			String content = rs.getString("CONTENT");
			//String writerNo = rs.getString("WRITER_NO");
			String writerNo = rs.getString("NICK");
			String hit = rs.getString("HIT");
//			String enrollDate = rs.getString("ENROLL_DATE");
//			String modifyDate = rs.getString("MODIFY_DATE");
//			String delYn = rs.getString("DEL_YN");
			BoardVo vo = new BoardVo(no, title, null, writerNo, hit, null, null, null);
			voList.add(vo);
		}
		
		System.out.println("----------------");
		System.out.print("번호");
		System.out.print(" | ");
		System.out.print("제목");
		System.out.print(" | ");
		System.out.print("조회수");
		System.out.print(" | ");
		System.out.print("작성자");
		System.out.println();
		for (BoardVo x : voList) {
			System.out.print(x.getNo());
			System.out.print(" | ");
			System.out.print(x.getTitle());
			System.out.print(" | ");
			System.out.print(x.getHit());
			System.out.print(" | ");
			System.out.print(x.getWriterNo());
			System.out.println();
		}
		System.out.println("----------------");
	}//method
	
	// 게시글 목록 조회(오래된순)
	// 게시글 목록 조회(조회수 높은 순)
	
	// 게시글 상세 조회
	private void selectBoardByNo() throws Exception {
		//conn
		Connection conn = JDBCTemplate.getConn();
		
		System.out.print("조회할 게시글 번호 : ");
		String no = Main.SC.nextLine();
		
		BoardDao dao = new BoardDao();
		
		int result = dao.increaseHit(conn, no);
		if(result != 1) {
			throw new Exception("게시글 상세 조회 중 에러 발생 (조회수 증가 실패)");
		}
		conn.commit();
		BoardVo vo = dao.selectBoardByNo(conn, no);
		
		System.out.println("---------------------------------------");
		System.out.println("제목 : " + vo.getTitle());
		System.out.println("작성자 : " + vo.getWriterNo());
		System.out.println("조회수 : " + vo.getHit());
		System.out.println("작성일시 : " + vo.getEnrollDate()); //2024-04-03 11:12:34
		System.out.println("내용 : " + vo.getContent());
		System.out.println("---------------------------------------");
		
	}
	
	// 게시글 검색 (제목)
	public void searchBoardByTitle() throws Exception {
		
		//conn
		Connection conn = JDBCTemplate.getConn();
		
		System.out.print("검색어(제목) 입력 : ");
		String str = Main.SC.nextLine();
		
		BoardDao dao = new BoardDao();
		List<BoardVo> voList = dao.searchBoardByTitle(conn, str);
		
		if( conn != null && !conn.isClosed() ) {
			conn.close();
		}
		
		// ~~~~~~~~~~~~~~~~~
		for (BoardVo x : voList) {
			System.out.println(x);
		}
		
	}//method
	
	// 게시글 검색 (내용)
	
	// 게시글 수정 (작성자 또는 관리자 만 가능)
	// 게시글 삭제 (작성자 또는 관리자 만 가능)

}//class








