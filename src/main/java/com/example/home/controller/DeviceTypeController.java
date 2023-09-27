package com.example.home.controller;

import com.example.home.entity.DeviceInfo;
import com.example.home.entity.DeviceType;
import com.example.home.service.DeviceInfoService;
import com.example.home.service.DeviceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class DeviceTypeController {

    @Autowired
    private DeviceTypeService deviceTypeService;

    @RequestMapping("/deviceTypeList")
    @ResponseBody
    public Object deviceTypeList(){

        List<DeviceType> deviceTypeList = deviceTypeService.queryDeviceTypeList();


        return deviceTypeList;

    }
}
