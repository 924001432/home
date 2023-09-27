package com.example.home.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.home.entity.testEntity;

/**
 * 用户表的service接口
 */
public interface testService extends IService<testEntity> {
    /**
     * 根据用户名查询用户对象
     */

    public testEntity queryUserById(testEntity entity);
}