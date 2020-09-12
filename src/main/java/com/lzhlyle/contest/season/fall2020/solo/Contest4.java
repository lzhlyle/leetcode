package com.lzhlyle.contest.season.fall2020.solo;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class Contest4 {
    // tle
    public int busRapidTransit(int target, int inc, int dec, int[] jump, int[] cost) {
        Queue<int[]> queue = new PriorityQueue<>((a, b) -> a[1] == b[1] ? Math.abs(target - a[0]) - Math.abs(target - b[0]) : a[1] - b[1]);
        queue.add(new int[]{0, 0});
        Set<Integer> set = new HashSet<>();
        while (!queue.isEmpty()) {
            int[] node = queue.remove();
            int curr = node[0], cc = node[1];
            if (curr == target) return cc;
            if (set.add(curr + 1)) queue.add(new int[]{curr + 1, cc + inc});
            if (curr - 1 > 0 && set.add(curr - 1)) queue.add(new int[]{curr - 1, cc + dec});
            for (int i = 0; i < jump.length; i++) {
                if (set.add(curr * jump[i])) queue.add(new int[]{curr * jump[i], cc + cost[i]});
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Contest4 contest = new Contest4();
        {

        }
    }
}
