package com.lzhlyle.contest.weekly.weekly193;

public class Contest1 {

    public int[] runningSum(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        if (n == 0) return res;
        res[0] = nums[0];
        for (int i = 1; i < n; i++)
            res[i] = nums[i] + res[i - 1];
        return res;
    }

    public static void main(String[] args) {
        System.out.println("begin");
        Contest1 contest = new Contest1();
        {
            
        }
    }
}
