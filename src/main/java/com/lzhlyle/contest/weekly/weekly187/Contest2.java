package com.lzhlyle.contest.weekly.weekly187;

public class Contest2 {
    public boolean kLengthApart(int[] nums, int k) {
        if (k == 0) return true;
        for (int i = 0, last = -1; i < nums.length; i++) {
            if (nums[i] == 1) {
                int dis = i - last - 1;
                if (last > -1 && dis < k) return false;
                last = i;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Contest2 contest = new Contest2();
        {
            int[] nums = {1, 0, 0, 0, 1, 0, 0, 1};
            boolean res = contest.kLengthApart(nums, 2);
            System.out.println(res);
        }
    }
}
