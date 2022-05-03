package com.hyf.cloud.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author baB_hyf
 * @date 2021/05/11
 */
// @EnableEurekaClient // 不需要也可以
@SpringBootApplication
public class EurekaServiceConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaServiceConsumerApplication.class, args);
    }
}
