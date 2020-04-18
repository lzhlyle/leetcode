package com.lzhlyle.contest.biweekly24;

public class Contest3 {
    private int cnt = 0;
    private String res = "";

    // wrong
    public String getHappyString(int n, int k) {
        dfs(n, k, "a");
        dfs(n, k, "b");
        dfs(n, k, "c");
        return res;
    }

    private void dfs(int n, int k, String curr) {
        if (!res.isEmpty()) return;
        if (curr.length() == n) {
            cnt++;
            if (cnt == k) res = curr;
            return;
        }

        char last = curr.charAt(curr.length() - 1);
        if (last == 'a') {
            dfs(n, k, curr + 'b');
            dfs(n, k, curr + 'c');
        } else if (last == 'b') {
            dfs(n, k, curr + 'a');
            dfs(n, k, curr + 'c');
        } else if (last == 'c') {
            dfs(n, k, curr + 'a');
            dfs(n, k, curr + 'b');
        }
    }

    public static void main(String[] args) {
        Contest3 contest = new Contest3();
        {

        }
    }
}
