package com.hyf.cloud.sentinel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author baB_hyf
 * @date 2021/05/10
 */
@EnableDiscoveryClient
@SpringBootApplication
public class NacosServiceProvider02Application
{
    public static void main(String[] args) {
        SpringApplication.run(NacosServiceProvider02Application.class, args);
    }
}
