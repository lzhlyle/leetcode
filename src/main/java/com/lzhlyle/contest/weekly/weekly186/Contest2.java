package com.lzhlyle.contest.weekly.weekly186;

import java.util.Arrays;

public class Contest2 {
    // dp: O(n)
    // 环形滑动窗口
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int[] arr = new int[2 * k];
        System.arraycopy(cardPoints, 0, arr, k, k);
        System.arraycopy(cardPoints, n - k, arr, 0, k);
        System.out.println(Arrays.toString(arr));

        int max = 0;
        for (int i = 0; i < k; i++) {
            max += arr[i];
        }

        int sum = max;
        for (int i = k; i < arr.length; i++) {
            sum = sum - arr[i - k] + arr[i];
            max = Math.max(max, sum);
        }

        return max;
    }

    public static void main(String[] args) {
        Contest2 contest = new Contest2();
        {
            int[] arr = new int[]{1, 2, 3, 4, 5, 6, 1};
            int k = 3;
            int res = contest.maxScore(arr, k);
            System.out.println(res);
        }
    }
}
