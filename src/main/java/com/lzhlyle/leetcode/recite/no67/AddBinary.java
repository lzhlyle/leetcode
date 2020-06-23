package com.lzhlyle.leetcode.recite.no67;

import java.util.Arrays;

public class AddBinary {
    public String addBinary(String a, String b) {
        int alen = a.length(), blen = b.length();
        if (alen > blen) return addBinary(b, a);
        // make sure: alen <= blen
        char[] res = new char[blen + 1];
        char[] aarr = a.toCharArray(), barr = b.toCharArray();
        int carry = 0;
        for (int ri = blen, ai = alen - 1, bi = blen - 1; bi >= 0; ai--, bi--, ri--) {
            int abit = (ai >= 0 ? aarr[ai] : '0') - '0';
            int bbit = barr[bi] - '0';
            int oneCnt = abit + bbit + carry;
            res[ri] = (char) ((oneCnt & 1) + '0');
            carry = oneCnt >> 1;
        }
        if (carry == 0) return new String(res, 1, blen);
        res[0] = '1';
        return new String(res);
    }
}
