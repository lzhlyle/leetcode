package com.lzhlyle.leetcode.week.no1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        // base condition
        if (nums == null || nums.length < 2) return new int[0];

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) return new int[]{map.get(nums[i]), i};

            map.put(target - nums[i], i);
        }
        return new int[0];
    }

    public static void main(String[] args) {
        int[] res = new TwoSum().twoSum(new int[]{1, 2, 3}, 5);
        System.out.println(Arrays.toString(res));
    }
}
