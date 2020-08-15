package com.lzhlyle.leetcode.self.no546;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RemoveBoxes_DFS_MEMO {
    // tle
    // dfs + memo
    public int removeBoxes(int[] boxes) {
        return dfs(boxes, new HashMap<>());
    }

    private int dfs(int[] arr, Map<String, Integer> map) {
        if (arr.length == 0) return 0;
        String key = compress(arr);
        if (map.containsKey(key)) return map.get(key);

        int score = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i > 0 && arr[i] == arr[i - 1]) continue;
            int[] after = remove(arr, i);
            int len = (arr.length - after.length);
            score = Math.max(score, len * len + dfs(after, map));
        }

        map.put(key, score);
        return score;
    }

    private int[] remove(int[] arr, int p) {
        int[] res = new int[arr.length];
        int ri = 0, i = 0;
        while (i < arr.length && i < p) res[ri++] = arr[i++];
        while (i < arr.length && arr[i] == arr[p]) i++;
        while (i < arr.length) res[ri++] = arr[i++];
        return Arrays.copyOf(res, ri);
    }

    private String compress(int[] arr) {
        char[] chars = new char[arr.length];
        for (int i = 0; i < arr.length; i++)
            chars[i] = (char) (arr[i] + '0');
        return new String(chars);
    }
}
