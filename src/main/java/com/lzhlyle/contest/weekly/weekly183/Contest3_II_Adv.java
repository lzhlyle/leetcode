package com.lzhlyle.contest.weekly.weekly183;

import java.util.Arrays;

public class Contest3_II_Adv {
    // wrong
    public String longestDiverseString(int a, int b, int c) {
        int[] freq = {a, b, c};
        Arrays.sort(freq);

        char[] arr = new char[3];
        if (freq[0] == a) {
            arr[0] = 'a';
            if (freq[1] == b) {
                arr[1] = 'b';
                arr[2] = 'c';
            } else {
                arr[1] = 'c';
                arr[2] = 'b';
            }
        } else if (freq[0] == b) {
            arr[0] = 'b';
            if (freq[1] == a) {
                arr[1] = 'a';
                arr[2] = 'c';
            } else {
                arr[1] = 'c';
                arr[2] = 'a';
            }
        } else {
            arr[0] = 'c';
            if (freq[1] == a) {
                arr[1] = 'a';
                arr[2] = 'b';
            } else {
                arr[1] = 'b';
                arr[2] = 'a';
            }
        }

        return abc(freq[0], freq[1], freq[2], arr);
    }

    private String abc(int min, int mid, int max, char[] arr) {
        char[] chars = new char[min + mid + max];
        int ci = 4;

        // 先放最少的 min 个位
        for (int i = 0; i < min; i++) {
            chars[ci - 1] = arr[1];
            chars[ci] = arr[0];
            ci += 4;
        }
        if (mid > min) chars[ci] = arr[1];

        // 再放次少的
        for (int i = 0; i < mid - min - 1; i++) {

        }

        // 最后放最多的

        StringBuilder builder = new StringBuilder();
        return builder.toString();
    }

    public static void main(String[] args) {
        Contest3_II_Adv contest = new Contest3_II_Adv();
        {
            int a = 1, b = 1, c = 7;
            String res = contest.longestDiverseString(a, b, c);
            System.out.println(res);
        }
    }
}
