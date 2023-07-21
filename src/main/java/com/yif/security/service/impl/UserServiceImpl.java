package com.yif.security.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.yif.security.entity.LoginUser;
import com.yif.security.entity.SysUser;
import com.yif.security.mapper.SysUserMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Yif
 * @date 2023/7/21 10:08
 */
@Service
public class UserServiceImpl implements UserDetailsService {

    @Resource
    private SysUserMapper sysUserMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 1、根据用户名获取数据库的用户
        LambdaQueryWrapper<SysUser> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(SysUser::getUserName,username);
        SysUser sysUser = sysUserMapper.selectOne(wrapper);
        if (ObjectUtils.isEmpty(sysUser)) {
            throw new RuntimeException("用户名错误！");
        }
        // TODO 2、查询用户权限

        // 3、返回UserDetails
        return new LoginUser(sysUser);
    }
}
