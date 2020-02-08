package com.lzhlyle.contest.biweekly19;

/**
 * https://leetcode-cn.com/contest/biweekly-contest-19/problems/number-of-sub-arrays-of-size-k-and-average-greater-than-or-equal-to-threshold/
 * <p>
 * 5312. 大小为 K 且平均值大于等于阈值的子数组数目
 * <p>
 * 给你一个整数数组 arr 和两个整数 k 和 threshold 。
 * <p>
 * 请你返回长度为 k 且平均值大于等于 threshold 的子数组数目。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [2,2,2,2,5,5,5,8], k = 3, threshold = 4
 * 输出：3
 * 解释：子数组 [2,5,5],[5,5,5] 和 [5,5,8] 的平均值分别为 4，5 和 6 。其他长度为 3 的子数组的平均值都小于 4 （threshold 的值)。
 * 示例 2：
 * <p>
 * 输入：arr = [1,1,1,1,1], k = 1, threshold = 0
 * 输出：5
 * 示例 3：
 * <p>
 * 输入：arr = [11,13,17,23,29,31,7,5,2,3], k = 3, threshold = 5
 * 输出：6
 * 解释：前 6 个长度为 3 的子数组平均值都大于 5 。注意平均值不是整数。
 * 示例 4：
 * <p>
 * 输入：arr = [7,7,7,7,7,7,7], k = 7, threshold = 7
 * 输出：1
 * 示例 5：
 * <p>
 * 输入：arr = [4,4,4,4], k = 4, threshold = 1
 * 输出：1
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= arr.length <= 10^5
 * 1 <= arr[i] <= 10^4
 * 1 <= k <= arr.length
 * 0 <= threshold <= 10^4
 *
 */

public class Contest2 {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int count = 0;
        for (int i = 0; i < arr.length - k + 1; i++) {
            int sum = arr[i];
            for (int j = i + 1; j < i + k; j++) sum += arr[j];
            if ((sum / k) >= threshold) count++;
        }
        return count;
    }

    public static void main(String[] args) {
        Contest2 contest2 = new Contest2();
        {
            int res = contest2.numOfSubarrays(new int[]{2, 2, 2, 2, 5, 5, 5, 8}, 3, 4);
            System.out.println(res);
        }
        {
            int res = contest2.numOfSubarrays(new int[]{1, 1, 1, 1, 1}, 1, 0);
            System.out.println(res);
        }
        {
            int res = contest2.numOfSubarrays(new int[]{11, 13, 17, 23, 29, 31, 7, 5, 2, 3}, 3, 5);
            System.out.println(res);
        }
        {
            int res = contest2.numOfSubarrays(new int[]{7, 7, 7, 7, 7, 7, 7}, 7, 7);
            System.out.println(res);
        }
        {
            int res = contest2.numOfSubarrays(new int[]{4, 4, 4, 4}, 4, 1);
            System.out.println(res);
        }
    }
}
