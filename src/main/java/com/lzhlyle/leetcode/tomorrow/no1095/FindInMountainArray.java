package com.lzhlyle.leetcode.tomorrow.no1095;

public class FindInMountainArray {
    // bs O(log(n))
    public int findInMountainArray(int target, MountainArray ma) {
        int len = ma.length(), l = 0, r = len - 1;
        // looking for the INDEX of the peek
        while (l < r) {
            int mid = l + ((r - l + 1) >> 1);
            if (ma.get(mid - 1) < ma.get(mid)) l = mid;
            else r = mid - 1;
        }
        int top = l;
        if (ma.get(top) == target) return top;

        l = 0;
        r = top;
        while (l < r) {
            int mid = l + ((r - l) >> 1);
            if (ma.get(mid) < target) l = mid + 1;
            else r = mid;
        }
        if (ma.get(l) == target) return l;

        l = top;
        r = len - 1;
        while (l < r) {
            int mid = l + ((r - l) >> 1);
            if (ma.get(mid) > target) l = mid + 1;
            else r = mid;
        }
        return ma.get(l) == target ? l : -1;
    }
}
