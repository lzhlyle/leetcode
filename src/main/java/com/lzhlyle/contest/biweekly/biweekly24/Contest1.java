package com.lzhlyle.contest.biweekly.biweekly24;

public class Contest1 {
    public int minStartValue(int[] nums) {
        int min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
            if (nums[i] < min) min = nums[i];
        }
        return min > 0 ? 1 : 1 - min;
    }

    public static void main(String[] args) {
        System.out.println("begin");
        Contest1 contest = new Contest1();
        {
            
        }
    }
}
