package com.xiaobai.springbootdemo.service;

import javax.servlet.http.HttpSession;

public interface CheckPasswordService {
    public String checkPassword(String username, String password, HttpSession session);
}
