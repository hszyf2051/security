package com.yif.security.expression;

import com.yif.security.entity.LoginUser;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Yif
 * @date 2023/7/25 9:14
 */
@Component("ex")
public class ExpressionRoot {

    public boolean hasAuthority(String authority) {
        // 获取当前登陆人信息
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        List<String> permissions = loginUser.getPermissions();
        // 判断接口上是否有权限字符串
        return permissions.contains(authority);
    }
}
