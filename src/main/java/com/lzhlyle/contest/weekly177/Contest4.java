package com.lzhlyle.contest.weekly177;

import java.util.Arrays;

public class Contest4 {
    private String res = null;

    public String largestMultipleOfThree(int[] digits) {
        Arrays.sort(digits); // asc
        dfs(digits, digits.length - 1, "");
        if (res == null) return "";
        for (char c : res.toCharArray()) {
            if (c != '0') return res;
        }
        return "0";
    }

    private void dfs(int[] digits, int di, String curr) {
        if (di < 0) {
            if (!curr.equals("") && valid(curr)) {
                if (res == null) res = curr;
                else if (curr.length() > res.length()) res = curr;
            }
            return;
        }

        // 要
        dfs(digits, di - 1, curr + digits[di]);

        // 不要
        dfs(digits, di - 1, curr);
    }

    private boolean valid(String curr) {
        char[] arr = curr.toCharArray();
        int sum = 0;
        for (char c : arr) {
            sum += c - '0';
        }
        return sum % 3 == 0;
    }


    public static void main(String[] args) {
        {
            Contest4 contest = new Contest4();
            int[] digits = new int[]{1, 1, 1, 2};
            String res = contest.largestMultipleOfThree(digits);
            System.out.println(res);
        }
        {
            Contest4 contest = new Contest4();
            int[] digits = new int[]{8, 1, 9};
            String res = contest.largestMultipleOfThree(digits);
            System.out.println(res);
        }
        {
            Contest4 contest = new Contest4();
            int[] digits = new int[]{8, 6, 7, 1, 0};
            String res = contest.largestMultipleOfThree(digits);
            System.out.println(res);
        }
        {
            Contest4 contest = new Contest4();
            int[] digits = new int[]{1};
            String res = contest.largestMultipleOfThree(digits);
            System.out.println(res);
        }
        {
            Contest4 contest = new Contest4();
            int[] digits = new int[]{0, 0, 0, 0, 0, 0};
            String res = contest.largestMultipleOfThree(digits);
            System.out.println(res);
        }
    }
}
