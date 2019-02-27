package com.cd.shiro.service.serviceImpl;

import com.cd.shiro.dao.UserDao;
import com.cd.shiro.pojo.domain.User;
import com.cd.shiro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserDao userDao;


    @Override
    public List<User> getUsers() {
        return userDao.getUsers();
    }

//    @Override
//    public User selectById(Long id) {
//        return userDao.selectByPrimaryKey(id);
//    }
}
