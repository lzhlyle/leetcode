package com.lzhlyle.leetcode.self.no260;

public class SingleNumberIii {
    public int[] singleNumber(int[] nums) {
        int xor = 0b0;
        for (int num : nums) xor ^= num;

        int low = xor & (-xor);
        int a = 0b0, b = 0b0;
        for (int num : nums) {
            if ((num & low) == 0) a ^= num;
            else b ^= num;
        }
        return new int[]{a, b};
    }
}
