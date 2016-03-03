package com.learn.step07shiro;

import org.apache.shiro.authc.*;
import org.apache.shiro.realm.Realm;

/**
 *
 * Author: vince
 * Create: 2016-02-28 下午8:29
 */
public class MySimpleRealm  implements Realm {

    //这个Realm的名字
    @Override
    public String getName() {
        return "MySimpleRealm";
    }

    //支持的令牌
    @Override
    public boolean supports(AuthenticationToken token) {
        //仅支持UsernamePasswordToken类型的Token
        return token instanceof UsernamePasswordToken;
    }

    //获取认证信息
    @Override
    public AuthenticationInfo getAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //得到用户名
        String username = (String)token.getPrincipal();
        //得到密码
        String password = new String((char[])token.getCredentials());

        //如果用户名错误
        if(!"lisi".equals(username)) {
            throw new UnknownAccountException();
        }

        //如果密码错误
        if(!"qqq".equals(password)) {
            throw new IncorrectCredentialsException();
        }

        //如果身份认证验证成功，返回一个AuthenticationInfo实现；
        return new SimpleAuthenticationInfo(username, password, getName());
    }
}
