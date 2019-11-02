package com.lzhlyle.leetcode.recite.no127;

import java.util.*;

public class WordLadder {
    // 超时
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (wordList == null || wordList.size() < 2) return 0;

        // 深度优先 dfs 递归，找到只换一个字母的，就继续找，记录所有找到的情况，选最少转换次数
        return dfs(2, beginWord, endWord, wordList, new HashMap<>());
    }

    private int dfs(int level, String beginWord, String endWord, List<String> wordList, Map<String, Integer> visited) {
        // terminator
        if (visited.containsKey(beginWord) && visited.get(beginWord) < level) return 0;

        // process
        visited.put(beginWord, level);

        List<String> nextWords = this._lookUpNextWords(beginWord, wordList);
        if (nextWords.contains(endWord)) return level; // find

        int min = Integer.MAX_VALUE; // default is max
        for (String nextWord : nextWords) {
            int res = this.dfs(level + 1, nextWord, endWord, wordList, visited);
            if (res > 0) min = Math.min(min, res);
        }

        // reverse state

        return min == Integer.MAX_VALUE ? 0 : min;
    }

    private List<String> _lookUpNextWords(String beginWord, List<String> wordList) {
        List<String> res = new ArrayList<>();
        for (String word : wordList) {
            if (this._isOneLetterDiff(beginWord, word)) res.add(word);
        }
        return res;
    }

    private boolean _isOneLetterDiff(String beginWord, String word) {
        char[] begin = beginWord.toCharArray();
        char[] to = word.toCharArray();
        int diff = 0;
        for (int i = 0; i < begin.length; i++) {
            diff = diff + (begin[i] == to[i] ? 0 : 1); // if diff, then +1
        }
        return diff == 1;
    }

    public static void main(String[] args) {
        int res = new WordLadder().ladderLength("hit", "cog",
                Arrays.asList("hot", "dot", "dag", "lot", "log", "cog"));
        System.out.println(res);
    }
}
