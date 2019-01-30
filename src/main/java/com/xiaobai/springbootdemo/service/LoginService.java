package com.xiaobai.springbootdemo.service;

import java.util.Map;

public interface LoginService {
    public Map<String,String> login(String username, String password);
}
