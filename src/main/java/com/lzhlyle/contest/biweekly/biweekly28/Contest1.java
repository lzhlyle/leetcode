package com.lzhlyle.contest.biweekly.biweekly28;

public class Contest1 {

    public int[] finalPrices(int[] prices) {
        int n = prices.length;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = prices[i];
            for (int j = i + 1; j < n; j++) {
                if (prices[i] >= prices[j]) {
                    res[i] -= prices[j];
                    break;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Contest1 contest = new Contest1();
        {
            
        }
    }
}
