package com.lzhlyle.unitest;

import org.junit.Test;

public class BitOperation {

    @Test
    public void moveTest() {
        int n = 281;

        System.out.println(Utils.outputBit(n));
        System.out.println(Utils.outputBit(n << 1));
        System.out.println(Utils.outputBit(n << 2));
        System.out.println(Utils.outputBit(n << 3));
        System.out.println(Utils.outputBit(n >> 1));
        System.out.println(Utils.outputBit(n >> 2));
        System.out.println(Utils.outputBit(n >> 3));
        System.out.println(Utils.outputBit(n >> 4));
    }

}
