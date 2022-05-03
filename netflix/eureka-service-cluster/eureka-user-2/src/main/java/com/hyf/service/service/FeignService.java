package com.hyf.service.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author baB_hyf
 * @date 2021/06/12
 */
@FeignClient("eureka-service-1-2")
@RequestMapping("service")
public interface FeignService {

    @RequestMapping("1")
    String _1();

    @RequestMapping("2")
    String _2();
}
