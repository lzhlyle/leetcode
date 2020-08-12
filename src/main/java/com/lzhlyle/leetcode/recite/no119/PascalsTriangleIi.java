package com.lzhlyle.leetcode.recite.no119;

import java.util.Arrays;
import java.util.List;

public class PascalsTriangleIi {
    public List<Integer> getRow(int n) {
        Integer[] arr = new Integer[n + 1];
        Arrays.fill(arr, 0);
        arr[0] = 1;
        for (int r = 1; r <= n; r++)
            for (int i = r; i > 0; i--)
                arr[i] += arr[i - 1];
        return Arrays.asList(arr);
    }
}
