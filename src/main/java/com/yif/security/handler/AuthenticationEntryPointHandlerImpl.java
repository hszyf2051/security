package com.yif.security.handler;

import com.alibaba.fastjson.JSON;
import com.yif.security.Enum.Result;
import com.yif.security.Enum.ResultEnum;
import com.yif.security.util.WebUtils;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Yif
 * @date 2023/7/24 16:14
 * 认证失败处理器
 */
@Component
public class AuthenticationEntryPointHandlerImpl implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        Result result = Result.error(ResultEnum.UNAUTHENTICATED.getCode(), ResultEnum.UNAUTHENTICATED.getDesc());
        String json = JSON.toJSONString(result);
        WebUtils.renderString(response, json);
    }
}
