package com.lzhlyle.leetcode.recite.no403;

import java.util.HashSet;
import java.util.Set;

public class FrogJump_LC_DP_TopDown_Greedy_Recite {
    private int end;
    private Set<Integer> set = new HashSet<>();

    public boolean canCross(int[] stones) {
        if (stones[1] != 1) return false;
        int len = stones.length;
        end = stones[len - 1];
        for (int i = 0; i < len; i++) {
            if (i > 3 && stones[i] >= 2 * stones[i - 1]) return false;
            set.add(stones[i]);
        }
        return jump(1, 1);
    }

    private boolean jump(int curr, int k) {
        if (curr == end) return true;
        for (int far = k + 1; far > k - 2; far--) {
            if (far > 0 && set.contains(curr + far)) {
                if (jump(curr + far, far)) return true;
            }
        }
        return false;
    }
}
