package test;

import com.dao.IUserDao;
import domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

/**
 * @author gg
 * @create 2020-11-20 21:09
 */
public class UserTest {
    InputStream in;
    SqlSessionFactory factory;
    SqlSession session;
    IUserDao userDao;

    @Before
    public void setUp() throws Exception {
        //1 获取字节输入流
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2 构建sqlSessionFactory
        factory = new SqlSessionFactoryBuilder().build(in);
        //3 生产sqlSession
        session = factory.openSession();
        //4 使用sqlSession获取dao的代理对象
        userDao = session.getMapper(IUserDao.class);
    }

    @After
    public void tearDown() throws Exception {
        session.commit();
        session.close();
        in.close();
    }


    @Test
    public void findAll() {
        List<User> users = userDao.findAll();
        for (User user : users)
            System.out.println(user);
    }

    @Test
    public void findAllAccounts() {
        List<User> users = userDao.findAllAccounts();
        for (User user : users) {
            System.out.println("--------------");
            System.out.println(user);
            System.out.println(user.getAccounts());
        }
    }

    @Test
    public void saveUser(){
        User user = new User(null, "aaa", "杭州", "男", new Date());
        userDao.saveUser(user);
    }

    @Test
    public void updateUser(){
        User user = new User(52, "bbb", "杭州", "男", new Date());
        userDao.updateUser(user);
    }

    @Test
    public void deleteUser(){
        userDao.deleteUser(52);
    }

    @Test
    public void findById(){
        User user = userDao.findById(50);
        System.out.println(user);
    }

    @Test
    public void findByName() {
        List<User> users = userDao.findByName("%王%");
        for (User user : users)
            System.out.println(user);
    }

    @Test
    public void findTotal(){
        int total = userDao.findTotal();
        System.out.println(total);
    }
}