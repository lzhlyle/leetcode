package com.lzhlyle.leetcode.self.no3;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters_Deque {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        Set<Character> set = new HashSet<>();
        Deque<Character> deque = new LinkedList<>();
        for (char c : s.toCharArray()) {
            while (set.contains(c)) {
                set.remove(deque.removeFirst());
            }
            set.add(c);
            deque.addLast(c);
            max = Math.max(max, deque.size());
        }
        return max;
    }
}
