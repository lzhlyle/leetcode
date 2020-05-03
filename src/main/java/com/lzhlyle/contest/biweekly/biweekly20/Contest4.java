package com.lzhlyle.contest.biweekly.biweekly20;

public class Contest4 {
    public int countOrders(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        if (n == 3) return 90;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 6;
        dp[3] = 90;
        for (int i = 4; i <= n; i++) {
            dp[n] = factorial(n) * sum(dp[n - 1]);
        }
        return dp[n];
    }

    private int sum(int num) {
        int sum = 0;
        for (int i = 1; i < num; i++) {
            sum += i;
        }
        return sum;
    }

    private int factorial(int num) {
        if (num == 1) return 1;
        int fa = 1;
        for (int i = 2; i <= num; i++) fa *= i;
        return fa;
    }

    public static void main(String[] args) {
        Contest4 contest = new Contest4();
        {
            int res = contest.countOrders(3);
            System.out.println(res);
        }
    }
}
