package com.yif.security.filter;

import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.yif.security.entity.LoginUser;
import com.yif.security.util.JwtUtil;
import com.yif.security.util.RedisCache;
import io.jsonwebtoken.Claims;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.annotation.Resource;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Yif
 * @date 2023/7/21 15:48
 * OncePerRequestFilter 在请求之前 只走一次
 */
@Component
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {

    @Resource
    RedisCache redisCache;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        // 1、获取当前请求的uri
        String uri = request.getRequestURI();
        // 判断是否是认证请求路径
        // 是：直接放行
        if (uri.endsWith("/sys/user/login") || uri.endsWith("/sys/user/logout") || uri.startsWith("/swagger-ui")
                || uri.endsWith("doc.html") || uri.startsWith("/webjars/css") || uri.startsWith("/webjars/js")
                || uri.startsWith("/v3/api-docs") || uri.startsWith("/favicon.ico") || uri.startsWith("/v2/api-docs")
                || uri.startsWith("**/*.html") || uri.endsWith("/webjars/springfox-swagger-ui")
                || uri.startsWith("/swagger-resources")) {
            filterChain.doFilter(request, response);
            return;
        }

        // 2、获取token
        String token = request.getHeader("token");
        if (StringUtils.isBlank(token)) {
            filterChain.doFilter(request, response);
            return;
        }
        // 3、解析token
        String userId;
        try {
            Claims claims = JwtUtil.parseJWT(token);
            // 获取签名中的信息
            userId = claims.getSubject();
        } catch (Exception e) {
            throw new RuntimeException("token非法");
        }
        // 4、获取userId， redis获取用户信息
        LoginUser loginUser = redisCache.getCacheObject("loginUser:" + userId);
        if (ObjectUtils.isEmpty(loginUser)) {
            throw new RuntimeException("用户未认证");
        }

        // 5、封装Authentication
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(loginUser, null, null);

        // 6、存入SecurityContextHolder上下文
        SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
        // 放行
        filterChain.doFilter(request, response);
    }
}
