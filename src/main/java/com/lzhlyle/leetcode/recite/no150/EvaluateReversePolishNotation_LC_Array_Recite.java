package com.lzhlyle.leetcode.recite.no150;

public class EvaluateReversePolishNotation_LC_Array_Recite {
    public int evalRPN(String[] tokens) {
        int[] arr = new int[tokens.length / 2 + 1];
        int i = 0;
        for (String token : tokens) {
            switch (token) {
                case "+" : arr[i - 2] += arr[--i]; break;
                case "-" : arr[i - 2] -= arr[--i]; break;
                case "*" : arr[i - 2] *= arr[--i]; break;
                case "/" : arr[i - 2] /= arr[--i]; break;
                default: arr[i++] = Integer.parseInt(token);
            }
        }
        return arr[0];
    }
}
