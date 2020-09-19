package com.lzhlyle.contest.biweekly.biweekly35;

import java.util.HashMap;
import java.util.Map;

public class Contest3 {
    // presum
    public int minSubarray(int[] nums, int p) {
        if (p == 1) return 0;
        int n = nums.length;
        if (n == 1) return nums[0] % p == 0 ? 0 : -1;

        for (int i = 0; i < n; i++)
            nums[i] %= p;

        long[] pre = new long[n + 1];
        for (int i = 1; i < pre.length; i++)
            pre[i] = pre[i - 1] + nums[i - 1];

        long mod = pre[n] % p;
        if (mod == 0) return 0;

        // two-sum: (后 - 前) % p == mod
        int min = n;
        Map<Long, Integer> map = new HashMap<>(); // (val, last-index)
        map.put(0L, 0);
        for (int i = 1; i < pre.length; i++) {
            long expected = (pre[i] - mod) % p;
            if (map.containsKey(expected)) {
                int j = map.get(expected);
                min = Math.min(min, i - j);
            }
            map.put(pre[i] % p, i);
        }
        return min == n ? -1 : min;
    }

    public static void main(String[] args) {
        Contest3 contest = new Contest3();
        {

        }
    }
}
