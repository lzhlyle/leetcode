package com.lzhlyle.contest.weekly.weekly207;

import java.util.HashSet;
import java.util.Set;

public class Contest2 {
    // bt
    private int max;
    public int maxUniqueSplit(String s) {
        max = 0;
        dfs(s.toCharArray(), 0, "", new HashSet<>());
        return max;
    }

    private void dfs(char[] arr, int i, String curr, Set<String> set) {
        if (i == arr.length) {
            max = Math.max(max, set.size());
            return;
        }

        char c = arr[i];
        String comb = curr + c;
        if (set.contains(comb)) {
            // 已有，必须再等
            dfs(arr, i + 1, comb, set);
        } else {
            // 未有
            // 选择不等了直接进
            set.add(comb);
            dfs(arr, i + 1, "", set);
            set.remove(comb);

            // 选择继续等待
            dfs(arr, i + 1, comb, set);
        }
    }

    public static void main(String[] args) {
        Contest2 contest = new Contest2();
        {
            
        }
    }
}
