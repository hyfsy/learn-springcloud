package com.hyf.cloud.nacos.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author baB_hyf
 * @date 2021/05/30
 */
@RestController
@RequestMapping("gateway")
public class GatewayController {

    @RequestMapping("1")
    public String _1() {
        return "gateway1";
    }
}
