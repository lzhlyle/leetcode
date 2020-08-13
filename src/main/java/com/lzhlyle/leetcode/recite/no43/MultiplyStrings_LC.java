package com.lzhlyle.leetcode.recite.no43;

public class MultiplyStrings_LC {
    public String multiply(String num1, String num2) {
        if (num1.isEmpty() || num2.isEmpty()) return "";
        if (num1.equals("0") || num2.equals("0")) return "0";

        char[] arr1 = num1.toCharArray(), arr2 = num2.toCharArray();
        int[] arr = new int[arr1.length + arr2.length];
        for (int i = arr1.length - 1; i >= 0; i--) {
            int a = arr1[i] - '0';
            for (int j = arr2.length - 1; j >= 0; j--) {
                int b = arr2[j] - '0';
                int sum = arr[i + j + 1] + a * b;
                arr[i + j + 1] = sum % 10;
                arr[i + j] += sum / 10;
            }
        }

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < arr.length; i++)
            if (i > 0 || arr[i] > 0)
                builder.append(arr[i]);
        return builder.toString();
    }
}
