package com.lzhlyle.leetcode.self.no525;

import java.util.HashMap;
import java.util.Map;

public class ContiguousArray_LC_Map {
    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int cnt = 0, max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) cnt++;
            else cnt--;

            if (!map.containsKey(cnt)) map.put(cnt, i);
            else max = Math.max(max, i - map.get(cnt));
        }
        return max;
    }
}
