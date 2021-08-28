package com.hyf.cloud.eureka.config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;

/**
 * @author baB_hyf
 * @date 2021/05/13
 */
public class InnerConfiguration {

    @Configuration(proxyBeanMethods = false)
    protected static class Empty {

        public Empty() {
            System.out.println("Empty init...");
        }

    }
}
