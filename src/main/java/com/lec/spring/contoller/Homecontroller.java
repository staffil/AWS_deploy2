package com.lec.spring.contoller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j // 이게 뭐라고?
@RestController // 바디를 리턴하는 것 (responsbody + controller)
public class Homecontroller {
    @Value("${env.info}")
    private String envinfo;


    @GetMapping("/aws/v2")
    public String hello (@RequestParam(defaultValue ="1")  Integer num) {
        if(num ==1) {
            log.info("["+ envinfo +"]/aws/v2/ 호출. info 로그🙌");
        }else if (num == -1){
            log.error("["+ envinfo +"]/aws/v2 호출 errror 로그😒");
        }else if (num == 0){
            log.warn("["+ envinfo +"]/aws/v2 호출 경고 로그🤣");
        }
        return "<h1>AWS 배포 v1.2</h1>";
        // 디버깅을 할때 어떤게 오류 나야 하는지 알아야 하기 때문에
    }

}
