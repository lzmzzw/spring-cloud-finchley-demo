package com.lz.feign;

import com.lz.feign.service.HiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

public class controller {
    @RestController
    public static class HiController {
        @Autowired
        private HiService hiService;

        @GetMapping(value = "/hi")
        public String sayHi(@RequestParam String name) {
            return hiService.sayHi(name);
        }
    }
}
