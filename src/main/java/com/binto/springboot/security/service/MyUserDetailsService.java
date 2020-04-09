package com.binto.springboot.security.service;

import com.binto.springboot.security.mapper.RoleMapper;
import com.binto.springboot.security.mapper.UserMapper;
import com.binto.springboot.security.model.Role;
import com.binto.springboot.security.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RoleMapper roleMapper;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        //查数据库
        User user = userMapper.loadUserByUsername( userName );
        if (null != user) {
            List<Role> roles = roleMapper.getRolesByUserId( user.getId() );
            //将roles作为Authorities放到user中（MyAccessDecisionManager会用到这个Authorities）
            user.setAuthorities( roles );
        }

        return user;
    }


}