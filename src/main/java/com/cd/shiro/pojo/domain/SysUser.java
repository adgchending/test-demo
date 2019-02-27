package com.cd.shiro.pojo.domain;

import java.io.Serializable;

public class SysUser implements Serializable {
    private Long userId; //用户表id
    private String userName; //账号
    private String fullName; //用户的名字
    private String password; //密码
    private String salt; // 盐值

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }
}
