package com.onlinejudge.moudle.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.onlinejudge.bean.model.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}
