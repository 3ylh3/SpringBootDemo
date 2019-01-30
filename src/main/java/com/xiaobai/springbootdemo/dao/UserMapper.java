package com.xiaobai.springbootdemo.dao;

import com.xiaobai.springbootdemo.bean.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    public void register(@Param("username") String username, @Param("password") String password);
    public String checkUsername(@Param("username") String username);
    public User queryUserByUsername(@Param("username")String username);
    public void saveUserInfo(@Param("username")String username,@Param("nickname")String nickname,@Param("sex")String sex,@Param("email")String email,@Param("mobile")String mobile,@Param("birthday")String birthday,@Param("introduce")String introduce);
    public void saveHead(@Param("username")String username,@Param("head")String head);
}
