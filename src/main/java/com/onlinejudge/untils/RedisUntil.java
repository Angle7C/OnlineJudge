package com.onlinejudge.untils;


import cn.hutool.core.lang.UUID;
import cn.hutool.json.JSONUtil;
import com.onlinejudge.bean.model.User;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@Component
public class RedisUntil {
    @Resource
    private RedisTemplate redisTemplate;
    @Resource
    private StringRedisTemplate stringRedisTemplate;
    public String setUserCache(User user){
        String key=UUID.fastUUID().toString();
        redisTemplate.opsForValue().set("user: "+ key, JSONUtil.toJsonStr(user),30,TimeUnit.MINUTES);
        return key;
    }
    public void setCodeCache(String email,String code){
        stringRedisTemplate.opsForValue().set("code: "+email,code,5, TimeUnit.MINUTES);
    }
    public void remove(String key){
        redisTemplate.opsForValue().getAndDelete(key);
    }
    public void updateCache(String key ){
        redisTemplate.opsForValue().getAndExpire(key,30,TimeUnit.MINUTES);
    }

    public String getCode(String email) {
      return  stringRedisTemplate.opsForValue().getAndDelete("code: "+email);
    }
}
