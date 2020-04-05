package com.lzhlyle.contest.weekly183;

public class Contest2 {

    public int numSteps(String s) {
        if (s.equals("1")) return 0;
        if (s.charAt(s.length() - 1) == '0') return 1 + numSteps(s.substring(0, s.length() - 1));
        return 1 + numSteps(plusOne(s.toCharArray(), s.length() - 1));
    }

    private String plusOne(char[] arr, int i) {
        if (i == 0) {
            arr[i] = '0';
            return "1" + new String(arr);
        }
        if (arr[i] == '0') {
            arr[i] = '1';
            return new String(arr);
        }
        arr[i] = '0';
        return plusOne(arr, i - 1);
    }

    public static void main(String[] args) {
        Contest2 contest = new Contest2();
        {

        }
    }
}
