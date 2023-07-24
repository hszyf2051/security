package com.yif.security.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yif.security.entity.SysUser;
import com.yif.security.entity.vo.UserRoleVo;

import java.util.List;

/**
 * @author Yif
 * @date 2023/7/20 15:31
 */
public interface SysUserMapper extends BaseMapper<SysUser> {

    List<UserRoleVo> selectUserRolById(String userId);
}
