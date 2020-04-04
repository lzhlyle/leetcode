package com.lzhlyle.leetcode.self.no150;

import java.util.Stack;

public class EvaluateReversePolishNotation_Stack {
    public int evalRPN(String[] tokens) {
        String opers = "+-*/";
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if (opers.contains(token)) {
                int b = stack.pop(), a = stack.pop();
                int res = calc(a, b, token);
                stack.push(res);
            } else stack.push(Integer.valueOf(token));
        }
        return stack.pop();
    }

    private int calc(int a, int b, String oper) {
        switch (oper) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                return a / b;
        }
        throw new RuntimeException("Unknown operation: " + oper);
    }
}
