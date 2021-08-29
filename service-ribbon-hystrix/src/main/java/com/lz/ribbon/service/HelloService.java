package com.lz.ribbon.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HelloService {
    @Autowired
    private RestTemplate restTemplate;

    // 在hiService方法上加上@HystrixCommand注解，该注解对该方法创建了熔断器的功能，并指定了fallbackMethod熔断方法
    @HystrixCommand(fallbackMethod = "saySorry")
    public String sayHello(String name) {
        return restTemplate.getForObject("http://eureka-client/hi?name=" + name, String.class);
    }

    public String saySorry(String name) {
        return "sorry, " + name;
    }
}