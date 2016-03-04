package com.learn.step07shiro;


import com.learn.step06ehcache.entity.User;
import com.learn.step06ehcache.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import javax.annotation.Resource;

public class MyRealm extends AuthorizingRealm {

    @Resource
    UserService userService;

    /**
     *
     * @return 本Realm的名字
     */
    @Override
    public String getName() {
        return this.getClass().getSimpleName();
    }

    /**
     * 通过数据库获取角色的信息:角色,权限
     */
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String username = (String)principals.getPrimaryPrincipal();
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        authorizationInfo.setRoles(userService.getRoles(username));
        authorizationInfo.setStringPermissions(userService.getPermissions(username));
        return authorizationInfo;
    }

    /**
     * 通过数据库,认证用户
     */
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String username = (String)token.getPrincipal();
        User user = userService.findByUsername(username);
        if(user == null) {
            throw new UnknownAccountException();//没找到帐号
        }
        if(Boolean.TRUE.equals(user.getLocked())) {
            throw new LockedAccountException(); //帐号锁定
        }
        //交给AuthenticatingRealm使用CredentialsMatcher进行密码匹配，如果觉得人家的不好可以在此判断或自定义实现
        return new SimpleAuthenticationInfo(
                user.getUsername(), //用户名
                user.getPassword(), //密码
                ByteSource.Util.bytes(user.getUsername()+user.getSalt()),//salt=username+salt
                getName()  //realm name
        );
    }

    /**
     * 清除缓存
     */
    public void clearAllCache()
    {
        clearAllCachedAuthenticationInfo();
        clearAllCachedAuthorizationInfo();
    }

    @Override
    public void clearCachedAuthorizationInfo(PrincipalCollection principals)
    {
        super.clearCachedAuthorizationInfo(principals);
    }

    @Override
    public void clearCachedAuthenticationInfo(PrincipalCollection principals)
    {
        super.clearCachedAuthenticationInfo(principals);
    }

    @Override
    public void clearCache(PrincipalCollection principals)
    {
        super.clearCache(principals);
    }

    public void clearAllCachedAuthorizationInfo()
    {
        getAuthorizationCache().clear();
    }

    public void clearAllCachedAuthenticationInfo()
    {
        getAuthenticationCache().clear();
    }


}


