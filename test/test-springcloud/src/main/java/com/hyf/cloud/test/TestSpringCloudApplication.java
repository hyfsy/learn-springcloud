package com.hyf.cloud.test;

import org.springframework.aop.scope.ScopedObject;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.context.refresh.ContextRefresher;
import org.springframework.cloud.endpoint.event.RefreshEvent;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Configuration;

/**
 * @author baB_hyf
 * @date 2021/05/11
 */
@SpringBootApplication
public class TestSpringCloudApplication {

    public static void main(String[] args) {
        try (ConfigurableApplicationContext ctx = new SpringApplicationBuilder(Config.class)
                .web(WebApplicationType.NONE)
                .properties("spring.cloud.refresh.refreshable:" + TestProperties.class.getName())
                .properties("server.port=0")
                .run()) {

            TestProperties properties = ctx.getBean(TestProperties.class);
            // properties.invoke();

            ScopedObject scopedObject = (ScopedObject) properties;
            Object targetObject = scopedObject.getTargetObject();
            scopedObject.removeFromScope();

            System.out.println(properties);

            ctx.publishEvent(new RefreshEvent("", null, null));

            // ContextRefresher refresher = ctx.getBean(ContextRefresher.class);
            // refresher.refresh();

            properties = ctx.getBean(TestProperties.class);
            System.out.println(properties);

        }
    }

    @Configuration
    @EnableAutoConfiguration
    @EnableConfigurationProperties(TestProperties.class)
    static class Config {
    }

    @ConfigurationProperties("test-properties")
    static class TestProperties {

        public void invoke() {
            System.out.println("invoke");
        }
    }
}
