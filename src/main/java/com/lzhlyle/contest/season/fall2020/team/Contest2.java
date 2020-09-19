package com.lzhlyle.contest.season.fall2020.team;

import java.util.HashSet;
import java.util.Set;

public class Contest2 {
    // wa
    private String tt = "";

    public boolean isMagic(int[] target) {
        int n = target.length;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = i + 1;
        tt = toStr(target);

        for (int k = 1; k <= n; k++) {
            Set<String> set = new HashSet<>();
            set.add(toStr(arr));
            if (dfs(arr.clone(), 0, set, target, k)) return true;
            System.out.println();
        }
        return false;
    }

    private boolean dfs(int[] arr, int i, Set<String> set, int[] target, int k) {
        if (i == arr.length) return true;

        // 移动索引到从 i 开始
        move(arr, i);
        if (!set.add(toStr(arr))) return false;

        int kk = k, j = i;
        while (kk > 0 && j < arr.length && arr[j] == target[j]) {
            kk--;
            j++;
        }
        if (j == arr.length) return true;
        if (kk == 0) {
            // 取前 k 个
            if (toStr(arr).equals(tt)) return true;
            if (dfs(arr, i + k, set, target, k)) return true;
        }
        return false;
    }

    private void move(int[] arr, int i) {
        for (int to = i, from = i + 1; from < arr.length; from += 2, to++) {
            int temp = arr[from];
            int j = from - 1;
            while (j >= to) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[to] = temp;
        }
    }

    private String toStr(int[] arr) {
        StringBuilder builder = new StringBuilder();
        for (int v : arr) builder.append(v);
        System.out.println(builder.toString());
        return builder.toString();
    }

    public static void main(String[] args) {
        Contest2 contest = new Contest2();
        {
            boolean res = contest.isMagic(new int[]{2, 4, 3, 1, 5});
            System.out.println(res);
        }
    }
}
