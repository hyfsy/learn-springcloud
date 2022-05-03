package com.hyf.service.config;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

/**
 * @author baB_hyf
 * @date 2021/06/12
 */
@Configuration
@EnableFeignClients(basePackages = "com.hyf.service")
public class FeignConfiguration {
}
