package com.service.impl;

import com.service.IAccountService;

/**
 * @author gg
 * @create 2020-11-24 下午6:37
 */
public class AccountServiceImpl implements IAccountService {
    public void saveAccount() {
        System.out.println("执行了保存");
//        int i = 12 / 0;
    }

    public void updateAccount(int i) {
        System.out.println("执行了更新");
    }

    public int deleteAccount() {
        System.out.println("执行了删除");
        return 0;
    }
}
