package com.lzhlyle.contest.weekly.weekly194;

import java.util.HashMap;
import java.util.Map;

public class Contest2 {
    public String[] getFolderNames(String[] names) {
        int n = names.length;
        Map<String, Integer> map = new HashMap<>();
        String[] res = new String[n];
        int i = 0;
        for (String name : names) {
            if (!map.containsKey(name)) {
                map.put(name, 0);
                res[i++] = name;
            } else {
                int v = map.get(name) + 1;
                String val = name + "(" + v + ")";
                while (map.containsKey(val)) {
                    v++;
                    val = name + "(" + v + ")";
                }
                map.put(val, 0);
                map.put(name, v);
                res[i++] = val;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Contest2 contest = new Contest2();
        {

        }
    }
}
