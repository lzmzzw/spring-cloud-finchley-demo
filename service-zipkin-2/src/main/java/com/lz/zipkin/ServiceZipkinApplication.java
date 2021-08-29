package com.lz.zipkin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ServiceZipkinApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceZipkinApplication.class, args);
    }

    // 通过@LoadBalanced注解表明这个为restRemplate开启负载均衡的功能
    @Bean
    @LoadBalanced
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
}