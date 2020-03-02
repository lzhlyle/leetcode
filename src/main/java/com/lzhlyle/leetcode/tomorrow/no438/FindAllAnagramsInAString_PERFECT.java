package com.lzhlyle.leetcode.tomorrow.no438;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class FindAllAnagramsInAString_PERFECT {
    public List<Integer> findAnagrams(String students, String plans) {
        if (students.length() < plans.length()) return Collections.emptyList();

        int[] need = new int[26], hire = new int[26];
        for (char plan : plans.toCharArray()) hire[plan - 'a'] = ++need[plan - 'a'];

        int needCnt = plans.length(), expected = needCnt;
        char[] coders = students.toCharArray();
        List<Integer> perfect = new LinkedList<>();

        for (int i = 0; i < coders.length; i++) {
            // leaving
            if (i - needCnt >= 0) {
                int leaving = coders[i - needCnt] - 'a';
                hire[leaving]++;
                if (need[leaving] > 0 && hire[leaving] > 0) expected++;
            }

            // hire
            int hiring = coders[i] - 'a';
            if (need[hiring] > 0 && hire[hiring] > 0) expected--;
            hire[hiring]--;

            // perfect
            if (expected == 0) perfect.add(i - needCnt + 1);
        }

        return perfect;
    }
}
