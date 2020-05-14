package com.lzhlyle.leetcode.week.no645;

public class SetMismatch_LC_ArrayHashTable {
    public static int[] findErrorNums(int[] nums) {
        int[] res = new int[2];
        for (int v : nums) {
            int i = Math.abs(v) - 1; // 保证正数

            if (nums[i] > 0) nums[i] = -nums[i];  // 有这个数则转 负数索引值
            else res[0] = i + 1; // 若已转为 负索引值，说明已重复
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) res[1] = i + 1; // 未转负索引值的，即缺少的
        }
        return res;
    }
}
