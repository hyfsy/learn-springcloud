package com.hyf.cloud.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author baB_hyf
 * @date 2021/05/11
 */
@EnableFeignClients
@SpringBootApplication
public class EurekaServiceConsumerOpenFeignApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaServiceConsumerOpenFeignApplication.class, args);
    }
}
