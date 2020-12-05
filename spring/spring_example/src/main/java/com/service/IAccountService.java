package com.service;

import com.domain.Account;

import java.util.List;

/**
 * @author gg
 * @create 2020-11-23 15:26
 */
public interface IAccountService {

    List<Account> findAll();

    Account findAccountById(Integer id);

    void saveAccount(Account account);

    void updateAccount(Account account);

    void deleteAccount(Integer id);
}
