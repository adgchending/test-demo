package com.cd.shiro.service.serviceImpl;

import com.cd.shiro.dao.SysUserDao;
import com.cd.shiro.pojo.domain.SysUser;
import com.cd.shiro.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysUserServiceImpl implements SysUserService {
    @Autowired
    SysUserDao sysUserDao;


    @Override
    public SysUser findByUserName(String username) {
        return sysUserDao.findByUserName(username);
    }
}
