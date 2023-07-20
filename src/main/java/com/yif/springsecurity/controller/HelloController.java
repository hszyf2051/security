package com.yif.springsecurity.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Yif
 * @date 2023/7/20 14:24
 */
@RestController
@RequestMapping("/hello")
public class HelloController {

    @Operation(summary = "测试接口 - 获取hello")
    @GetMapping("/index")
    public String hello() {
        System.out.println("hello");
        return "hello";
    }
}
