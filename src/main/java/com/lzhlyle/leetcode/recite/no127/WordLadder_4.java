package com.lzhlyle.leetcode.recite.no127;

import java.util.*;

public class WordLadder_4 {
    // 失败
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (wordList == null) return 0; // no need: wordList.size() >= 2
        if (!wordList.contains(endWord)) return 0;

        // 双向广度优先 bfs 循环，找到换一个字母能成的所有可能，再逐个继续找，最快找到的就是
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
        Map<String, Integer> visitedBegin = new HashMap<>();
        Queue<KV> queueBegin = new LinkedList<>();
        queueBegin.add(new KV(beginWord, 1));

        Map<String, Integer> visitedEnd = new HashMap<>();
        Queue<KV> queueEnd = new LinkedList<>();
        queueEnd.add(new KV(endWord, 1));

        // terminator
        while (!queueBegin.isEmpty() && !queueEnd.isEmpty()) { // same times
            // begin to end
            {
                // process
                KV curr = queueBegin.remove();
                visitedBegin.put(curr.word, curr.level);

                List<String> keys = this._getPatterns(curr.word);
                for (String key : keys) {
                    if (!preHandleMap.containsKey(key)) continue;

                    List<String> nextWords = preHandleMap.get(key);
                    if (nextWords.contains(endWord)) return curr.level + 1; // find

                    // drill down
                    int min = preHandleMap.size();
                    for (String nextWord : nextWords) {
                        if (visitedBegin.containsKey(nextWord)) continue;
                        if (visitedEnd.containsKey(nextWord))
                            min = Math.min(min, visitedEnd.get(nextWord));
                        queueBegin.add(new KV(nextWord, curr.level + 1));
                    }

                    // reverse state

                    if (min < preHandleMap.size()) return curr.level + min;
                }
            }

            // end to begin
            {
                // process
                KV curr = queueEnd.remove();
                visitedEnd.put(curr.word, curr.level);

                List<String> keys = this._getPatterns(curr.word);
                for (String key : keys) {
                    if (!preHandleMap.containsKey(key)) continue;

                    List<String> nextWords = preHandleMap.get(key);
                    if (nextWords.contains(beginWord)) return curr.level + 1; // find

                    // drill down
                    int min = preHandleMap.size();
                    for (String nextWord : nextWords) {
                        if (visitedEnd.containsKey(nextWord)) continue;
                        if (visitedBegin.containsKey(nextWord))
                            min = Math.min(min, visitedEnd.get(nextWord));
                        queueEnd.add(new KV(nextWord, curr.level + 1));
                    }

                    // reverse state

                    if (min < preHandleMap.size()) return curr.level + min;
                }
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
        int res = new WordLadder_4().ladderLength("kiss", "tusk",
                Arrays.asList("miss", "dusk", "kiss", "musk", "tusk", "diss", "disk", "sang", "ties", "muss"));
        System.out.println(res);
    }
}
