package com.lzhlyle.contest.interview;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class Wangyi20201103 {
    public static void main(String[] args) {
        Wangyi20201103 statistics = new Wangyi20201103();
        int[] res = statistics.topK("", 100);
        System.out.println(Arrays.toString(res));
    }

    /**
     * 查询指定文本中，最大的 k 个数字
     * 支持：文本每行一个数字，数字均为整型，在 int 范围内
     *
     * @param path 文本地址
     * @param k    数字个数
     * @return 最大的 k 个数字
     */
    public int[] topK(String path, int k) {
        if (path == null) throw new IllegalArgumentException("未指定文本地址");
        if (k < 0) throw new IllegalArgumentException("数字个数错误");

        if (k == 0) return new int[0];

        Queue<Integer> queue = new PriorityQueue<>(); // 小顶堆

        try (FileInputStream fileInputStream = new FileInputStream(new File(path));
             InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, StandardCharsets.UTF_8);
             BufferedReader reader = new BufferedReader(inputStreamReader)) {
            String line;
            while ((line = reader.readLine()) != null) {
                Integer digit = Integer.valueOf(line);
                if (queue.size() < k) {
                    queue.add(digit);
                } else if (digit > queue.element()) {
                    queue.remove();
                    queue.add(digit);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return queue.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}
