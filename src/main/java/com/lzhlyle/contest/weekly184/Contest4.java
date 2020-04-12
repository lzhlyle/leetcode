package com.lzhlyle.contest.weekly184;

public class Contest4 {
    /**
     * 分为双色和三色两种
     * 其中双色下一行里面5种可能中3种是三色、2种是三色
     * 三色下一行里面2种三色、2种双色
     *
     * @param n
     * @return
     */
    public int numOfWays(int n) {
        int MOD = 1000000007;
        long[][] dp = new long[n][2]; // 0->2   1->3 ;
        dp[0][0] = dp[0][1] = 6;
        for (int i = 1; i < n; i++) {
            dp[i][0] = (dp[i - 1][0] * 3 + dp[i - 1][1] * 2) % MOD;
            dp[i][1] = (dp[i - 1][0] * 2 + dp[i - 1][1] * 2) % MOD;
        }
        return (int) ((dp[n - 1][0] + dp[n - 1][1]) % MOD);
    }

    public static void main(String[] args) {
        Contest4 contest = new Contest4();
        {

        }
    }
}
