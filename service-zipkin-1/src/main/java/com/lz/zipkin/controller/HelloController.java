package com.lz.zipkin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
public class HelloController {
    private static final Logger logger = Logger.getLogger(HelloController.class.getName());

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/hi")
    public String callHome() {
        logger.log(Level.INFO, "calling trace service-zipkin-1");
        return restTemplate.getForObject("http://localhost:8989/info2", String.class);
    }

    @RequestMapping("/info1")
    public String info1() {
        logger.log(Level.INFO, "calling trace service-zipkin-1");
        return "i'm service-zipkin-1";
    }
}