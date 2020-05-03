package com.lzhlyle.contest.weekly.weekly183;

import java.util.Arrays;

public class Contest3_II {
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
        StringBuilder builder = new StringBuilder();

        int len1 = Math.min(max - mid, 2);
        for (int i = 0; i < len1; i++) {
            builder.append(arr[2]);
        }

        int len2 = (mid - min) / 2;
        String bc = arr[1] + "" + arr[2];
        for (int i = 0; i < len2; i++) {
            builder.append(bc);
        }

        String abc = new String(arr);
        for (int i = 0; i < min; i++) {
            builder.append(abc);
        }

        for (int i = 0; i < len2; i++) {
            builder.append(bc);
        }

        for (int i = 0; i < len1; i++) {
            builder.append(arr[2]);
        }

        return builder.toString();
    }

    public static void main(String[] args) {
        Contest3_II contest = new Contest3_II();
        {
            int a = 1, b = 1, c = 7;
            String res = contest.longestDiverseString(a, b, c);
            System.out.println(res);
        }
    }
}
