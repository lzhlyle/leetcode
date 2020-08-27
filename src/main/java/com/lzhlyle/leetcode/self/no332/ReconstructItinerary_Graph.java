package com.lzhlyle.leetcode.self.no332;

import java.util.*;

public class ReconstructItinerary_Graph {
    public List<String> findItinerary(List<List<String>> tickets) {
        if (tickets.isEmpty()) return Collections.emptyList();

        Map<String, Queue<String>> map = new HashMap<>();
        for (List<String> t : tickets) {
            String from = t.get(0), to = t.get(1);
            if (!map.containsKey(from))
                map.put(from, new PriorityQueue<>());
            map.get(from).add(to);
        }

        List<String> res = new LinkedList<>();
        visit("JFK", map, res);
        return res;
    }

    private void visit(String from, Map<String, Queue<String>> map, List<String> res) {
        Queue<String> tos = map.get(from);
        while (tos != null && !tos.isEmpty())
            visit(tos.remove(), map, res);
        res.add(0, from);
    }
}
