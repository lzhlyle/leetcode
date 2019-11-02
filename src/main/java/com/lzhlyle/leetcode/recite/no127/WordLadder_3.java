package com.lzhlyle.leetcode.recite.no127;

import java.util.*;

public class WordLadder_3 {
    // 272ms
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (wordList == null) return 0; // no need: wordList.size() >= 2

        // 广度优先 bfs 循环，找到换一个字母能成的所有可能，再逐个继续找，最快找到的就是
        Map<String, List<String>> preHandleMap = this._preHandle(wordList);

        return bfs(beginWord, endWord, preHandleMap);
    }

    private class KV {
        String word;

        int level;

        KV(String word, int level) {
            this.word = word;
            this.level = level;
        }

    }

    private int bfs(String beginWord, String endWord, Map<String, List<String>> preHandleMap) {
        Set<String> visited = new HashSet<>();
        Queue<KV> queue = new LinkedList<>();
        queue.add(new KV(beginWord, 2));

        // terminator
        while (!queue.isEmpty()) {
            // process
            KV curr = queue.remove();
            visited.add(curr.word);

            List<String> keys = this._getPatterns(curr.word);
            for (String key : keys) {
                if (!preHandleMap.containsKey(key)) continue;

                List<String> nextWords = preHandleMap.get(key);
                if (nextWords.contains(endWord)) return curr.level; // find

                // drill down
                if (!nextWords.isEmpty()) {
                    for (String nextWord : nextWords) {
                        if (visited.contains(nextWord)) continue;
                        queue.add(new KV(nextWord, curr.level + 1));
                    }
                }

                // reverse state
            }
        }
        return 0;
    }

    private Map<String, List<String>> _preHandle(List<String> wordList) {
        Map<String, List<String>> map = new HashMap<>();
        for (String word : wordList) {
            List<String> keys = this._getPatterns(word);
            for (String key : keys) {
                if (!map.containsKey(key)) map.put(key, new ArrayList<>());
                map.get(key).add(word);
            }
        }
        return map;
    }

    private List<String> _getPatterns(String word) {
        List<String> res = new ArrayList<>();
        char[] arr = word.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            char temp = arr[i];
            arr[i] = '*';
            res.add(String.valueOf(arr));
            arr[i] = temp;
        }
        return res;
    }

    public static void main(String[] args) {
        int res = new WordLadder_3().ladderLength("hit", "cog",
                Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"));
        System.out.println(res);
    }
}
