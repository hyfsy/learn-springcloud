package com.hyf.cloud.nacos.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author baB_hyf
 * @date 2021/05/11
 */
@Configuration
public class EurekaClientConfiguration {

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    // @Bean
    // public DiscoveryClient.DiscoveryClientOptionalArgs args() {
    //     DiscoveryClient.DiscoveryClientOptionalArgs args = new DiscoveryClient.DiscoveryClientOptionalArgs();
    //     return args;
    // }

    // @Bean
    // public ClientFilter clientFilter() {
    //
    // }

    // @Bean
    // public EurekaClientHttpRequestFactorySupplier supplier() {
    //
    // }
}
