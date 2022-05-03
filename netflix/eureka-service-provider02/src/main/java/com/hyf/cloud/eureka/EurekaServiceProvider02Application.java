package com.hyf.cloud.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author baB_hyf
 * @date 2021/05/11
 */
@EnableEurekaClient
@SpringBootApplication
public class EurekaServiceProvider02Application {

    public static void main(String[] args) {
        SpringApplication.run(EurekaServiceProvider02Application.class, args);
    }
}
