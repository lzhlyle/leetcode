package com.lzhlyle.contest.weekly.weekly176;

import java.util.Arrays;

public class ProductOfNumbers {
    private int di;
    private int[] prod;

    public ProductOfNumbers() {
        di = 0;
        prod = new int[40000];
        Arrays.fill(prod, 1);
    }

    public void add(int num) {
        di++;
        if (num == 1) return;
        if (num == 0) Arrays.fill(prod, 0, di, 0);
        else for (int i = 0; i < di; i++) if (prod[i] != 0) prod[i] *= num;
    }

    public int getProduct(int k) {
        return prod[di - k];
    }


    public static void main(String[] args) {
        ProductOfNumbers productOfNumbers = new ProductOfNumbers();
        productOfNumbers.add(3);        // [3]
        productOfNumbers.add(0);        // [3,0]
        productOfNumbers.add(2);        // [3,0,2]
        productOfNumbers.add(5);        // [3,0,2,5]
        productOfNumbers.add(4);        // [3,0,2,5,4]
        productOfNumbers.getProduct(2); // 返回 20 。最后 2 个数字的乘积是 5 * 4 = 20
        productOfNumbers.getProduct(3); // 返回 40 。最后 3 个数字的乘积是 2 * 5 * 4 = 40
        productOfNumbers.getProduct(4); // 返回  0 。最后 4 个数字的乘积是 0 * 2 * 5 * 4 = 0
        productOfNumbers.add(8);        // [3,0,2,5,4,8]
        productOfNumbers.getProduct(2); // 返回 32 。最后 2 个数字的乘积是 4 * 8 = 32
    }
}
