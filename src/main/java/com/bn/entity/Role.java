package com.bn.entity;

/**
 * @Author: xiongjianjian
 * @Description:
 * @Date: 2019/11/22 11:44
 * @Modified: xiongjianjian
 **/
public class Role {
    private Integer id;
    private String roleAuth;
    private String roleName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoleAuth() {
        return roleAuth;
    }

    public void setRoleAuth(String roleAuth) {
        this.roleAuth = roleAuth;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
