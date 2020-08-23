package com.lzhlyle.contest.weekly.weekly203;

import java.util.Arrays;

public class Contest2 {
    public int maxCoins(int[] arr) {
        Arrays.sort(arr);
        int sum = 0, n = arr.length / 3;
        for (int i = arr.length - 2, cnt = 0; cnt < n; i -= 2, cnt++)
            sum += arr[i];
        return sum;
    }

    public static void main(String[] args) {
        Contest2 contest = new Contest2();
        {

        }
    }
}
