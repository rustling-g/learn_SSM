package com.utils;

import org.springframework.core.convert.converter.Converter;

import javax.sound.midi.Soundbank;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 自定义类型转换，字符串转日期
 * @author gg
 * @create 2020-11-27 下午5:53
 */
public class StringToDateConverter implements Converter<String, Date> {
    @Override
    public Date convert(String s) {
        if (s == null)
            throw new RuntimeException("未传入数据");
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = df.parse(s);
        } catch (ParseException e) {
            throw new RuntimeException("日期格式错误");
        }
        return date;
    }
}
