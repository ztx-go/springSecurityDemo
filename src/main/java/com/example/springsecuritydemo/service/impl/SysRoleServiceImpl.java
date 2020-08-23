package com.example.springsecuritydemo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.springsecuritydemo.entity.SysRole;
import com.example.springsecuritydemo.mapper.SysRoleMapper;
import com.example.springsecuritydemo.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements SysRoleService {

    @Autowired
    SysRoleMapper sysRoleMapper;

    @Transactional
    @Override
    public void create(SysRole sysRole) {
        sysRoleMapper.insert(sysRole);
    }

    @Override
    public SysRole selectByName(String name) {
        QueryWrapper<SysRole> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name", name);
        SysRole sysRole = sysRoleMapper.selectOne(queryWrapper);
        return sysRole;
    }
}
