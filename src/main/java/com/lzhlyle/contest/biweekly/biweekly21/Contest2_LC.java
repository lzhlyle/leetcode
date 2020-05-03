package com.lzhlyle.contest.biweekly.biweekly21;

import java.util.Arrays;

public class Contest2_LC {
    public int findTheLongestSubstring(String s) {
        char[] arr = s.toCharArray();
        int even = 0b0, max = 0;

        int[] dp = new int[1 << 5]; // "各种"情况，首次出现的索引
        Arrays.fill(dp, -1);
        dp[even] = 0; // 现在是完美平衡

        for (int i = 0; i < arr.length; i++) {
            char c = arr[i];

            if (c == 'a') even ^= 1;
            else if (c == 'e') even ^= (1 << 1);
            else if (c == 'i') even ^= (1 << 2);
            else if (c == 'o') even ^= (1 << 3);
            else if (c == 'u') even ^= (1 << 4);

            if (dp[even] == -1) dp[even] = i + 1;
            else max = Math.max(max, i + 1 - dp[even]); // 上次出现这种情况的索引
        }
        return max;
    }

    public static void main(String[] args) {
        Contest2_LC contest = new Contest2_LC();
        {
            String s = "id";
            int res = contest.findTheLongestSubstring(s);
            System.out.println(res);
            System.out.println(res == 1);
        }
        {
            String s = "eleetminicoworoep";
            int res = contest.findTheLongestSubstring(s);
            System.out.println(res);
            System.out.println(res == 13);
        }
        {
            String s = "leetcodeisgreat";
            int res = contest.findTheLongestSubstring(s);
            System.out.println(res);
            System.out.println(res == 5);
        }
        {
            String s = "bcbcbc";
            int res = contest.findTheLongestSubstring(s);
            System.out.println(res);
            System.out.println(res == 6);
        }
    }
}
