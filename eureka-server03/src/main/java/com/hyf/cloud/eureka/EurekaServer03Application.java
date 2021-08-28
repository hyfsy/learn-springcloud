package com.hyf.cloud.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author baB_hyf
 * @date 2021/05/11
 */
@EnableEurekaServer
@SpringBootApplication
public class EurekaServer03Application {

    public static void main(String[] args) {
        SpringApplication.run(EurekaServer03Application.class, args);
    }
}
