package com.lzhlyle.leetcode.self.no268;

public class MissingNumber_Hash {
    public int missingNumber(int[] nums) {
        int n = nums.length;

        // make sure nums[0] is 0
        if (nums[0] != 0) {
            for (int i = 1; i < n; i++) {
                if (nums[i] == 0) {
                    nums[i] = nums[0];
                    nums[0] = 0;
                }
            }
        }

        for (int v : nums) {
            int i = Math.abs(v);
            if (i == n) continue;
            nums[i] = -nums[i];
        }

        for (int i = 0; i < n; i++)
            if (nums[i] > 0) return i;
        return n;
    }
}
