package com.hyf.cloud.eureka.controller;

import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author baB_hyf
 * @date 2021/05/11
 */
@RestController
public class ConsumerController {

    @Resource
    private DiscoveryClient discoveryClient;

    @RequestMapping("consumer")
    public String consumer() {
        List<String> services = discoveryClient.getServices();
        return "consumer";
    }
}
