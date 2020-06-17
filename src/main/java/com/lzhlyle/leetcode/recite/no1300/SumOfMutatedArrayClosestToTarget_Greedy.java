package com.lzhlyle.leetcode.recite.no1300;

import java.util.Arrays;

public class SumOfMutatedArrayClosestToTarget_Greedy {
    public int findBestValue(int[] arr, int target) {
        Arrays.sort(arr);

        int n = arr.length, sum = 0, res = -1, rest = n; // rest: 还有几个元素可变
        int last = arr[0]; // 记录最后离开时本应计入 sum 的数
        for (int i = 0; i < n; i++, rest--) {
            int r = (target - sum) / rest; // 剩余后面的都变成多少比较接近
            if (r <= arr[i]) { // 比当前元素小（保证 r > arr[i - 1]，否则上一轮已 break）
                res = r; // 当前及以后都改为 r
                last = arr[i];
                break; // 找到就跳出
            }
            sum += arr[i];
        }

        // 都找不到，说明希望 value 比 arr[n - 1] 还要大，则返回最大即可
        if (res == -1) return arr[n - 1];

        // 当前得出的 res 只保证了总和小于 target 的较近
        // 试一试 res + 1 会不会更近
        int dis = Math.abs(target - (sum + res * rest)); // dis: distance
        int dis1 = Math.abs(target - (sum + (res + 1) * rest)); // 试试 res + 1 的情况，且后面剩余可变个数仍为 rest 时
        int dis2 = Math.abs(target - ((sum + last) + (res + 1) * (rest - 1))); // 试试 res + 1 的情况，且后面剩余可变个数少了一个时，sum 应计入 break 时的最后一个元素 last
        if (dis1 < dis || dis2 < dis) return res + 1;
        return res;
    }
}
