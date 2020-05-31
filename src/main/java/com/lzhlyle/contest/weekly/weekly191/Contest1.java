package com.lzhlyle.contest.weekly.weekly191;

public class Contest1 {
    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE, n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                max = Math.max(max, (nums[i] - 1) * (nums[j] - 1));
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Contest1 contest = new Contest1();
        {
            
        }
    }
}
