package com.example.springsecuritydemo.controller;

import com.example.springsecuritydemo.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    SysUserService sysUserService;

    @GetMapping("/echo")
    public String demo() {
        return "示例返回";
    }

    @GetMapping("/home")
    public String home() {
        sysUserService.getById("1");
        return "我是首页";
    }

    @GetMapping("/admin")
    public String admin() {
        return "我是管理员";
    }

    @GetMapping("/normal")
    public String normal() {
        return "我是普通用户";
    }

}
