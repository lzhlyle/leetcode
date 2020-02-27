package com.lzhlyle.leetcode.recite.no771;

import java.util.HashSet;
import java.util.Set;

public class JewelsAndStones_Set {
    public int numJewelsInStones(String J, String S) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < J.length(); i++) set.add(J.charAt(i));
        int count = 0;
        for (char c : S.toCharArray()) {
            if (set.contains(c)) count++;
        }
        return count;
    }
}
