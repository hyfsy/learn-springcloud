package com.hyf.cloud.nacos.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Mono;

import java.util.Locale;

/**
 * @author baB_hyf
 * @date 2021/06/05
 */
@Configuration
public class RouteFilterConfiguration {

    @Bean
    public RouteLocator filterRoute(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("rewrite-request-body", r -> r.host("*.example.org")
                        .filters(f -> f.prefixPath("/httpbin")
                                // 重写请求体
                                .modifyRequestBody(String.class, String.class,
                                        (exchange, s) -> s == null ? Mono.empty() :
                                                Mono.just(s.toUpperCase(Locale.ROOT)))
                                // 重写响应体
                                .modifyRequestBody(String.class, String.class,
                                        (exchange, s) -> s == null ? Mono.empty() :
                                                Mono.just(s.toUpperCase(Locale.ROOT)))
                        ).uri("http://bin"))

                // 将 OAuth2 访问令牌下游转发到它正在代理的服务
                // .route("resource-token", r -> r.path("/resource")
                //         .filters(f -> f.tokenRelay())
                //         .uri("http://localhost:9000"))
                .build();
    }
}
