package config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.context.annotation.*;

import javax.sql.DataSource;

/**
 * 该类是一个配置类，作用=bean.xml
 * @author gg
 * @create 2020-11-23 17:03
 */
/*
@Configuration      指定当前类为配置类
    *当当前类被作为AnnotationConfigApplicationContext的参数时，该注解可以不写
@ComponentScan      告知spring在创建容器时要扫描的包
@Bean               把当前方法的返回值作为bean对象，存入ioc容器中，默认名称是方法名
@Import             用于导入其他的配置类
    *有该注解的类是父配置类
@PropertySource     用于指定properties文件的位置
    *classpath表示类路径下
 */
@Configuration
@ComponentScan(basePackages = "com")
@Import(JdbcConfig.class)
@PropertySource("classpath:jdbcConfig.properties")
public class SpringConfiguration {

}
