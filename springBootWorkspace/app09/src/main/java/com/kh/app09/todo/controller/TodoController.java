package com.kh.app09.todo.controller;

import com.kh.app09.todo.service.TodoService;
import com.kh.app09.todo.vo.TodoVo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("todo")
@RequiredArgsConstructor
@CrossOrigin
public class TodoController {

    private final TodoService service;

    //목록조회
    @GetMapping
    public List<TodoVo> getTodoList(){
        List<TodoVo> todoVoList = service.getTodoList();
        return todoVoList;
    }

    //작성하기
    @PostMapping
    public int insertTodo(TodoVo vo){
        int result = service.insertTodo(vo);
        return result;
    }

    //상세조회
    @GetMapping("detail")
    public TodoVo getTodoByNo(String num){
        TodoVo vo = service.getTodoByNo(num);
        return vo;
    }

    //삭제하기
    @DeleteMapping
    public int delete(String num){
        int result = service.delete(num);
        return result;
    }

    //수정하기
    @PutMapping
    public int edit(TodoVo vo){
        int result = service.edit(vo);
        return result;
    }

}//class






