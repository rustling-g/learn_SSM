package com.exception;

/**
 * 自定义异常类
 * @author gg
 * @create 2020-11-28 下午5:55
 */
public class SysException extends Exception{
    private String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public SysException(String msg) {
        this.msg = msg;
    }
}
