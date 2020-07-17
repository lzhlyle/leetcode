package com.lzhlyle.leetcode.tomorrow.no287;

public class FindTheDuplicateNumber_FastSlowPoints {
    public int findDuplicate(int[] nums) {
        int fast = 0, slow = 0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (fast != slow);

        int again = 0;
        while (again != slow) {
            again = nums[again];
            slow = nums[slow];
        }
        return again;
    }
}
