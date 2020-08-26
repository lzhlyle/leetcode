package com.lzhlyle.leetcode.recite.no412;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FizzBuzz {
    public List<String> fizzBuzz(int n) {
        if (n == 0) return Collections.emptyList();
        List<String> res = new ArrayList<>(n);
        for (int i = 1; i <= n; i++) {
            String str = "";
            if (i % 3 == 0) str = "Fizz";
            if (i % 5 == 0) str += "Buzz";
            if (str.isEmpty()) str = String.valueOf(i);
            res.add(str);
        }
        return res;
    }
}
