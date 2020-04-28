package com.lzhlyle.leetcode.recite.no645;

public class SetMismatch_LC_ArrayHashTable {
    public static int[] findErrorNums(int[] nums) {
        int[] res = new int[2];
        for (int i : nums) {
            int abs = Math.abs(i); // 保证正数
            if (nums[abs - 1] < 0) res[0] = abs; // 若已转为 负索引值，说明已重复
            else nums[abs - 1] *= -1; // 有这个数则转 负数索引值
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) res[1] = i + 1; // 未转负索引值的，即缺少的
        }
        return res;
    }
}
