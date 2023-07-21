package com.yif.security.controller;

import com.yif.security.service.SysRoleService;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * 系统角色表(SysRole)表控制层
 * @author yif
 * @since 2023-07-21 10:38:02
 */
@RestController
@RequestMapping("/sys/role")
@Schema(description = "系统角色接口")
public class SysRoleController {

    @Autowired
    private SysRoleService sysRoleService;

}

