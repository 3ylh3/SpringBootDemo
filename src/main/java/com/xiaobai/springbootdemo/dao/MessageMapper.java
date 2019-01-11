package com.xiaobai.springbootdemo.dao;

import com.xiaobai.springbootdemo.bean.Message;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageMapper {
    public Message getMessage(@Param("id")String id);
}
