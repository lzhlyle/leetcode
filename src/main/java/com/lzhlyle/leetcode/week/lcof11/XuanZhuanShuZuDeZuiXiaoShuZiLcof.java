package com.lzhlyle.leetcode.week.lcof11;

public class XuanZhuanShuZuDeZuiXiaoShuZiLcof {
    public int minArray(int[] arr) {
        int l = 0, r = arr.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] > arr[r]) l = mid + 1;
            else if (arr[mid] < arr[l]) r = mid;
            else r--;
        }
        return arr[l];
    }
}
