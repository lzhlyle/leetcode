package com.lzhlyle.contest.biweekly.biweekly30;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class Contest3 {
    public int minDifference(int[] nums) {
        if (nums.length <= 4) return 0;

        Queue<Integer> maxs = new PriorityQueue<>(), // 小顶堆，放最大的4个
                mins = new PriorityQueue<>((a, b) -> b - a); // 大顶堆，最小的4个
        for (int v : nums) {
            maxs.add(v);
            mins.add(v);
            if (maxs.size() > 4) maxs.remove();
            if (mins.size() > 4) mins.remove();
        }

        int[] maxarr = new int[4], minarr = new int[4];
        for (int i = 0; i < 4; i++) {
            maxarr[i] = maxs.remove();
            minarr[i] = mins.remove();
        }
        Arrays.sort(minarr);

        int res = Integer.MAX_VALUE;
        for (int i = 0; i < 4; i++) {
            res = Math.min(res, maxarr[i] - minarr[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        Contest3 contest = new Contest3();
        {

        }
    }
}
