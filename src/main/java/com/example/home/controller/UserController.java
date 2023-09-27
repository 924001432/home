package com.example.home.controller;

import com.example.home.common.ResultMapUtil;
import com.example.home.entity.User;
import com.example.home.mapper.UserMapper;
import com.example.home.service.UserService;
import org.apache.shiro.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;

import javax.servlet.http.HttpSession;


@Controller
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserService userService;

    /**
     * 登录界面
     * @return
     */
    @RequestMapping("/Login")
    public String Login(){

        Session session = SecurityUtils.getSubject().getSession();
        String username = (String) session.getAttribute("username");
        System.out.println(username);

        if (username == null){
            return "/login";
        }else {
            return "redirect:/Index";
        }



    }

    /**
     * 用户密码核实，数据库交互
     * @param username
     * @param password
     * @return
     */
    @RequestMapping("/LoginIn")
    @ResponseBody
    public Object LoginIn(String username,String password){

        if(username==null||password==null){
            return ResultMapUtil.getHashMapLogin("用户名密码不能为空","2");
        }
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username,password);
        try{
            subject.login(token);
        }catch (UnknownAccountException e){
            return ResultMapUtil.getHashMapLogin("用户名不存在","2");
        }catch (IncorrectCredentialsException e){
            return ResultMapUtil.getHashMapLogin("密码错误","2");
        }

        Session session = SecurityUtils.getSubject().getSession();
        session.setAttribute("username",username);                      //默认30min



        return ResultMapUtil.getHashMapLogin("验证成功","1");

    }

    /**
     * 跳转到主页
     * @return
     */
    @RequestMapping("/Index")
    public String Index(){


        return "/index";
    }

    /**
     * 退出登录
     */
    @RequestMapping(value = "/Logout")
    public String Logout(){
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "redirect:/login";
    }

    @RequestMapping("/getUser")
    @ResponseBody
    public String getUser(){
        Session session = SecurityUtils.getSubject().getSession();

        return (String) session.getAttribute("key");
    }
}
