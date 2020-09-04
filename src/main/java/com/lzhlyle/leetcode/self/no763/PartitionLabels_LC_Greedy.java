package com.lzhlyle.leetcode.self.no763;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PartitionLabels_LC_Greedy {
    public List<Integer> partitionLabels(String S) {
        int n = S.length();
        if (n == 1) return Collections.singletonList(1);

        int[] last = new int[26];
        for (int i = 0; i < n; i++)
            last[S.charAt(i) - 'a'] = i;

        List<Integer> res = new ArrayList<>();
        int l = 0, r = 0;
        for (int i = 0; i < n; i++) {
            r = Math.max(r, last[S.charAt(i) - 'a']);
            if (r == i) {
                res.add(r - l + 1);
                l = r = i + 1;
            }
        }
        return res;
    }
}
