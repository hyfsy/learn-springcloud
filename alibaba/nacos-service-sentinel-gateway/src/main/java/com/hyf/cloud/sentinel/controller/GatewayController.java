package com.hyf.cloud.sentinel.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author baB_hyf
 * @date 2021/10/16
 */
@RestController
@RequestMapping("gateway")
public class GatewayController {

    // http://localhost:8334/test?id=1
    @RequestMapping("test")
    public void test(@RequestParam(required = false) String id) {
        System.out.println("test");
    }
}
