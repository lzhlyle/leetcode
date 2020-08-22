package com.lzhlyle.leetcode.self.no905;

public class SortArrayByParity {
    public int[] sortArrayByParity(int[] arr) {
        int l = 0, r = arr.length - 1;
        while (l < r) {
            while (l < r && (arr[l] & 1) == 0) l++;
            while (l < r && (arr[r] & 1) == 1) r--;
            if (l < r) {
                int swap = arr[l];
                arr[l++] = arr[r];
                arr[r--] = swap;
            }
        }
        return arr;
    }
}
