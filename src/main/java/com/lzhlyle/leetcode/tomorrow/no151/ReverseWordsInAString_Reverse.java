package com.lzhlyle.leetcode.tomorrow.no151;

import java.util.Arrays;
import java.util.Collections;

public class ReverseWordsInAString_Reverse {
    public String reverseWords(String s) {
        String[] words = s.trim().split(" +");
        Collections.reverse(Arrays.asList(words));
        return String.join(" ", words);
    }
}
