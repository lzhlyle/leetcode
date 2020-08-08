package com.lzhlyle.contest.biweekly.biweekly32;

public class Contest1 {
    public int findKthPositive(int[] arr, int k) {
        for (int i = 0, num = 1; i < arr.length; num++) {
            if (arr[i] == num) i++;
            else k--;
            if (k == 0) return num;
        }
        return arr[arr.length - 1] + k;
    }

    public static void main(String[] args) {
        Contest1 contest = new Contest1();
        {

        }
    }
}
