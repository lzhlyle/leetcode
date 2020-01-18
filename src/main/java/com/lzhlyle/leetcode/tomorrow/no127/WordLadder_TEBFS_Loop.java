package com.lzhlyle.leetcode.tomorrow.no127;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class WordLadder_TEBFS_Loop {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (beginWord == null || endWord == null || wordList == null || wordList.size() < 1) return 0;
        if (beginWord.equals(endWord)) return 2;

        Set<String> meets = new HashSet<>(wordList);
        if (!meets.contains(endWord)) return 0;

        Set<String> beginSet = new HashSet<>();
        beginSet.add(beginWord);

        Set<String> endSet = new HashSet<>();
        endSet.add(endWord);

        int level = 1;
        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            level++;

            if (beginSet.size() > endSet.size()) {
                Set<String> swap = beginSet;
                beginSet = endSet;
                endSet = swap;
            }

            meets.removeAll(beginSet);
            Set<String> nextBeginSet = new HashSet<>();
            for (String begin : beginSet) {
                for (String neighbor : _getNeighbors(begin)) {
                    if (endSet.contains(neighbor)) return level;
                    if (!meets.contains(neighbor)) continue;
                    nextBeginSet.add(neighbor);
                }
            }

            beginSet = nextBeginSet;
        }

        return 0;
    }

    private List<String> _getNeighbors(String word) {
        List<String> res = new LinkedList<>();
        char[] arr = word.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            char ori = arr[i];
            for (char j = 'a'; j < 'z'; j++) {
                if (ori == j) continue;
                arr[i] = j;
                res.add(String.valueOf(arr));
            }
            arr[i] = ori;
        }
        return res;
    }
}
