package com.example.home.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.home.entity.DeviceInfo;
import com.example.home.entity.DeviceType;
import com.example.home.mapper.DeviceInfoMapper;
import com.example.home.mapper.DeviceTypeMapper;
import com.example.home.service.DeviceInfoService;
import com.example.home.service.DeviceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceTypeServiceImpl extends ServiceImpl<DeviceTypeMapper, DeviceType> implements DeviceTypeService {

    @Autowired
    private DeviceTypeMapper deviceTypeMapper;

    @Override
    public DeviceType queryDeviceTypeById(DeviceType device) {
        QueryWrapper<DeviceType> wrapper = new QueryWrapper<>();
        wrapper.eq("deviceInfo_id",device.getDeviceTypeId());
        return deviceTypeMapper.selectOne(wrapper);
    }

    @Override
    public List<DeviceType> queryDeviceTypeList(){
        //return this.list();

        return deviceTypeMapper.selectList(null);
    }

    @Override
    public void insertDeviceType(DeviceType device){


        /*
            不为空则更新，空则插入
         */
    }
}
