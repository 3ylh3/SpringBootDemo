package com.xiaobai.springbootdemo.controller;

import com.xiaobai.springbootdemo.bean.Message;
import com.xiaobai.springbootdemo.bean.User;
import com.xiaobai.springbootdemo.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;

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
        //设置超时时间
        cookie.setMaxAge(1000*60*60*24*7);
        response.addCookie(cookie);
        Message message = new Message();
        Map<String,String> map = loginService.login(user.getUsername(),user.getPassword());
        message.setMessage(map.get("message"));
        session.setAttribute("head",map.get("head"));
        session.setAttribute("nickname",map.get("nickname"));
        session.setAttribute("sex",map.get("sex"));
        session.setAttribute("email",map.get("email"));
        session.setAttribute("mobile",map.get("mobile"));
        session.setAttribute("birthday",map.get("birthday"));
        session.setAttribute("introduce",map.get("introduce"));
        return message;
    }
}
