package com.prince.crm.util;

import com.prince.crm.domain.Employee;
import com.prince.crm.domain.Permission;
import com.prince.crm.service.PermissionService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Description 权限校验工具类
 * @Author prince Chen
 * @Date 2019/11/16 21:26
 */
@Component
public class PermissionUtil {

    private static Logger logger = Logger.getLogger(PermissionUtil.class);

    private static PermissionService permissionService;

    @Autowired
    public void setPermissionService(PermissionService permissionService) {
        PermissionUtil.permissionService = permissionService;
    }

    public static boolean checkPermission(String function) {

        /**
         *  1，如果是超级管理员，则放行
         *  2，拿到当前系统所有需要校验的权限url，判断当前方法是否包含在内：
         *      1） 不在其中，则放行
         *      2）在其中，则进一步校验权限
         *          a.拥有，返回true
         *          b.不拥有，返回false
         */
        System.out.println(function);
        Employee employee = (Employee) UserContext.getLocalRequest().getSession().getAttribute(UserContext.USER_SESSION);
        // 是管理员，直接放行
        if (employee.getAdmin()) {
            logger.info("===> 用户[" + employee + "] 为超级管理员，不需要校验权限！");
            return true;
        }

        // 拿到当前系统所有需要校验权限的url
        if (CommonUtil.URLS_NEED_PERMISSION.size() == 0) {
            List<Permission> permissions = permissionService.selectAll();
            for(Permission p : permissions) {
                CommonUtil.URLS_NEED_PERMISSION.add(p.getResource());
            }
            logger.info("===> 需要校验权限的所有资源：" + CommonUtil.URLS_NEED_PERMISSION);

        }

        // 判断当前访问的Controller方法是否在需要权限控制控制的url里面
        if (CommonUtil.URLS_NEED_PERMISSION.contains(function)) {
            // 需要校验权限
            List<String> userPermissions = (List<String>) UserContext.getLocalRequest().getSession().getAttribute(UserContext.PERMISSION_IN_SESSION);
            if (userPermissions.contains(function)) {
                return true;
            } else {
                // ALL 权限校验，拥有ALL权限则返回true
                String allPermission = function.split(":")[0] + ":ALL";
                if(userPermissions.contains(allPermission)) {
                    return true;
                } else {
                    return false;
                }
            }
        } else {
            // no need to check permission
            return true;
        }
    }

}
