package com.lzhlyle.leetcode.tomorrow.no126;

import java.util.*;

public class WordLadderII_TEBFS_Recursion {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        if (beginWord == null || endWord == null || wordList == null || wordList.size() < 1)
            return Collections.emptyList();
        if (beginWord.equals(endWord)) return Collections.singletonList(Arrays.asList(beginWord, endWord));

        Set<String> meets = new HashSet<>(wordList);
        if (!meets.contains(endWord)) return Collections.emptyList();
        Set<String> beginSet = new HashSet<>(Collections.singleton(beginWord));
        Set<String> endSet = new HashSet<>(Collections.singleton(endWord));

        Map<String, Set<String>> pathMap = _bfs(beginSet, endSet, meets, true, new HashMap<>());
        if (pathMap.isEmpty()) return Collections.emptyList();

        List<List<String>> res = new LinkedList<>();
        _dfs(pathMap, beginWord, endWord, res, new Stack<>());
        return res;
    }

    private void _dfs(Map<String, Set<String>> pathMap, String beginWord, String endWord, List<List<String>> res, Stack<String> path) {
        if (!res.isEmpty() && path.isEmpty()) return;
        path.push(beginWord);
        if (beginWord.equals(endWord)) res.add(new ArrayList<>(path));
        else if (pathMap.containsKey(beginWord)) {
            for (String neighbor : pathMap.get(beginWord)) {
                _dfs(pathMap, neighbor, endWord, res, path);
            }
        }
        path.pop();
    }

    private Map<String, Set<String>> _bfs(Set<String> beginSet, Set<String> endSet, Set<String> meets,
                                           boolean isFromBeginToEnd, Map<String, Set<String>> pathMap) {
        if (beginSet.isEmpty() || endSet.isEmpty()) return Collections.emptyMap();

        if (beginSet.size() > endSet.size()) {
            isFromBeginToEnd = !isFromBeginToEnd;
            Set<String> swap = beginSet;
            beginSet = endSet;
            endSet = swap;
        }

        meets.removeAll(beginSet);
        Set<String> nextBeginSet = new HashSet<>();
        boolean found = false;

        for (String begin : beginSet) {
            for (String neighbor : _getNeighbors(begin)) {
                if (!meets.contains(neighbor)) continue;

                if (endSet.contains(neighbor)) found = true;
                else nextBeginSet.add(neighbor);

                // record
                String from = isFromBeginToEnd ? begin : neighbor;
                String to = isFromBeginToEnd ? neighbor : begin;
                if (!pathMap.containsKey(from)) pathMap.put(from, new HashSet<>());
                pathMap.get(from).add(to);
            }
        }

        if (found) return pathMap;
        return _bfs(nextBeginSet, endSet, meets, isFromBeginToEnd, pathMap);
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

    public static void main(String[] args) {
        String beginWord = "qa", endWord = "sq";
        List<String> wordList = Arrays.asList("si", "go", "se", "cm", "so", "ph", "mt", "db", "mb", "sb", "kr", "ln",
                "tm", "le", "av", "sm", "ar", "ci", "ca", "br", "ti", "ba", "to", "ra", "fa", "yo", "ow", "sn", "ya",
                "cr", "po", "fe", "ho", "ma", "re", "or", "rn", "au", "ur", "rh", "sr", "tc", "lt", "lo", "as", "fr",
                "nb", "yb", "if", "pb", "ge", "th", "pm", "rb", "sh", "co", "ga", "li", "ha", "hz", "no", "bi", "di",
                "hi", "qa", "pi", "os", "uh", "wm", "an", "me", "mo", "na", "la", "st", "er", "sc", "ne", "mn", "mi",
                "am", "ex", "pt", "io", "be", "fm", "ta", "tb", "ni", "mr", "pa", "he", "lr", "sq", "ye");
        List<List<String>> res = new WordLadderII_TEBFS_Recursion().findLadders(beginWord, endWord, wordList);
        System.out.println(res);
    }
}
