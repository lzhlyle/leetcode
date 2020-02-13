package com.lzhlyle.leetcode.recite.no120;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Triangle_DP_LC {
    public int minimumTotal(List<List<Integer>> triangle) {
        int rows = triangle.size();
        int[] dp = new int[rows + 1];
        for (int i = rows - 1; i >= 0; i--) {
            List<Integer> level = triangle.get(i);
            for (int j = 0; j < level.size(); j++) {
                dp[j] = Math.min(dp[j], dp[j + 1]) + level.get(j);
            }
        }
        return dp[0];
    }

    public static void main(String[] args) {
        List<List<Integer>> triangle = Arrays.asList(
                Collections.singletonList(2),
                Arrays.asList(3, 4),
                Arrays.asList(6, 5, 7),
                Arrays.asList(4, 1, 8, 3)
        );

        int res = new Triangle_DP_LC().minimumTotal(triangle);
        System.out.println(res);
    }
}
