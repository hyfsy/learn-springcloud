package com.hyf.cloud.nacos.controller;

import com.hyf.cloud.nacos.service.FeignProxyService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author baB_hyf
 * @date 2021/05/17
 */
@RestController
@RequestMapping("test")
public class HystrixController {

    @Resource
    private FeignProxyService feignProxyService;

    @HystrixCommand(fallbackMethod = "fallback")
    @RequestMapping
    public String _0() {
        System.out.println(Thread.currentThread().getName());
        throw new RuntimeException("throw ex");
    }

    public String fallback() {
        System.out.println(Thread.currentThread().getName());
        throw new RuntimeException("fallback");
        // return "fallback";
    }

    public String fallback2() {
        return "fallback2";
    }

    // @HystrixCommand
    @RequestMapping("1")
    public String _1() {
        return feignProxyService.provider();
    }

}
