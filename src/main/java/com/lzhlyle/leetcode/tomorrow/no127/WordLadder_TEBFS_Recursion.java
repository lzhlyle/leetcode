package com.lzhlyle.leetcode.tomorrow.no127;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class WordLadder_TEBFS_Recursion {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (beginWord == null || endWord == null || wordList == null) return 0;
        if (beginWord.equals(endWord)) return 2;

        Set<String> meets = new HashSet<>(wordList);
        if (!meets.contains(endWord)) return 0;

        Set<String> beginSet = new HashSet<>();
        beginSet.add(beginWord);

        Set<String> endSet = new HashSet<>();
        endSet.add(endWord);

        return _twoEndedBfs(1, beginSet, endSet, meets);
    }

    private int _twoEndedBfs(int level, Set<String> beginSet, Set<String> endSet, Set<String> meets) {
        if (beginSet.isEmpty() || endSet.isEmpty()) return 0;

        if (beginSet.size() > endSet.size()) {
            Set<String> swap = beginSet;
            beginSet = endSet;
            endSet = swap;
        }

        level++;
        meets.removeAll(beginSet);
        Set<String> nextBeginSet = new HashSet<>();
        for (String begin : beginSet) {
            for (String neighbor : _getNeighbors(begin)) {
                if (endSet.contains(neighbor)) return level;
                if (!meets.contains(neighbor)) continue;
                nextBeginSet.add(neighbor);
            }
        }

        return _twoEndedBfs(level, nextBeginSet, endSet, meets);
    }

    private List<String> _getNeighbors(String word) {
        List<String> res = new LinkedList<>();
        char[] chars = word.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char temp = chars[i];
            for (char c = 'a'; c < 'z'; c++) {
                if (temp == c) continue;
                chars[i] = c;
                res.add(String.valueOf(chars));
            }
            chars[i] = temp;
        }
        return res;
    }
}
