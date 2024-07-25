package com.kh.app09.todo.dao;

import com.kh.app09.todo.todo.TodoMapper;
import com.kh.app09.todo.vo.TodoVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class TodoDao {

    private final TodoMapper mapper;

    public List<TodoVo> getTodoList() {
        return mapper.getTodoList();
    }

    public int insertTodo(TodoVo vo) {
        return mapper.insertTodo(vo);
    }

    public TodoVo getTodoByNo(String num) {
        return mapper.getTodoByNo(num);
    }

    public int delete(String num) {
        return mapper.delete(num);
    }

    public int edit(TodoVo vo) {
        return mapper.edit(vo);
    }


}//class
