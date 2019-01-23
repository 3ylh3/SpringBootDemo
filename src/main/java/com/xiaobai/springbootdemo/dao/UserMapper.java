package com.xiaobai.springbootdemo.dao;

import com.xiaobai.springbootdemo.bean.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    public void register(@Param("username") String username, @Param("password") String password);
    public String checkUsername(@Param("username") String username);
    public User queryUserByUsername(@Param("username")String username);
}
