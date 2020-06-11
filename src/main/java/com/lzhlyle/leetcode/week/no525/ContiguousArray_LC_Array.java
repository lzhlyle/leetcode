package com.lzhlyle.leetcode.week.no525;

import java.util.Arrays;

public class ContiguousArray_LC_Array {
    public int findMaxLength(int[] nums) {
        int cnt = 0, max = 0, len = nums.length;
        int[] arr = new int[2 * len + 1];
        Arrays.fill(arr, -2);
        arr[len] = -1;
        for (int i = 0; i < len; i++) {
            if (nums[i] == 1) cnt++;
            else cnt--;

            if (arr[cnt + len] == -2) arr[cnt + len] = i;
            else max = Math.max(max, i - arr[cnt + len]);
        }
        return max;
    }
}
