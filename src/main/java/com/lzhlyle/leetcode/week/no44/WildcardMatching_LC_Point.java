package com.lzhlyle.leetcode.week.no44;

public class WildcardMatching_LC_Point {
    public boolean isMatch(String s, String p) {
        char[] sarr = s.toCharArray(), parr = p.toCharArray();
        int slen = sarr.length, plen = parr.length, si = 0, pi = 0, match = -1, star = -1;
        while (si < slen) {
            if (pi < plen && (parr[pi] == '?' || parr[pi] == sarr[si])) {
                ++si;
                ++pi;
            } else if (pi < plen && parr[pi] == '*') {
                match = si;
                star = pi++;
            } else if (match != -1) {
                si = ++match;
                pi = star + 1;
            } else return false;
        }
        while (pi < plen && parr[pi] == '*') ++pi;
        return pi == plen;
    }
}
