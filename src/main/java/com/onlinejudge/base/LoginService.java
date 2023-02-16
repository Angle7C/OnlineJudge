package com.onlinejudge.base;

import com.onlinejudge.bean.model.User;
import com.onlinejudge.moudle.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    @Autowired
    private UserService userService;
    public User login(String token){
        User user=userService.getById(token);
        if(user!=null){
            return user;
        }else{
            User user1 = new User();
            user1.setRole("default");
            return user1;
        }
    }

}
