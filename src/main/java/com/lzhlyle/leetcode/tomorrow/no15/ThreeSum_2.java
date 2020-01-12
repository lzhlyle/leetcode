package com.lzhlyle.leetcode.tomorrow.no15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ThreeSum_2 {
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) return Collections.emptyList();

        Arrays.sort(nums);
        if (nums[nums.length - 1] < 0) return Collections.emptyList();

        List<List<Integer>> result = new ArrayList<>();
        for (int target = 0; target < nums.length - 2; target++) {
            if (nums[target] > 0) return result;
            if (target > 0 && nums[target] == nums[target - 1]) continue; // skip duplicate

            int left = target + 1, right = nums.length - 1;

            while (left < right) {
                int sum = nums[target] + nums[left] + nums[right];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[target], nums[left], nums[right]));

                    // skip duplicate
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0, 0, 0};
        new ThreeSum_2().threeSum(nums);
    }
}
