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
        logger.log(Level.INFO, "calling trace service-zipkin-2");
        return restTemplate.getForObject("http://localhost:8988/info1", String.class);
    }

    @RequestMapping("/info2")
    public String info2() {
        logger.log(Level.INFO, "calling trace service-zipkin-2");
        return "i'm service-zipkin-2";
    }
}
