package com.kh.app10.member;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberDao dao;
    private final BCryptPasswordEncoder encoder;

    public int join(MemberVo vo) {
        String encStr = encoder.encode(vo.getPwd());
        vo.setPwd( encStr );
        return dao.join(vo);
    }

    public MemberVo login(MemberVo vo) {
        MemberVo loginVo = dao.login(vo);
        boolean isMatch = encoder.matches(vo.getPwd(), loginVo.getPwd());
        return isMatch ? loginVo : null;
    }

}
