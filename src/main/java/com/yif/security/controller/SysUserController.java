package com.yif.security.controller;

import com.yif.security.Enum.Result;
import com.yif.security.entity.SysUser;
import com.yif.security.service.impl.SysUserServiceImpl;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 系统用户表(SysUser)表控制层
 * @author yif
 * @since 2023-07-21 10:38:02
 */
@RestController
@RequestMapping("/sys/user")
@Schema(description = "系统用户接口")
public class SysUserController {

    @Autowired
    private SysUserServiceImpl sysUserService;

    @PostMapping("/login")
    public Result login(@RequestBody SysUser user) {
        return sysUserService.login(user);
    }
}

