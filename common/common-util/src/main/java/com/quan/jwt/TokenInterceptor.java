package com.quan.jwt;

import com.quan.constant.ConfigConsts;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 全俊
 */
@Slf4j
@Configuration
public class TokenInterceptor extends HandlerInterceptorAdapter implements WebMvcConfigurer {
    private JwtUtils jwtUtils = new JwtUtils();

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        jwtUtils.tokenRefresh();
        if (ConfigConsts.OPTIONS.equalsIgnoreCase(request.getMethod())) {
            return true;
        }
        String username = jwtUtils.parseJwt(request.getHeader("x-token"));
        if (username != null && checkAuth(username, request.getRequestURI())) {
            return true;
        }
        throw new RuntimeException("No access");
    }

    /**
     * 校验用户访问权限
     *
     * @param username
     * @param requestURI
     * @return
     */
    private boolean checkAuth(String username, String requestURI) {
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(this).addPathPatterns("/**").excludePathPatterns(ConfigConsts.LIST);
    }
}