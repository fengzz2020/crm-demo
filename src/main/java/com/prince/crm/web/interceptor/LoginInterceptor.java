package com.prince.crm.web.interceptor;

import com.prince.crm.domain.Employee;
import com.prince.crm.util.PermissionUtil;
import com.prince.crm.util.UserContext;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author: Prince Chen
 * @Description:
 * @Date: Create in 2019/9/22 16:20
 */
public class LoginInterceptor implements HandlerInterceptor {


    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object handler) throws Exception {
        // 将request设置到当前线程的ThreadLocal中，供后面的Log切面类使用
        UserContext.setLocalRequest(httpServletRequest);

        // 是否登录判断
        Employee emp = (Employee) httpServletRequest.getSession().getAttribute(UserContext.USER_SESSION);
        if(emp == null) {
            httpServletResponse.sendRedirect("/login.jsp");
            return false;
        }

        // 是否拥有权限校验
        if(handler instanceof HandlerMethod) {
            HandlerMethod hm = (HandlerMethod) handler;
            String requestMethod = hm.getBean().getClass().getName() + ":" + hm.getMethod().getName();
            // 判断用户是否拥有访问此方法的权限
            boolean hasPermission = PermissionUtil.checkPermission(requestMethod);
            if(hasPermission) {
                return true;
            } else {
                if(hm.getMethod().isAnnotationPresent(ResponseBody.class)) {
                    // 如果是Ajax请求，返回json数据
                    // 这里采用重定向，需要两次请求，其实可以直接返回json数据
                    httpServletResponse.sendRedirect("/noPermission.json");
                } else {
                    // 如果是页面请求，返回的是页面
                    httpServletResponse.sendRedirect("/noPermission.jsp");
                }

            }

        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
