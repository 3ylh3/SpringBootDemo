package com.xiaobai.springbootdemo.controller;

import com.xiaobai.springbootdemo.bean.Message;
import com.xiaobai.springbootdemo.bean.User;
import com.xiaobai.springbootdemo.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/SpringBootDemo")
public class LoginController {
    @Autowired
    LoginService loginService;
    @RequestMapping(value = "/submit",method = RequestMethod.POST)
    public Message login(@RequestBody User user, HttpServletRequest request, HttpServletResponse response){
        //设置session
        HttpSession session = request.getSession();
        session.setAttribute("username",user.getUsername());
        session.setAttribute("password",user.getPassword());
        //将sessionId存在cookie中返回
        String sessionId = session.getId();
        Cookie cookie = new Cookie("JSESSIONID", sessionId);
        cookie.setPath(request.getContextPath());
        response.addCookie(cookie);
        Message message = new Message();
        message.setMessage(loginService.login(user.getUsername(),user.getPassword()));
        return message;
    }
}
