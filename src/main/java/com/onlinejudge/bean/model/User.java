package com.onlinejudge.bean.model;;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.time.OffsetDateTime;

/**
 * User
 */
@TableName("user")
public class User extends BaseModel {
    private String avatar;

    private String email;

    private String password;
    private String role;
    private String username;

    /**
     * 头像URL
     */
    public String getAvatar() { return avatar; }
    public void setAvatar(String value) { this.avatar = value; }

    /**
     * 邮箱
     */
    public String getEmail() { return email; }
    public void setEmail(String value) { this.email = value; }
    /**
     * 密码
     */
    public String getPassword() { return password; }
    public void setPassword(String value) { this.password = value; }

    /**
     * 角色
     */
    public String getRole() { return role; }
    public void setRole(String value) { this.role = value; }

    /**
     * 用户名
     */
    public String getUsername() { return username; }
    public void setUsername(String value) { this.username = value; }
}