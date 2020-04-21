package com.lzhlyle.leetcode.recite.no1248;

import java.util.ArrayList;
import java.util.List;

public class CountNumberOfNiceSubarrays_Deque {
    public int numberOfSubarrays(int[] nums, int k) {
        List<Integer> list = new ArrayList<>(nums.length + 1);
        list.add(-1); // sentinel
        int cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] & 1) == 1) list.add(i);
            if (list.size() + 1 > k) list.remove(0);
            if (list.size() + 1 == k) cnt += list.get(1) - list.get(0);
        }
        return cnt;
    }
}
