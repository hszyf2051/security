package com.yif.security.service.impl;

import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.yif.security.Enum.Result;
import com.yif.security.entity.LoginUser;
import com.yif.security.entity.SysUser;
import com.yif.security.mapper.SysUserMapper;
import com.yif.security.util.JwtUtil;
import com.yif.security.util.RedisCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Yif
 * @date 2023/7/21 10:08
 */
@Service
public class SysUserServiceImpl {

    @Autowired
    private RedisCache redisCache;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Resource
    private SysUserMapper sysUserMapper;

    /**
     * 用户登录
     * @param user
     * @return
     */
    public Result login(SysUser user) {
        // 1、验证
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(user.getUserName(), user.getPassword());
        Authentication authenticate = authenticationManager.authenticate(usernamePasswordAuthenticationToken);
        // 2、校验失败
        if (ObjectUtils.isEmpty(authenticate)) {
            return Result.error("用户名或密码错误");
        }
        // 3、生成jwt返回给前端
        LoginUser loginUser = (LoginUser) authenticate.getPrincipal();
        String userId = loginUser.getSysUser().getId();
        String token = JwtUtil.createJWT(userId);
        // 4、若redis中没有用户信息缓存，则将用户信息存入redis
        redisCache.setCacheObject("loginUser:" + userId, loginUser);
        Map<String, Object> map = new HashMap<>();
        map.put("token", token);
        map.put("userId", userId);
        return Result.ok(map);
    }

    /**
     * 用户退出
     * @return
     */
    public Result logout() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        String userId = loginUser.getSysUser().getId();
        redisCache.deleteObject("loginUser:" + userId);
        return Result.ok("退出成功");
    }
}
