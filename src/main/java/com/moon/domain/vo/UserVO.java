package com.moon.domain.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * 用户视图类，主要用于用户数据脱敏
 *
 * @author moon
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserVO {
    /**
     * id,主键
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 账号
     */
    private String userAccount;


    /**
     * 性别，1-男 0-女
     */
    private Integer gender;

    /**
     * 头像地址
     */
    private String imgUrl;

    /**
     * 电话号
     */
    private String phone;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 用户角色，0 - 普通用户，1 - 管理员
     */
    private Integer role;

    /**
     * 用户状态，0-正常 其他后面再定义
     */
    private Integer status;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;
}
