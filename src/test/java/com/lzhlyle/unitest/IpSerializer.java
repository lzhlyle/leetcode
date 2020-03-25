package com.lzhlyle.unitest;

import org.junit.Test;

import java.util.Arrays;

public class IpSerializer {
    public long serialize(String ip) {
        String[] nums = ip.split("\\.");
        long res = 0b0L;
        for (int i = 0; i < 4; i++) {
            int n = Integer.valueOf(nums[i]);
            int move = 8 * (nums.length - i - 1);
            res |= ((long) n) << move;
        }
        return res;
    }

    public String deserialize(long l) {
        int[] nums = new int[4];
        for (int i = 0; i < 4; i++) {
            int move = 8 * (nums.length - i - 1);
            int mask = ((1 << 8) - 1) << move; // 8个1 左移 dis
            nums[i] = (int) ((l & mask) >> move);
        }
        return nums[0] + "." + nums[1] + "." + nums[2] + "." + nums[3];
    }

    @Test
    public void test() {
        String[] ips = {"0.0.0.0", "127.0.0.1", "192.168.1.1", "10.215.99.103", "255.0.0.255", "255.255.255.255"};
        System.out.println(Arrays.toString(ips));

        long[] arr = new long[ips.length];
        for (int i = 0; i < ips.length; i++) {
            arr[i] = serialize(ips[i]);
        }
        System.out.println(Arrays.toString(arr));

        String[] res = new String[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = deserialize(arr[i]);
        }
        System.out.println(Arrays.toString(res));
    }
}
