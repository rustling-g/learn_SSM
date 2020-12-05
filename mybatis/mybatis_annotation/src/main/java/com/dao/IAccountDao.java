package com.dao;

import domain.Account;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * @author gg
 * @create 2020-11-21 16:01
 */
public interface IAccountDao {
    /**
     * 一对一：查询所有账户，并获取每个账户的用户信息
     * @return
     */
    @Select("select * from account ")
    @Results( id = "accountMap" ,value = {
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "uid",property = "uid"),
            @Result(column = "money",property = "money"),

            //此处为外联,
            @Result(property = "user",column = "uid", one = @One(
                    select = "com.dao.IUserDao.findById",
                    fetchType = FetchType.EAGER     //立即加载
            ))
    })
    List<Account> findAll();

    @Select("select * from account where uid=#{uid}")
    List<Account> findAccountByUid(Integer uid);

}
