package com.hyf.cloud.sentinel;

import com.alibaba.nacos.api.annotation.NacosProperties;
import com.alibaba.nacos.spring.context.annotation.config.EnableNacosConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 依赖关系，没启起来，orz
 *
 * @author baB_hyf
 * @date 2021/05/10
 */
// @EnableNacos(globalProperties = @NacosProperties(serverAddr = "127.0.0.1:8848"))
// @EnableNacosDiscovery(globalProperties = @NacosProperties(serverAddr = "127.0.0.1:8848"))
@EnableNacosConfig(globalProperties = @NacosProperties(serverAddr = "127.0.0.1:8848"))
@SpringBootApplication
public class NacosServiceSpringApplication {
    public static void main(String[] args) {
        SpringApplication.run(NacosServiceSpringApplication.class, args);
    }
}
