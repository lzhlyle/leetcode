package com.lzhlyle.leetcode.tomorrow.lcci1611;

public class DivingBoardLcci {
    public int[] divingBoard(int s, int l, int k) {
        if (k == 0) return new int[0];
        if (s == l) return new int[]{s * k};

        int[] res = new int[k + 1];
        int i = 0, mul = s * k;
        while (k-- >= 0) {
            res[i++] = mul;
            mul += l - s;
        }
        return res;
    }
}
