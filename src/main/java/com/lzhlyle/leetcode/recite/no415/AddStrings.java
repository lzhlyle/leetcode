package com.lzhlyle.leetcode.recite.no415;

public class AddStrings {
    public String addStrings(String num1, String num2) {
        int len1 = num1.length(), len2 = num2.length();
        if (len1 > len2) return addStrings(num2, num1);

        char[] arr1 = num1.toCharArray(), arr2 = num2.toCharArray();
        char[] res = new char[len2 + 1];

        int carry = 0;
        for (int i = len1 - 1, j = len2 - 1, k = len2; k >= 0; i--, j--, k--) {
            int n1 = i < 0 ? 0 : (arr1[i] - '0'), n2 = j < 0 ? 0 : (arr2[j] - '0');
            int sum = n1 + n2 + carry;
            carry = sum > 9 ? 1 : 0;
            res[k] = (char) ((sum % 10) + '0');
        }
        if (res[0] == '0') return new String(res, 1, len2);
        return new String(res);
    }
}
