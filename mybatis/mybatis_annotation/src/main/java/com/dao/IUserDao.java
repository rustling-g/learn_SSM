package com.dao;

import domain.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * @author gg
 * @create 2020-11-20 19:08
 */
////开启二级缓存
//@CacheNamespace(blocking = true)
public interface IUserDao {

    @Select("select * from user")
    //配置别名，id为该别名集的唯一标志
    @Results(id = "userMap" ,value = {
            //id为主键，默认为false
            //column为数据库中名，property为实体类中名。
            @Result(id=true,column = "id",property = "id"),
            @Result(column = "username",property = "username"),
            @Result(column = "address",property = "address"),
            @Result(column = "birthday",property = "birthday"),
            @Result(column = "sex",property = "sex")
    })
    List<User> findAll();

    /**
     * 一对多：获取用户的所有账户
     * @return
     */
    @Select("select * from user")
    @Results(value = {
            //property为当前类中的包含的对象集合名，column为当前类与外表连接的主键名
            @Result(property = "accounts",column = "id", many = @Many(
                    //select中是通过外表的某个方法，用column值作为查询参数，查出来的结果以property的形式返回
                    select = "com.dao.IAccountDao.findAccountByUid",
                    fetchType = FetchType.LAZY
            ))
    })
    List<User> findAllAccounts();

    @Insert("insert into user(username,address,sex,birthday) values(#{username},#{address},#{sex},#{birthday})")
    void saveUser(User user);

    @Update("update user set username=#{username},sex=#{sex},birthday=#{birthday},address=#{address} where id=#{id}")
    void updateUser(User user);

    @Delete("delete from user where id=#{id}")
    void deleteUser(Integer id);

    @Select("select * from user where id=#{id}")
    //此处配置别名集引用上面的Results，可配置多个
    @ResultMap(value = {"userMap"})
    User findById(int id);

    @Select("select * from user where username like #{username}")
    List<User> findByName(String username);

    @Select("select count(*) from user")
    int findTotal();
}
