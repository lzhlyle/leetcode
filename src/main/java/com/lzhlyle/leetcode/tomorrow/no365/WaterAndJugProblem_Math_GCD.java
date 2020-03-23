package com.lzhlyle.leetcode.tomorrow.no365;

public class WaterAndJugProblem_Math_GCD {
    public boolean canMeasureWater(int x, int y, int z) {
        if (x + y < z) return false;
        int gcd = gcd(x, y);
        return gcd == 0 || z % gcd == 0;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
