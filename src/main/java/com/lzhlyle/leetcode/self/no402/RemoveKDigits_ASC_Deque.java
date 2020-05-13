package com.lzhlyle.leetcode.self.no402;

import java.util.Deque;
import java.util.LinkedList;

public class RemoveKDigits_ASC_Deque {
    public String removeKdigits(String num, int k) {
        Deque<Character> deque = new LinkedList<>(); // asc
        char[] arr = num.toCharArray();
        for (char c : arr) {
            while (!deque.isEmpty() && k > 0 && deque.getLast() > c) {
                k--;
                deque.removeLast();
            }
            deque.addLast(c);
        }
        while (k-- > 0 && !deque.isEmpty()) deque.removeLast();

        while (!deque.isEmpty() && deque.getFirst() == '0')
            deque.removeFirst();
        if (deque.isEmpty()) return "0";

        char[] res = new char[deque.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = deque.removeFirst();
        }
        return new String(res);
    }
}
