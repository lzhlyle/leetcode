package com.lzhlyle.leetcode.recite.no120;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Triangle_DP_Adv {
    public int minimumTotal(List<List<Integer>> triangle) {
        // f(i, j) = min(f(i+1, j), f(i+1, j+1)) + a(i, j)
        int rows = triangle.size();
        List<Integer> lastRow = triangle.get(rows - 1);
        int[] dp = new int[lastRow.size()];
        for (int i = 0; i < lastRow.size(); i++) {
            dp[i] = lastRow.get(i);
        }
        for (int i = rows - 2; i >= 0; i--) {
            List<Integer> row = triangle.get(i);
            for (int j = 0; j < row.size(); j++) {
                dp[j] = Math.min(dp[j], dp[j + 1]) + row.get(j);
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

        int res = new Triangle_DP_Adv().minimumTotal(triangle);
        System.out.println(res);
    }
}
