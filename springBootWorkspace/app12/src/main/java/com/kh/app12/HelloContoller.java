package com.kh.app12;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.spi.LoggingEventBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("hello")
@Slf4j
public class HelloContoller {

    @GetMapping
    public String hello(){
        String str = "swy";
        int age = 20;

        log.info("안녕 나는 {} 이고, 나이는 {} 살이야." , str , age);

        return "hello ~~~ !";
    }

}
