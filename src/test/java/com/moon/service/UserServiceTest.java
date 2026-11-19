package com.moon.service;

import com.moon.domain.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.DigestUtils;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.*;

/**
 * 用户服务测试
 *
 * @author moon
 */
@SpringBootTest
class UserServiceTest {

    @Autowired
    private UserService userService;

    /**
     * 测用户服务的插入方法
     */
    @Test
    void testAddUser(){
        User user = new User();
        user.setUsername("moon");
        user.setUserAccount("moon");
        user.setPassword("123456");
        user.setGender(1);
        user.setImgUrl("1.jpg");
        user.setPhone("18980903400");
        user.setEmail("3081892513@qq.com");
        user.setStatus(0);
        user.setCreateTime(LocalDateTime.now());
        user.setUpdateTime(LocalDateTime.now());
        user.setIsDelete(0);
        boolean res = userService.save(user);
        System.out.println(user.getId());
        assertTrue(res);
    }

    /**
     * 测试加密
     * @throws NoSuchAlgorithmException
     */
    @Test
    void digest() throws NoSuchAlgorithmException {
        String newPwd = DigestUtils.md5DigestAsHex(("abcd" + "123456").getBytes(StandardCharsets.UTF_8));
        System.out.println(newPwd);
    }

    @Test
    void testUserRegister(){
        Long id = userService.userRegister("moon1", "12345678", "12345678");
        System.out.println(id);
    }
}