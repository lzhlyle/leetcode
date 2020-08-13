package com.lzhlyle.leetcode.recite.no43;

public class MultiplyStrings {
    public String multiply(String num1, String num2) {
        if (num1.isEmpty() || num2.isEmpty()) return "";
        if (num1.equals("0") || num2.equals("0")) return "0";
        if (num1.length() > num2.length()) return multiply(num2, num1);

        String res = "0";
        char[] arr1 = num1.toCharArray(), arr2 = num2.toCharArray();
        for (int i = arr1.length - 1, zero = 0; i >= 0; i--, zero++) {
            int a = arr1[i] - '0';
            String mul = mul(arr2, a, zero);
            res = add(res, mul);
        }
        return res;
    }

    private String mul(char[] arr, int num, int zero) {
        if (num == 0) return "0";
        StringBuilder builder = new StringBuilder();
        int carry = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            int tot = (arr[i] - '0') * num + carry;
            carry = tot / 10;
            builder.append(tot % 10);
        }
        if (carry > 0) builder.append(carry);
        builder.reverse();
        while (zero-- > 0) builder.append('0');
        return builder.toString();
    }

    private String add(String a, String b) {
        if (a.length() > b.length()) return add(b, a);
        char[] aarr = a.toCharArray(), barr = b.toCharArray();
        StringBuilder builder = new StringBuilder();
        int carry = 0, j = barr.length - 1;
        for (int i = aarr.length - 1; i >= 0; i--, j--) {
            int tot = (aarr[i] - '0') + (barr[j] - '0') + carry;
            carry = tot / 10;
            builder.append(tot % 10);
        }
        while (j >= 0) {
            int tot = (barr[j--] - '0') + carry;
            carry = tot / 10;
            builder.append(tot % 10);
        }
        if (carry > 0) builder.append(carry);
        return builder.reverse().toString();
    }
}
