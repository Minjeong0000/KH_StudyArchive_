package com.kh.app99.notice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.kh.app99.notice.vo.NoticeVo;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
@Rollback
class NoticeApiControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void 공지사항_작성하기_성공_테스트() throws Exception {
        // URL : http://127.0.0.1:8080/api/notice
        // method : POST
        // data : title:String , content:String

        NoticeVo vo = new NoticeVo();
        vo.setTitle("제이유닛테스트ㅡㅡㅡㅡ제이슨~~~~");
        vo.setContent("ccc");

        String jsonStr = objectMapper.writeValueAsString(vo);

        ResultActions resultActions = mockMvc.perform(
                MockMvcRequestBuilders
                        .post("/api/notice")
                        .contentType( MediaType.APPLICATION_JSON )
                        .content(jsonStr)
//                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
//                        .param("title", "제이유닛파이브롤백테스트ㅡㅡㅡㅡㅡㅡㅡㅡㅡ2222")
//                        .param("content", "테스트")
        );

        MvcResult resp = resultActions
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        String str = resp.getResponse().getContentAsString();

        Assertions.assertThat(str).isEqualTo("작성하기 성공!");
    }

    @Test
    public void 공지사항_작성하기_실패_테스트(){

    }

    @Test
    public void 공지사항_상세조회_성공_테스트() throws Exception {

        // given
        String num = "52";

        // when
        ResultActions resultActions = mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/api/notice")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .param("num", num)
        );

        // then
        resultActions
                .andExpect( MockMvcResultMatchers.status().isOk() )
                .andExpect( MockMvcResultMatchers.jsonPath("$.title").isNotEmpty() )
                .andExpect( MockMvcResultMatchers.jsonPath("$.content").isNotEmpty() )
        ;

    }

    @Test
    public void 예외가_발생하는_테스트(){

        Assertions.assertThatThrownBy( () -> {
            System.out.println("어떤 메소드 호출됨 ....");
            throw new RuntimeException("예외 ㅋㅋㅋㅋ 런타임ㅁㅁㅁ");
        } );

    }

}