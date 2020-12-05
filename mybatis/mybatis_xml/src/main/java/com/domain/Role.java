package com.domain;

import java.io.Serializable;
import java.util.List;

/**
 * @author gg
 * @create 2020-10-15 20:26
 */
public class Role implements Serializable {
    private int id;
    private String roleName;
    private String roleDesc;

    private List<User> users;

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", role_name='" + roleName + '\'' +
                ", role_desc='" + roleDesc + '\'' +
                '}';
    }
}
