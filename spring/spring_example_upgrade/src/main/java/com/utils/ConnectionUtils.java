package com.utils;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * 连接工具类，用于从数据源中获取一个连接，并实现和线程的绑定
 * @author gg
 * @create 2020-11-24 11:01
 */
public class ConnectionUtils {
    private ThreadLocal<Connection> threadLocal = new ThreadLocal<Connection>();
    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    //获取当前线程上的连接
    public Connection getConnection(){
        try {
            //先从threadLocal上获取
            Connection connection = threadLocal.get();
            //判断当前线程上是否有连接
            if (connection == null) {
                //若没有，就从数据源中获取一个连接，并且存入threadLocal中
                connection = dataSource.getConnection();
                threadLocal.set(connection);
            }
            //返回当前线程上的连接
            return connection;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    //把连接和线程解绑
    public void removeConnection(){
        threadLocal.remove();
    }
}
