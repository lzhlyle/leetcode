package com.lzhlyle.leetcode.recite.no403;

import java.util.HashSet;
import java.util.Set;

public class FrogJump_LC_DP_TopDown_Greedy {
    private int end;
    private Set<Integer> set = new HashSet<>();

    public boolean canCross(int[] stones) {
        if (stones[1] != 1) return false;
        end = stones[stones.length - 1];
        for (int i = 0; i < stones.length; i++) {
            // 如果下一个石头位置序号为当前序号的两倍，肯定不符合
            if (i > 3 && stones[i] >= 2 * stones[i - 1]) return false;
            set.add(stones[i]);
        }
        return check(1, 1);
    }

    private boolean check(int curr, int k) {
        if (curr == end) return true;
        // 贪心：尽量往前跳
        for (int step = k + 1; step > k - 2; step--) {
            if (step == 0) continue;
            if (set.contains(curr + step) && check(curr + step, step)) return true;
        }
        return false;
    }
}
