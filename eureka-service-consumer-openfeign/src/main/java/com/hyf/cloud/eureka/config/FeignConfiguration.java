package com.hyf.cloud.nacos.config;

import com.hyf.cloud.nacos.service.custom.CustomFeignService;
import com.hyf.cloud.nacos.service.custom.impl.CustomFeignServiceImpl;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.cloud.openfeign.FeignClientBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import javax.annotation.Resource;

/**
 * @author baB_hyf
 * @date 2021/05/24
 */
// @Configuration
public class FeignConfiguration {

    @Resource
    private ApplicationContext applicationContext;
    @Resource
    private FeignClientBuilder feignClientBuilder;

    @Bean
    @ConditionalOnMissingBean
    public CustomFeignService customFeignService() {
        return feignClientBuilder.forType(CustomFeignService.class, "eureka-service-provider")
                .contextId("FeignContextId-EurekaServiceProvider")
                .path("/api")
                .url("") // 固定url地址
                .decode404(false)
                .fallback(CustomFeignServiceImpl.class)
                // .fallbackFactory(CustomFallbackFactory.class)
                // .customize()
                // .inheritParentContext()
                .build();
    }
}
