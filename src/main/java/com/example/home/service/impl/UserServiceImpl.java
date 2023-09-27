package com.example.home.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.home.entity.User;
import com.example.home.mapper.UserMapper;
import com.example.home.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User queryUserByNameAndPassword(String username,String password) {
        QueryWrapper<User> QueryWrapper = new QueryWrapper<>();

        QueryWrapper.eq("u_name",username)
                .eq("u_psw", password);

        //User QueryUser = userMapper.selectOne(QueryWrapper1);

        return userMapper.selectOne(QueryWrapper);
    }

    @Override
    public User queryUserById(User user) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("u_id",user.getUId());
        return userMapper.selectOne(wrapper);
    }

    @Override
    public User queryUserByName(User user) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("u_name",user.getUName());
        return userMapper.selectOne(wrapper);
    }

}