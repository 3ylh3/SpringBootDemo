package com.xiaobai.springbootdemo.service;

import javax.servlet.http.HttpSession;

public interface SaveHeadService {
    public String saveHead(String username, String tmpImg,HttpSession session);
}
