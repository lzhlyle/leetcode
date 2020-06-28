package com.lzhlyle.contest.weekly.weekly195;

import java.util.Arrays;

public class Contest3_LC {
    private static int MOD = 1000000007;

    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);

        int n = nums.length;
        int[] mul = new int[n];
        mul[0] = 1;
        for (int i = 1; i < n; i++) {
            mul[i] = mul[i - 1] << 1;
            if (mul[i] >= MOD) mul[i] -= MOD;
        }

        int l = 0, r = n - 1;
        int cnt = 0;
        while (l <= r) {
            int sum = nums[l] + nums[r];
            if (sum <= target) {
                cnt += mul[r - l];
                if (cnt >= MOD) cnt -= MOD;
                l++;
            } else r--;
        }
        return cnt;
    }

    public static void main(String[] args) {
        Contest3_LC contest = new Contest3_LC();
        {

        }
    }
}
