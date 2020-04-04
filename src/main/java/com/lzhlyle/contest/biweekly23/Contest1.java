package com.lzhlyle.contest.biweekly23;

import java.util.Arrays;

public class Contest1 {
    public int countLargestGroup(int n) {
        int[] freq = new int[10000]; // 0-9
        for (int i = 1; i <= n; i++) {
            freq[calc(i)]++;
        }
        Arrays.sort(freq);
        int cnt = 1, max = freq[freq.length - 1];
        for (int i = freq.length - 2; i > 0; i--) {
            if (freq[i] == max) cnt++;
            else break;
        }
        return cnt;
    }

    private int calc(int n) {
        int total = 0;
        while (n > 0) {
            total += n % 10;
            n /= 10;
        }
        return total;
    }

    public static void main(String[] args) {
        Contest1 contest = new Contest1();
        {
            int res = contest.countLargestGroup(24);
            System.out.println(res);
        }
    }
}
