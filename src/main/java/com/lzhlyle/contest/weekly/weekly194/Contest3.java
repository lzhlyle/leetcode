package com.lzhlyle.contest.weekly.weekly194;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Contest3 {
    public int[] avoidFlood(int[] rains) {
        int n = rains.length;
        Map<Integer, Integer> map = new HashMap<>(); // (已满的湖泊, 上次降雨日)
        int[] days = new int[n]; // 可选的抽日
        Arrays.fill(days, -1);
        int[] res = new int[n];
        for (int i = 0, dr = 0; i < n; i++) {
            int lake = rains[i];
            if (lake > 0) {
                res[i] = -1;
                if (!map.containsKey(lake)) {
                    // lake 为空
                    map.put(lake, i);
                } else {
                    // lake 已满
                    // 选择尽早的可抽日
                    boolean done = false;
                    for (int di = 0, last = map.get(lake); di < dr; di++) {
                        if (days[di] < last) continue;
                        res[days[di]] = lake;
                        days[di] = -1;
                        map.put(lake, i);
                        done = true;
                        break;
                    }
                    if (!done) return new int[0]; // 没有可选的抽日
                }
            } else {
                // 可抽日
                days[dr++] = i;
                res[i] = 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Contest3 contest = new Contest3();
        {
            int[] rains = new int[]{2, 3, 0, 0, 3, 1, 0, 1, 0, 2, 2};
            int[] res = contest.avoidFlood(rains);
            System.out.println(Arrays.toString(res));
        }
    }
}
