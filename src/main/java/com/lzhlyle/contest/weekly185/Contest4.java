package com.lzhlyle.contest.weekly185;

public class Contest4 {
    private int MOD = 1000000007;

    // wrong
    // 前面有k个有序严格递增
    public int numOfArrays(int n, int m, int k) {
        if (m < k) return 0;
        int kjie = jie(k);
        int mjie = jie(m);
        int njie = jie(n);
        int chengji = (k + n) * (n - k + 1);
        return ((njie * mjie) / (chengji * kjie)) % MOD;
    }

    private int jie(int x) {
        long res = 1;
        while (x > 1) {
            res *= x;
            x = x - 1;
        }
        return (int) (res % MOD);
    }

    public static void main(String[] args) {
        Contest4 contest = new Contest4();
        {

        }
    }
}
