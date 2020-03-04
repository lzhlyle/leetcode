package com.lzhlyle.leetcode.tomorrow.no151;

import java.util.Arrays;
import java.util.Stack;

public class ReverseWordsInAString_Stack {
    public String reverseWords(String s) {
        String[] words = s.trim().split(" ");
        Stack<String> stack = new Stack<>();
        for (String word : words) if (!word.isEmpty()) stack.push(word);
        StringBuilder builder  = new StringBuilder();
        while (!stack.isEmpty()) {
            builder.append(stack.pop());
            if (!stack.isEmpty()) builder.append(' ');
        }
        return builder.toString();
    }
}
