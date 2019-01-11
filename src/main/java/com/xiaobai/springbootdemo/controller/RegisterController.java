package com.xiaobai.springbootdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/SpringBootDemo")
public class RegisterController {
    @RequestMapping("/register")
    public String register(){
        return "register";
    }
}
