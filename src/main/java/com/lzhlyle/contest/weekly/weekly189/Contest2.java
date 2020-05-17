package com.lzhlyle.contest.weekly.weekly189;

import java.util.Arrays;
import java.util.Comparator;

public class Contest2 {
    public String arrangeWords(String text) {
        String[] arr = text.toLowerCase().split(" ");
        Arrays.sort(arr, Comparator.comparingInt(String::length));
        char[] cs = arr[0].toCharArray();
        cs[0] -= (int) ('a' - 'A');
        arr[0] = new String(cs);
        return String.join(" ", arr);
    }

    public static void main(String[] args) {
        Contest2 contest = new Contest2();
        {

        }
    }
}
