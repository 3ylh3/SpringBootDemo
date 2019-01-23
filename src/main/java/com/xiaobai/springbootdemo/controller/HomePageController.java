package com.xiaobai.springbootdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/SpringBootDemo")
public class HomePageController {
    @RequestMapping("/home")
    public String home(@RequestParam("ID") String ID, HttpSession session){
        if(ID.equals(session.getId())) {
            return "home";
        }
        else{
            return "redirect:/SpringBootDemo/login";
        }
    }
}
