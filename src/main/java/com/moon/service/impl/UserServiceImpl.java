package com.moon.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.spring.service.impl.ServiceImpl;
import com.moon.domain.entity.User;
import com.moon.service.UserService;
import com.moon.mapper.UserMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 用户服务实现类
 * @author moon
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 用户注册方法
     *
     * @param userAccount 用户账号
     * @param pwd         用户密码
     * @param checkPwd    用户二次密码
     * @return 用户id
     */
    @Override
    public Long userRegister(String userAccount, String pwd, String checkPwd) {
        // 1.1 校验账号，密码，二次密码是否为空
        if (StringUtils.isAllBlank(userAccount, pwd, checkPwd)) {
            return -1L;
        }
        // 1.2 校验用户账号长度不小于 4 位
        if (userAccount.length() < 4) {
            return -1L;
        }
        // 1.3 校验用户密码长度不小于 8 位
        if (pwd.length() < 8 || checkPwd.length() < 8) {
            return -1L;
        }
        // 1.4 校验用户两次输入密码一致
        if (!pwd.equals(checkPwd)) {
            return -1L;
        }
        // 1.5 校验账户不能包含特殊字符
        String validPattern="\\pP|\\pS|\\s+";
        Matcher matcher = Pattern.compile(validPattern).matcher(userAccount);
        if (matcher.find()){
            return -1L;
        }
        // 1.6 校验账号是否重复
        User user1 = userMapper.selectOne(new LambdaQueryWrapper<User>().eq(User::getUserAccount, userAccount));
        if (user1 != null) {
            return -1L;
        }
        // 2. 加密
        String newPwd = DigestUtils.md5DigestAsHex(("abcd" + pwd).getBytes(StandardCharsets.UTF_8));
        // 3. 插入数据
        User user = new User();
        user.setUserAccount(userAccount);
        user.setPassword(newPwd);
        user.setCreateTime(LocalDateTime.now());
        user.setUpdateTime(LocalDateTime.now());
        userMapper.insert(user);
        return user.getId();
    }
}




