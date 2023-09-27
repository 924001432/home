package com.example.home.service;

import com.baomidou.mybatisplus.extension.service.IService;

import com.example.home.entity.DeviceInfo;

import java.util.List;


public interface DeviceInfoService extends IService<DeviceInfo> {

    public DeviceInfo queryDeviceInfoById(DeviceInfo device);

    public List<DeviceInfo> queryDeviceInfoList();

    public void insertDeviceInfo(DeviceInfo device);
}
