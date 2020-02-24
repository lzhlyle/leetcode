package com.lzhlyle.leetcode.week.no433;

import java.util.*;

public class MinimumGeneticMutation_TwoEndedBFS {
    public int minMutation(String start, String end, String[] bank) {
        if (start.equals(end)) return 0;

        Set<String> meets = new HashSet<>(Arrays.asList(bank));
        if (!meets.contains(end)) return -1;

        Set<String> beginSet = new HashSet<>(Collections.singleton(start));
        Set<String> endSet = new HashSet<>(Collections.singleton(end));

        return bfs(0, beginSet, endSet, meets);
    }

    private int bfs(int step, Set<String> beginSet, Set<String> endSet, Set<String> meets) {
        if (beginSet.isEmpty() || endSet.isEmpty()) return -1;

        step++;
        if (beginSet.size() > endSet.size()) {
            Set<String> swap = beginSet;
            beginSet = endSet;
            endSet = swap;
        }

        meets.removeAll(beginSet);
        Set<String> next = new HashSet<>();
        for (String begin : beginSet) {
            List<String> neighbors = getNeighbors(begin);
            for (String neighbor : neighbors) {
                if (endSet.contains(neighbor)) return step;
                if (!meets.contains(neighbor)) continue;
                next.add(neighbor);
            }
        }

        return bfs(step, next, endSet, meets);
    }

    private List<String> getNeighbors(String genetic) {
        char[] mutation = new char[]{'A', 'C', 'G', 'T'}, arr = genetic.toCharArray();
        List<String> res = new ArrayList<>((mutation.length - 1) * arr.length);
        for (int i = 0; i < arr.length; i++) {
            char ori = arr[i];
            for (char m : mutation) {
                if (m == ori) continue;
                arr[i] = m;
                res.add(String.valueOf(arr));
            }
            arr[i] = ori;
        }
        return res;
    }
}
