package com.lec.spring.contoller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
// 서버 동작을 하게 될 경우 랜덤 포드로 동작하라
class HomecontrollerTest {
    @Autowired
    private TestRestTemplate restTemplate; // test 에서만 쓰는 bean 객체

    @Test
    void hello(){
        ResponseEntity<String> response = restTemplate.getForEntity("/aws/v2", String.class);
        assertEquals("<h1>AWS 배포 v1.2</h1>",response.getBody());
        // 하나의 문자가 틀려도 실패 했다고 뜸
    }


}