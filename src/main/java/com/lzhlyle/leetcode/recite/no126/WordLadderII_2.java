package com.lzhlyle.leetcode.recite.no126;

import java.util.*;

public class WordLadderII_2 {
    // 18ms
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        // base condition
        Set<String> meets = new HashSet<>(wordList);
        if (!meets.contains(endWord)) return Collections.emptyList();

        Set<String> begin = new HashSet<>(Collections.singleton(beginWord));
        Set<String> end = new HashSet<>(Collections.singleton(endWord));

        // 相邻词映射
        Map<String, List<String>> neighborsMap = new HashMap<>();
        if (!doubleBfs(begin, end, neighborsMap, true, meets)) return Collections.emptyList(); // not find

        List<List<String>> result = new ArrayList<>();
        dfs(neighborsMap, result, beginWord, endWord, new LinkedList<>());
        return result;
    }

    // 双向广度优先，并确定在相遇时（找到最短路径时）所涉及的相邻词集合 neighbors
    private boolean doubleBfs(Set<String> begin, Set<String> end, Map<String, List<String>> neighborsMap,
                              boolean isFromBeginToEnd, Set<String> meets) {
        // terminator
        if (begin.size() == 0) return false;

        // process
        meets.removeAll(begin);

        // 在当前层是否已相遇
        boolean isMeetInCurrLevel = false;

        Set<String> nextLevels = new HashSet<>();
        // every word
        for (String beginWord : begin) {
            char[] arr = beginWord.toCharArray();
            // every letter
            for (int j = 0; j < arr.length; j++) {
                char swap = arr[j];
                // every other letter
                for (char i = 'a'; i <= 'z'; i++) {
                    arr[j] = i;
                    String newWord = String.valueOf(arr);
                    if (!meets.contains(newWord)) continue;

                    nextLevels.add(newWord);

                    // 记录相邻词映射
                    String key = isFromBeginToEnd ? beginWord : newWord;
                    String value = isFromBeginToEnd ? newWord : beginWord;
                    if (!neighborsMap.containsKey(key)) neighborsMap.put(key, new ArrayList<>());
                    neighborsMap.get(key).add(value);

                    // 而不是立刻返回，还要在这一层多找找
                    if (end.contains(newWord)) isMeetInCurrLevel = true;
                }
                arr[j] = swap;
            }
        }

        if (isMeetInCurrLevel) return true;

        // drill down
        // 少的找多的
        if (nextLevels.size() > end.size()) return doubleBfs(end, nextLevels, neighborsMap, !isFromBeginToEnd, meets);
        else return doubleBfs(nextLevels, end, neighborsMap, isFromBeginToEnd, meets);
    }

    // 深度优先，确定路径
    private void dfs(Map<String, List<String>> neighborsMap, List<List<String>> result,
                     String begin, String end, Deque<String> path) {
        path.addLast(begin); // add last 添加到路径末尾

        // 完成一条路径
        if (begin.equals(end)) {
            result.add(new ArrayList<>(path)); // 避免引用问题
            path.removeLast(); // 退一步，以便找另一条路径
            return;
        }

        // drill down
        if (neighborsMap.containsKey(begin)) { // 有相邻词
            // 遍历相邻词并递归
            List<String> neighbors = neighborsMap.get(begin);
            for (String neighbor : neighbors) {
                dfs(neighborsMap, result, neighbor, end, path);
            }
        }

        path.removeLast(); // 退一步，以便找另一条路径
    }

    public static void main(String[] args) {
        Object res = new WordLadderII_2().findLadders("hit", "cog",
                Arrays.asList("hit", "hot", "dot", "dog", "lot", "log", "cog"));
        System.out.println(res);
    }
}
