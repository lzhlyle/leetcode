package com.lzhlyle.contest.weekly.weekly196;

import java.util.Arrays;

public class Contest1 {
    public boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);
        int del = arr[1] - arr[0];
        for (int i = 2; i < arr.length; i++)
            if (arr[i] - arr[i - 1] != del) return false;
        return true;
    }

    public static void main(String[] args) {
        Contest1 contest = new Contest1();
        {

        }
    }
}
