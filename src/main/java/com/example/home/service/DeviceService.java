package com.example.home.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.home.entity.Device;

import java.util.List;


public interface DeviceService extends IService<Device> {

    public Device queryDeviceById(Device device);

    public List<Device> queryDeviceList();

    public void insertDevice(Device device);
}
