package com.example.springsecuritydemo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.springsecuritydemo.entity.SysPermission;

import java.util.List;

public interface SysPermissionService extends IService<SysPermission> {

    List<SysPermission> listByRoleId(Long roleId);
}
