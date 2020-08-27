package com.lzhlyle.leetcode.recite.no332;

import java.util.*;

public class ReconstructItinerary_BT_Modeling {
    // bt
    public List<String> findItinerary(List<List<String>> tickets) {
        if (tickets.isEmpty()) return Collections.emptyList();

        Map<String, Map<String, Integer>> iniMap = new HashMap<>(); // (from, tos)
        for (List<String> t : tickets) {
            String from = t.get(0), to = t.get(1);
            if (!iniMap.containsKey(from))
                iniMap.put(from, new HashMap<>());
            iniMap.get(from).put(to, iniMap.get(from).getOrDefault(to, 0) + 1);
        }

        Map<String, List<ToLocation>> map = new HashMap<>();
        for (String from : iniMap.keySet()) {
            List<ToLocation> list = new ArrayList<>();
            for (String to : iniMap.get(from).keySet())
                list.add(new ToLocation(to, iniMap.get(from).get(to)));
            list.sort(Comparator.comparing(a -> a.name));
            map.put(from, list);
        }

        Stack<String> path = new Stack<>();
        path.push("JFK");
        bt(0, tickets.size(), path, map);
        return new ArrayList<>(path);
    }

    private boolean bt(int level, int n, Stack<String> path, Map<String, List<ToLocation>> map) {
        if (level == n) return true;
        if (!map.containsKey(path.peek())) return false;

        for (ToLocation to : map.get(path.peek())) {
            if (to.cnt == 0) continue;
            path.push(to.name);
            to.cnt--;
            if (bt(level + 1, n, path, map)) return true;
            to.cnt++;
            path.pop();
        }
        return false;
    }

    class ToLocation {
        String name;
        int cnt;

        ToLocation(String name, int cnt) {
            this.name = name;
            this.cnt = cnt;
        }
    }
}
