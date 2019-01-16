package com.xiaobai.springbootdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/SpringBootDemo")
public class RegisterSuccessPageController {
    @RequestMapping(value = "/registerSuccess",method = RequestMethod.POST)
    public String regesterSuccess(){
        return "registerSuccess";
    }
}
