package com.lzhlyle.contest.weekly.weekly193;

import java.util.*;

public class Contest2 {

    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int v : arr) {
            if (!map.containsKey(v)) map.put(v, 0);
            map.put(v, map.get(v) + 1);
        }

        Queue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a.freq));
        for (Integer key : map.keySet()) {
            queue.add(new Node(key, map.get(key)));
        }

        while (!queue.isEmpty() && k >= queue.peek().freq) {
            k -= queue.remove().freq;
        }

        return queue.size();
    }

    class Node {
        int val, freq;

        Node(int v, int f) {
            this.val = v;
            this.freq = f;
        }
    }

    public static void main(String[] args) {
        Contest2 contest = new Contest2();
        {

        }
    }
}
