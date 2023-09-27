package com.example.home.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.home.entity.Device;
import com.example.home.mapper.DeviceMapper;
import com.example.home.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceServiceImpl extends ServiceImpl<DeviceMapper, Device> implements DeviceService {

    @Autowired
    private DeviceMapper deviceMapper;

    @Override
    public Device queryDeviceById(Device device) {
        QueryWrapper<Device> wrapper = new QueryWrapper<>();
        wrapper.eq("device_id",device.getDeviceId());
        return deviceMapper.selectOne(wrapper);
    }

    @Override
    public List<Device> queryDeviceList(){
        //return this.list();

        return deviceMapper.selectList(null);
    }

    @Override
    public void insertDevice(Device device){

        QueryWrapper<Device> wrapper = new QueryWrapper<>();
        wrapper.eq("device_serial",device.getDeviceSerial());

        if(deviceMapper.selectOne(wrapper)!=null){
            deviceMapper.update(device,wrapper);
        }else {
            deviceMapper.insert(device);
        }
        /*
            不为空则更新，空则插入
         */
    }
}
