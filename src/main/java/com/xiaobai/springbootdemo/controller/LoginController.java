package com.xiaobai.springbootdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
    @RequestMapping("/SpringBootDemo")
    public String index(){
        return "login";
    }
}
