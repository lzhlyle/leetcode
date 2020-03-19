package com.lzhlyle.leetcode.recite.lcof40;

import java.util.Arrays;
import java.util.Stack;

public class ZuiXiaoDeKgeShuLcof_Stack {
    public int[] getLeastNumbers(int[] arr, int k) {
        Stack<Integer> asc = new Stack<>(), temp = new Stack<>();
        for (int num : arr) {
            while (!asc.isEmpty() && num < asc.peek()) temp.push(asc.pop());
            if (asc.size() < k) asc.push(num);
            while (!temp.isEmpty() && asc.size() < k) asc.push(temp.pop());
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) res[i] = asc.pop();
        return res;
    }
}
