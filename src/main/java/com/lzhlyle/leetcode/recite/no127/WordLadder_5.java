package com.lzhlyle.leetcode.recite.no127;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordLadder_5 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) return 0; // O(n)
        if (beginWord.equals(endWord)) return 2;

        // 既不影响wordList，又让HashSet实现以保证高效增删
        Set<String> dict = new HashSet<>(wordList); // O(n)

        Set<String> beginSet = new HashSet<>();
        beginSet.add(beginWord);

        Set<String> endSet = new HashSet<>();
        endSet.add(endWord);

        return search(beginSet, endSet, dict, 1);
    }

    // recursion
    private int search(Set<String> beginSet, Set<String> endSet, Set<String> dict, int level) {
        // terminator
        // 两端都走不到对方
        if (beginSet.size() == 0 || endSet.size() == 0) return 0;

        // process
        dict.removeAll(beginSet); // 利用增删的O(1)，减少原本比较的O(n)，同时具备visited记录访问过节点的功能
        Set<String> currLevelSet = new HashSet<>(); // 当前层
        level++;
        // 遍历单词
        for (String bStr : beginSet) {
            char[] chs = bStr.toCharArray();
            // 遍历字母
            for (int i = 0; i < chs.length; i++) {
                char cur = chs[i];
                // 遍历替换后的所有可能
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    chs[i] = ch;
                    String tmp = String.valueOf(chs);
                    if (!dict.contains(tmp)) continue; // 不再给定的单词表里
                    if (endSet.contains(tmp)) return level; // 另一端里已有，则找到最短路径
                    currLevelSet.add(tmp); // 加入当前层
                }
                chs[i] = cur;
            }
        }

        // drill down
        // 总是从少的找向多的
        if (currLevelSet.size() <= endSet.size()) {
            // 从当前层继续往下找，不再关心beginSet原有节点，都已在visited里了
            beginSet = currLevelSet;
        } else {
            // endSet比较少，从endSet开始找更快
            beginSet = endSet;
            endSet = currLevelSet;
        }
        return search(beginSet, endSet, dict, level);

        // reverse state
    }

    public static void main(String[] args) {
        int res = new WordLadder_5().ladderLength("hit", "cog",
                Arrays.asList("hit", "hot", "dot", "dog", "lot", "log", "cog"));
        System.out.println(res);
    }
}
