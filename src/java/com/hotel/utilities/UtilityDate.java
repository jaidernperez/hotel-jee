package com.hotel.utilities;

import java.util.Date;

public class UtilityDate {

    public static java.sql.Date generateDate() {
        Date currentDate = new java.util.Date();
        return new java.sql.Date(currentDate.getTime());
    }

    public static boolean isGreaterEndDate(Date startDate, Date endDate){
        return startDate.before(endDate);
    }

    public static java.sql.Date convertToSqlDate(Date date){
        return new java.sql.Date(date.getTime());
    }

    public static int getDiffDays(Date startDate, Date endDate) {
        long startTime = startDate.getTime();
        long endTime = endDate.getTime();

        long diffTime = endTime - startTime;
        long diffDays = diffTime / (86400000);
        return (int) diffDays;
    }
}
