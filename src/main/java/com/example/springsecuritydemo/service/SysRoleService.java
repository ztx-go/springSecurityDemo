package com.example.springsecuritydemo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.springsecuritydemo.entity.SysRole;

public interface SysRoleService extends IService<SysRole> {

    void create(SysRole sysRole);

    SysRole selectByName(String name);

}
