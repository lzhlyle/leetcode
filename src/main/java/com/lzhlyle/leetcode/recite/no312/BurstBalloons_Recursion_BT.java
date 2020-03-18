package com.lzhlyle.leetcode.recite.no312;

public class BurstBalloons_Recursion_BT {
    // timeout
    public int maxCoins(int[] nums) {
        int max = 0;
        for (int i = 0, len = nums.length; i < len; i++) {
            if (nums[i] == -1) continue;
            int total = nums[i], ori = nums[i];

            int l = i - 1;
            while (l >= 0 && nums[l] == -1) l--;
            if (l >= 0) total *= nums[l];

            int r = i + 1;
            while (r < len && nums[r] == -1) r++;
            if (r < len) total *= nums[r];

            nums[i] = -1; // flood-fill
            max = Math.max(max, maxCoins(nums) + total);
            nums[i] = ori; // bt
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {3, 1, 5, 8};
        int res = new BurstBalloons_Recursion_BT().maxCoins(nums);
        System.out.println(res);
    }
}
