package com.dao;

import com.domain.Account;

import java.util.List;

/**
 * @author gg
 * @create 2020-11-23 15:32
 */
public interface IAccountDao {

    List<Account> findAll();

    Account findAccountById(Integer id);

    void saveAccount(Account account);

    void updateAccount(Account account);

    void deleteAccount(Integer id);

    Account findAccountByName(String name);
}
