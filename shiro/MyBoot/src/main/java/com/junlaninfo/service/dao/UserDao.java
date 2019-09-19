package com.junlaninfo.service.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.junlaninfo.entity.User;

public interface UserDao {
    @Select("select * from user where username=#{username} ;")
	User login(@Param("username")String username);
    
}
