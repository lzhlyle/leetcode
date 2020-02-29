package com.lzhlyle.leetcode.recite.no438;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class FindAllAnagramsInAString_LC_TwoPoints {
    public List<Integer> findAnagrams(String s, String p) {
        int left = 0, right = 0, slen = s.length(), plen = p.length(), rest = p.length(); // rest 表示还差多少
        if (slen < plen) return Collections.emptyList();

        List<Integer> res = new LinkedList<>();
        int[] needs = new int[26], window = new int[26];
        for (char ch : p.toCharArray()) needs[ch - 'a']++;

        while (right < slen) {
            int iChr = s.charAt(right) - 'a';
            if (needs[iChr] > 0) { // 需要有，才加入 window
                window[iChr]++;
                if (window[iChr] <= needs[iChr]) rest--;
            }

            while (rest == 0) { // 字符不差了
                if (right - left + 1 == plen) res.add(left); // 长度整好

                int iChl = s.charAt(left) - 'a';
                if (needs[iChl] > 0) {
                    window[iChl]--;
                    if (window[iChl] < needs[iChl]) rest++; // 空出一个位，待 right 指针找到下一个需要的
                }
                left++;
            }
            right++;
        }
        return res;
    }
}
