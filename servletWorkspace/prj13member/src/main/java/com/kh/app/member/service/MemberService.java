package com.kh.app.member.service;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.kh.app.db.JDBCTemplate;
import com.kh.app.member.dao.MemberDao;
import com.kh.app.member.vo.MemberVo;

public class MemberService {
	
	public int join(MemberVo vo) throws Exception {
		//복잡한 작업 (비즈니스 로직 + SQL)
		boolean isValid = true;
		if(vo.getMemberId().length() < 4 || vo.getMemberId().length() > 12) {
			isValid = false;
		}
		if(vo.getMemberPwd().length() < 4 || vo.getMemberPwd().length() > 12) {
			isValid = false;
		}
		if(!vo.getMemberPwd().equals(vo.getMemberPwd2())) {
			isValid = false;
		}
		if(vo.getMemberNick().contains("관리자") || vo.getMemberNick().contains("운영자")) {
			isValid = false;
		}
		
		if(!isValid) {
			return 0;
		}
		
		MemberDao dao = new MemberDao();
		int result = dao.join(vo);
		
		return result;
	}//join

	public MemberVo login(MemberVo vo) throws Exception {
		// 비즈니스 로직
		
		// SQL
		MemberDao dao = new MemberDao();
		MemberVo loginMemberVo = dao.login(vo);
		
		return loginMemberVo;
	}

}//class













