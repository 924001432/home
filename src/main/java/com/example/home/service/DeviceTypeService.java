package com.example.home.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.home.entity.DeviceType;

import java.util.List;


public interface DeviceTypeService extends IService<DeviceType> {

    public DeviceType queryDeviceTypeById(DeviceType device);

    public List<DeviceType> queryDeviceTypeList();

    public void insertDeviceType(DeviceType device);
}
