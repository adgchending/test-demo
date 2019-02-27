package com.cd.shiro.service;

import java.util.List;

public interface SysPermissionService {
    List<String> selectPermissionByUserId(Long userId);
}
