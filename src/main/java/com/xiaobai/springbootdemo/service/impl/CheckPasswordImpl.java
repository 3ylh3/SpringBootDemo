package com.xiaobai.springbootdemo.service.impl;

import com.xiaobai.springbootdemo.service.CheckPasswordService;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public class CheckPasswordImpl implements CheckPasswordService {
    public String checkPassword(String username, String password, HttpSession session){
        if(password.equals(session.getAttribute("password"))){
            return "success";
        }
        else{
            return "error";
        }
    }
}
