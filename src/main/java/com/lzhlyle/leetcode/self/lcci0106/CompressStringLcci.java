package com.lzhlyle.leetcode.self.lcci0106;

public class CompressStringLcci {
    public String compressString(String S) {
        int len = S.length();
        if (len == 0) return S;

        StringBuilder builder = new StringBuilder();
        int cnt = 1;
        char[] arr = S.toCharArray();
        char last = arr[0];
        for (int i = 1; i < len; i++) {
            char c = arr[i];
            if (c == last) cnt++;
            else {
                builder.append(last).append(cnt);
                cnt = 1;
                last = c;
            }
            if (builder.length() >= len) return S;
        }
        builder.append(last).append(cnt);

        if (builder.length() >= len) return S;
        return builder.toString();
    }
}
