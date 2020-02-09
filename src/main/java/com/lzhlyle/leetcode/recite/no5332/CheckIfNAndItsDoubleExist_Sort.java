package com.lzhlyle.leetcode.recite.no5332;

import java.util.*;

public class CheckIfNAndItsDoubleExist_Sort {
    public boolean checkIfExist(int[] arr) {
        Arrays.sort(arr);
        Set<Integer> set = new HashSet<>();
        for (int value : arr) {
            if (value <= 0) continue;
            if (set.contains(value)) return true;
            set.add(value * 2);
        }
        set.clear();
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] > 0) continue;
            if (set.contains(arr[i])) return true;
            set.add(arr[i] * 2);
        }
        return false;
    }
}
