package com.lzhlyle.leetcode.self.no151;

import java.util.Stack;

public class ReverseWordsInAString_Stack {
    public String reverseWords(String s) {
        s = s.trim();
        String[] words = s.split(" +");
        Stack<String> stack = new Stack<>();
        for (String word : words) stack.push(word);
        StringBuilder builder = new StringBuilder();
        while (!stack.isEmpty()) {
            builder.append(stack.pop());
            if (!stack.isEmpty()) builder.append(" ");
        }
        return builder.toString();
    }
}
