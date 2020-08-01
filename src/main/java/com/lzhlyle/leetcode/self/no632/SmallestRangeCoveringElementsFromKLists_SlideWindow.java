package com.lzhlyle.leetcode.self.no632;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SmallestRangeCoveringElementsFromKLists_SlideWindow {
    public int[] smallestRange(List<List<Integer>> nums) {
        int n = nums.size();
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < n; i++)
            for (int val : nums.get(i))
                list.add(new int[]{val, i}); // {val, group}
        int[][] arr = list.toArray(new int[list.size()][2]);
        Arrays.sort(arr, Comparator.comparingInt(a -> a[0]));

        int[] freq = new int[n], res = new int[2];
        int cnt = 0, min = Integer.MAX_VALUE;
        for (int r = 0, l = 0; r < arr.length; r++) {
            if (++freq[arr[r][1]] == 1) cnt++;
            while (cnt == n) {
                int ll = arr[l][0], rr = arr[r][0];
                if (rr - ll < min) {
                    min = rr - ll;
                    res[0] = ll;
                    res[1] = rr;
                }
                if (--freq[arr[l++][1]] == 0) cnt--;
            }
        }
        return res;
    }
}
