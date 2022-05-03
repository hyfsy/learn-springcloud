package com.hyf.cloud.sentinel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author baB_hyf
 * @date 2021/09/12
 */
@SpringBootApplication
public class NacosServiceSentinelGatewayApplication {
    public static void main(String[] args) {
        // System.setProperty("csp.sentinel.app.type", "1");
        SpringApplication.run(NacosServiceSentinelGatewayApplication.class, args);
    }
}
