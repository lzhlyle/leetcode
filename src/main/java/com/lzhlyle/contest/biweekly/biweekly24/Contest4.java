package com.lzhlyle.contest.biweekly.biweekly24;

import java.util.Arrays;

public class Contest4 {
    private int MOD = 1000000007;

    // wrong
    // dp
    public int numberOfArrays(String s, int k) {
        if (s.charAt(0) == '0') return 0;
        char[] arr = s.toCharArray();
        int n = arr.length;
        if (arr[n - 1] - '0' > k) return 0;

        int[] dp = new int[n]; // dp[i] 表示从 arr[i] 到结尾的所有情况
        int start = n - 1;
        while (arr[start] == '0') start--;
        dp[start] = Integer.valueOf(new String(Arrays.copyOfRange(arr, start, n))) <= k ? 1 : 0;
        for (int i = start - 1; i >= 0; i--) {
            int num = arr[i] - '0';
            if (num > k) return 0; // 单独数字都不行
            if (num == 0) dp[i] = dp[i + 1];
            else { // 非0
                int sum = 0;
                for (int j = i + 1; j < n; j++) {
                    int digit = arr[j] - '0';
                    num = num * 10 + digit;
                    if (1 <= num && num <= k) sum += dp[j];
                    else break;
                }
                dp[i] = sum;
            }
        }
        return dp[0];
    }

    public static void main(String[] args) {
        Contest4 contest = new Contest4();
        {
            String s = "2020";
            int k = 30;
            int res = contest.numberOfArrays(s, k);
            System.out.println(res);
        }
    }
}
