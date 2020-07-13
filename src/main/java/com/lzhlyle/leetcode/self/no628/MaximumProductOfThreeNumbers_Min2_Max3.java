package com.lzhlyle.leetcode.self.no628;

public class MaximumProductOfThreeNumbers_Min2_Max3 {
    public int maximumProduct(int[] nums) {
        int[] arr = new int[5];
        arr[2] = arr[3] = arr[4] = -1001;
        for (int v : nums) {
            if (v < arr[0]) {
                arr[1] = arr[0];
                arr[0] = v;
            } else if (v < arr[1]) {
                arr[1] = v;
            }

            if (v > arr[4]) {
                arr[2] = arr[3];
                arr[3] = arr[4];
                arr[4] = v;
            } else if (v > arr[3]) {
                arr[2] = arr[3];
                arr[3] = v;
            } else if (v > arr[2]) {
                arr[2] = v;
            }
        }

        int a = arr[0], b = arr[1], c = arr[2], d = arr[3], e = arr[4];
        if (b >= 0) return c * d * e;
        return Math.max(a * b * e, c * d * e);
    }
}
