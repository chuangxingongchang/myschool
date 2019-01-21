package com.school.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Auther: XiTao
 * @Date: 2018/12/23
 * @Field:时间处理
 */
public class DateUtil {

    /**
     * 获取 短 时间String
     *
     * @param date
     * @return
     */
    public static String getDate(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String h = simpleDateFormat.format(date);
        System.out.println(h);
        return h;
    }
    /**
     * 获取 长 时间String
     *
     * @param date
     * @return
     */
    public static String getLongDate(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String h = simpleDateFormat.format(date);
        System.out.println(h);
        return h;
    }
    /**
     * String获取时间 短 date
     *
     * @param s
     * @return
     */
    public static Date getDate(String s) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = simpleDateFormat.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
    public static Date getLongDate(String s) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date date = null;
        try {
            date = simpleDateFormat.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * 时间戳转 长时间 String
     * @param args
     * @return
     */
    public static String DateTimeTOLongString(String args) {
        String format;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        long lt = new Long(args);
        Date date = new Date(lt);
        format = simpleDateFormat.format(date);
        return format;
    }

    /**
     * 时间戳转类型String的格式日期（yyyy-MM-dd）
     * @param args
     * @return
     */
    public static String DateTimeTOString(String args) {
        String format;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd ");
        long lt = new Long(args);
        Date date = new Date(lt);
        format = simpleDateFormat.format(date);
        return format;
    }

    /**
     * 获取短时间类型
     * @return
     */
    public static String getDATE() {
        String format;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd ");
        Date date = new Date();
        format = simpleDateFormat.format(date);
        return format;
    }

}
