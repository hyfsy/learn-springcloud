package com.hyf.cloud.eureka.qualifier;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author baB_hyf
 * @date 2021/05/23
 */
@Configuration
public class TemplateConfiguration {

    @Bean
    @LoadBalanced
    public Template template1() {
        Template template = new Template();
        System.out.println("template1: " + template);
        return template;
    }

    @Bean
    @LoadBalanced
    public Template template2() {
        Template template = new Template();
        System.out.println("template2: " + template);
        return template;
    }

    // 没有一起放入容器 ?
    @Bean
    public Template template3() {
        Template template = new Template();
        System.out.println("template3: " + template);
        return template;
    }

    static class Template {
    }
}
