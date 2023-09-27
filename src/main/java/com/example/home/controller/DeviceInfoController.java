package com.example.home.controller;

import com.example.home.common.ResultMapUtil;
import com.example.home.entity.DeviceInfo;
import com.example.home.mapper.DeviceInfoMapper;
import com.example.home.mapper.UserMapper;
import com.example.home.service.DeviceInfoService;
import com.example.home.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class DeviceInfoController {

    @Autowired
    private DeviceInfoService deviceInfoService;

    @RequestMapping("/deviceInfoList")
    @ResponseBody
    public Object deviceInfoList(){

        List<DeviceInfo> deviceInfoList = deviceInfoService.queryDeviceInfoList();

        return deviceInfoList;

    }
}
