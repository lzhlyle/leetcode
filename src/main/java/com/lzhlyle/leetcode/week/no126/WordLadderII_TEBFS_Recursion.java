package com.lzhlyle.leetcode.week.no126;

import java.util.*;

public class WordLadderII_TEBFS_Recursion {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        if (beginWord == null || endWord == null || wordList == null || wordList.isEmpty())
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

    private void _dfs(Map<String, Set<String>> pathMap, String beginWord, String endWord, List<List<String>> res, Stack<String> curr) {
        if (!res.isEmpty() && curr.isEmpty()) return;
        curr.push(beginWord);
        if (beginWord.equals(endWord)) res.add(new ArrayList<>(curr));
        else if (pathMap.containsKey(beginWord)) {
            Set<String> neighbors = pathMap.get(beginWord);
            for (String neighbor : neighbors) {
                _dfs(pathMap, neighbor, endWord, res, curr);
            }
        }
        curr.pop(); // back tracking
    }

    private Map<String, Set<String>> _bfs(Set<String> beginSet, Set<String> endSet, Set<String> meets,
                                          boolean isFromBegin, Map<String, Set<String>> pathMap) {
        if (beginSet.isEmpty() || endSet.isEmpty()) return pathMap;

        if (beginSet.size() > endSet.size()) {
            isFromBegin = !isFromBegin;
            Set swap = beginSet;
            beginSet = endSet;
            endSet = swap;
        }

        meets.removeAll(beginSet);
        Set<String> nextBeginSet = new HashSet<>();
        boolean found = false;

        for (String begin : beginSet) {
            List<String> neighbors = _getNeighbors(begin);
            for (String neighbor : neighbors) {
                if (!meets.contains(neighbor)) continue;
                if (endSet.contains(neighbor)) found = true;
                else nextBeginSet.add(neighbor);

                // record from to
                String from = isFromBegin ? begin : neighbor;
                String to = isFromBegin ? neighbor : begin;
                if (!pathMap.containsKey(from)) pathMap.put(from, new HashSet<>());
                pathMap.get(from).add(to);
            }
        }

        if (found) return pathMap;
        return _bfs(nextBeginSet, endSet, meets, isFromBegin, pathMap);
    }

    private List<String> _getNeighbors(String begin) {
        List<String> neighbors = new LinkedList<>();
        char[] arr = begin.toCharArray();
        for (int i = 0, len = arr.length; i < len; i++) {
            char ori = arr[i];
            for (char c = 'a'; c <= 'z'; c++) {
                if (c == ori) continue;
                arr[i] = c;
                neighbors.add(String.valueOf(arr));
            }
            arr[i] = ori; // reverse
        }
        return neighbors;
    }
}
