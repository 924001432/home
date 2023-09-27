package com.example.home.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName(value = "user")
public class User implements Serializable {

    @TableField(value = "u_id")
    @TableId(value = "u_id",type = IdType.AUTO)
    private Integer uId;


    @TableField(value = "u_name")
    private String uName;

    /*电话*/
    @TableField(value = "u_psw")
    private String uPsw;
}
