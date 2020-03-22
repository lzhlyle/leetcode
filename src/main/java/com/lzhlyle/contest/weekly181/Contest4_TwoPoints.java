package com.lzhlyle.contest.weekly181;

public class Contest4_TwoPoints {
    // timeout
    public String longestPrefix(String s) {
        char[] arr = s.toCharArray();
        int len = arr.length;
        for (int end = len - 2; end >= 0; end--) {
            int l = 0, r = len - end - 1;
            boolean match = false;
            while (r < len && arr[l] == arr[r]) {
                l++;
                r++;
                match = true;
            }
            if (match && r == len) return String.valueOf(arr, 0, l );
        }
        return "";
    }

    public static void main(String[] args) {
        Contest4_TwoPoints contest = new Contest4_TwoPoints();
        {
            String str = "level";
            String res = contest.longestPrefix(str);
            System.out.println(res);
        }
    }
}
