package com.xiaobai.springbootdemo.controller;

import com.xiaobai.springbootdemo.bean.Message;
import com.xiaobai.springbootdemo.bean.User;
import com.xiaobai.springbootdemo.service.RegisterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/SpringBootDemo")
public class RegisterController {
    @Autowired
    RegisterService registerService;
    private Logger logger = LoggerFactory.getLogger("Register");
    @RequestMapping(value = "/submitReg",method = RequestMethod.POST)
    public Message submitReg(@RequestBody User user){
        logger.info("register-------------------------------------------------------------");
        logger.info("username:" + user.getUsername() + "    password:" + user.getPassword());
        Message response = new Message();
        String message = registerService.register(user.getUsername(),user.getPassword());
        if(message.equals("success")) {
            logger.info("response:" + message);
        }
        else{
            logger.error(message);
        }
        response.setMessage(message);
        return response;
    }
}
