package com.hyf.cloud.nacos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.turbine.EnableTurbine;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author baB_hyf
 * @date 2021/05/11
 */
@EnableHystrix
@EnableHystrixDashboard
@EnableTurbine
@EnableFeignClients
@SpringBootApplication
public class EurekaServiceConsumerHystrixTurbineApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaServiceConsumerHystrixTurbineApplication.class, args);
    }
}
