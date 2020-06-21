package com.lzhlyle.contest.weekly.weekly194;

public class Contest1 {
    public int xorOperation(int n, int start) {
        int xor = 0b0;
        for (int i = 0; i < n; i++)
            xor ^= start + 2 * i;
        return xor;
    }

    public static void main(String[] args) {
        Contest1 contest = new Contest1();
        {

        }
    }
}
