package com.lzhlyle.leetcode.tomorrow.no169;

public class MajorityElement_DC {
    public int majorityElement(int[] nums) {
        return _majorityEle(nums, 0, nums.length - 1);
    }

    private int _majorityEle(int[] arr, int begin, int end) {
        if (begin >= end) return arr[begin];

        int mid = begin + ((end - begin) >> 1);
        int left = _majorityEle(arr, begin, mid);
        int right = _majorityEle(arr, mid + 1, end);
        if (left == right) return left;

        int leftCnt = _countRange(arr, left, begin, end);
        int rightCnt = _countRange(arr, right, begin, end);
        return leftCnt > rightCnt ? left : right;
    }

    private int _countRange(int[] arr, int target, int begin, int end) {
        int count = 0;
        for (int i = begin; i <= end; i++) if (arr[i] == target) count++;
        return count;
    }
}
