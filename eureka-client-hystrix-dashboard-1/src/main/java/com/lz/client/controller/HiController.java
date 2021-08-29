package com.lz.client.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HiController {
    @Value("${server.port}")
    String port;

    @RequestMapping("/hi")
    @HystrixCommand(fallbackMethod = "hiError")
    public String hi(@RequestParam(value = "name", defaultValue = "lz") String name) {
        return "hi " + name + ", i am from port: " + port;
    }

    public String hiError(String name) {
        return "sorry, " + name;
    }
}