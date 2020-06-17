package com.lzhlyle.leetcode.recite.no368;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LargestDivisibleSubset_DP {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        if (n == 0) return Collections.emptyList();

        Arrays.sort(nums);
        List[] dp = new List[n]; // dp[i] 以 nums[i] 结尾的整除子集
        int max = 0;
        List<Integer> res = null;
        for (int i = 0; i < n; i++) {
            dp[i] = new ArrayList<Integer>();
            int currMax = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] % nums[j] == 0 && dp[j].size() > currMax) {
                    dp[i].clear();
                    dp[i].addAll(dp[j]);
                    currMax = dp[j].size();
                }
            }
            dp[i].add(nums[i]);

            if (dp[i].size() > max) {
                res = dp[i];
                max = dp[i].size();
            }
        }
        return res;
    }
}
