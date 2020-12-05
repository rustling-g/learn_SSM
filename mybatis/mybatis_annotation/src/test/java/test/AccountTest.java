package test;

import com.dao.IAccountDao;
import domain.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

/**
 * @author gg
 * @create 2020-11-21 16:12
 */
public class AccountTest {
    InputStream in;
    SqlSessionFactory factory;
    SqlSession session;
    IAccountDao accountDao;

    @Before
    public void setUp() throws Exception {
        //1 获取字节输入流
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2 构建sqlSessionFactory
        factory = new SqlSessionFactoryBuilder().build(in);
        //3 生产sqlSession
        session = factory.openSession();
        //4 使用sqlSession获取dao的代理对象
        accountDao = session.getMapper(IAccountDao.class);
    }

    @After
    public void tearDown() throws Exception {
        session.commit();
        session.close();
        in.close();
    }

    @Test
    public void findAll() {
        List<Account> accounts = accountDao.findAll();
        for (Account account : accounts) {
            System.out.println("-------------");
            System.out.println(account);
            System.out.println(account.getUser());
        }
    }

    @Test
    public void findAccountByUid(){
        List<Account> accounts = accountDao.findAccountByUid(41);
        System.out.println(accounts);
    }
}