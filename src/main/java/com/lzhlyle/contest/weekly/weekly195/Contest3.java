package com.lzhlyle.contest.weekly.weekly195;

public class Contest3 {
    // wa
    // merge
    private static int MOD = 1000000007;

    public int numSubseq(int[] nums, int target) {
        long res = mergeSort(nums, 0, nums.length - 1, target);
        return (int) (res % MOD);
    }

    private long mergeSort(int[] nums, int l, int r, int target) {
        if (l >= r) return 0;
        int mid = l + (r - l) / 2;
        long lCnt = mergeSort(nums, l, mid, target);
        long rCnt = mergeSort(nums, mid + 1, r, target);
        long mgCnt = merge(nums, l, mid, r, target);
        return lCnt + rCnt + mgCnt;
    }

    private long merge(int[] arr, int l, int mid, int r, int target) {
        int[] temp = new int[r - l + 1];
        int i = l, j = mid + 1, k = 0;
        long cnt = 0;

        int min = Math.min(arr[i], arr[j]);
        while (i <= mid && j <= r) {
            if (arr[i] < arr[j]) {
                if (min + arr[j] <= target)
                    cnt += (i - l) * (j - mid - 1);

                temp[k++] = arr[i++];
            } else {
                if (min + arr[i] <= target)
                    cnt += (i - l) * (j - mid - 1);
                temp[k++] = arr[j++];
            }
        }

        while (i <= mid) {
            temp[k++] = arr[i++];
            cnt += (i - l) * (j - mid - 1);
        }
        while (j <= r) {
            temp[k++] = arr[j++];
            cnt += (i - l) * (j - mid - 1);
        }

        for (int p = 0; p < temp.length; p++) {
            arr[l + p] = temp[p];
        }
        return cnt;
    }

    public static void main(String[] args) {
        Contest3 contest = new Contest3();
        {

        }
    }
}
