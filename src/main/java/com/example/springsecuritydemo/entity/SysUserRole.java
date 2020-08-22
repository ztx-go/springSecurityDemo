package com.example.springsecuritydemo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@TableName(value = "sys_user_role")
@Data
public class SysUserRole implements Serializable {

    @TableField(value = "user_id")
    private Long userId;

    @TableField(value = "role_id")
    private Integer roleId;

    // 省略getter/setter
}
