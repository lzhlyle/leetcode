package com.lzhlyle.contest.weekly.weekly205;

public class Contest1 {
    public String modifyString(String s) {
        if (s.equals("?")) return "a";

        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '?') {
                if (i == 0) arr[i] = get(arr[i + 1]);
                else if (i == arr.length - 1) arr[i] = get(arr[i - 1]);
                else arr[i] = get(arr[i - 1], arr[i + 1]);
            }
        }
        return new String(arr);
    }

    private char get(char l, char r) {
        if (r == '?') return get(l);
        char res = get(r);
        while (res == r || res == l)
            res = get(res);
        return res;
    }

    private char get(char nb) {
        if (nb == '?') return 'a';
        if (nb == 'z') return 'a';
        return (char) (nb + 1);
    }

    public static void main(String[] args) {
        System.out.println("begin");
        Contest1 contest = new Contest1();
        {
            
        }
    }
}
