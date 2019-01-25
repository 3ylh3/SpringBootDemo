package com.xiaobai.springbootdemo.controller;

import com.xiaobai.springbootdemo.bean.Message;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/SpringBootDemo")
public class LogoutController {
    @RequestMapping("/logout")
    public Message logout(HttpSession session){
        Message message = new Message();
        //销毁session
        session.invalidate();
        message.setMessage("success");
        return message;
    }
}
