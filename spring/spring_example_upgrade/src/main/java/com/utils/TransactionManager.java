package com.utils;

import java.sql.SQLException;

/**
 * 和事务管理相关的工具类，包含开启事务 提交事务 回滚事务 释放连接
 * @author gg
 * @create 2020-11-24 11:20
 */
public class TransactionManager {

    private ConnectionUtils connectionUtils;

    public void setConnectionUtils(ConnectionUtils connectionUtils) {
        this.connectionUtils = connectionUtils;
    }

    public void begin(){
        try {
            connectionUtils.getConnection().setAutoCommit(false);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void commit(){
        try {
            connectionUtils.getConnection().commit();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void rollback(){
        try {
            connectionUtils.getConnection().rollback();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void release(){
        try {
            connectionUtils.getConnection().close();    //把连接还回连接池中
            connectionUtils.removeConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
