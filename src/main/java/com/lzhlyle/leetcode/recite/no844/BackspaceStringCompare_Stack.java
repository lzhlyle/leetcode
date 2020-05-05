package com.lzhlyle.leetcode.recite.no844;

import java.util.Stack;

public class BackspaceStringCompare_Stack {
    // stack
    public boolean backspaceCompare(String S, String T) {
        Stack<Character> stackS = enStack(S), stackT = enStack(T);
        if (stackS.size() != stackT.size()) return false;
        while (!stackS.isEmpty()) {
            if (stackS.pop() != stackT.pop()) return false;
        }
        return true;
    }

    private Stack<Character> enStack(String str) {
        Stack<Character> stack = new Stack<>();
        for (char c : str.toCharArray()) {
            if (c != '#') stack.push(c);
            else if (!stack.isEmpty()) stack.pop();
        }
        return stack;
    }
}
