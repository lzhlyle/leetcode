package com.lzhlyle.contest.weekly.weekly201;

import java.util.HashMap;
import java.util.Map;

public class Contest3 {
    // from lc
    public int maxNonOverlapping(int[] nums, int target) {
        int n = nums.length;
        int[] dp = new int[n + 1];
        Map<Long, Integer> map = new HashMap<>(n + 1); // (sum, i)
        map.put(0L, 0); // 前补 sum=0, i=0
        long sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += nums[i - 1];
            Integer pre = map.get(sum - target);
            dp[i] = dp[i - 1];
            if (pre != null) {
                dp[i] = Math.max(dp[i], dp[pre] + 1);
            }
            map.put(sum, i);
        }
        int ans = dp[n];
        return ans;
    }

    public static void main(String[] args) {
        Contest3 contest = new Contest3();
        {

        }
    }
}
