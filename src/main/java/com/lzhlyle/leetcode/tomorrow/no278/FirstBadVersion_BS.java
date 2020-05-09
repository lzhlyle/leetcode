package com.lzhlyle.leetcode.tomorrow.no278;

public class FirstBadVersion_BS {
    public int firstBadVersion(int n) {
        int l = 1, r = n;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (!isBadVersion(mid)) l = mid + 1;
            else r = mid;
        }
        return l;
    }

    static boolean isBadVersion(int version) {
        return false;
    }
}
