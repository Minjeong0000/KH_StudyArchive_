package com.kh.app09.todo.todo;

import com.kh.app09.todo.vo.TodoVo;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface TodoMapper {

    @Select("SELECT * FROM TODO")
    List<TodoVo> getTodoList();

    @Insert("INSERT INTO TODO(NO, CONTENT) VALUES( SEQ_TODO.NEXTVAL , #{content} )")
    int insertTodo(TodoVo vo);

    @Select("SELECT * FROM TODO WHERE NO = #{num}")
    TodoVo getTodoByNo(String num);

    @Delete("DELETE TODO WHERE NO = #{num}")
    int delete(String num);

    @Update("UPDATE TODO SET CONTENT = #{content} WHERE NO = #{no}")
    int edit(TodoVo vo);

}//class