package com.hyf.cloud.nacos.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author baB_hyf
 * @date 2021/07/25
 */
@RefreshScope
@RestController
public class RefreshController {

    @Resource
    private ConfigurableEnvironment environment;

    @Value("${hello:unset}")
    private String hello;

    @RequestMapping("hello")
    public String hello() {
        return "hello: " + hello + " - " + environment.getProperty("world");
    }
}
