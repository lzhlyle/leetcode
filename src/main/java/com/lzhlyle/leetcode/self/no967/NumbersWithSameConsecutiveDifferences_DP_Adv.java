package com.lzhlyle.leetcode.self.no967;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NumbersWithSameConsecutiveDifferences_DP_Adv {
    public int[] numsSameConsecDiff(int n, int k) {
        if (n == 1) return new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

        List<Integer>[] dp = new List[10]; // 当前位，以 j 结尾，有 set
        for (int i = 0; i <= 9; i++)
            dp[i] = new ArrayList<>(Collections.singletonList(i));

        int cnt = 0;
        for (int i = 2; i <= n; i++) {
            if (i == n) cnt = 0; // re-count
            List[] next = new List[dp.length];
            for (int j = 0; j <= 9; j++) {
                List<Integer> list = new ArrayList<>();
                if (j - k >= 0 && !dp[j - k].isEmpty())
                    for (int last : dp[j - k])
                        if (last > 0) list.add(last * 10 + j);
                if (k != 0 && j + k <= 9 && !dp[j + k].isEmpty())
                    for (int last : dp[j + k])
                        if (last > 0) list.add(last * 10 + j);
                cnt += (next[j] = list).size();
            }
            dp = next;
        }

        int[] res = new int[cnt];
        int i = 0;
        for (List<Integer> row : dp)
            for (int v : row)
                if (v > 0)
                    res[i++] = v;
        return res;
    }
}
