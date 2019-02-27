package com.cd.shiro.api;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author sgl
 * @Date 2018-05-08 13:55
 */
@RestController
public class TestController {
    /**
     * 没有加shiro权限注解
     *
     * @return
     */
    @RequestMapping("/test1")
    public String test1() {
        return "你拥有进入test1的权限";
    }

    /**
     * 添加了shiro权限注解，需要用户有"systemUserAdd"权限
     *
     * @return
     */
    @RequestMapping("/test2")
    @RequiresPermissions("systemUserAdd")
    public String test2() {
        return "你拥有进入test2的权限";
    }
}
