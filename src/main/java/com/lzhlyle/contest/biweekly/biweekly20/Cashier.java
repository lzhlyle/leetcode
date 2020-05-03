package com.lzhlyle.contest.biweekly.biweekly20;

import java.util.HashMap;
import java.util.Map;

public class Cashier {
    private int n, discount, curr;
    private Map<Integer, Integer> map;

    public Cashier(int n, int discount, int[] products, int[] prices) {
        this.n = n;
        this.discount = discount;
        this.curr = 0;
        map = new HashMap<>();
        for (int i = 0; i < products.length; i++) {
            map.put(products[i], prices[i]);
        }
    }

    public double getBill(int[] product, int[] amount) {
        curr++;
        double ori = 0;
        for (int i = 0; i < product.length; i++) {
            ori += map.get(product[i]) * amount[i];
        }
        if (curr == n) {
            curr = 0;
            return ori - (discount * ori) / 100;
        } else return ori;
    }
}
