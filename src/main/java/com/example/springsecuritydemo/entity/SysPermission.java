package com.example.springsecuritydemo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

/**
 * 权限实体类
 *
 * @author jitwxs
 * @since 2018/5/15 18:11
 */
@TableName(value = "sys_permission")
@Data
public class SysPermission implements Serializable {

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @TableField(value = "url")
    private String url;

    @TableField(value = "role_id")
    private Integer roleId;

    @TableField(value = "permission")
    private String permission;

    @TableField(exist = false)
    private List permissions;

    // 省略除permissions外的getter/setter

    public List getPermissions() {
        return Arrays.asList(this.permission.trim().split(","));
    }

    public void setPermissions(List permissions) {
        this.permissions = permissions;
    }

}
