package com.xiaobai.springbootdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/SpringBootDemo")
public class RegisterPageController {
    @RequestMapping("/register")
    public String register(){
        return "register";
    }
    @RequestMapping("/registerSuccess")
    public String regesterSuccess(){
        return "registerSuccess";
    }
}
