package com.lzhlyle.leetcode.recite.no336;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PalindromePairs_BruteForce {
    // brute force
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (valid(words[i] + words[j])) res.add(Arrays.asList(i, j));
                if (valid(words[j] + words[i])) res.add(Arrays.asList(j, i));
            }
        }
        return res;
    }

    private boolean valid(String str) {
        char[] arr = str.toCharArray();
        int i = 0, j = arr.length - 1;
        while (i < j && arr[i] == arr[j]) {
            i++;
            j--;
        }
        return i >= j;
    }
}
