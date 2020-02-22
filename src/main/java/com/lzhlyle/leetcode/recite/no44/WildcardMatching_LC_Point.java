package com.lzhlyle.leetcode.recite.no44;

public class WildcardMatching_LC_Point {
    public boolean isMatch(String s, String p) {
        char[] sarr = s.toCharArray(), parr = p.toCharArray();
        int si = 0, pi = 0, sStar = -1, pStar = -1, slen = sarr.length, plen = parr.length;
        while (si < slen) {
            if (pi < plen && (parr[pi] == '?' || parr[pi] == sarr[si])) {
                // 字符匹配，都移动
                ++si;
                ++pi;
            } else if (pi < plen && parr[pi] == '*') {
                // 匹配'*'，标记位置，p移动--等待下一个字符，s不移动--'*'可匹配空（下一循环时，若没有字符匹配，会在下一个if移动）
                sStar = si;
                pStar = pi;
                // pi在下一个位等着
                ++pi;
            } else if (sStar != -1) {
                // 之前匹配过'*'，s移动--'*'可匹配多个，p一直等着下一个字符
                ++sStar;
                // 把si 和 pi都拉回来
                si = sStar; // 把 si 拉回来
                pi = pStar + 1;
            } else return false;
        }
        while (pi < plen && parr[pi] == '*') ++pi; // * match ""
        return pi == plen;
    }

    public static void main(String[] args) {
        new WildcardMatching_LC_Point().isMatch("aaaa", "***a");
    }
}
