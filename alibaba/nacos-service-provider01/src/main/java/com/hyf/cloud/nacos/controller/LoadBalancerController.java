package com.hyf.cloud.nacos.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author baB_hyf
 * @date 2021/05/17
 */
@RestController
public class LoadBalancerController {

    @RequestMapping("loadbalancer")
    public String loadbalancer() {
        return "loadbalancer01";
    }
}
