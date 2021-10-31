package com.hyf.cloud.nacos.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author baB_hyf
 * @date 2021/05/25
 */
@FeignClient("eureka-service-provider")
public interface FeignProxyService {

    @RequestMapping("provider")
    String provider();
}
