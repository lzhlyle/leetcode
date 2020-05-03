package com.lzhlyle.contest.weekly.weekly183;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Contest1 {
    public List<Integer> minSubsequence(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int num : nums) sum += num;
        int avg = sum / 2;

        List<Integer> res = new ArrayList<>();
        int curr = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (curr <= avg) {
                curr += nums[i];
                res.add(nums[i]);
            }
            else break;
        }
        return res;
    }

    public static void main(String[] args) {
        Contest1 contest = new Contest1();
        {
            
        }
    }
}
