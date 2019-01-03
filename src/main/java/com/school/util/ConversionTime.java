package com.school.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ConversionTime {
    public String conversion(long time){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        date.setTime(time);
        String mydate = sdf.format(date);
        return  mydate;
    }
}
