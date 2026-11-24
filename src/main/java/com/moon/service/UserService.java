package com.moon.service;

import com.baomidou.mybatisplus.spring.service.IService;
import com.moon.domain.entity.User;
import com.moon.domain.vo.UserVO;

import javax.servlet.http.HttpServletRequest;

/**
 * 用户服务业务层
 *
 * @author moon
 */
public interface UserService extends IService<User> {
    /**
     * 用户注册方法
     *
     * @param userAccount 用户账号
     * @param pwd         用户密码
     * @param checkPwd    用户二次密码
     * @return 用户id
     */
    Long userRegister(String userAccount, String pwd, String checkPwd);

    /**
     * 用户登录方法
     *
     * @param userAccount 用户账号
     * @param pwd         用户密码
     * @param request
     * @return            用户信息（脱敏）
     */
    UserVO userLogin(String userAccount, String pwd, HttpServletRequest request);
}
