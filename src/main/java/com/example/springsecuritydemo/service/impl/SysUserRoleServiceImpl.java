package com.example.springsecuritydemo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.springsecuritydemo.entity.SysUserRole;
import com.example.springsecuritydemo.mapper.SysUserRoleMapper;
import com.example.springsecuritydemo.service.SysUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SysUserRoleServiceImpl extends ServiceImpl<SysUserRoleMapper, SysUserRole> implements SysUserRoleService {

    @Autowired
    SysUserRoleMapper sysUserRoleMapper;

    @Transactional
    @Override
    public void create(SysUserRole sysUserRole) {
        sysUserRoleMapper.insert(sysUserRole);
    }

    @Override
    public List<SysUserRole> selectByUserId(Long userId) {
        QueryWrapper<SysUserRole> queryWrapper = new QueryWrapper<>();
//        注意这里的参数是表的字段
        queryWrapper.eq("user_id", userId);
        List<SysUserRole> sysUserRoles = sysUserRoleMapper.selectList(queryWrapper);
        return sysUserRoles;
    }
}
