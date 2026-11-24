package com.moon.constant;

/**
 * 用户常量类
 *
 * @author moon
 */
public interface UserConstant {

    /**
     * 用户登录状态（用于 session 的键）
     */
    String USER_LOGIN_STATE = "userLoginState";

    /**
     * 普通用户（默认权限）
     */
    Integer DEFAULT_ROLE=0;

    /**
     * 管理员权限
     */
    Integer ADMIN_ROLE=1;

}
