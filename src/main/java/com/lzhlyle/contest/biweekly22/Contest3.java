package com.lzhlyle.contest.biweekly22;

import java.util.*;

public class Contest3 {
    public int getKth(int lo, int hi, int k) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int num = lo; num <= hi; num++) {
            int w = _calc(num, 0);
            if (!map.containsKey(w)) map.put(w, new HashSet<>());
            map.get(w).add(num);
        }
        int[] arr = new int[map.size()];
        int i = 0;
        for (Integer w : map.keySet()) arr[i++] = w;
        Arrays.sort(arr);
        for (int w : arr) {
            Set<Integer> set = map.get(w);
            int[] nums = new int[set.size()];
            int j = 0;
            for (Integer num : set) nums[j++] = num;
            Arrays.sort(nums);
            if (nums.length >= k) return nums[k - 1];
            else k -= nums.length;
        }
        return -1;
    }
    private int _calc(int num, int step) {
        if (num == 1) return step;
        if ((num & 1) == 0) return _calc(num >> 1, step + 1);
        return _calc(3 * num + 1, step + 1);
    }

    public static void main(String[] args) {
        Contest3 contest = new Contest3();
        {
            int res = contest.getKth(12, 15, 2);
            System.out.println(res);
            System.out.println(res == 13);
        }
    }
}
