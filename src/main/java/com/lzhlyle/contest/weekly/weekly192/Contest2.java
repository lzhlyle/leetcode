package com.lzhlyle.contest.weekly.weekly192;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class Contest2 {

    public int[] getStrongest(int[] arr, int k) {
        int n = arr.length;
        Arrays.sort(arr);
        int m = arr[(n - 1) / 2];

        Queue<Node> queue = new PriorityQueue<>((a, b) -> a.calc == b.calc ? b.val - a.val : b.calc - a.calc);
        for (int v : arr) {
            queue.add(new Node(v, Math.abs(v - m)));
        }

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = queue.remove().val;
        }
        return res;
    }

    class Node {
        int val, calc;

        Node(int v, int c) {
            val = v;
            calc = c;
        }
    }

    public static void main(String[] args) {
        Contest2 contest = new Contest2();
        {

        }
    }
}
