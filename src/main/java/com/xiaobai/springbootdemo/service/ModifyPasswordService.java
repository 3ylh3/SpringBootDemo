package com.xiaobai.springbootdemo.service;

import javax.servlet.http.HttpSession;

public interface ModifyPasswordService {
    public String modifyPassword(String uername, String password, HttpSession session);
}
