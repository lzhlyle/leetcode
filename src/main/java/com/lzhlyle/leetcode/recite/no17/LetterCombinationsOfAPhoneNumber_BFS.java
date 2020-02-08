package com.lzhlyle.leetcode.recite.no17;

import java.util.*;

public class LetterCombinationsOfAPhoneNumber_BFS {
    private String[] map = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() < 1) return Collections.emptyList();
        Queue<String> queue = new LinkedList<>(Collections.singleton(""));
        for (int i = 0; i < digits.length(); i++) {
            while (queue.peek().length() == i) {
                String prefix = queue.remove();
                for (char c : map[digits.charAt(i) - '0'].toCharArray()) queue.add(prefix + c);
            }
        }
        return new ArrayList<>(queue);
    }
}
