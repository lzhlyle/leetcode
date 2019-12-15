package com.lzhlyle.contest.date20191215;

import java.util.*;

public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> meets = new HashSet<>(wordList);

        // base condition
        if (!meets.contains(endWord)) return 0; // O(1)
        if (Objects.equals(beginWord, endWord)) return 2;

        // two-ended bfs with recursion
        Set<String> beginSet = new HashSet<>(Collections.singleton(beginWord));
        Set<String> endSet = new HashSet<>(Collections.singleton(endWord));

        return bfs(1, beginSet, endSet, meets);
    }

    private int bfs(int level, Set<String> beginSet, Set<String> endSet, Set<String> meets) {
        // terminator
        if (beginSet.isEmpty() || endSet.isEmpty()) return 0;

        // process
        level++;
        // always from less to more
        if (beginSet.size() > endSet.size()) {
            Set swap = beginSet;
            beginSet = endSet;
            endSet = swap;
        }

        meets.removeAll(beginSet);
        Set<String> nextBegin = new HashSet<>();
        for (String begin : beginSet) {
            for (String neighbor : getNeighbors(begin)) {
                if (!meets.contains(neighbor)) continue;
                if (endSet.contains(neighbor)) return level;

                nextBegin.add(neighbor);
            }
        }

        // drill down
        return bfs(level, nextBegin, endSet, meets);

        // reverse state
    }

    private List<String> getNeighbors(String word) {
        List<String> res = new ArrayList<>();
        char[] chars = word.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            // replace
            for (char j = 'a'; j < 'z'; j++) {
                if (j != c) {
                    chars[i] = j;
                    res.add(String.valueOf(chars));
                }
            }
            // reverse
            chars[i] = c;
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
