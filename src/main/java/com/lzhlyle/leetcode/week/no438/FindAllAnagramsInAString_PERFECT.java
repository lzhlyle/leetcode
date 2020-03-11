package com.lzhlyle.leetcode.week.no438;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FindAllAnagramsInAString_PERFECT {
    public List<Integer> findAnagrams(String students, String plans) {
        if (students.length() < plans.length()) return Collections.emptyList();
        int[] need = new int[26], hire = new int[26];
        for (char plan : plans.toCharArray()) hire[plan - 'a'] = ++need[plan - 'a'];
        int needCnt = plans.length(), expected = needCnt;
        char[] coders = students.toCharArray();
        List<Integer> perfect = new ArrayList<>();
        for (int i = 0; i < coders.length; i++) {
            if (i - needCnt > -1) {
                int leaving = coders[i - needCnt] - 'a';
                hire[leaving]++;
                if (need[leaving] > 0 && hire[leaving] > 0) expected++;
            }

            int hiring = coders[i] - 'a';
            if (need[hiring] > 0 && hire[hiring] > 0) expected--;
            hire[hiring]--;

            if (expected == 0) perfect.add(i - needCnt + 1);
        }
        return perfect;
    }
}
