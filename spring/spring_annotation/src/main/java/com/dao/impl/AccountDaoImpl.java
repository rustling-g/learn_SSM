package com.dao.impl;

import com.dao.IAccountDao;
import org.springframework.stereotype.Repository;

/**
 * @author gg
 * @create 2020-11-22 14:37
 */
@Repository("accountDao1")
public class AccountDaoImpl implements IAccountDao {
    public void saveAccount() {
        System.out.println("保存了账户");
    }
}
