package com.lzhlyle.leetcode.tomorrow.no140;

import java.util.*;

public class WordBreakIi_DFS_Memo {
    public List<String> wordBreak(String s, List<String> wordDict) {
        return dfs(s, wordDict, new HashMap<>());
    }

    private List<String> dfs(String str, List<String> dict, Map<String, List<String>> map) {
        if (str.isEmpty()) return Collections.singletonList("");
        if (map.containsKey(str)) return map.get(str);

        List<String> res = new ArrayList<>();
        for (String word : dict) {
            if (str.startsWith(word)) {
                List<String> list = dfs(str.substring(word.length()), dict, map);
                for (String es : list)
                    res.add(word + (es.isEmpty() ? "" : " " + es));
            }
        }
        map.put(str, res);
        return res;
    }
}
