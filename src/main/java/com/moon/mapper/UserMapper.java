package com.moon.mapper;

import com.moon.domain.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.moon.domain.vo.UserVO;
import org.apache.ibatis.annotations.Insert;

import java.util.List;

/**
 * 用户数据访问层
 *
 * @author moon
*/
public interface UserMapper extends BaseMapper<User> {

    List<UserVO> search(String username);
}




