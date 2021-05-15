package com.huchen.springboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author huchen
 * @Date 2021/5/15 0015 下午 20:38
 */
@RestController
public class HelloControllar {
    @RequestMapping("/hello")
    public String hello(){
        return "hello springboot";
    }
}
