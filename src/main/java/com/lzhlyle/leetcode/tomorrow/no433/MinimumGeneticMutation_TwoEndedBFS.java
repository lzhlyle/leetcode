package com.lzhlyle.leetcode.tomorrow.no433;

import java.util.*;

public class MinimumGeneticMutation_TwoEndedBFS {
    private static final char[] _CHARS = new char[]{'A', 'C', 'G', 'T'};

    public int minMutation(String start, String end, String[] bank) {
        if (start.equals(end)) return 0;
        Set<String> meets = new HashSet<>(Arrays.asList(bank));
        if (!meets.contains(end)) return -1;

        Set<String> beginSet = new HashSet<>(Collections.singleton(start));
        Set<String> endSet = new HashSet<>(Collections.singleton(end));

        return _twoEndedBFS(0, beginSet, endSet, meets);
    }

    private int _twoEndedBFS(int step, Set<String> beginSet, Set<String> endSet, Set<String> meets) {
        if (beginSet.isEmpty() || endSet.isEmpty()) return -1;

        step++;
        if (beginSet.size() > endSet.size()) {
            Set<String> swap = beginSet;
            beginSet = endSet;
            endSet = swap;
        }

        meets.removeAll(beginSet);
        Set<String> nextBegin = new HashSet<>();
        for (String begin : beginSet) {
            List<String> neighbors = _getNeighbors(begin);
            for (String neighbor : neighbors) {
                if (endSet.contains(neighbor)) return step;
                if (!meets.contains(neighbor)) continue;
                nextBegin.add(neighbor);
            }
        }

        return _twoEndedBFS(step, nextBegin, endSet, meets);
    }

    private List<String> _getNeighbors(String begin) {
        List<String> res = new LinkedList<>();
        char[] chars = begin.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char ori = chars[i];
            for (char c : _CHARS) {
                if (ori == c) continue;
                chars[i] = c;
                res.add(String.valueOf(chars));
            }
            chars[i] = ori;
        }
        return res;
    }
}
