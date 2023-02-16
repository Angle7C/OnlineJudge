package com.onlinejudge.untils;

import com.onlinejudge.bean.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserHolder {
    private static ThreadLocal<User> map=new ThreadLocal<User>();
    public void putUser(User user){map.set(user);}
    public void removeUser(){map.remove();}
    public User getUser(){return map.get();}
}
