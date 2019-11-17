package com.prince.crm.util;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: Prince Chen
 * @Description:
 * @Date: Create in 2019/9/22 16:41
 */
public class UserContext {
    public static final String USER_SESSION = "CRM_USER_SESSION";
    public static final String PERMISSION_IN_SESSION = "PERMISSION_IN_SESSION";

    private static ThreadLocal<HttpServletRequest> local = new ThreadLocal<>();

    public static HttpServletRequest getLocalRequest() {
        return local.get();
    }

    public static void setLocalRequest(HttpServletRequest request) {
        local.set(request);
    }
}
