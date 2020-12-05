package com.dao;

import com.domain.Account;
import com.domain.AccountUser;
import com.domain.User;

import java.util.List;

/**
 * @author gg
 * @create 2020-10-15 17:06
 */
public interface  IAccountDao {

    //查询所有账户，同时获取到当前账户所属的用户信息
    List<Account> findAll();

    //查询所有账户，并且包含用户名称和地址
    List<AccountUser> findAllAccount();
}
