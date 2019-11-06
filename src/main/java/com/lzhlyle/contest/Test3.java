package com.lzhlyle.contest;

import java.util.HashMap;
import java.util.Map;

public class Test3 {
    public int[] twoSum(int[] nums, int target) {
        // base condition
        if (nums == null || nums.length < 2) return new int[0];

        Map<Integer, Integer> expectedMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (expectedMap.containsKey(nums[i])) return new int[]{expectedMap.get(nums[i]), i};

            expectedMap.put(target - nums[i], i);
        }
        return new int[0];
    }

    public static void main(String[] args) {
        Object res = new Test3();
        System.out.println(res);
    }
}
