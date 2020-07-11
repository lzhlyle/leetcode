package com.lzhlyle.contest.biweekly.biweekly30;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Contest1 {
    public String reformatDate(String date) {
        Map<String, String> monthMap = new HashMap<>();
        List<String> months = Arrays.asList("Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec");
        int i = 1;
        for (String m : months) {
            String im;
            if (i < 10) im = "0" + i;
            else im = i + "";
            monthMap.put(m, im);
            i++;
        }

        String[] arr = date.split(" ");
        String d = arr[0].replace("th", "")
                .replace("st", "")
                .replace("nd", "")
                .replace("rd", "");

        return String.format("%s-%s-%s", arr[2], monthMap.get(arr[1]), d.length() == 1 ? "0" + d : d);
    }

    public static void main(String[] args) {
        Contest1 contest = new Contest1();
        {

        }
    }
}
