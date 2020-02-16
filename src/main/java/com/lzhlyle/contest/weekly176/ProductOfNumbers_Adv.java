package com.lzhlyle.contest.weekly176;

import java.util.LinkedList;
import java.util.List;

public class ProductOfNumbers_Adv {
    private List<Integer> products;

    public ProductOfNumbers_Adv() {
        products = new LinkedList<>();
        products.add(1);
    }

    public void add(int num) {
        if (num == 0) {
            products.clear();
            products.add(1);
        } else products.add(products.get(products.size() - 1) * num);
    }

    public int getProduct(int k) {
        if (products.size() - 1 - k < 0) return 0;
        return products.get(products.size() - 1) / products.get(products.size() - 1 - k);
    }

    public static void main(String[] args) {
        ProductOfNumbers_Adv productOfNumbers = new ProductOfNumbers_Adv();
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
