package com.lzhlyle.contest.weekly.weekly182;

public class Contest1 {
    public int findLucky(int[] arr) {
        int[] freq = new int[501];
        for (int num : arr) freq[num]++;
        int res = -1;
        for (int num = 1; num < freq.length; num++) {
            if (num == freq[num]) res = num;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println("begin");
        Contest1 contest = new Contest1();
        {

        }
    }
}
