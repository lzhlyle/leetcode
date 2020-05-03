package com.lzhlyle.contest.weekly187;

import java.util.*;

public class Contest1 {
    public String destCity(List<List<String>> paths) {
        Map<String, Set<String>> map = new HashMap<>();
        for (List<String> p : paths) {
            String from = p.get(0), to = p.get(1);
            if (!map.containsKey(from)) map.put(from, new HashSet<>());
            map.get(from).add(to);
        }

        Queue<String> queue = new LinkedList<>(map.keySet());
        while (!queue.isEmpty()) {
            Queue<String> next = new LinkedList<>();
            while (!queue.isEmpty()) {
                Set<String> tos = map.get(queue.remove());
                for (String to : tos) {
                    if (!map.containsKey(to)) return to;
                    next.add(to);
                }
            }
            queue = next;
        }
        return null;
    }

    public static void main(String[] args) {
        Contest1 contest = new Contest1();
        {

        }
    }
}
