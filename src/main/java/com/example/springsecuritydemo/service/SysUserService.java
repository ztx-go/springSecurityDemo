package com.example.springsecuritydemo.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.example.springsecuritydemo.entity.SysUser;

public interface SysUserService extends IService<SysUser> {


    void create(SysUser sysUser);

    SysUser selectByName(String name);
}
