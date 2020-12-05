package test;

import com.dao.IUserDao;
import com.domain.QueryVo;
import com.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author gg
 * @create 2020-10-11 22:04
 */
public class UserTest {
    private InputStream in;
    SqlSessionFactory factory;
    private SqlSession session;
    private IUserDao userDao;

    @Before     //在单元测试方法之前运行
    public void init() throws IOException{
        //1 读取配置文件
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2 创建SqlSessionFactory工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        factory = builder.build(in);
        //3 使用工厂生产SqlSession对象
        //如果openSession中为true，则为自动提交，后面不用写session.commit都可以增删改查
        session = factory.openSession();
        //4 使用SqlSession创建Dao接口的代理对象
        userDao = session.getMapper(IUserDao.class);
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
    public void testFirstClassCache(){
        User user1 = userDao.findById(41);
        System.out.println(user1);
        session.clearCache();

        userDao = session.getMapper(IUserDao.class);
        User user2 = userDao.findById(41);
        System.out.println(user2);

        System.out.println(user1==user2);       //false
    }

    @Test
    public void testFindAllRoles(){
        List<User> users = userDao.findAllRoles();
        for (User user : users){
            System.out.println(user);
            System.out.println(user.getRoles());
        }
    }

    @Test
    public void testFindAll(){
        //5 使用代理对象执行方法
        List<User> users = userDao.findAll();
        for(User user: users) {
            System.out.println(user);
            System.out.println(user.getAccounts());

        }
    }

    @Test
    public void testSave(){
        //5 使用代理对象执行方法
        User user = new User("老王",new Date(),"女","hangzhou");
        System.out.println("保存操作之前："+user);
        userDao.saveUser(user);
        System.out.println("保存操作之后："+user);
    }

    @Test
    public void testUpdate(){
        //5 使用代理对象执行方法
        User user = new User("test",new Date(),"B","hangzhou");
        user.setId(50);
        userDao.updateUser(user);
    }

    @Test
    public void testDelete(){
        //5 使用代理对象执行方法
        userDao.deleteUser(50);
    }

    @Test
    public void findOne(){
        //5 使用代理对象执行方法
        User user = userDao.findById(48);
        System.out.println(user);
    }

    @Test
    public void testFindByName(){
        //5 使用代理对象执行方法
        List<User> users = userDao.findByName("王");
        for (User user : users)
            System.out.println(user);
    }

    @Test
    public void findTotal(){
        int total = userDao.findTotal();
        System.out.println("总记录条数为："+total);
    }

    @Test
    public void testFindByCondition(){
        User u = new User();
        u.setUsername("老王");
        u.setSex("男");
        List<User> result = userDao.findByCondition(u);
        for (User user : result)
            System.out.println(user);
    }

    @Test
    public void testFindInIds(){
        QueryVo vo = new QueryVo();
        List<Integer> list = new ArrayList<>();
        list.add(41);
        list.add(42);
        list.add(46);
        vo.setIds(list);
        List<User> result = userDao.findUserInIds(vo);
        for (User user : result)
            System.out.println(user);
    }
}
