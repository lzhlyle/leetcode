package com.lzhlyle.contest.biweekly24;

import java.util.HashMap;
import java.util.Map;

public class Contest4_LC_DP_TopDown {
    // recursion(dfs) + memo
    // tle: O(nlog(k))

    private int MOD = 1000000007;
    private Map<String, Integer> memo = new HashMap<>();

    public int numberOfArrays(String s, int k) {
        return dfs(s, k);
    }

    private int dfs(String curr, int k) {
        if (curr.isEmpty()) return 1;
        if (curr.startsWith("0")) return 0;
        if (memo.containsKey(curr)) return memo.get(curr);

        long sum = 0, last = 0;
        for (int i = 1, len = curr.length(); i <= len && last < k; i++) {
            if (i < len) {
                int digit = curr.charAt(i) - '0';
                last = last * 10 + digit;
                if (last > k) break;
            }
            sum += dfs(curr.substring(i, len), k) % MOD;
        }
        int res = (int) (sum % MOD);
        memo.put(curr, res);
        return res;
    }

    public static void main(String[] args) {
        Contest4_LC_DP_TopDown contest = new Contest4_LC_DP_TopDown();
        {
            String s = "1000";
            int k = 10;
            int res = contest.numberOfArrays(s, k);
            System.out.println(res);
        }
    }
}
