package com.skillswap.skillswap_core.Util;

import java.sql.Date;
import java.util.Calendar;

public class Utils {
    
    public static Date getFechaHoy(){
        Calendar calendar = Calendar.getInstance();
        Date currentDate = new Date(calendar.getTimeInMillis());
        return currentDate;
    }

}
