package com.lzhlyle.leetcode.week.no1300;

public class SumOfMutatedArrayClosestToTarget_BS {
    public int findBestValue(int[] arr, int target) {
        int l = 0, r = arr[0];
        for (int v : arr)
            r = Math.max(r, v);

        while (l < r) {
            int mid = l + (r - l) / 2;
            // 排除小的，留下大于等于的
            if (calc(arr, mid) < target) l = mid + 1;
            else r = mid;
        }

        int sum1 = calc(arr, l - 1); // 可能小一点
        int sum2 = calc(arr, l); // 可能大于等于
        return Math.abs(sum1 - target) <= Math.abs(sum2 - target)
                ? l - 1 : l;
    }

    private int calc(int[] arr, int bound) {
        int sum = 0;
        for (int v : arr)
            sum += Math.min(v, bound);
        return sum;
    }
}
