package com.lzhlyle.leetcode.recite.no974;

public class SubarraySumsDivisibleByK {
    public int subarraysDivByK(int[] A, int K) {
        int[] freq = new int[K]; // freq[i]: count of mod i = (sum / K)
        freq[0] = 1;
        int cnt = 0, mod = 0;
        for (int a : A) {
            mod = (mod + a) % K;
            if (mod < 0) mod += K;
            cnt += freq[mod]++;
        }
        return cnt;
    }
}
