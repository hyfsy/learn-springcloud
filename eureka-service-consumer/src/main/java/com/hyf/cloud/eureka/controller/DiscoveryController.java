package com.hyf.cloud.nacos.controller;

import com.netflix.appinfo.HealthCheckHandler;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;
import java.util.Set;

/**
 * @author baB_hyf
 * @date 2021/05/11
 */
@RestController
public class DiscoveryController {

    @Resource
    private EurekaClient eurekaClient;
    @Resource
    private DiscoveryClient discoveryClient;

    @RequestMapping("discovery")
    public String discovery() {


        Set<String> allKnownRegions = eurekaClient.getAllKnownRegions();
        HealthCheckHandler healthCheckHandler = eurekaClient.getHealthCheckHandler();
        InstanceInfo instance = eurekaClient.getNextServerFromEureka("STORES", false);
        if (instance != null) {
            System.out.println(instance.getHomePageUrl());
        }


        String description = discoveryClient.description();
        List<ServiceInstance> instances = discoveryClient.getInstances("eureka-service");
        if (instances != null) {
            for (ServiceInstance serviceInstance : instances) {
                URI uri = serviceInstance.getUri();
            }
        }
        List<String> services = discoveryClient.getServices();
        int order = discoveryClient.getOrder();


        return "discovery";
    }

}
