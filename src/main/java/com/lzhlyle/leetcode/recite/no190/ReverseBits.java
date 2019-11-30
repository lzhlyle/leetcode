package com.lzhlyle.leetcode.recite.no190;

public class ReverseBits {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int res = 0b0;
        for (int i = 0; i < 32; i++) {
            res = res << 1;
            res += n & 1;
            n >>>= 1;
        }
        return res;
    }

    public static void main(String[] args) {
        int n = 0b00000010100101000001111010011100;
        int res = new ReverseBits().reverseBits(n);
        System.out.println(Integer.toBinaryString(res));
    }
}
