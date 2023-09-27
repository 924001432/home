package com.example.home.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.home.entity.Device;
import com.example.home.entity.DeviceInfo;
import com.example.home.mapper.DeviceInfoMapper;
import com.example.home.mapper.DeviceMapper;
import com.example.home.service.DeviceInfoService;
import com.example.home.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceInfoServiceImpl extends ServiceImpl<DeviceInfoMapper, DeviceInfo> implements DeviceInfoService {

    @Autowired
    private DeviceInfoMapper deviceInfoMapper;

    @Override
    public DeviceInfo queryDeviceInfoById(DeviceInfo device) {
        QueryWrapper<DeviceInfo> wrapper = new QueryWrapper<>();
        wrapper.eq("deviceInfo_id",device.getDeviceInfoId());
        return deviceInfoMapper.selectOne(wrapper);
    }

    @Override
    public List<DeviceInfo> queryDeviceInfoList(){
        //return this.list();

        return deviceInfoMapper.selectList(null);
    }

    @Override
    public void insertDeviceInfo(DeviceInfo device){


        /*
            不为空则更新，空则插入
         */
    }
}
