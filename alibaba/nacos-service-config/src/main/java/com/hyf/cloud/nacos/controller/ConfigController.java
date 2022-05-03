package com.hyf.cloud.nacos.controller;

import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author baB_hyf
 * @date 2021/05/10
 */
@RestController
public class ConfigController {

    @Resource
    private Environment environment;

    @RequestMapping("config")
    public String config() {
        return config("hello");
    }

    @RequestMapping("config/{name}")
    public String config(@PathVariable String name) {
        String property = environment.getProperty(name);
        return name + ": " + property;
    }
}
