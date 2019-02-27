package com.cd.shiro.dao;

import com.cd.shiro.pojo.domain.SysUser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SysUserDao {
    SysUser findByUserName(String username);
}
