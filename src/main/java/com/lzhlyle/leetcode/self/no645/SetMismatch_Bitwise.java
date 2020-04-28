package com.lzhlyle.leetcode.self.no645;

public class SetMismatch_Bitwise {
    public int[] findErrorNums(int[] nums) {
        int xor = 0b0, n = nums.length;
        for (int num : nums) xor ^= num;
        for (int i = 1; i <= n; i++) xor ^= i;

        int spliter = xor & (-xor), a = 0b0, b = 0b0;
        for (int num : nums) {
            if ((num & spliter) == 0) a ^= num;
            else b ^= num;
        }
        for (int i = 1; i <= n; i++) {
            if ((i & spliter) == 0) a ^= i;
            else b ^= i;
        }

        for (int num : nums) {
            if (num == a) return new int[]{a, b};
            if (num == b) return new int[]{b, a};
        }
        return new int[2];
    }
}
