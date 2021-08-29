package com.lz.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// 注解@EnableEurekaClient 表明自己是一个eureka client
@EnableEurekaClient
@SpringBootApplication
@RestController
public class EurekaClientApplication {
    @Value("${server.port}")
    String port;

    public static void main(String[] args) {
        SpringApplication.run(EurekaClientApplication.class, args);
    }

    @RequestMapping("/hi")
    public String home(@RequestParam(value = "name", defaultValue = "lz") String name) {
        return "hi " + name + " ,i am from port:" + port;
    }
}