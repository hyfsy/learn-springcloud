package com.hyf.cloud.nacos.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author baB_hyf
 * @date 2021/05/30
 */
@Configuration
public class RouteConfiguration {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("path_route", r -> r.path("/get")
                        .uri("http://httpbin.org"))
                // .route(p -> p.path("/get")
                //         .filters(f -> f.addRequestHeader("Hello", "World"))
                //         .uri("http://httpbin.org:80").metadata("key", "value"))
                .route("host_route", r -> r.host("*.myhost.org")
                        .uri("http://httpbin.org"))
                .route("rewrite_route", r -> r.host("*.rewrite.org")
                        .filters(f -> f.rewritePath("/foo/(?<segment>.*)", "/${segment}"))
                        .uri("http://httpbin.org"))
                // .route("hystrix_route", r -> r.host("*.hystrix.org")
                //         .filters(f -> f.hystrix(c -> c.setName("slowcmd")))
                //         .uri("http://httpbin.org"))
                // .route("hystrix_fallback_route", r -> r.host("*.hystrixfallback.org")
                //         .filters(f -> f.hystrix(c -> c.setName("slowcmd").setFallbackUri("forward:/hystrixfallback"))) // 网关的api
                //         .uri("http://httpbin.org"))
                // .route("limit_route", r -> r
                //         .host("*.limited.org").and().path("/anything/**")
                //         .filters(f -> f.requestRateLimiter(c -> c.setRateLimiter(myRedisRateLimiter()))) // RedisRateLimiter
                //         .uri("http://httpbin.org"))
                .build();

    }

    // @Bean
    // public RedisRateLimiter myRedisRateLimiter() {
    //     return new RedisRateLimiter(30, 60, 1);
    // }
    //
    // @Bean
    // public KeyResolver myKeyResolver() {
    //     return new PrincipalNameKeyResolver();
    // }
}
