package com.lzhlyle.leetcode.self.no763;

import java.util.*;

public class PartitionLabels {
    public List<Integer> partitionLabels(String S) {
        int n = S.length();
        if (n == 1) return Collections.singletonList(1);

        int[][] arr = new int[26][2];
        for (int[] row : arr) Arrays.fill(row, -1);
        for (int i = 0; i < n; i++) {
            char c = S.charAt(i);
            if (arr[c - 'a'][0] == -1)
                arr[c - 'a'][0] = i;
            arr[c - 'a'][1] = i;
        }
        Arrays.sort(arr, Comparator.comparingInt(a -> a[0]));

        List<Integer> res = new ArrayList<>();
        int l = -1, r = -1;
        for (int[] a : arr) {
            if (a[0] == -1) continue;
            if (l == -1) {
                l = a[0];
                r = a[1];
            } else if (a[0] <= r) {
                r = Math.max(r, a[1]);
            } else {
                res.add(r - l + 1);
                l = a[0];
                r = a[1];
            }
        }
        res.add(r - l + 1);
        return res;
    }
}
