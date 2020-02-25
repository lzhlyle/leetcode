package com.lzhlyle.leetcode.recite.no66;

import java.util.Arrays;

public class PlusOne {
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        int[] res = Arrays.copyOf(digits, len);
        for (int i = len - 1; i >= 0; i--) {
            if (res[i] < 9) {
                res[i] += 1;
                return res;
            }
            res[i] = 0;
        }
        int[] adv = new int[len + 1];
        System.arraycopy(res, 0, adv, 1, len);
        adv[0] = 1;
        return adv;
    }
}
