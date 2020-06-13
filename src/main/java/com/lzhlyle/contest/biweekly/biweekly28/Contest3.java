package com.lzhlyle.contest.biweekly.biweekly28;

import java.util.ArrayList;
import java.util.List;

public class Contest3 {

    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;
        // list 记录所有和为 target 的区间
        List<int[]> list = new ArrayList<>();
        for (int l = 0, r = 0, sum = 0; r < n; r++) {
            if (arr[r] == target) {
                list.add(new int[]{r, r});
                // 重置滑动窗口
                l = r + 1;
                sum = 0;
            } else if (arr[r] > target) {
                // 重置滑动窗口
                l = r + 1;
                sum = 0;
            } else {
                // 双指针滑动窗口
                sum += arr[r];
                while (sum > target) {
                    sum -= arr[l++];
                }
                if (sum == target) {
                    list.add(new int[]{l, r});
                }
            }
        }

        if (list.size() < 2) return -1;

        // 从后向前确定最窄区间
        // dp[i] 表示从第 i 个起往后，最小的区间宽度是多少
        int len = list.size();
        int[] dp = new int[len + 1];
        dp[len] = Integer.MAX_VALUE;
        for (int i = len - 1; i >= 0; i--) {
            int[] p = list.get(i);
            dp[i] = Math.min(dp[i + 1], p[1] - p[0] + 1);
        }

        // 构建 ps 记录所有区间的左端点
        // 使得可二分法快速查找 第一个比 a[1] 大的区间
        int[] ps = new int[len];
        int pi = 0;
        for (int[] p : list) ps[pi++] = p[0];

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < len - 1; i++) {
            int[] a = list.get(i);
            // 找第一个比 a[1] 大的区间，即与 q 区间不重合
            int l = i + 1, r = len - 1;
            while (l < r) {
                int mid = l + (r - l) / 2;
                if (ps[mid] <= a[1]) l = mid + 1;
                else r = mid;
            }
            if (ps[l] > a[1])
                min = Math.min(min, (a[1] - a[0] + 1) + dp[l]);
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    public static void main(String[] args) {
        Contest3 contest = new Contest3();
        {

        }
    }
}
