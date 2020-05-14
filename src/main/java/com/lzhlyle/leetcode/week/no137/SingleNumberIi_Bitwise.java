package com.lzhlyle.leetcode.week.no137;

public class SingleNumberIi_Bitwise {
    public int singleNumber(int[] nums) {
        // every bit should be 3 times of '1'
        int res = 0b0;
        for (int i = 0; i < 32; i++) {
            int cnt = 0;
            for (int num : nums)
                cnt += (num >> i) & 1;
            if (cnt % 3 != 0) res |= (1 << i);
        }
        return res;
    }
}
