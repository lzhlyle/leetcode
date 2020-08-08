package com.lzhlyle.contest.biweekly.biweekly32;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Contest4 {
    // WA
    public int longestAwesome(String s) {
        char[] arr = s.toCharArray();
        if (arr.length == 1) return 1;

        int freq = 0b0;
        int[] index = new int[1 << 10]; // 出现全偶/唯一同奇数(0-9)时的 首次 index
        Arrays.fill(index, -1);
        int odd = 0, even = 0, max = 1;
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>(); // (odd, (freq, index))
        for (int i = 0; i < arr.length; i++) {
            int v = arr[i] - '0';
            if (((freq >> v) & 1) == 1) {
                odd--;
                even++;
                freq &= ~(1 << v);
            } else {
                odd++;
                freq |= 1 << v;
            }


            if (freq == 0b0) {
                // 全偶
                max = Math.max(max, i + 1);
            } else if (index[freq] != -1) {
                // 唯一同奇数的上次
                max = Math.max(max, i - index[freq] + 1);
            } else {
                if (map.containsKey(odd)) {
                    for (int f : map.get(odd).keySet()) {
                        int xor = f ^ freq;
                        if ((xor & (xor - 1)) == 0) {
                            max = Math.max(max, i - map.get(odd).get(f) + 1);
                        }
                    }
                    if (!map.get(odd).containsKey(freq))
                        map.get(odd).put(freq, i);
                } else {
                    map.put(odd, new HashMap<>());
                    map.get(odd).put(freq, i);
                }
            }
            if (index[freq] == -1) index[freq] = i;
            System.out.println(String.format("odd: %s, even: %s, freq: %s, max: %s", odd, even, Integer.toBinaryString(freq), max));
        }
        return max;
    }

    public static void main(String[] args) {
        Contest4 contest = new Contest4();
        {

        }
    }
}
