package com.lzhlyle.contest.weekly.weekly185;

import java.util.*;

public class Contest2 {
    public List<List<String>> displayTable(List<List<String>> orders) {
        Set<String> foodSet = new HashSet<>();
        Map<Integer, Map<String, Integer>> map = new HashMap<>();
        for (List<String> order : orders) {
            String food = order.get(2);
            foodSet.add(food);

            Integer table = Integer.valueOf(order.get(1));
            if (!map.containsKey(table)) map.put(table, new HashMap<>());
            Map<String, Integer> foodCnt = map.get(table);
            if (!foodCnt.containsKey(food)) foodCnt.put(food, 0);
            foodCnt.put(food, foodCnt.get(food) + 1);
        }

        String[] foods = new String[foodSet.size()];
        int fi = 0;
        for (String food : foodSet) foods[fi++] = food;
        Arrays.sort(foods);

        Integer[] tables = new Integer[map.size()];
        int ti = 0;
        for (Integer table : map.keySet()) tables[ti++] = table;
        Arrays.sort(tables);

        List<List<String>> res = new ArrayList<>(tables.length);

        List<String> head = new ArrayList<>(foods.length);
        head.add("Table");
        Collections.addAll(head, foods);
        res.add(head);

        for (Integer table : tables) {
            List<String> tableCnt = new ArrayList<>(foods.length);
            tableCnt.add(table.toString());
            for (String food : foods) {
                if (map.get(table).containsKey(food)) tableCnt.add(map.get(table).get(food).toString());
                else tableCnt.add("0");
            }
            res.add(tableCnt);
        }
        return res;
    }

    public static void main(String[] args) {
        Contest2 contest = new Contest2();
        {

        }
    }
}
