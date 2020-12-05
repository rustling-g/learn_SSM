package com.service.impl;

import com.dao.IAccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import com.service.IAccountService;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import java.util.*;

/**
 * @author gg
 * @create 2020-11-22 14:34
 */
/*
注解类型：
    用于创建对象
        下面四个作用相同，只是为了表示区分层次结构区分
        @Component   value默认为类名首字母改小写
        @Controller  表现层
        @Service     业务层
        @Repository  持久层

    用于注入数据
        注入基本类型/String
        @Value       可使用 ${表达式} 的形式注入
        注入其他bean类型
        @Autowired   自动按照类型注入
            *可以用在变量上/方法上
            *如果Ioc中没有任何bean类型和要注入的类型匹配，则报错
            *如果有且仅有唯一的一个类型匹配，则直接注入；如不止1个类型匹配，则再根据变量名与bean中的变量名进行匹配
        @Qualifier   按照类型注入的基础上，再按照名称注入
            *在给类成员注入时不能单独使用，但是给方法参数注入时可以
        @Resource    直接按照bean的id注入，可独立使用
            *参数为name

    用于改变作用范围
        @Scope

    生命周期相关
        @PostConstruct
        @PreDestroy
 */
@Component("accountService")
@Scope("prototype")
public class AccountServiceImpl implements IAccountService {

//    @Autowired
//    @Qualifier("accountDao1")
    @Resource(name = "accountDao1")
    private IAccountDao accountDao;

    @Value("天")
    private String name;
    @Value("18")
    private Integer age;
    private Date birthday;

    public void saveAccount() {
        accountDao.saveAccount();
        System.out.println("service中的saveAccount方法被执行了 "+name+" "+age+" "+birthday);
//        System.out.println("service中的saveAccount方法被执行了 ");
    }

    @PostConstruct
    public void init(){
        System.out.println("初始化方法被执行了");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("销毁方法被执行了");
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
