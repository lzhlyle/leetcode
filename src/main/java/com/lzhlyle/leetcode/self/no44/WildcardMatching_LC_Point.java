package com.lzhlyle.leetcode.self.no44;

public class WildcardMatching_LC_Point {
    public boolean isMatch(String s, String p) {
        int slen = s.length(), plen = p.length(), match = -1, star = -1, si = 0, pi = 0;
        while (si < slen) {
            if (pi < plen && (p.charAt(pi) == '?' || p.charAt(pi) == s.charAt(si))) {
                si++;
                pi++;
            } else if (pi < plen && p.charAt(pi) == '*') {
                match = si;
                star = pi;
                pi++;
            } else if (match != -1) {
                match++;
                si = match;
                pi = star + 1;
            } else return false;
        }
        while (pi < plen && p.charAt(pi) == '*') pi++;
        return pi == plen;
    }
}
