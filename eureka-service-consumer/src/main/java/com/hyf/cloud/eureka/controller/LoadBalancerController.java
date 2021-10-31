package com.hyf.cloud.nacos.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author baB_hyf
 * @date 2021/05/17
 */
@RestController
public class LoadBalancerController {

    public static final String SERVICE_NAME = "http://eureka-service-provider";

    @Resource
    private RestTemplate restTemplate;

    @RequestMapping("loadbalancer")
    public String _1() {
        String result = restTemplate.getForObject(SERVICE_NAME + "/loadbalancer", String.class);
        // System.out.println(result);
        return result;
    }
}
