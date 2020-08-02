package com.lzhlyle.contest.weekly.weekly200;

import java.util.Deque;
import java.util.LinkedList;

public class Contest2 {
    public int getWinner(int[] arr, int k) {
        Deque<Integer> deque = new LinkedList<>();
        int max = 0;
        for (int v : arr) {
            deque.add(v);
            max = Math.max(max, v);
        }

        int curr = 0, last = 0;
        while (curr < k) {
            int a = deque.remove(), b = deque.remove();
            if (a > b) {
                if (a == last) curr++;
                else curr = 1;
                deque.addFirst(a);
                deque.add(b);
                last = a;
            } else {
                if (b == last) curr++;
                else curr = 1;
                deque.addFirst(b);
                deque.add(a);
                last = b;
            }
            if (last == max) return max;
        }
        return last;
    }

    public static void main(String[] args) {
        Contest2 contest = new Contest2();
        {

        }
    }
}
