package com.lzhlyle.leetcode.recite.no5332;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CheckIfNAndItsDoubleExist_NotSort {
    public boolean checkIfExist(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (int value : arr) {
            if (set.contains(value)) return true;
            set.add(value * 2);
            if ((value % 2) == 0) set.add(value / 2);
        }
        return false;
    }
}
