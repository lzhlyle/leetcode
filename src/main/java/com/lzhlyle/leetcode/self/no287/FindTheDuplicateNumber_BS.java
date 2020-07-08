package com.lzhlyle.leetcode.self.no287;

public class FindTheDuplicateNumber_BS {
    public int findDuplicate(int[] nums) {
        int l = 1, r = nums.length;
        while (l < r) {
            int mid = l + (r - l + 1) / 2;
            int cnt = 0;
            for (int v : nums)
                if (v < mid) cnt++;
            if (cnt < mid) l = mid;
            else r = mid - 1;
        }
        return l;
    }
}
