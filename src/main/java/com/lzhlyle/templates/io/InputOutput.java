package com.lzhlyle.templates.io;

import java.util.Scanner;

public class InputOutput {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int res = alg(n);
        System.out.println(res);
    }

    private static int alg(int n) {
        return n;
    }
}
