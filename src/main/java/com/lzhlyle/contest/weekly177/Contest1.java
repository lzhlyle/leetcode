package com.lzhlyle.contest.weekly177;

import java.util.Calendar;
import java.util.Date;

public class Contest1 {
    public int daysBetweenDates(String date1, String date2) {
        long d1 = getDate(date1), d2 = getDate(date2);
        long del = (d1 - d2) / 1000 / 60 / 60 / 24;
        return (int) Math.abs(del);
    }

    private long getDate(String date) {
        String[] arr = date.split("-");
        return -1;
    }

    public static void main(String[] args) {
        Contest1 contest = new Contest1();
        {
            String date1 = "2019-06-29", date2 = "2019-06-30";
            int res = contest.daysBetweenDates(date1, date2);
            System.out.println(res);
        }

        {
            String date1 = "2020-01-15", date2 = "2019-12-31";
            int res = contest.daysBetweenDates(date1, date2);
            System.out.println(res);
        }
    }
}
