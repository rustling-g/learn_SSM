package com.dao.impl;

import com.dao.IAccountDao;
import com.domain.Account;
import com.utils.ConnectionUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

/**
 * @author gg
 * @create 2020-11-23 15:37
 */
public class AccountDaoImpl implements IAccountDao {

    private QueryRunner runner;
    private ConnectionUtils connectionUtils;

    public void setRunner(QueryRunner runner) {
        this.runner = runner;
    }

    public void setConnectionUtils(ConnectionUtils connectionUtils) {
        this.connectionUtils = connectionUtils;
    }

    public List<Account> findAll() {
        try {
            return runner.query(connectionUtils.getConnection(),"select * from account",new BeanListHandler<Account>(Account.class));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public Account findAccountById(Integer id) {
        try {
            return runner.query(connectionUtils.getConnection(),"select * from account where id = ?",new BeanHandler<Account>(Account.class),id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public void saveAccount(Account account) {
        try {
            runner.update(connectionUtils.getConnection(),"insert into account(name,money) values (?,?)",account.getName(),account.getMoney());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void updateAccount(Account account) {
        try {
            runner.update(connectionUtils.getConnection(),"update account set name=?,money=? where id=?",account.getName(),account.getMoney(),account.getId());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void deleteAccount(Integer id) {
        try {
            runner.update(connectionUtils.getConnection(),"delete from account where id = ?",id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public Account findAccountByName(String name) {
        try {
            List<Account> accounts = runner.query(connectionUtils.getConnection(),"select * from account where name = ?",new BeanListHandler<Account>(Account.class),name);
            if(accounts == null ||accounts.size()==0)
                return null;
            if(accounts.size()>1)
                throw new RuntimeException("结果集不唯一");
            return accounts.get(0);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}
