package com.cd.shiro.service.serviceImpl;

import com.cd.shiro.dao.SysPermissionDao;
import com.cd.shiro.service.SysPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysPermissionServiceImpl implements SysPermissionService {
    @Autowired
    SysPermissionDao sysPermissionDao;

    @Override
    public List<String> selectPermissionByUserId(Long userId) {
        return sysPermissionDao.selectPermissionByUserId(userId);
    }
}
