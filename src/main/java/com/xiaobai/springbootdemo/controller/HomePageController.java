package com.xiaobai.springbootdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/SpringBootDemo")
public class HomePageController {
    @RequestMapping("/home")
    public String home(HttpServletRequest request, Model model){
        String ID = request.getParameter("ID");
        HttpSession session = request.getSession();
        if(ID == null){
            return "redirect:/SpringBootDemo/login";
        }
        else if(ID.equals(session.getId())) {
            model.addAttribute("username",session.getAttribute("username"));
            model.addAttribute("head",session.getAttribute("head"));
            model.addAttribute("nickname",session.getAttribute("nickname"));
            return "home";
        }
        else{
            return "redirect:/SpringBootDemo/login";
        }
    }
}
