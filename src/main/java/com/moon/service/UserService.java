package com.moon.service;

import com.baomidou.mybatisplus.spring.service.IService;
import com.moon.domain.entity.User;
import org.springframework.stereotype.Service;

/**
 * 用户服务业务层
 *
 * @author moon
*/
public interface UserService extends IService<User> {
    /**
     * 用户注册方法
     * @param userAccount 用户账号
     * @param pwd         用户密码
     * @param checkPwd    用户二次密码
     * @return            用户id
     */
    Long userRegister(String userAccount,String pwd,String checkPwd);
}
