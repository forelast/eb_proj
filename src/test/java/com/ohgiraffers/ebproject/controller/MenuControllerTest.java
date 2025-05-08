package com.ohgiraffers.ebproject.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
/* @AutoConfigureMockMvc: MockMvc를 자동으로 설정하여 HTTP 요청/응답을 테스트할 수 있게 함 */
@AutoConfigureMockMvc
class MenuControllerTest {

    /* MockMvc는 실제 서버를 구동하지 않고도 HTTP 요청과 응답을 시뮬레이션하여
     * Spring MVC 컨트롤러를 테스트할 수 있게 해주는 클래스
     * 이를 통해 실제 서버 배포 없이도 API의 동작을 검증할 수 있다. */
    @Autowired
    private MockMvc mockMvc;

    /* 서버의 상태를 확인하는 health check API 테스트 */
    @DisplayName("상태확인")
    @Test
    public void healthCheckTest() throws Exception {
        mockMvc.perform(get("/health"))                // /health 엔드포인트로 GET 요청
                .andExpect(status().isOk())            // HTTP 상태코드 200 OK 확인
                .andDo(print());                       // 테스트 결과를 콘솔에 출력
    }

    /* 메뉴 코드로 특정 메뉴를 조회하는 API 테스트 */
    @DisplayName("4번 메뉴확인")
    @Test
    public void findMenuByCodeTest() throws Exception {
        mockMvc.perform(get("/menus/4"))              // /menus/4 엔드포인트로 GET 요청
                .andExpect(status().isOk())            // HTTP 상태코드 200 OK 확인
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))    // 응답이 JSON 형식인지 확인
                .andExpect(jsonPath("$.menuName").value("갈릭미역파르페"))    // 응답 JSON의 menuName이 "우럭스무디"인지 확인
                .andDo(print());                       // 테스트 결과를 콘솔에 출력
    }
}