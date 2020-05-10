package com.lzhlyle.contest.weekly.weekly188;

public class Contest2 {
    public int countTriplets(int[] arr) {
        int len = arr.length, cnt = 0;
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                int a = 0b0;
                for (int ai = i; ai < j; ai++) a ^= arr[ai];
                for (int k = j; k < len; k++) {
                    int b = 0b0;
                    for (int bi = j; bi <= k; bi++) b ^= arr[bi];
                    if (a == b) {
                        // System.out.println(i + ", " + j + ", " + k);
                        cnt++;
                    }
                }
            }
        }
        return cnt;
    }


    public static void main(String[] args) {
        Contest2 contest = new Contest2();
        {

        }
    }
}
