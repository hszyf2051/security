package com.yif.security;

import com.yif.security.entity.SysUser;
import com.yif.security.entity.vo.UserRoleVo;
import com.yif.security.mapper.SysUserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class SpringSecurityApplicationTests {

    @Resource
    private SysUserMapper sysUserMapper;

    @Test
    void contextLoads() {
        List<SysUser> sysUsers = sysUserMapper.selectList(null);
        System.out.println(sysUsers);
    }

    @Test
    void selectRole() {
        List<UserRoleVo> userRoleVos = sysUserMapper.selectUserRolById("1671414749908094977");
        System.out.println(userRoleVos);
    }

}
