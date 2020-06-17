package com.lzhlyle.leetcode.recite.no368;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LargestDivisibleSubset_DP_LC {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        if (n == 0) return Collections.emptyList();

        Arrays.sort(nums);

        int[] dp = new int[n], pre = new int[n]; // 前一个索引
        Arrays.fill(dp, 1);
        Arrays.fill(pre, -1);

        int max = 0, index = -1;
        for (int i = 0; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] % nums[j] == 0) {
                    if (dp[j] + 1 > dp[i]) { // 关键!
                        dp[i] = dp[j] + 1;
                        pre[i] = j;
                    }
                }
            }
            if (dp[i] > max) {
                max = dp[i];
                index = i;
            }
        }

        List<Integer> res = new ArrayList<>(max);
        while (index != -1) {
            res.add(nums[index]);
            index = pre[index];
        }
        return res;
    }
}
