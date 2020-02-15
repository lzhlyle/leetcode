package com.lzhlyle.leetcode.recite.no433;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class MinimumGeneticMutation_TwoEndedBFS_Loop {
    private static final char[] _CHARS = new char[]{'A', 'C', 'G', 'T'};

    public int minMutation(String start, String end, String[] bank) {
        // base condition
        if (start.equals(end)) return 0;
        Set<String> meets = new HashSet<>(Arrays.asList(bank));
        if (!meets.contains(end)) return -1;

        Set<String> beginSet = new HashSet<>(Collections.singleton(start));
        Set<String> endSet = new HashSet<>(Collections.singleton(end));

        int step = 0;
        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            step++;
            if (beginSet.size() > endSet.size()) {
                Set<String> swap = beginSet;
                beginSet = endSet;
                endSet = swap;
            }

            meets.removeAll(beginSet);
            Set<String> nextBegin = new HashSet<>();
            for (String begin : beginSet) {
                char[] chars = begin.toCharArray();
                for (int i = 0; i < chars.length; i++) {
                    char ori = chars[i];
                    for (char c : _CHARS) {
                        if (c == ori) continue;
                        chars[i] = c;
                        String neighbor = String.valueOf(chars);
                        if (endSet.contains(neighbor)) return step;
                        if (!meets.contains(neighbor)) continue;
                        nextBegin.add(neighbor);
                    }
                    chars[i] = ori;
                }
            }

            beginSet = nextBegin;
        }

        return -1;
    }
}
