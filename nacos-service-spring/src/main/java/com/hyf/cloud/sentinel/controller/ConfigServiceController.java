package com.hyf.cloud.sentinel.controller;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author baB_hyf
 * @date 2021/07/25
 */
@RestController
@RequestMapping("config")
@NacosPropertySource(dataId = "example", autoRefreshed = true)
public class ConfigServiceController {

    @NacosValue(value = "${hello:unset}", autoRefreshed = true)
    private String hello;

    @RequestMapping("")
    public String get() {
        return hello;
    }
}
