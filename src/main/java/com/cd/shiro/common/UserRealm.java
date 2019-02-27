package com.cd.shiro.common;

import com.cd.shiro.pojo.domain.SysUser;
import com.cd.shiro.service.SysPermissionService;
import com.cd.shiro.service.SysUserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
* @Param:描述:shiro核心类
* @return：返回结果描述:
* @Throws：返回异常结果:
* @Author: chenshangxian
*/
public class UserRealm extends AuthorizingRealm {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserRealm.class);
    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private SysPermissionService sysPermissionService;

    /**
    * @Param:描述:授权
    * @return：返回结果描述:
    * @Throws：返回异常结果:
    * @Author: chenshangxian
    */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        SysUser sysUser = (SysUser) principals.getPrimaryPrincipal();
        //查询用户权限
        List<String> sysPermissions = sysPermissionService.selectPermissionByUserId(sysUser.getUserId());

        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        //设置用户权限,可以通过@RequiresPermissions("xxx")注解来限制
        authorizationInfo.addStringPermissions(sysPermissions);
        LOGGER.info("doGetAuthorizationInfo");
        LOGGER.info("---- 获取到以下权限 ----");
        LOGGER.info(authorizationInfo.getStringPermissions().toString());
        return authorizationInfo;
    }

    /**
    * @Param:描述:认证
    * @return：返回结果描述:
    * @Throws：返回异常结果:
    * @Author: chenshangxian
    * @Date: 2018-11-10 14:22
    */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        SysUser sysUser = sysUserService.findByUserName(token.getUsername());
        if (sysUser == null) {
            return null;
        }
        LOGGER.info("doGetAuthenticationInfo");
        return new SimpleAuthenticationInfo(
                sysUser,//用户对象
                sysUser.getPassword().toCharArray(),//密码
                ByteSource.Util.bytes(sysUser.getSalt()), //盐值
                getName()//realm name
        );
    }
}
