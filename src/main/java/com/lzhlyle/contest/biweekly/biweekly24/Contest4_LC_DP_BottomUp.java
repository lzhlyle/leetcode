package com.lzhlyle.contest.biweekly.biweekly24;

public class Contest4_LC_DP_BottomUp {
    // dp bottom-up
    private int MOD = 1000000007;

    public int numberOfArrays(String s, int k) {
        if (s.charAt(0) == '0') return 0;
        char[] arr = s.toCharArray();
        int n = arr.length;
        if (arr[n - 1] - '0' > k) return 0;

        int[] dp = new int[n + 1]; // dp[i]: f(sub(i, n), cnt)
        dp[n] = 1; // ""
        for (int i = n - 1; i >= 0; i--) {
            if (arr[i] == '0') continue;
            long last = 0;
            for (int j = i + 1; j <= n; j++) {
                last = last * 10 + (arr[j - 1] - '0');
                if (last > k) break;
                dp[i] = (dp[i] + dp[j]) % MOD;
            }
        }
        return dp[0];
    }

    public static void main(String[] args) {
        Contest4_LC_DP_BottomUp contest = new Contest4_LC_DP_BottomUp();
        {
            String s = "1317";
            int k = 15;
            int res = contest.numberOfArrays(s, k);
            System.out.println(res);
        }
    }
}
