package com.lzhlyle.leetcode.self.no476;

public class NumberComplement_BS {
    public int findComplement(int num) {
        int l = 0, r = 31;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if ((1 << mid) < num) l = mid + 1;
            else r = mid;
        }
        if ((1 << l) == num) return num - 1;
        return ((1 << l) - 1) ^ num;
    }
}
