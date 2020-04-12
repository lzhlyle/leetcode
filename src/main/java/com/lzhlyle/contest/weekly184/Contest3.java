package com.lzhlyle.contest.weekly184;

import java.util.HashMap;
import java.util.Map;

public class Contest3 {
    public String entityParser(String text) {
        text = text.replace("&quot;", "\"")
                .replace("&apos;", "'")
                .replace("&gt;", ">")
                .replace("&lt;", "<")
                .replace("&frasl;", "/")
                .replace("&amp;", "&");
        return text;
    }

    private Map<String, String> init() {
        Map<String, String> res = new HashMap<>();
        res.put("&quot;", "\"");
        res.put("&apos;", "'");
        res.put("&amp;", "&");
        res.put("&gt;", ">");
        res.put("&lt;", "<");
        res.put("&frasl;", "/");
        return res;
    }

    public static void main(String[] args) {
        Contest3 contest = new Contest3();
        {
            
        }
    }
}
