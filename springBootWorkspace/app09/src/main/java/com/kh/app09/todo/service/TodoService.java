package com.kh.app09.todo.service;

import com.kh.app09.todo.dao.TodoDao;
import com.kh.app09.todo.vo.TodoVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoService {

    private final TodoDao dao;

    public List<TodoVo> getTodoList() {
        return dao.getTodoList();
    }

    public int insertTodo(TodoVo vo) {
        return dao.insertTodo(vo);
    }

    public TodoVo getTodoByNo(String num) {
        return dao.getTodoByNo(num);
    }

    public int delete(String num) {
        return dao.delete(num);
    }

    public int edit(TodoVo vo) {
        return dao.edit(vo);
    }

}//class
