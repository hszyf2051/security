package com.yif.security.Enum;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Yif
 * @description 返回参数枚举类
 **/
@Getter
@AllArgsConstructor
public enum ResultEnum {

    SUCCESS(200, "成功"),

    ERROR(10001, "错误"),

    UNAUTHENTICATED(401, "认证失败"),
    AUTH_FAIL(403, "权限不足"),

    // token异常
    TOKEN_PAST(1401, "身份过期，请求重新登录！"),
    TOKEN_ERROR(1402, "令牌错误"),
    HEADER_ERROR(1403, "请求头错误"),
    AUTH_USERNAME_NONE(1405, "用户名不能为空"),
    AUTH_PASSWORD_NONE(1406, "密码不能为空"),

    MENU_NO(306, "没此权限，请联系管理员！"),

    SYSTEM_ERROR(50000, "系统内部异常");

    private final Integer code;
    private final String desc;
}