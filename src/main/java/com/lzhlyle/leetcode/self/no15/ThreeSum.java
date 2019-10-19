package com.lzhlyle.leetcode.self.no15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 2) return Collections.emptyList();

        Arrays.sort(nums);

        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) return list;

            // duplicate in i
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            // left, right
            int left = i + 1;
            int right = nums.length - 1;
            if (nums[right] < 0) return list;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum < 0) {
                    left++;
                } else if (sum > 0) {
                    right--;
                } else {
                    list.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // duplicate in left, right
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;

                    left++;
                    right--;
                }
            }
        }
        return list;
    }
}
