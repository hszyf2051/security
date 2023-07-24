package com.yif.security.handler;

import com.alibaba.fastjson.JSON;
import com.yif.security.Enum.Result;
import com.yif.security.Enum.ResultEnum;
import com.yif.security.util.WebUtils;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Yif
 * @date 2023/7/24 16:23
 * 权限处理器
 */
@Component
public class AccessDeniedHandlerImpl implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        Result result = Result.error(ResultEnum.AUTH_FAIL.getCode(),ResultEnum.AUTH_FAIL.getDesc());
        String json = JSON.toJSONString(result);
        WebUtils.renderString(response, json);
    }
}
