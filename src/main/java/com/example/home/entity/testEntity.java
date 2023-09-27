package com.example.home.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName(value = "test_table")
public class testEntity implements Serializable {

    /*主键*/
    @TableField(value = "idtest_table")
    @TableId(value = "idtest_table",type = IdType.AUTO)
    private Integer idtestTable;
}
