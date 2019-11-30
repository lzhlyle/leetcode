package com.lzhlyle.leetcode.recite.no190;

public class ReverseBits_2 {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int res = 0b0;
        for (int i = 0; i < 32; i++) {
            // 1. 将给定的二进制数,由低到高位逐个取出
            // 1.1 右移 i 位,
            int tmp = n >> i;
            // 1.2  取有效位
            tmp = tmp & 1;
            // 2. 然后通过位运算将其放置到反转后的位置.
            tmp = tmp << (31 - i);
            // 3. 将上述结果再次通过运算结合到一起
            res |= tmp;
        }
        return res;
    }

    public static void main(String[] args) {
        int n = 0b00000010100101000001111010011100;
        int res = new ReverseBits_2().reverseBits(n);
        System.out.println(Integer.toBinaryString(res));
    }
}
