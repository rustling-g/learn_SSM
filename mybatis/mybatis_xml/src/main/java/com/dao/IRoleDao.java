package com.dao;

import com.domain.Role;

import java.util.List;

/**
 * @author gg
 * @create 2020-10-15 20:30
 */
public interface IRoleDao {
    //返回Role的所有信息，同时返回有此角色的User信息（借助中间表user-role
    List<Role> findAll();

}
