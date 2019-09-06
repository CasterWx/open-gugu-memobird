package com.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtil {
    public static String getDate(){
        SimpleDateFormat lFormat = new SimpleDateFormat("yyyy-MM-dd%20HH:mm:ss");
        return (lFormat.format(new Date()));
    }
}
