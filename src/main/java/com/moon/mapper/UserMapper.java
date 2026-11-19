package com.moon.mapper;

import com.moon.domain.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;

/**
 *
 *
 *
 *
 * @author moon
*/
public interface UserMapper extends BaseMapper<User> {

    @Insert("insert into user (username, user_account, password, gender, img_url, phone, email, status, create_time, update_time, is_delete) value " +
            "()")
    void userRegister(User user);
}




