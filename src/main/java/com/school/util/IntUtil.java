package com.school.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 2019年1月4日21:53:06
 * Integer 操作工具类
 */
public class IntUtil {
    /**
     * 判断是否等于1
     */
    public static boolean addDeleteUpdate(int i) {
        boolean b = false;
        if (i == 1) {
            b = true;
        }
        return b;
    }

    public static void main(String[] args) {
        System.out.println(getIntegerUUID());
    }
    public static Integer getIntegerUUID() {
        return  Integer.parseInt(1+""+(int) ((Math.random()*9+1)*1000)+""+(int) ((Math.random()*9+1)*10000));
    }

}
