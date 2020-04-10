package com.binto.springboot.security.mapper;

import com.binto.springboot.security.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    @Select( "select id , username , password, last_password_reset_date from user where username = #{username}" )
    User loadUserByUsername(@Param("username") String username);

}
