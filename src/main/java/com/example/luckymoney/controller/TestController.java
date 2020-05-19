package com.example.luckymoney.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class TestController {

    @Autowired
    RestTemplate restTemplate;


    @RequestMapping(value = "/hello")
    public String hello() {
        return "hello spring boot";
    }

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }


}
