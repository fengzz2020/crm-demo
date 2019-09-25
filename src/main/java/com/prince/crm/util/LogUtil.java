package com.prince.crm.util;

import com.prince.crm.domain.Employee;
import com.prince.crm.domain.Log;
import com.prince.crm.service.LogService;
import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.JoinPoint;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Date;

/**
 * @Author: Prince Chen
 * @Description: 日志切面类
 * @Date: Create in 2019/9/25 22:19
 */
public class LogUtil {
    @Autowired
    private LogService logService;

    public void writeLog(JoinPoint joinPoint) {
        if (joinPoint.getTarget() instanceof LogService) {
            return;
        }

        Log log = new Log();
        Object[] args = joinPoint.getArgs();
        log.setParams(Arrays.toString(args));
        String clszz = joinPoint.getTarget().getClass().toString();
        String method = joinPoint.getSignature().getName();
        log.setFunction(clszz + ":" + method);
        log.setOptime(new Date());

        HttpServletRequest localRequest = UserContext.getLocalRequest();

        Employee currentUser = (Employee) localRequest.getSession().getAttribute(UserContext.USER_SESSION);
        log.setOpuser(currentUser);
        log.setOpip(localRequest.getRemoteAddr());

        logService.insert(log);

    }
}
