package com.lzhlyle.leetcode.self.lcci1716;

public class TheMasseuseLcci {
    // dp
    public int massage(int[] nums) {
        if (nums.length == 0) return 0;
        int dp0 = 0, dp1 = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int ori0 = dp0;
            if (dp1 > dp0) dp0 = dp1;
            dp1 = ori0 + nums[i];
        }
        return Math.max(dp0, dp1);
    }
}
