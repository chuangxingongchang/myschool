package com.school;

import com.school.util.DateUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class MyschoolApplicationTests {
    private int id;
    private String ms;
    private Map map;
    private List<Integer> list;
    private Object object;


    @Test
    public void s(){
       String s =  DateUtil.getDate(new Date());
        System.out.println(s);
        Date date = DateUtil.getDate(s);
        System.out.println(date);
    }


    public Object sd(String s){
        Object o = s;
        return o;
    }



    public void sf(){

    }



}

