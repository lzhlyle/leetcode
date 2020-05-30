package com.lzhlyle.contest.biweekly.biweekly27;

import java.util.HashSet;
import java.util.Set;

public class Contest2 {
    public boolean hasAllCodes(String s, int k) {
        char[] arr = s.toCharArray();
        Set<String> set = new HashSet<>();
        for (int i = 0; i + k - 1 < arr.length; i++) {
            set.add(new String(arr, i, k));
        }
        return set.size() >= Math.pow(2, k);
    }

    public static void main(String[] args) {
        Contest2 contest = new Contest2();
        {

        }
    }
}
