package com.lzhlyle.contest.weekly.weekly197;

public class Contest1 {
    public int numIdenticalPairs(int[] nums) {
        int cnt = 0;
        for (int i = 0; i < nums.length; i++)
            for (int j = i + 1; j < nums.length; j++)
                if (nums[i] == nums[j]) cnt++;
        return cnt;
    }

    public static void main(String[] args) {
        Contest1 contest = new Contest1();
        {
            
        }
    }
}
