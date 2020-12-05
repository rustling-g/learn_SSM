package jdbctemplate;

import dao.impl.AccountDaoImpl;
import domain.Account;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sound.midi.Soundbank;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @author gg
 * @create 2020-11-25 上午10:22
 */
public class JdbcTemplateDemo {
    public static void main(String[] args) {
        //准备容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //获取对象
        AccountDaoImpl accountDao = ac.getBean("accountDao", AccountDaoImpl.class);

        Account acc = accountDao.findAccountById(11);
        acc.setName("eee");
        accountDao.updateAccount(acc);

    }
}
