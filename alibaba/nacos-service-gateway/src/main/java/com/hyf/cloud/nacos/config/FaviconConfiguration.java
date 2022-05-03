package com.hyf.cloud.nacos.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ResourceLoader;
import org.springframework.web.reactive.handler.SimpleUrlHandlerMapping;
import org.springframework.web.reactive.resource.ResourceWebHandler;

import java.util.Collections;

/**
 * 去除 Gateway调用 /favicon.ico 引起的 500错误
 *
 * @author baB_hyf
 * @date 2021/06/08
 */
@Configuration
public class FaviconConfiguration {

    @Bean
    public SimpleUrlHandlerMapping faviconHandlerMapping(ResourceLoader resourceLoader) throws Exception {
        ResourceWebHandler faviconWebHandler = new ResourceWebHandler();
        faviconWebHandler.setLocationValues(Collections.singletonList("classpath:favicon.ico"));
        faviconWebHandler.setResourceLoader(resourceLoader);
        faviconWebHandler.afterPropertiesSet();

        SimpleUrlHandlerMapping faviconHandlerMapping = new SimpleUrlHandlerMapping();
        faviconHandlerMapping.setUrlMap(Collections.singletonMap("/favicon.ico", faviconWebHandler));
        faviconHandlerMapping.setOrder(0);
        return faviconHandlerMapping;
    }
}
