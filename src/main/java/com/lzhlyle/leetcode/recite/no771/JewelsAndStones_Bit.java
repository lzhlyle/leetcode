package com.lzhlyle.leetcode.recite.no771;

public class JewelsAndStones_Bit {
    public int numJewelsInStones(String J, String S) {
        long jewels = 0b0;
        for (char c : J.toCharArray()) jewels |= 1L << (c - 'A');
        int count = 0;
        for (char c : S.toCharArray()) {
            if (((jewels >> (c - 'A')) & 1) == 1) count++;
        }
        return count;
    }

    public static void main(String[] args) {
        String J = "aA", S = "aAAbbbb";
        int res = new JewelsAndStones_Bit().numJewelsInStones(J, S);
        System.out.println(res);
    }
}
