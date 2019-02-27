package com.cd.shiro.service;

import com.cd.shiro.pojo.domain.User;

import java.util.List;

public interface UserService {
    List<User> getUsers();

    //User selectById(Long id);
}
