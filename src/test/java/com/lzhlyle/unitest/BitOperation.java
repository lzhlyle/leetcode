package com.lzhlyle.unitest;

import org.junit.Test;

public class BitOperation {

    @Test
    public void bitMoveTest() {
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

    @Test
    public void bitOrAndTest() {
        int a = Integer.valueOf("11010011101", 2);
        int b = Integer.valueOf("00001100101", 2);

        System.out.println(Utils.outputBit(a));
        System.out.println(Utils.outputBit(b));
        System.out.println(Utils.outputBit(a | b));
        System.out.println(Utils.outputBit(a & b));
    }

    @Test
    public void bitNotTest() {
        int a = 458;

        System.out.println(Utils.outputBit(a));
        System.out.println(Utils.outputBit(~a));
    }

    @Test
    public void bitXOrTest() {
        int a = Integer.valueOf("0001", 2);
        int b = Integer.valueOf("1001", 2);

        a = 145;
        b = 942;

        System.out.println(Utils.outputBit(a));
        System.out.println(Utils.outputBit(b));
        System.out.println(Utils.outputBit(b ^ a));
    }

    @Test
    public void moveTest() {
        int x = Integer.valueOf("1101101101", 2);
        int n = 5;

        System.out.println(Utils.outputBit(x));
        System.out.println(n);
        System.out.println();

        System.out.println("清最右n个位 x & (~0 << n)");
        System.out.println(Utils.outputBit(x & (~0 << n)));
        System.out.println();

        System.out.println("取右0起第n位的值 (x >> n) & 1");
        System.out.println(Utils.outputBit(x >> n));
        System.out.println(Utils.outputBit((x >> n) & 1));
        System.out.println();

        System.out.println("取右0起第n位的幂值 x & (1 << (n - 1))");
        System.out.println(Utils.outputBit(1 << (n - 1)));
        System.out.println(Utils.outputBit(x & (1 << (n - 1))));
        System.out.println();

        System.out.println("将右0起第n位改1, x | (1 << n))");
        System.out.println(Utils.outputBit(1 << n));
        System.out.println(Utils.outputBit(x | (1 << n)));
        System.out.println();

        System.out.println("将右0起第n位改0, x & (~(1 << n)))");
        System.out.println(Utils.outputBit(~(1 << n)));
        System.out.println(Utils.outputBit(x & (~(1 << n))));
        System.out.println();

        System.out.println("留最后n个位 x & ((1 << n) - 1))");
        System.out.println(Utils.outputBit((1 << n) - 1));
        System.out.println(Utils.outputBit(x & ((1 << n) - 1)));
        System.out.println();

        System.out.println("将第n位至第0位(含)清零, x&(~((1<<(n+1))-1)), x & (-(1 << (n + 1)))");
        System.out.println(Utils.outputBit(-(1 << (n + 1))));
        System.out.println(Utils.outputBit(x & (-(1 << (n + 1)))));
        System.out.println();
    }

    @Test
    public void swapTest() {
//        int a = 8108;
//        int b = 234;
//        a ^= b;
//        b ^= a;
//        a ^= b;
//        System.out.println(a);
//        System.out.println(b);

//        int[] arr = {1, 2, 1, 3, 1};
//        System.out.println(Arrays.toString(arr));
//        for (int len = arr.length, l = 0, r = len - 1; l <= r; l++, r--) {
//            arr[l] ^= arr[r];
//            arr[r] ^= arr[l];
//            arr[l] ^= arr[r];
//        }
//        System.out.println(Arrays.toString(arr));

        // 加减法交换（java溢出也没关系，循环的，能算回来）
        {
            int x = Integer.MAX_VALUE, y = Integer.MAX_VALUE - 1;
            System.out.println(x + ", " + y);
            x = x + y;
            y = x - y;
            x = x - y;
            System.out.println(x + ", " + y);
        }
        {
            int x = Integer.MIN_VALUE, y = Integer.MIN_VALUE + 1;
            System.out.println(x + ", " + y);
            x = x - y;
            y = x + y;
            x = y - x;
            System.out.println(x + ", " + y);
        }
    }

    // 方法是值传递，否则会有问题自己异或自己得0的问题——指向同一个地址，两个都变0
    // 此方法毫无任何作用
    private void swap(int a, int b) {
        a = a ^ b;
        b = b ^ a;
        a = a ^ b;
    }
}
