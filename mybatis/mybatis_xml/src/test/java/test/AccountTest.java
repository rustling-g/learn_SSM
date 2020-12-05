package test;

import com.dao.IAccountDao;
import com.domain.Account;
import com.domain.AccountUser;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author gg
 * @create 2020-10-15 17:12
 */
public class AccountTest {
    private InputStream in;
    private SqlSession session;
    private IAccountDao accountDao;

    @Before     //在单元测试方法之前运行
    public void init() throws IOException {
        //1 读取配置文件
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2 创建SqlSessionFactory工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        //3 使用工厂生产SqlSession对象
        //如果openSession中为true，则为自动提交，后面不用写session.commit都可以增删改查
        session = factory.openSession();
        //4 使用SqlSession创建Dao接口的代理对象
        accountDao = session.getMapper(IAccountDao.class);
    }

    @After      //在单元测试方法之后运行
    public void destroy() throws IOException {
        //(提交事务）
        session.commit();
        //6 释放资源
        session.close();
        in.close();
    }

    @Test
    public void findAll(){
        List<Account> all = accountDao.findAll();
        for (Account account : all) {
            System.out.println(account);
            System.out.println(account.getUser());
        }

    }

    @Test
    public void testFindAllAccount(){
        List<AccountUser> list = accountDao.findAllAccount();
        for (AccountUser acc : list)
            System.out.println(acc);
    }
}
