package com.lz.gateway.controller;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class MyController {
    /**
     * 访问get接口，获取httpbin.org:80返回的信息
     * curl http://localhost:8080/get
     * <p>
     * 访问post接口，获取httpbin.org:80返回的信息
     * curl -X POST http://localhost:8080/post
     * <p>
     * 指定host为www.hystrix.com，延迟3秒，触发hystrix熔断
     * curl --dump-header - --header Host:www.hystrix.com http://localhost:8080/delay/3
     */
    @Bean
    public RouteLocator myRoutes(RouteLocatorBuilder builder) {
        String httpUri = "http://httpbin.org:80";
        return builder.routes()
                .route(p -> p
                        .path("/get")
                        .filters(f -> f.addRequestHeader("Hello", "World1"))
                        .uri(httpUri + "/get"))
                .route(p -> p
                        .path("/post")
                        .filters(f -> f.addRequestHeader("Hello", "World2"))
                        .uri(httpUri + "/post"))
                .route(p -> p
                        .host("*.hystrix.com")
                        .filters(f -> f
                                .hystrix(config -> config
                                        .setName("lz")
                                        .setFallbackUri("forward:/fallback")))
                        .uri(httpUri))
                .build();
    }

    @RequestMapping("/fallback")
    public Mono<String> fallback() {
        return Mono.just("fallback");
    }
}