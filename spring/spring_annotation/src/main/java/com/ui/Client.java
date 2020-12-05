package com.ui;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.service.IAccountService;

/**
 * 模拟一个表现层，用于调用业务层
 * @author gg
 * @create 2020-11-22 14:40
 */
public class Client {
    //获取Spring的ioc核心容器，并根据id获取对象
    public static void main(String[] args) {
        //1 获取核心容器对象
        /*
        需要注意的是，因为此处用的是ApplicationContext，所以没有close方法，下面的destroy方法是无法被执行的
        需要把ac定义为它的子类才ok
         */
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2 根据id获取bean对象（2种方法都ok）
        IAccountService accountService = (IAccountService) ac.getBean("accountService");
        System.out.println(accountService);
        accountService.saveAccount();
    }
}
