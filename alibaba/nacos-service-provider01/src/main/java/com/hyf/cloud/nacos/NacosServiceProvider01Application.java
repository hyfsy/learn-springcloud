package com.hyf.cloud.nacos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author baB_hyf
 * @date 2021/05/10
 */
@EnableDiscoveryClient
@SpringBootApplication
public class NacosServiceProvider01Application {
    public static void main(String[] args) {
        SpringApplication.run(NacosServiceProvider01Application.class, args);
    }
}
