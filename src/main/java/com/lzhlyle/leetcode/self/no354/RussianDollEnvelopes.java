package com.lzhlyle.leetcode.self.no354;

import java.util.Arrays;

public class RussianDollEnvelopes {
    // sort + lis
    // dp + bs
    public int maxEnvelopes(int[][] envelopes) {
        int len = envelopes.length;
        Arrays.sort(envelopes, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);

        // lis
        int[] groups = new int[len];
        int cnt = 0;
        for (int[] pair : envelopes) {
            int i = bs(groups, pair[1], 0, cnt);
            groups[i] = pair[1];
            if (i == cnt) cnt++;
        }
        return cnt;
    }

    private int bs(int[] arr, int target, int l, int r) {
        while (l < r) {
            int mid = l + ((r - l) >> 1);
            if (arr[mid] < target) l = mid + 1;
            else r = mid;
        }
        return l;
    }
}
