package com.lzhlyle.contest.weekly.weekly198;

import java.util.*;

public class Contest3 {
    // wa
    // 同字母在一起，尽量拆
    public List<String> maxNumOfSubstrings(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        int[][] arr = new int[26][2]; // [char][from, to]
        for (int c = 0; c < 26; c++)
            Arrays.fill(arr[c], -1);
        for (int i = 0; i < n; i++) {
            int c = chars[i] - 'a';
            if (arr[c][0] == -1) arr[c][0] = i;
            arr[c][1] = i;
        }

        Arrays.sort(arr, Comparator.comparingInt(a -> a[0]));

        List<String> res = Collections.emptyList();
        int min = Integer.MAX_VALUE;
        for (int c = 0; c < 26; c++) {
            if (arr[c][0] < 0) continue;
            int len = 0;
            List<String> curr = new ArrayList<>();

            // 找到无交集的
//          // 有交集则连上
//            curr.add(s.substring(arr[c][0], arr[c][1] + 1));
//            len += arr[c][1] - arr[c][0] + 1;

            int l = arr[c][0], r = arr[c][1];
            int i = c + 1;
            while (i < 26) {
                if (arr[i][0] < arr[c][1]) {
                    // 有交集
                    r = arr[i][1];
                    i++;
                } else {
                    // 无交集
                    curr.add(s.substring(l, r + 1));
                    len += r - l + 1;
                    i++;
                    if (i == 26) break;
                    l = arr[i][0];
                    r = arr[i][1];
                    i++;
                }
            }
            System.out.println(curr);

            if (curr.size() > res.size() && len < min) {
                res = curr;
                min = len;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Contest3 contest = new Contest3();
        {
            String str = "adefaddaccc";
            List<String> res = contest.maxNumOfSubstrings(str);
            System.out.println(res);
        }
        }
//    }
}
