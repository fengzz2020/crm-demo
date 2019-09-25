package com.prince.crm.web.interceptor;

import com.prince.crm.domain.Employee;
import com.prince.crm.util.UserContext;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author: Prince Chen
 * @Description:
 * @Date: Create in 2019/9/22 16:20
 */
public class LoginInceptor implements HandlerInterceptor {


    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        // 将request设置到当前线程的ThreadLocal中，供后面的Log切面类使用
        UserContext.setLocalRequest(httpServletRequest);

        Employee emp = (Employee) httpServletRequest.getSession().getAttribute(UserContext.USER_SESSION);
        if(emp == null) {
            httpServletResponse.sendRedirect("/login.jsp");
            return false;
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
