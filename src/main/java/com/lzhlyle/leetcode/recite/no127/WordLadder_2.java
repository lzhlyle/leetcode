package com.lzhlyle.leetcode.recite.no127;

import java.util.*;

public class WordLadder_2 {
    // 超时
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (wordList == null || wordList.size() < 2) return 0;

        // 广度优先 bfs 循环，找到换一个字母能成的所有可能，再逐个继续找，最快找到的就是
        return bfs(beginWord, endWord, wordList);
    }

    private class KV {
        String word;

        int level;

        KV(String word, int level) {
            this.word = word;
            this.level = level;
        }

    }

    private int bfs(String beginWord, String endWord, List<String> wordList) {
        Set<String> visited = new HashSet<>();
        Queue<KV> queue = new LinkedList<>();
        queue.add(new KV(beginWord, 2));

        // terminator
        while (!queue.isEmpty()) {
            // process
            KV curr = queue.remove();
            visited.add(curr.word);

            List<String> nextWords = this._lookUpNextWords(curr.word, wordList, visited);
            if (nextWords.contains(endWord)) return curr.level; // find

            // drill down
            if (!nextWords.isEmpty()) {
                for (String nextWord : nextWords) {
                    queue.add(new KV(nextWord, curr.level + 1));
                }
            }

            // reverse state
        }
        return 0;
    }

    private List<String> _lookUpNextWords(String beginWord, List<String> wordList, Set<String> visited) {
        List<String> res = new ArrayList<>();
        for (String word : wordList) {
            if (visited.contains(word)) continue;
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
        int res = new WordLadder_2().ladderLength("hit", "cog",
                Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"));
        System.out.println(res);
    }
}
