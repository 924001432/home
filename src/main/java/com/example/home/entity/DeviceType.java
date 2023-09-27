package com.example.home.entity;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "device_type")
public class DeviceType {
    @TableField(value = "deviceType_id")
    @TableId(value = "deviceType_id",type = IdType.AUTO)
    private Integer deviceTypeId;

    @TableField(value = "deviceType_name")
    private String deviceTypeName;

    @TableField(value = "deviceType_icon")
    private String deviceTypeIcon;
}
