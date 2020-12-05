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
        ApplicationContext的3个实现类
            ClassPathXmlApplicationContext          加载类路径下的配置文件
            FileSystemXmlApplicationContext         加载磁盘任意路径下的配置文件（必须有访问权限）
            AnnotationConfigApplicationContext      用于读取注解创建容器

        核心容器的两个接口引发出的问题：
        ApplicationContext      饿汉式创建核心容器对象     单例对象       用的更多
        BeanFactory             懒汉式                   多例对象
         */
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2 根据id获取bean对象（以下2种方法都ok）
        IAccountService accountService = (IAccountService) ac.getBean("accountService3");
//        IAccountService accountService = ac.getBean("accountService", IAccountService.class);

        accountService.saveAccount();
    }
}
