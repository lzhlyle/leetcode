package com.lzhlyle.leetcode.tomorrow.no628;

public class MaximumProductOfThreeNumbers_Min2_Max3 {
    public int maximumProduct(int[] nums) {
        int min1, min2, max3, max2, max1;
        min1 = min2 = 1001;
        max3 = max2 = max1 = -1001;
        for (int v : nums) {
            if (v < min1) {
                min2 = min1;
                min1 = v;
            } else if (v < min2) min2 = v;

            if (v > max1) {
                max3 = max2;
                max2 = max1;
                max1 = v;
            } else if (v > max2) {
                max3 = max2;
                max2 = v;
            } else if (v > max3) max3 = v;
        }
        if (min2 >= 0) return max3 * max2 * max1;
        return Math.max(min1 * min2 * max1, max3 * max2 * max1);
    }
}
