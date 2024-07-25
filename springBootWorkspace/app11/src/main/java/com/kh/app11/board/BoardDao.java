package com.kh.app11.board;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class BoardDao {

    private final BoardMapper mapper;

    public int write(BoardVo vo) {
        return mapper.write(vo);
    }

    public BoardVo detail(String no) {
        return mapper.detail(no);
    }
}
