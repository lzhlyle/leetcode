package com.lzhlyle.leetcode.self.no126;

import java.util.*;

public class WordLadderII_2 {
    // 18ms
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        // base condition
        Set<String> meets = new HashSet<>(wordList);
        if (!meets.contains(endWord)) return Collections.emptyList();

        // double end bfs
        Set<String> beginSet = new HashSet<>(Collections.singleton(beginWord));
        Set<String> endSet = new HashSet<>(Collections.singleton(endWord));
        Map<String, List<String>> neighborsMap = new HashMap<>();
        if (!this._doubleBfs(beginSet, endSet, true, neighborsMap, meets)) return Collections.emptyList();

        // dfs
        List<List<String>> res = new ArrayList<>();
        this._dfs(beginWord, endWord, neighborsMap, new LinkedList<>(), res);
        return res;
    }

    private boolean _doubleBfs(Set<String> beginSet, Set<String> endSet, boolean isFromBeginToEnd,
                               Map<String, List<String>> neighborsMap, Set<String> meets) {
        // terminator
        if (beginSet.size() == 0) return false;

        // process
        meets.removeAll(beginSet);
        boolean isMeetInCurrLevel = false;
        Set<String> nextLevelSet = new HashSet<>();

        // iterate: every word, every char, every possibility
        // every word
        for (String beginWord : beginSet) {
            char[] chars = beginWord.toCharArray();
            // every char
            for (int i = 0; i < chars.length; i++) {
                char stash = chars[i];

                // every possibility
                for (char c = 'a'; c <= 'z'; c++) {
                    chars[i] = c;
                    String newWord = String.valueOf(chars);
                    if (!meets.contains(newWord)) continue;

                    // continue looking up in this level, but not next level
                    if (endSet.contains(newWord)) isMeetInCurrLevel = true;
                    else nextLevelSet.add(newWord);

                    // record into neighbors
                    String key = isFromBeginToEnd ? beginWord : newWord;
                    String neighbor = isFromBeginToEnd ? newWord : beginWord;
                    if (!neighborsMap.containsKey(key)) neighborsMap.put(key, new ArrayList<>());
                    neighborsMap.get(key).add(neighbor);
                }

                // back tracking
                chars[i] = stash;
            }
        }

        if (isMeetInCurrLevel) return true;

        // drill down
        // always from less to more
        if (nextLevelSet.size() <= endSet.size()) {
            return this._doubleBfs(nextLevelSet, endSet, isFromBeginToEnd, neighborsMap, meets);
        } else {
            return this._doubleBfs(endSet, nextLevelSet, !isFromBeginToEnd, neighborsMap, meets);
        }
    }

    private void _dfs(String beginWord, String endWord, Map<String, List<String>> neighborsMap,
                      Deque<String> path, List<List<String>> res) {
        // terminator: complete appending res, but path back to empty
        if (res.size() > 0 && path.size() == 0) return;

        // process
        path.addLast(beginWord);

        // complete a path
        if (beginWord.contains(endWord)) {
            res.add(new ArrayList<>(path));
        } else if (neighborsMap.containsKey(beginWord)) {
            // drill down
            // has neighbors
            // iterate every neighbor
            for (String neighbor : neighborsMap.get(beginWord)) {
                this._dfs(neighbor, endWord, neighborsMap, path, res);
            }
        }

        // back tracking
        path.removeLast();
    }

    public static void main(String[] args) {
        Object res = new WordLadderII_2().findLadders("hit", "cog",
                Arrays.asList("hit", "hot", "dot", "dog", "lot", "log", "cog"));
        System.out.println(res);
    }
}
