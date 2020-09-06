package com.lzhlyle.contest.weekly.weekly205;

import java.util.*;

public class Contest2 {
    public int numTriplets(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        Map<Integer, List<Integer>> map1 = getMap(nums1), map2 = getMap(nums2);

        return cnt(nums1, nums2, map1, map2) + cnt(nums2, nums1, map2, map1);
    }

    private int cnt(int[] nums1, int[] nums2, Map<Integer, List<Integer>> map1, Map<Integer, List<Integer>> map2) {
        int cnt = 0;
        int last = 0;
        for (int i = 0; i < nums1.length; i++) {
            int v = nums1[i];
            if (i > 0 && v == nums1[i - 1]) {
                cnt += last;
                continue;
            }


            long v2 = (long) v * (long) v;
            int curr = 0;
            for (int j = 0; j < nums2.length - 1; j++) {
                // bs
                int l = j + 1, r = nums2.length - 1;
                while (l < r) {
                    int mid = l + (r - l) / 2;
                    if ((long) nums2[mid] * (long) nums2[j] < v2) l = mid + 1;
                    else r = mid;
                }
                if ((long) nums2[l] * (long) nums2[j] == v2) {
                    // 还要看 l 后面有几个与 nums2[l] 相同
                    // System.out.printf("%s, %s%n", i, l);
                    List<Integer> list = map2.get(nums2[l]);
                    curr += list.get(list.size() - 1) - l + 1;
                }
            }
            cnt += curr;
            last = curr;
        }
        // System.out.println();
        return cnt;
    }

    // (value, indexes)
    private Map<Integer, List<Integer>> getMap(int[] arr) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (!map.containsKey(arr[i]))
                map.put(arr[i], new ArrayList<>());
            map.get(arr[i]).add(i);
        }
        return map;
    }

    public static void main(String[] args) {
        Contest2 contest = new Contest2();
        {
            int[] nums1 = {7, 4};
            int[] nums2 = {5, 2, 8, 9};
            int res = contest.numTriplets(nums1, nums2);
            System.out.println(res);
        }
    }
}
