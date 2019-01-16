package com.xiaobai.springbootdemo.controller;

import com.xiaobai.springbootdemo.bean.Message;
import com.xiaobai.springbootdemo.bean.User;
import com.xiaobai.springbootdemo.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/SpringBootDemo")
public class Register {
    @Autowired
    RegisterService registerService;
    @RequestMapping(value = "/submitReg",method = RequestMethod.POST)
    public Message register(@RequestBody User user){
        Message response = new Message();
        String message = registerService.register(user.getUsername(),user.getPassword());
        if(message.equals("success")){
            response.setMessage("注册成功！");
        }
        else{
            response.setMessage(message);
        }
        return response;
    }
}
