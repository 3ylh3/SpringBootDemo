package com.xiaobai.springbootdemo.service;

import org.apache.ibatis.annotations.Param;

import javax.servlet.http.HttpSession;

public interface SaveUserInfoService {
    public String saveUserInfo(String username, String nickname, String sex, String email, String mobile, String birthday, String introduce, HttpSession session);
}
