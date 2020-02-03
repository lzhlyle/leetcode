package com.lzhlyle.leetcode.week.no127;

import java.util.*;

public class WordLadder_TEBFS_Loop {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (beginWord == null || endWord == null || wordList == null || wordList.isEmpty()) return 0;
        if (beginWord.equals(endWord)) return 2;

        Set<String> meets = new HashSet<>(wordList);
        if (!meets.contains(endWord)) return 0;

        Set<String> beginSet = new HashSet<>(Collections.singleton(beginWord));
        Set<String> endSet = new HashSet<>(Collections.singleton(endWord));

        int level = 1;
        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            level++;
            if (beginSet.size() > endSet.size()) {
                Set swap = beginSet;
                beginSet = endSet;
                endSet = swap;
            }

            meets.removeAll(beginSet);
            Set<String> nextBeginSet = new HashSet<>();
            for (String begin : beginSet) {
                List<String> neighbors = _getNeighbors(begin);
                for (String neighbor : neighbors) {
                    if (endSet.contains(neighbor)) return level;
                    if (!meets.contains(neighbor)) continue;
                    nextBeginSet.add(neighbor);
                }
            }

            beginSet = nextBeginSet;
        }

        return 0;
    }

    private List<String> _getNeighbors(String begin) {
        List<String> res = new LinkedList<>();
        char[] arr = begin.toCharArray();
        for (int i = 0, len = arr.length; i < len; i++) {
            char ori = arr[i];
            for (char c = 'a'; c <= 'z'; c++) {
                if (c == ori) continue;
                arr[i] = c;
                res.add(String.valueOf(arr));
            }
            arr[i] = ori; // reverse
        }
        return res;
    }
}
