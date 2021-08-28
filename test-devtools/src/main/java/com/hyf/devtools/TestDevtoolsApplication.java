package com.hyf.devtools;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author baB_hyf
 * @date 2021/06/05
 */
@SpringBootApplication
public class TestDevtoolsApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestDevtoolsApplication.class, args);
    }

    @RestController
    static class TestController {

        @RequestMapping("test")
        public String test() {
            return "test2";
        }
    }
}
