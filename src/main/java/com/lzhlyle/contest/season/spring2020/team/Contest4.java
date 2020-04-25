package com.lzhlyle.contest.season.spring2020.team;

public class Contest4 {
    // wa
    // dp 每次增加一个数，看与之前的所有数组的头部的谁能匹配就合并
    public int splitArray(int[] nums) {
        int[] arr = new int[nums.length];
        arr[0] = nums[0];
        int ai = 1; // arr index
        for (int i = 1; i < nums.length; i++) {
            boolean combine = false;
            for (int j = 0; j < ai; j++) {
                if (gcd(arr[j], nums[i]) <= 1) continue;
                else {
                    ai = j + 1;
                    combine = true;
                    break;
                }
            }
            if (!combine) arr[ai++] = nums[i];
        }
        return ai;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public static void main(String[] args) {
        Contest4 contest = new Contest4();
        {
            int[] nums = new int[]{2, 3, 5, 7, 11, 2, 3};
            int res = contest.splitArray(nums);
            System.out.println(res);
        }
    }
}
