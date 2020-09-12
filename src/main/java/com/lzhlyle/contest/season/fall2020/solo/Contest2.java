package com.lzhlyle.contest.season.fall2020.solo;

import java.util.Arrays;

public class Contest2 {
    private static final int MOD = 1000000007;

    public int breakfastNumber(int[] aarr, int[] barr, int x) {
        Arrays.sort(aarr);
        Arrays.sort(barr);
        int cnt = 0;
        for (int i = 0; i < aarr.length && aarr[i] < x; i++) {
            int target = x - aarr[i];
            // lookup first larger then
            int l = 0, r = barr.length - 1;
            while (l < r) {
                int mid = l + (r - l + 1) / 2;
                if (barr[mid] > target) r = mid - 1;
                else l = mid;
            }
            if (barr[l] <= target) cnt += l + 1;
            if (cnt >= MOD) cnt -= MOD;
        }
        return cnt;
    }

    public static void main(String[] args) {
        Contest2 contest = new Contest2();
        {

        }
    }
}
