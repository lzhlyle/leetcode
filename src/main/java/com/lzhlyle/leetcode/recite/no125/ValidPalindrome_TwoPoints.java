package com.lzhlyle.leetcode.recite.no125;

public class ValidPalindrome_TwoPoints {
    public boolean isPalindrome(String s) {
        char[] arr = s.toLowerCase().toCharArray();
        int left = 0, right = arr.length - 1;
        while (left < right) {
            while (left < right && !valid(arr[left])) left++;
            while (left < right && !valid(arr[right])) right--;
            if (left < right && arr[left++] != arr[right--]) return false;
        }
        return true;
    }

    private boolean valid(char c) {
        return (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9');
    }

    public static void main(String[] args) {
        String str = "A man, a plan, a canal: Panama";
        boolean res = new ValidPalindrome_TwoPoints().isPalindrome(str);
        System.out.println(res);
    }
}
