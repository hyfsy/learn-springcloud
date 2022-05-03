package com.hyf.cloud.sentinel.listener;

import com.alibaba.nacos.api.config.annotation.NacosConfigListener;
import com.hyf.cloud.sentinel.converter.CustomConfigConverter;
import org.springframework.context.annotation.Configuration;

/**
 * @author baB_hyf
 * @date 2021/07/25
 */
@Configuration
public class ConfigListenerConfiguration {

    // configService.addListener
    // 支持更丰富的类型转换
    @NacosConfigListener(dataId = "example", timeout = 100L /* 防止阻塞其他监听器 */)
    public void onMessage(String config) {
        System.out.println("Get updated config: " + config);
    }

    @NacosConfigListener(dataId = "example_convert", converter = CustomConfigConverter.class)
    public void testConvert(CustomConfigConverter.Person person) {
        System.out.println("Get updated config: " + person);
    }
}
