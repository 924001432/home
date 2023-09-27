package com.example.home.entity;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName(value = "device_info")
public class DeviceInfo {
    @TableField(value = "deviceInfo_id")
    @TableId(value = "deviceInfo_id",type = IdType.AUTO)
    private Integer deviceInfoId;

    @TableField(value = "deviceInfo_name")
    private String deviceInfoName;

    @TableField(value = "deviceInfo_type")
    private String deviceInfoType;

    @TableField(value = "deviceInfo_status")
    private String deviceInfoStatus;

    @TableField(value = "deviceInfo_icon")
    private String deviceInfoIcon;
}
