package com.lzhlyle.contest.weekly178;

import java.util.Arrays;

public class Contest1 {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (i == j) continue;
                if (nums[i] > nums[j]) res[i]++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println("begin");
        Contest1 contest = new Contest1();
        {
            int[] nums = {8, 1, 2, 2, 3};
            int[] res = contest.smallerNumbersThanCurrent(nums);
            System.out.println(Arrays.toString(res));
        }
        {
            int[] nums = {6, 5, 4, 8};
            int[] res = contest.smallerNumbersThanCurrent(nums);
            System.out.println(Arrays.toString(res));
        }
        {
            int[] nums = {7, 7, 7, 7};
            int[] res = contest.smallerNumbersThanCurrent(nums);
            System.out.println(Arrays.toString(res));
        }
    }
}
