package com.lzhlyle.leetcode.recite.no438;

import com.sun.xml.internal.messaging.saaj.util.FinalArrayList;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class FindAllAnagramsInAString_BruteForce {
    private int[] valid = new int[26];

    public List<Integer> findAnagrams(String s, String p) {
        // base condition
        if (s.length() < p.length()) return Collections.emptyList();
        // initial
        for (char pc : p.toCharArray()) valid[pc - 'a']++;
        List<Integer> res = new LinkedList<>();
        // for-each
        int plen = p.length();
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length - plen + 1; i++) {
            if (valid(Arrays.copyOfRange(arr, i, i + plen))) res.add(i);
        }
        return res;
    }

    private boolean valid(char[] arr) {
        int[] freq = new int[26];
        for (char sc : arr) {
            int i = sc - 'a';
            freq[i]++;
            if (freq[i] > valid[i]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        List<Integer> res = new FindAllAnagramsInAString_BruteForce().findAnagrams("abab", "ab");
        System.out.println(res);
    }
}
