package com.lzhlyle.leetcode.recite.no1014;

public class BestSightseeingPair_Iteration {
    public int maxScoreSightseeingPair(int[] A) {
        int res = 0, add = A[0] + 0;
        for (int j = 1; j < A.length; j++) {
            res = Math.max(res, add + A[j] - j);
            add = Math.max(add, A[j] + j);
        }
        return res;
    }
}
