package com.onlinejudge.moudle.user.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.onlinejudge.bean.model.User;
import com.onlinejudge.moudle.user.mapper.UserMapper;
import org.springframework.stereotype.Service;

@Service
public class UserService extends ServiceImpl<UserMapper, User> {


}
