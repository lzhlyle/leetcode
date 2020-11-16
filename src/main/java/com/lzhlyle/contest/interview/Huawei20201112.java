package com.lzhlyle.contest.interview;

import java.util.Scanner;

/**
 * 题目描述
 * 上图是一个Mysql查询结果图，我们看到这个表格非常漂亮，只需要使用”+”和”-”两个符号就可以打印，
 * 现在你的任务是打印一个n×m的表格我们定义单位长度（水平方向有三个”-”，竖直方向有一个”| ”，”|”对齐”+”）的矩形表格为
 * 解答要求
 * 时间限制：1000ms, 内存限制：64MB
 * 输入
 * 输入只有一行包含两个整数n和m(0<n,m<13)。
 * 输出
 * 输出n×m的表格。
 * 样例
 * 输入样例 1 复制
 * 1 1
 * 输出样例 1
 * +---+
 * |   |
 * +---+
 * <p>
 * 输入样例 2 复制
 * 1 2
 * 输出样例 2
 * +---+---+
 * |   |   |
 * +---+---+
 */

public class Huawei20201112 {

    /**
     * print matrix with rows and columns
     *
     * @param n rows
     * @param m columns
     */
    private static void printMatrix(int n, int m) {
        // horizon
        StringBuilder hBuilder = new StringBuilder();
        hBuilder.append("+");
        for (int col = 0; col < m; col++) {
            hBuilder.append("---+");
        }
        String hline = hBuilder.toString();

        // vertical
        StringBuilder vBuilder = new StringBuilder();
        vBuilder.append("|");
        for (int col = 0; col < m; col++) {
            vBuilder.append("   |");
        }
        String vline = vBuilder.toString();

        // print table
        printTable(hline, vline, n);
    }

    private static void printTable(String hline, String vline, int n) {
        System.out.println(hline);
        for (int row = 0; row < n; row++) {
            System.out.println(vline);
            System.out.println(hline);
        }
    }

    public static void main(String[] arg) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(), m = scanner.nextInt();
        printMatrix(n, m);
    }
}
