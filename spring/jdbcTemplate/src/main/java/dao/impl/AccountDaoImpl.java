package dao.impl;

import dao.IAccountDao;
import domain.Account;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.util.List;

/**
 * @author gg
 * @create 2020-11-25 下午2:31
 */
//继承了JdbcDaoSupport后，就不能用注解配置了
public class AccountDaoImpl extends JdbcDaoSupport implements IAccountDao {
    public Account findAccountById(Integer id) {
        List<Account> accounts = super.getJdbcTemplate().query("select * from account where id =?", new BeanPropertyRowMapper<Account>(Account.class), id);
        return accounts.isEmpty()?null:accounts.get(0);
    }

    public Account findAccountByName(String name) {
        List<Account> accounts = super.getJdbcTemplate().query("select * from account where name =?", new BeanPropertyRowMapper<Account>(Account.class), name);
        if (accounts.isEmpty())
            return null;
        if (accounts.size()>1)
            throw new RuntimeException("结果集不唯一");
        return accounts.get(0);
    }

    public void updateAccount(Account account) {
        super.getJdbcTemplate().update("update account set name=?,money=? where id=?",account.getName(),account.getMoney(),account.getId());
    }
}
