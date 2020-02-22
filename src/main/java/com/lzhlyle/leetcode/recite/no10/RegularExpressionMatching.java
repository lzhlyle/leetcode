package com.lzhlyle.leetcode.recite.no10;

public class RegularExpressionMatching {
    // 无通配符时
    public boolean isMatch_normal(String str, String pattern) {
        char[] chars = str.toCharArray(), arr = pattern.toCharArray();
        int sl = chars.length, pl = arr.length;
        if (sl != pl) return false;
        for (int i = 0; i < sl; i++) {
            if (chars[i] != arr[i]) return false;
        }
        return true;
    }

    // 无通配符时，方便递归
    public boolean isMatch_normal_recursion(String str, String pattern) {
        char[] chars = str.toCharArray(), arr = pattern.toCharArray();
        int sl = chars.length, pl = arr.length;

        if (pl == 0) return sl == 0;
        boolean first = chars[0] == arr[0];
        return first && isMatch_normal_recursion(str.substring(1), pattern.substring(1));
    }

    // 增加考虑'.'通配符
    public boolean isMatch_normal_recursion_dot(String str, String pattern) {
        char[] chars = str.toCharArray(), arr = pattern.toCharArray();
        int sl = chars.length, pl = arr.length;

        if (pl == 0) return sl == 0;
        boolean first = arr[0] == '.' || (chars[0] == arr[0]);
        return first && isMatch_normal_recursion_dot(str.substring(1), pattern.substring(1));
    }

    // 增加考虑'*'通配符
    public boolean isMatch_normal_recursion_dot_star(String str, String pattern) {
        char[] chars = str.toCharArray(), arr = pattern.toCharArray();
        int sl = chars.length, pl = arr.length;

        if (pl == 0) return sl == 0;
        boolean first = sl > 0 && (arr[0] == '.' || (chars[0] == arr[0]));

        if (pl == 2 && arr[1] == '*') { // 提前找星号
            return isMatch_normal_recursion_dot_star(str, pattern.substring(2)) // 0次
                    || (first && isMatch_normal_recursion_dot_star(str.substring(1), pattern)); // 多次
        }
        return first && isMatch_normal_recursion_dot_star(str.substring(1), pattern.substring(1));
    }
}
