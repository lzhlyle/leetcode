package com.lzhlyle.contest.season.spring2020.team;

public class Contest4_II {
    // dp
    public int splitArray(int[] nums) {
        int n = nums.length;
        int[] dpl = new int[n], dpr = new int[n];
        dpl[0] = nums[0];
        dpr[0] = nums[n - 1]; // 右区间，从右到左进入数组
        int i = 1, j = n - 2;


        return -1;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public static void main(String[] args) {
        Contest4_II contest = new Contest4_II();
        {
            int[] nums = new int[]{2, 3, 5, 7};
            int res = contest.splitArray(nums);
            System.out.println(res);
        }
    }
}
