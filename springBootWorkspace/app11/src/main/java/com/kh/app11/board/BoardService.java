package com.kh.app11.board;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardDao dao;

    public int write(BoardVo vo) {
        return dao.write(vo);
    }

    public BoardVo detail(String no) {
        return dao.detail(no);
    }
}
