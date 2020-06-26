package com.lzhlyle.leetcode.tomorrow.no448;

import java.util.ArrayList;
import java.util.List;

public class FindAllNumbersDisappearedInAnArray {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        List<Integer> res = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] > 0) nums[index] = -nums[index];
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) res.add(i + 1);
            nums[i] = -nums[i];
        }
        return res;
    }
}
