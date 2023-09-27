package com.example.home.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.home.entity.User;


/**
 * 用户表的service接口
 */
public interface UserService extends IService<User> {
    /**
     * 根据用户名查询用户对象
     */

    public User queryUserById(User user);

    public User queryUserByName(User user);

    public User queryUserByNameAndPassword(String username,String password);


}
/**
 * for(i=0,j=0,i<re_len;i++){
 *         if(result[i] between A-Z) {//统计
 *             nterm[j] = result[i];
 *             j++;
 *         }
 *     }
 */