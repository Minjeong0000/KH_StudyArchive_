package com.kh.app14;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface HelloMapper {

    @Select("""
            SELECT * FROM KH_SWY
            """)
    List<HelloVo> getList();

    @Insert("""
            INSERT INTO KH_SWY
            (
                MSG
            )
            VALUES
            (
                #{msg}
            )
            """)
    int insert(HelloVo vo);

}
