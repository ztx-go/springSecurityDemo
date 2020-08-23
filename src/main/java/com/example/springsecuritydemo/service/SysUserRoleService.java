package com.example.springsecuritydemo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.springsecuritydemo.entity.SysUserRole;

import java.util.List;

public interface SysUserRoleService extends IService<SysUserRole> {

    void create(SysUserRole sysUserRole);

    List<SysUserRole> selectByUserId(Long userId);
}
