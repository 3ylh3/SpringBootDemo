package com.xiaobai.springbootdemo.controller;

import com.xiaobai.springbootdemo.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/SpringBootDemo")
public class UsercenterPageController {
    @RequestMapping("/usercenter")
    public String usercenter(HttpServletRequest request, Model model){
        String ID = request.getParameter("ID");
        HttpSession session = request.getSession();
        if(ID == null){
            return "redirect:/SpringBootDemo/login";
        }
        else if(ID.equals(session.getId())) {
            model.addAttribute("username",session.getAttribute("username"));
            model.addAttribute("head",session.getAttribute("head"));
            model.addAttribute("nickname",session.getAttribute("nickname"));
            model.addAttribute("sex",session.getAttribute("sex"));
            model.addAttribute("email",session.getAttribute("email"));
            model.addAttribute("mobile",session.getAttribute("mobile"));
            model.addAttribute("birthday",session.getAttribute("birthday"));
            model.addAttribute("introduce",session.getAttribute("introduce"));
            return "userCenter";
        }
        else{
            return "redirect:/SpringBootDemo/login";
        }
    }
}
