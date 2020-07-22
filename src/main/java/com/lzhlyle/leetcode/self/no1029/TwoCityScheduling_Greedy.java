package com.lzhlyle.leetcode.self.no1029;

import java.util.Arrays;

public class TwoCityScheduling_Greedy {
    // O(nlog(n))
    public int twoCitySchedCost(int[][] costs) {
        int res = 0, n = costs.length;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            res += costs[i][0];
            arr[i] = costs[i][0] - costs[i][1];
        }

        Arrays.sort(arr);
        for (int i = n / 2; i < n; i++)
            res -= arr[i];
        return res;
    }
}
