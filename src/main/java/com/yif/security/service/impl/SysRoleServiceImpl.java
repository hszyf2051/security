package com.yif.security.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yif.security.entity.SysRole;
import com.yif.security.mapper.SysRoleMapper;
import com.yif.security.service.SysRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 角色表(SysRole)表服务实现类
 * @author yif
 * @since 2023-07-21 10:38:12
 */
@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole>  implements SysRoleService {
    @Resource
    private SysRoleMapper sysRoleMapper;

}
