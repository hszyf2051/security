package com.yif.security.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Created by IT李老师
 * 公主号 “元动力课堂”
 * 个人微 itlils
 */
@RestController
@RequestMapping("/test")
public class DemoController {

    @GetMapping("/hello")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String hello(){
        return "hello security.yif";
    }
}

