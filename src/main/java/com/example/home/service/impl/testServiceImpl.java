package com.example.home.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.example.home.entity.testEntity;
import com.example.home.mapper.testMapper;
import com.example.home.service.testService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户service实现类
 */
@Service
public class testServiceImpl extends ServiceImpl<testMapper, testEntity> implements testService {

    @Autowired
    private testMapper userMapper;

    @Override
    public testEntity queryUserById(testEntity user) {
        QueryWrapper<testEntity> wrapper = new QueryWrapper<>();
        wrapper.eq("idtest_table",user.getIdtestTable());
        return userMapper.selectOne(wrapper);
    }

}