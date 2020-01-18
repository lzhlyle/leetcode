package com.lzhlyle.leetcode.self.no126;

import java.util.*;

public class WordLadderII_2_1 {
    // 18ms
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        // base condition
        Set<String> meets = new HashSet<>(wordList);
        if (!meets.contains(endWord)) return Collections.emptyList();

        // double end bfs
        Set<String> beginSet = new HashSet<>(Collections.singleton(beginWord));
        Set<String> endSet = new HashSet<>(Collections.singleton(endWord));
        Map<String, List<String>> neighborsMap = new HashMap<>();
        if (!this._doubleEndBfs(beginSet, endSet, neighborsMap, true, meets)) return Collections.emptyList();

        // dfs
        List<List<String>> result = new ArrayList<>();
        this._dfs(beginWord, endWord, neighborsMap, new LinkedList<>(), result);
        return result;
    }

    private boolean _doubleEndBfs(Set<String> beginSet, Set<String> endSet, Map<String, List<String>> neighborsMap,
                                  boolean isFromBeginToEnd, Set<String> meets) {
        // terminator
        if (beginSet.size() == 0) return false;

        // process
        meets.removeAll(beginSet);
        Set<String> nextLevelSet = new HashSet<>();
        boolean isMeetInCurrLevel = false;

        // iterate: every word, every char, every possibility
        for (String beginWord : beginSet) {
            char[] chars = beginWord.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                char stash = chars[i];

                for (char c = 'a'; c <= 'z'; c++) {
                    chars[i] = c;
                    String newWord = String.valueOf(chars);
                    if (!meets.contains(newWord)) continue;

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
        if (nextLevelSet.size() < endSet.size()) {
            return this._doubleEndBfs(nextLevelSet, endSet, neighborsMap, isFromBeginToEnd, meets);
        }
        return this._doubleEndBfs(endSet, nextLevelSet, neighborsMap, !isFromBeginToEnd, meets);

        // reverse state
    }

    private List<String> _getNeighbors(String word) {
        List<String> neighbors = new LinkedList<>();
        char[] arr = word.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            char original = arr[i];
            for (char j = 'a'; j < 'z'; j++) {
                if (arr[i] == j) continue;
                arr[i] = j;
                neighbors.add(String.valueOf(arr));
            }
            arr[i] = original;
        }
        return neighbors;
    }

    private void _dfs(String beginWord, String endWord, Map<String, List<String>> neighborsMap,
                      Deque<String> path, List<List<String>> result) {
        // terminator
        if (!result.isEmpty() && path.isEmpty()) return;

        // process
        // append into path
        path.addLast(beginWord);

        // complete a path
        if (beginWord.equals(endWord)) result.add(new ArrayList<>(path));
        else if (neighborsMap.containsKey(beginWord)) {
            // drill down
            // has neighbors
            // iterate every neighbor
            for (String neighbor : neighborsMap.get(beginWord)) {
                this._dfs(neighbor, endWord, neighborsMap, path, result);
            }
        }

        // back tracking
        path.removeLast();

        // reverse state
    }

    public static void main(String[] args) {
        String beginWord = "qa", endWord = "sq";
        List<String> wordList = Arrays.asList("si", "go", "se", "cm", "so", "ph", "mt", "db", "mb", "sb", "kr", "ln",
                "tm", "le", "av", "sm", "ar", "ci", "ca", "br", "ti", "ba", "to", "ra", "fa", "yo", "ow", "sn", "ya",
                "cr", "po", "fe", "ho", "ma", "re", "or", "rn", "au", "ur", "rh", "sr", "tc", "lt", "lo", "as", "fr",
                "nb", "yb", "if", "pb", "ge", "th", "pm", "rb", "sh", "co", "ga", "li", "ha", "hz", "no", "bi", "di",
                "hi", "qa", "pi", "os", "uh", "wm", "an", "me", "mo", "na", "la", "st", "er", "sc", "ne", "mn", "mi",
                "am", "ex", "pt", "io", "be", "fm", "ta", "tb", "ni", "mr", "pa", "he", "lr", "sq", "ye");
        Object res = new WordLadderII_2_1().findLadders(beginWord, endWord, wordList);
        System.out.println(res);
    }
}
