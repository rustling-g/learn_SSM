package com.dao;

import com.domain.QueryVo;
import com.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author gg
 * @create 2020-10-11 12:00
 *
 * 用户的持久层接口
 */
public interface IUserDao {

    //查询所有,并显示账户信息（一对多
//    如果使用注解开发的话，不需要IUserDao.xml文件，只需要加上面这一行就OK
    @Select("select * from user")
    List<User> findAll();
    //查询所有，并显示角色信息
    List<User> findAllRoles();
    //添加
    void saveUser(User user);
    //修改
    void updateUser(User user);
    //删除
    void deleteUser(int id);
    //查询一个
    User findById(int id);
    //根据名字模糊查询
    List<User> findByName(String name);
    //获取用户的总记录条数
    int findTotal();
    //根据多个条件查找
    List<User> findByCondition(User user);
    //select * from user where id in...
    List<User> findUserInIds(QueryVo vo);
}
