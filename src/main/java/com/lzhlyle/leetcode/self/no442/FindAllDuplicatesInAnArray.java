package com.lzhlyle.leetcode.self.no442;

import java.util.ArrayList;
import java.util.List;

public class FindAllDuplicatesInAnArray {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            nums[index] = -nums[index];
            if (nums[index] > 0) res.add(Math.abs(nums[i]));
        }
        return res;
    }
}
