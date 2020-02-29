package com.lzhlyle.leetcode.recite.no438;

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
            if (i > needCnt - 1) {
                char leaving = coders[i - needCnt];
                hire[leaving - 'a']++;
                if (need[leaving - 'a'] > 0 && hire[leaving - 'a'] > 0) expected++;
            }

            char hiring = coders[i];
            if (need[hiring - 'a'] > 0 && hire[hiring - 'a'] > 0) expected--;
            hire[hiring - 'a']--;

            if (expected == 0) perfect.add(i - needCnt + 1);
        }
        return perfect;
    }

    public static void main(String[] args) {
        List<Integer> res = new FindAllAnagramsInAString_PERFECT().findAnagrams("cbaebabacd", "abc");
        System.out.println(res);
    }
}
