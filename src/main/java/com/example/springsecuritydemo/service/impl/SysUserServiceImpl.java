package com.example.springsecuritydemo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.springsecuritydemo.entity.SysUser;
import com.example.springsecuritydemo.mapper.SysUserMapper;
import com.example.springsecuritydemo.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

    @Autowired
    SysUserMapper sysUserMapper;

    @Transactional
    @Override
    public void create(SysUser sysUser) {
        sysUserMapper.insert(sysUser);
    }

    @Override
    public SysUser selectByName(String name) {
        QueryWrapper<SysUser> queryWrapper = new QueryWrapper();
        queryWrapper.eq("name", name);
        SysUser user = sysUserMapper.selectOne(queryWrapper);
        return user;
    }
}
