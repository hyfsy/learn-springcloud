package com.hyf.cloud.nacos.controller;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author baB_hyf
 * @date 2021/05/10
 */
@RestController
public class DiscoveryController {

    private static final String PROVIDER_SERVICE_NAME = "nacos-service-provider";
    private static final String PROVIDER_URL          = "http://" + PROVIDER_SERVICE_NAME;

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private LoadBalancerClient loadBalancerClient;

    @RequestMapping("consumer")
    public String consumer() {
        return restTemplate.getForObject(PROVIDER_URL + "/provider", String.class);
    }

    // 需要 RestTemplate 为非负载均衡的，否则找不到服务报错
    @RequestMapping("consumer2")
    public String consumer2() {
        ServiceInstance serviceInstance = loadBalancerClient.choose(PROVIDER_SERVICE_NAME);
        String providerUrl = String.format("%s://%s:%s/provider",
                serviceInstance.isSecure() ? "https" : "http",
                serviceInstance.getHost(),
                serviceInstance.getPort());
        return restTemplate.getForObject(providerUrl, String.class);
    }
}
