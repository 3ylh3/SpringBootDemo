package com.xiaobai.springbootdemo.controller;

import com.xiaobai.springbootdemo.bean.Message;
import com.xiaobai.springbootdemo.bean.User;
import com.xiaobai.springbootdemo.service.CheckPasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/SpringBootDemo")
public class CheckPasswordController {
    @Autowired
    CheckPasswordService checkPasswordService;
    @RequestMapping("/checkPassword")
    public Message checkPassword(@RequestBody User user, HttpSession session){
        Message message = new Message();
        message.setMessage(checkPasswordService.checkPassword(user.getUsername(),user.getPassword(),session));
        return message;
    }
}
