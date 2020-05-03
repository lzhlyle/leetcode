package com.lzhlyle.contest.weekly.weekly178;

import java.util.*;

public class Contest1_LC {
    public int[] smallerNumbersThanCurrent(int[] nums) { // 8, 1, 2, 2, 3
        int len = nums.length;
        Map<Integer, Set<Integer>> valueIndex = new HashMap<>(len);
        for (int i = 0; i < len; i++) {
            if (!valueIndex.containsKey(nums[i])) valueIndex.put(nums[i], new HashSet<>());
            valueIndex.get(nums[i]).add(i);
        }

        int[] sortedArr = Arrays.copyOf(nums, len), res = new int[len];
        Arrays.sort(sortedArr); // 1, 2, 2, 3, 8

        for (int si = len - 1; si >= 0; si--) {
            for (int i : valueIndex.get(sortedArr[si])) res[i] = si;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {8, 1, 2, 2, 3};
        int[] res = new Contest1_LC().smallerNumbersThanCurrent(nums);
        System.out.println(Arrays.toString(res));
    }
}
