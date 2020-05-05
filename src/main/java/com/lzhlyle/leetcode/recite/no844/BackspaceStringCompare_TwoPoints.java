package com.lzhlyle.leetcode.recite.no844;

public class BackspaceStringCompare_TwoPoints {
    // two points
    public boolean backspaceCompare(String S, String T) {
        char[] arrS = S.toCharArray(), arrT = T.toCharArray();
        int i = arrS.length - 1, j = arrT.length - 1;
        int iCnt = 0, jCnt = 0;
        while (i >= 0 || j >= 0) {
            while (i >= 0 && (arrS[i] == '#' || iCnt > 0)) {
                if (arrS[i--] == '#') iCnt++;
                else iCnt--;
            }
            while (j >= 0 && (arrT[j] == '#' || jCnt > 0)) {
                if (arrT[j--] == '#') jCnt++;
                else jCnt--;
            }
            if (i < 0 && j < 0) return true;
            if (i < 0 || j < 0) return false;
            if (arrS[i--] != arrT[j--]) return false;
        }
        return true;
    }
}
