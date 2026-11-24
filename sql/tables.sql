drop database if exists user_center;

create database if not exists user_center;

use user_center;

drop table if exists user;

create table if not exists user
(
    id           bigint unsigned primary key auto_increment comment 'id,主键',
    username     varchar(128)  null comment '用户名',
    user_account varchar(128)  null unique comment '账号',
    password     varchar(512)  not null comment '密码',
    gender       tinyint unsigned default 1 comment '性别，1-男 0-女',
    img_url      varchar(1024) null comment '头像地址',
    phone        varchar(128)  null unique comment '电话号',
    email        varchar(128)  null unique comment '邮箱',
    role         tinyint unsigned   default 0 comment '用户角色。0-普通用户 1-管理员',
    status       tinyint unsigned default 0 comment '用户状态，0-正常 其他后面再定义',
    create_time  datetime comment '创建时间',
    update_time  datetime comment '更新时间',
    is_delete    tinyint unsigned default 0 comment '逻辑删除，0-未删除 1-已删除'
) comment '用户表';