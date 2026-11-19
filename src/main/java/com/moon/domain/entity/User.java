package com.moon.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.time.LocalDateTime;
import lombok.Data;

/**
 * 用户表
 * @TableName user
 */
@TableName(value ="user")
@Data
public class User {
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
     * 密码
     */
    private String password;

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

    /**
     * 逻辑删除，0-未删除 1-已删除
     */
    private Integer isDelete;
}