package com.lzhlyle.contest.weekly.weekly185;

import java.util.ArrayList;
import java.util.List;

public class Contest1 {
    public String reformat(String s) {
        char[] arr = s.toCharArray();
        List<Character> nums = new ArrayList<>(), chars = new ArrayList<>();
        int ntotal = 0, ctotal = 0;
        for (char c : arr) {
            if (c >= 'a' && c <= 'z') {
                chars.add(c);
                ctotal++;
            } else {
                nums.add(c);
                ntotal++;
            }
        }
        StringBuilder builder = new StringBuilder();
        if (ntotal + 1 == ctotal) {
            // number first
            builder.append(chars.get(0));
            for (int i = 0; i < ntotal; i++) {
                builder.append(nums.get(i)).append(chars.get(i + 1));
            }
        } else if (ctotal + 1 == ntotal) {
            // char first
            builder.append(nums.get(0));
            for (int i = 0; i < ctotal; i++) {
                builder.append(chars.get(i)).append(nums.get(i + 1));
            }
        } else if (ctotal == ntotal) {
            for (int i = 0; i < ctotal; i++) {
                builder.append(nums.get(i)).append(chars.get(i));
            }
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        Contest1 contest = new Contest1();
        {
            String str = "abcd123";
            String res = contest.reformat(str);
            System.out.println(res);
        }
    }
}
