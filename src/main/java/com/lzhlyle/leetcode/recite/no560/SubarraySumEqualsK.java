package com.lzhlyle.leetcode.recite.no560;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {
    // prefix sum
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int cnt = 0, sum = 0;
        for (int num : nums) {
            sum += num;
            if (map.containsKey(sum - k)) cnt += map.get(sum - k);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return cnt;
    }
}
