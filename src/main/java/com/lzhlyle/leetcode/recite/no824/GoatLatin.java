package com.lzhlyle.leetcode.recite.no824;

public class GoatLatin {
    public String toGoatLatin(String S) {
        String[] arr = S.split(" ");
        StringBuilder suffix = new StringBuilder("a");
        for (int i = 0; i < arr.length; i++) {
            String ori = arr[i];
            if (!valid(ori.charAt(0)))
                arr[i] = ori.substring(1) + ori.charAt(0);
            arr[i] += "ma" + suffix;
            suffix.append("a");
        }
        return String.join(" ", arr);
    }

    private boolean valid(char c) {
        char lower = Character.toLowerCase(c);
        return lower == 'a' ||
                lower == 'e' ||
                lower == 'i' ||
                lower == 'o' ||
                lower == 'u';
    }
}
