package com.lzhlyle.contest.weekly.weekly187;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Contest3 {
    public int longestSubarray(int[] nums, int limit) {
        int len = 0;
        Queue<Integer> queue = new LinkedList<>();
        Queue<Integer> min = new PriorityQueue<>();
        Queue<Integer> max = new PriorityQueue<>((a, b) -> b - a);
        for (int num : nums) {
            queue.add(num);
            min.add(num);
            max.add(num);
            while (max.element() - min.element() > limit) {
                int removed = queue.remove();
                min.remove(removed);
                max.remove(removed);
            }
            len = Math.max(len, queue.size());
        }
        return len;
    }

    public static void main(String[] args) {
        Contest3 contest = new Contest3();
        {

        }
    }
}
