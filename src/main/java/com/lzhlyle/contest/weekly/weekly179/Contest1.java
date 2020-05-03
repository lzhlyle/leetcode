package com.lzhlyle.contest.weekly.weekly179;

import java.util.Arrays;

public class Contest1 {
    public String generateTheString(int n) {
        char[] arr = new char[n];
        Arrays.fill(arr, 'a');
        if (n % 2 == 1) return new String(arr);

        arr[0] = 'b';
        return new String(arr);
    }

    public static void main(String[] args) {
        System.out.println("begin");
        Contest1 contest = new Contest1();
        {

        }
    }
}
