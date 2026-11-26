package com.moon.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.moon.constant.UserConstant;
import com.moon.domain.dto.UserLoginDTO;
import com.moon.domain.dto.UserRegisterDTO;
import com.moon.domain.entity.User;
import com.moon.domain.vo.UserVO;
import com.moon.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.moon.constant.UserConstant.ADMIN_ROLE;
import static com.moon.constant.UserConstant.USER_LOGIN_STATE;

/**
 * 用户控制层
 *
 * @author moon
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 用户注册
     *
     * @param userRegisterDTO
     * @return 返回用户 id
     */
    @PostMapping("/register")
    public Long userRegister(@RequestBody UserRegisterDTO userRegisterDTO) {
        if (userRegisterDTO == null) {
            return null;
        }
        String userAccount = userRegisterDTO.getUserAccount();
        String pwd = userRegisterDTO.getPwd();
        String checkPwd = userRegisterDTO.getCheckPwd();
        if (StringUtils.isAnyBlank(userAccount, pwd, checkPwd)) {
            return null;
        }
        return userService.userRegister(userAccount, pwd, checkPwd);
    }

    /**
     * 用户登录
     *
     * @param userLoginDTO
     * @param request
     * @return
     */
    @PostMapping("/login")
    public UserVO userLogin(@RequestBody UserLoginDTO userLoginDTO, HttpServletRequest request) {
        if (userLoginDTO == null) {
            return null;
        }
        String userAccount = userLoginDTO.getUserAccount();
        String pwd = userLoginDTO.getPwd();
        if (StringUtils.isAnyBlank(userAccount, pwd)) {
            return null;
        }
        return userService.userLogin(userAccount, pwd, request);
    }

    /**
     * 根据用户名查询用户
     *
     * @param username 用户名
     * @return 返回查询的用户列表
     */
    @GetMapping("/search")
    public List<UserVO> searchUserByName(@RequestParam String username, HttpServletRequest request) {
        // 仅管理员可查询
        if (!isAdmin(request)){
            return new ArrayList<>();
        }
        return userService.searchUserByName(username);
    }

    /**
     * 根据用户 id 删除用户
     *
     * @param id 用户 id
     * @return 返回是否删除成功
     */
    @DeleteMapping("/delete")
    public boolean deleteById(@RequestParam Long id, HttpServletRequest request) {
        // 仅管理员可删除用户
        if (!isAdmin(request)){
            return false;
        }
        // 判断 id
        if (id <= 0) {
            return false;
        }
        return userService.removeById(id);
    }

    /**
     * 判断是否是管理员
     *
     * @param request
     * @return 返回 true 或 false
     */
    private boolean isAdmin(HttpServletRequest request){
        Object userObj = request.getSession().getAttribute(USER_LOGIN_STATE);
        UserVO userVO = (UserVO) userObj;
        if (userVO == null || !Objects.equals(userVO.getRole(), ADMIN_ROLE)) {
            return false;
        }
        return true;
    }
}
