package com.hyf.cloud.sentinel.controller;

import com.alibaba.nacos.api.annotation.NacosInjected;
import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.api.naming.NamingService;
import com.alibaba.nacos.api.naming.pojo.Instance;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author baB_hyf
 * @date 2021/07/25
 */
// @RestController
@RequestMapping("discovery")
public class NamingServiceController {

    @NacosInjected
    private NamingService namingService;

    @RequestMapping("service/{serviceName}")
    public List<Instance> get(@PathVariable String serviceName) throws NacosException {
        return namingService.getAllInstances(serviceName);
    }
}
