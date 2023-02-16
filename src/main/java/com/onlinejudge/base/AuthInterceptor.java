package com.onlinejudge.base;

import cn.hutool.core.util.ObjectUtil;
import com.onlinejudge.bean.model.User;
import com.onlinejudge.untils.UserHolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AuthInterceptor implements HandlerInterceptor {
    private final Logger log= LoggerFactory.getLogger("Auth Interceptor");
    @Autowired
    private UserHolder userHolder;
    @Autowired
    private LoginService loginService;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (request.getMethod().equalsIgnoreCase("options")) {
            return true;
        }
        String token = request.getHeader("Auth-token");
        log.info("【过滤器拦截】 Auth-token:{}",token);
        if(ObjectUtil.isEmpty(token)) return false;
        User user = loginService.login(token);
        userHolder.putUser(user);
        return true;
    }
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        userHolder.removeUser();
        response.setHeader("Auth-token",userHolder.getUser().getId().toString());
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
