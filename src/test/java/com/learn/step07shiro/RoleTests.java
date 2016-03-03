package com.learn.step07shiro;


import junit.framework.Assert;
import org.apache.shiro.authz.UnauthorizedException;
import org.junit.Test;

import java.util.Arrays;

/**
 * <p>User: Zhang Kaitao
 * <p>Date: 14-1-26
 * <p>Version: 1.0
 */
public class RoleTests extends BaseTests {

    @Test
    public void testHasRole() {
        login("classpath:com/learn/step07shiro/shiro-users-roles.ini", "zhang", "123");
        //判断拥有角色：role1
        Assert.assertTrue(subject().hasRole("role1"));

        //判断拥有角色：role1 and role2
        Assert.assertTrue(subject().hasAllRoles(Arrays.asList("role1", "role2")));

        //判断拥有角色：role1 and role2 and !role3
        boolean[] result = subject().hasRoles(Arrays.asList("role1", "role2", "role3"));
        Assert.assertEquals(true, result[0]);
        Assert.assertEquals(true, result[1]);
        Assert.assertEquals(false, result[2]);
    }

    /**
     *  expected = UnauthorizedException.class 表示这个测试抛出一个 异常就通过了
     */
    @Test(expected = UnauthorizedException.class)
    public void testCheckRole() {
        login("classpath:com/learn/step07shiro/shiro-users-roles.ini", "zhang", "123");
        //断言拥有角色：role1
        subject().checkRole("role1");
        //断言拥有角色：role1 and role3 失败抛出异常
        subject().checkRoles("role1", "role3");
    }

    @Test
    public void testIsPermitted() {
        login("classpath:com/learn/step07shiro/shiro-users-roles-permission.ini", "zhang", "123");
        //判断拥有权限：user:create
        Assert.assertTrue(subject().isPermitted("user:create"));
        //判断拥有权限：user:update and user:delete
        Assert.assertTrue(subject().isPermittedAll("user:update", "user:delete"));
        //判断没有权限：user:view
        Assert.assertFalse(subject().isPermitted("user:view"));
    }

    @Test(expected = UnauthorizedException.class)
    public void testCheckPermission () {
        login("classpath:com/learn/step07shiro/shiro-users-roles-permission.ini", "zhang", "123");
        //断言拥有权限：user:create
        subject().checkPermission("user:create");
        //断言拥有权限：user:delete and user:update
        subject().checkPermissions("user:delete", "user:update");
        //断言拥有权限：user:view 失败抛出异常
        subject().checkPermissions("user:view");
    }
}

