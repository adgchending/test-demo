package com.cd.shiro.service;

import com.cd.shiro.pojo.domain.SysUser;

public interface SysUserService {
    SysUser findByUserName(String username);
}
