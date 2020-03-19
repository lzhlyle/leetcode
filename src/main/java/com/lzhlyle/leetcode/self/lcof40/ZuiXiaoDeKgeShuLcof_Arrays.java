package com.lzhlyle.leetcode.self.lcof40;

import java.util.Arrays;

public class ZuiXiaoDeKgeShuLcof_Arrays {
    public int[] getLeastNumbers(int[] arr, int k) {
        Arrays.sort(arr);
        return Arrays.copyOfRange(arr, 0, k);
    }
}
