package com.lzhlyle.leetcode.tomorrow.no914;

public class XOfAKindInADeckOfCards {
    public boolean hasGroupsSizeX(int[] deck) {
        if (deck.length < 2) return false;
        int[] freq = new int[10000];
        for (int num : deck) freq[num]++;

        int gcd = freq[0];
        for (int f : freq) {
            if (f == 0) continue;
            gcd = gcd(gcd, f);
            if (gcd == 1) return false;
        }
        return true;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
