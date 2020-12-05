package com.factory;

import com.domain.Account;
import com.service.IAccountService;
import com.utils.TransactionManager;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 用于创建Service的代理对象工厂
 * @author gg
 * @create 2020-11-24 下午4:24
 */
public class BeanFactory {
    private IAccountService accountService;
    private TransactionManager transactionManager;

    public void setTransactionManager(TransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }

    public final void setAccountService(IAccountService accountService) {
        this.accountService = accountService;
    }


    //获取service的代理对象
    public IAccountService getAccountService(){
        return (IAccountService) Proxy.newProxyInstance(
                accountService.getClass().getClassLoader(),
                accountService.getClass().getInterfaces(),
                new InvocationHandler() {
                    //添加事务的支持
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        Object rtValue = null;
                        try{
                            //开启事务
                            transactionManager.begin();
                            //执行操作
                            rtValue = method.invoke(accountService, args);
                            //提交事务
                            transactionManager.commit();
                            //返回结果
                            return rtValue;
                        }catch (Exception e){
                            //回滚
                            transactionManager.rollback();
                            throw new RuntimeException("错误信息");
                        }finally {
                            //释放连接
                            transactionManager.release();
                        }
                    }
                });
    }
}

