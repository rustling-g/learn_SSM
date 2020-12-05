package service;

import domain.Account;

/**
 * @author gg
 * @create 2020-11-25 下午5:17
 */
public interface IAccountService {
    Account findAccountById(Integer id);

    void transfer(String sourceName,String targetName,double money);
}
