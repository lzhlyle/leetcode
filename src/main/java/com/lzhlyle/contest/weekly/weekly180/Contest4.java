package com.lzhlyle.contest.weekly.weekly180;

public class Contest4 {
    private long max = 0;

    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        int MOD = 1000000007;
        find(0, 0, n, speed, efficiency, k, 0, Integer.MAX_VALUE);
        return (int) (max % MOD);
    }

    private void find(int cnt, int i, int n, int[] speed, int[] efficiency, int k, long curr, int currE) {
        if (cnt <= k && curr > max) max = curr;
        if (i == n) return;

        // used
        int lvlE = Math.min(efficiency[i], currE);
        long lvl = (curr / currE + speed[i]) * lvlE;
        find(cnt + 1, i + 1, n, speed, efficiency, k, lvl, lvlE);

        // unused
        find(cnt, i + 1, n, speed, efficiency, k, curr, currE);
    }

    public static void main(String[] args) {
        Contest4 contest = new Contest4();
        {
            int n = 7, k = 6;
            int[] speed = {1, 4, 1, 9, 4, 4, 4}, efficiency = {8, 2, 1, 7, 1, 8, 4};
            int res = contest.maxPerformance(n, speed, efficiency, k);
            System.out.println(res);
            System.out.println(res == 98);
        }
    }
}
