package com.lzhlyle.contest.biweekly.biweekly26;

// wa
public class Contest4 {
    private String res;

    public String largestNumber(int[] cost, int target) {
        res = null;
        if (dfs(0, cost, target, "", 0)) return res;
        return "0";
    }

    private boolean dfs(int level, int[] cost, int target, String currRes, int currCost) {
        if (currCost == target) {
            res = currRes;
            return true;
        }

        for (int i = 8; i >= 0; i--) {
            if (currCost + cost[i] > target) continue;
            boolean ok = dfs(level + 1, cost, target, appendForMax(currRes, i + 1), currCost + cost[i]);
            if (ok) return true;
        }
        return false;
    }

    private String appendForMax(String currRes, int digit) {
        if (currRes.isEmpty()) return String.valueOf(digit);
        char c = (char) (digit + '0');
        char[] arr = currRes.toCharArray();
        int l = 0, r = arr.length - 1;
        while (l < r) {
            int mid = l + ((r - l) >> 1);
            if (arr[mid] > c) l = mid + 1;
            else r = mid;
        }
        char[] res = new char[arr.length + 1];
        for (int i = 0; i < res.length; i++) {
            if (i < l) res[i] = arr[i];
            else if (i == l) res[i] = c;
            else res[i] = arr[i - 1];
        }
        return new String(res);
    }

    public static void main(String[] args) {
        Contest4 contest = new Contest4();
        {

        }
    }
}
