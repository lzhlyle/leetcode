package com.lzhlyle.leetcode.recite.no438;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class FindAllAnagramsInAString_BruteForce_Adv {
    private int[] valid = new int[26];

    public List<Integer> findAnagrams(String s, String p) {
        // base condition
        if (s.length() < p.length()) return Collections.emptyList();
        // initial
        List<Integer> res = new LinkedList<>();
        for (char pc : p.toCharArray()) valid[pc - 'a']++;
        int len = p.length();
        char[] arr = s.toCharArray();

        for (int i = 0; i < arr.length; i++) {
            if (i == len - 1) {
                if (_valid(Arrays.copyOfRange(arr, 0, len))) res.add(0);
            } else if (i > len - 1) {
                if (_valid(Arrays.copyOfRange(arr, i - len + 1, i + 1))) res.add(i - len + 1);
            }
        }

        return res;
    }

    private boolean _valid(char[] arr) {
        int[] freq = new int[26];
        for (char sc : arr) {
            int i = sc - 'a';
            freq[i]++;
            if (freq[i] > valid[i]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        List<Integer> res = new FindAllAnagramsInAString_BruteForce_Adv().findAnagrams("cbaebabacd", "abc");
        System.out.println(res);
    }
}
