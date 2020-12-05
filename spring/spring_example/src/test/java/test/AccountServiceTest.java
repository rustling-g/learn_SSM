package test;

import com.dao.IAccountDao;
import com.domain.Account;
import com.service.IAccountService;
import config.SpringConfiguration;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sound.midi.Soundbank;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author gg
 * @create 2020-11-23 16:22
 */
/*
spring整合junit：
1 在pom.xml中导入依赖
2 @RunWith 把junit原有的main方法替换为Spring的
3 @ContextConfiguration 告知Spring的运行器，spring和ioc的创建是基于注解/xml
    locations   指定xml文件的位置
    classes       指定注解类的位置
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)
public class AccountServiceTest {

    @Autowired
    private IAccountService accountService = null;

    @Test
    public void findAll() {
        List<Account> accounts = accountService.findAll();
        for (Account account : accounts)
            System.out.println(account);
    }

    @Test
    public void findAccountById() {
        Account account = accountService.findAccountById(2);
        System.out.println(account);
    }

    @Test
    public void saveAccount() {
        Account account = new Account("test", (double) 3000);
        accountService.saveAccount(account);
    }

    @Test
    public void updateAccount() {
        Account account = new Account("test", (double) 5000);
        account.setId(7);
        accountService.updateAccount(account);
    }

    @Test
    public void deleteAccount() {
        accountService.deleteAccount(7);
    }
}