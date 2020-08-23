package com.lzhlyle.contest.weekly.weekly203;

public class Contest4 {
    // dfs + memo
    public int stoneGameV(int[] arr) {
        int n = arr.length;
        if (n == 1) return 0;
        if (n == 2) return Math.min(arr[0], arr[1]);

        int[] pre = new int[n + 1];
        for (int i = 0; i < n; i++)
            pre[i + 1] = pre[i] + arr[i];
        return dfs(pre, 0, n - 1, new int[n][n]);
    }

    private int dfs(int[] pre, int l, int r, int[][] memo) {
        if (l >= r) return 0;
        if (memo[l][r] > 0) return memo[l][r];
        int max = 0;
        for (int p = l; p < r; p++) {
            int lp = pre[p + 1] - pre[l];
            int pr = pre[r + 1] - pre[p + 1];
            if (lp > pr) {
                max = Math.max(max, pr + dfs(pre, p + 1, r, memo));
            } else if (lp < pr) {
                max = Math.max(max, lp + dfs(pre, l, p, memo));
            } else {
                int dfs1 = dfs(pre, l, p, memo);
                int dfs2 = dfs(pre, p + 1, r, memo);
                max = Math.max(max, lp + Math.max(dfs1, dfs2));
            }
        }
        return memo[l][r] = max;
    }

    public static void main(String[] args) {
        Contest4 contest = new Contest4();
        {

        }
    }
}
