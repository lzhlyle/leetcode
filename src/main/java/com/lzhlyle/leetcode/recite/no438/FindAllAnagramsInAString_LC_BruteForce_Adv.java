package com.lzhlyle.leetcode.recite.no438;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class FindAllAnagramsInAString_LC_BruteForce_Adv {
    public List<Integer> findAnagrams(String s, String p) {
        if (s.length() < p.length()) return Collections.emptyList();
        List<Integer> res = new LinkedList<>();
        int[] freq = new int[26];
        int nonCnt = 26; // 计算有多少种字母为0(没有),这个用于判定匹配
        for (char pc : p.toCharArray()) {
            if (freq[pc - 'a'] == 0) nonCnt--;
            freq[pc - 'a']++;
        }

        int plen = p.length();
        char[] sarr = s.toCharArray();
        for (int i = 0; i < sarr.length; i++) {
            if (i >= plen) {
                if (freq[sarr[i - plen] - 'a'] == 0) nonCnt--;
                freq[sarr[i - plen] - 'a']++;
                if (freq[sarr[i - plen] - 'a'] == 0) nonCnt++;
            }

            if (freq[sarr[i] - 'a'] == 0) nonCnt--;
            freq[sarr[i] - 'a']--;
            if (freq[sarr[i] - 'a'] == 0) nonCnt++;

            if (i >= plen - 1 && nonCnt == 26) res.add(i - plen + 1);
        }

        return res;
    }

    public static void main(String[] args) {
        List<Integer> res = new FindAllAnagramsInAString_LC_BruteForce_Adv().findAnagrams("cbaebabacd", "abc");
        System.out.println(res);
    }
}
