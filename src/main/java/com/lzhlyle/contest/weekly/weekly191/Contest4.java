package com.lzhlyle.contest.weekly.weekly191;

public class Contest4 {
    // wa
    public double getProbability(int[] balls) {
        int sum = 0;
        for (int b : balls) sum += b;
        int n = sum / 2;
        double sub = 2 * jie(sum) / (2 * jie(n));
        // wrong sub
        return sub;
    }

    private double jie(int n) {
        double res = 1;
        while (n > 1) {
            res *= n;
            n = n - 1;
        }
        return res;
    }

    public static void main(String[] args) {
        Contest4 contest = new Contest4();
        {

        }
    }
}
