package com.lzhlyle.contest.season.spring2020;

public class Contest3 {
    public int[] getTriggerTime(int[][] increase, int[][] requirements) {
        int lenInc = increase.length, lenReq = requirements.length;

        // 累加
        int[] arrC = new int[lenInc + 1], arrR = new int[lenInc + 1], arrH = new int[lenInc + 1];
        for (int i = 1; i < lenInc + 1; i++) {
            arrC[i] = increase[i - 1][0] + arrC[i - 1];
            arrR[i] = increase[i - 1][1] + arrR[i - 1];
            arrH[i] = increase[i - 1][2] + arrH[i - 1];
        }

        int[] res = new int[lenReq];
        for (int i = 0; i < lenReq; i++) {
            int[] req = requirements[i];
            int ci = bs(arrC, req[0], 0, lenInc);
            if (ci == -1) res[i] = -1;
            else {
                int ri = bs(arrR, req[1], ci, lenInc);
                if (ri == -1) res[i] = -1;
                else {
                    int hi = bs(arrH, req[2], ri, lenInc);
                    if (hi == -1) res[i] = -1;
                    else res[i] = hi;
                }
            }
        }
        return res;
    }

    // 找第一个大于等于的位置
    private int bs(int[] arr, int target, int l, int r) {
        while (l < r) {
            int mid = l + ((r - l) >> 1);
            if (arr[mid] < target) l = mid + 1;
            else r = mid;
        }
        return arr[l] >= target ? l : -1;
    }


    public static void main(String[] args) {
        Contest3 contest = new Contest3();
        {

        }
    }
}
