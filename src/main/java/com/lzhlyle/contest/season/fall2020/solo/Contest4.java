package com.lzhlyle.contest.season.fall2020.solo;

import java.util.HashMap;
import java.util.Map;

public class Contest4 {
    private long inc, dec;
    private int[] jump, cost;
    private int MOD = 1000000007;

    public int busRapidTransit(int target, int inc, int dec, int[] jump, int[] cost) {
        this.inc = inc;
        this.dec = dec;
        this.jump = jump;
        this.cost = cost;
        return (int) (dfs(target, new HashMap<>()) % MOD);
    }

    private long dfs(int curr, Map<Integer, Long> map) {
        if (curr == 0) return 0;
        if (map.containsKey(curr)) return map.get(curr);

        map.put(curr, (long) MOD); // 最多不超过 MOD，避免无限扩展
        long res = (long) curr * inc;
        for (int i = 0; i < jump.length; i++) {
            res = Math.min(res, dfs(curr / jump[i], map) + cost[i] + (curr % jump[i]) * inc);
            res = Math.min(res, dfs((curr / jump[i]) + 1, map) + cost[i] + (jump[i] - (curr % jump[i])) * dec);
        }
        map.put(curr, res);
        return res;
    }

//    // tle
//    public int busRapidTransit(int target, int inc, int dec, int[] jump, int[] cost) {
//        Queue<int[]> queue = new PriorityQueue<>((a, b) -> a[1] == b[1] ? Math.abs(target - a[0]) - Math.abs(target - b[0]) : a[1] - b[1]);
//        queue.add(new int[]{0, 0});
//        Set<Integer> set = new HashSet<>();
//        while (!queue.isEmpty()) {
//            int[] node = queue.remove();
//            int curr = node[0], cc = node[1];
//            if (curr == target) return cc;
//            if (set.add(curr + 1)) queue.add(new int[]{curr + 1, cc + inc});
//            if (curr - 1 > 0 && set.add(curr - 1)) queue.add(new int[]{curr - 1, cc + dec});
//            for (int i = 0; i < jump.length; i++) {
//                if (set.add(curr * jump[i])) queue.add(new int[]{curr * jump[i], cc + cost[i]});
//            }
//        }
//        return -1;
//    }

    public static void main(String[] args) {
        Contest4 contest = new Contest4();
        {

        }
    }
}
