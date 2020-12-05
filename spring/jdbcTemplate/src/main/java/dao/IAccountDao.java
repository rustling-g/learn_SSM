package dao;

import domain.Account;

/**
 * @author gg
 * @create 2020-11-25 下午2:30
 */
public interface IAccountDao {
    Account findAccountById(Integer id);

    Account findAccountByName(String name);

    void updateAccount(Account account);
}
