package com.lzhlyle.contest.biweekly.biweekly32;

public class Contest3 {
    // WA
    public int minInsertions(String s) {
        char[] arr = s.toCharArray();
        int cnt = 0, i = 0, n = arr.length;

        // 先消掉前面的 )
        while (i + 1 < n && arr[i] == ')' && arr[i + 1] == ')') {
            cnt++; // 前补 (
            i += 2;
        }

        // 剩下一个 )
        if (i < n && arr[i] == ')') {
            cnt += 2; // 前补 ()
            i++;
        }
        System.out.println(cnt);


        // 剩下 ( 开头

        // ( 的后面已经有几个 ) 可用，还缺几个 )

        while (i < n) {
            int lcnt = 0;
            while (i < n && arr[i] == '(') {
                lcnt++;
                i++;
            }

            // 遇到 ) 时，开始抵消
            while (i + 1 < n && arr[i] == ')' && arr[i + 1] == ')') {
                lcnt--;
                i += 2;
            }
            if (i < n && arr[i] == ')') {
                // 剩一个 )
                cnt++; // 后补 )
                lcnt--;
                i++;
            }
            if (lcnt > 0) cnt += lcnt * 2;
            else if (lcnt < 0) cnt -= lcnt;
            System.out.println("lcnt:" + lcnt + ", cnt: " + cnt);
        }

        // System.out.println("lcnt:" + lcnt + ", cnt: " + cnt);
//         if (lcnt == 0) return cnt;

//         if (lcnt > 0) {
//             cnt += lcnt * 2; // ( 多了
//             return cnt;
//         }

//         // ) 多了
//         cnt += (-lcnt); // lcnt < 0
        return cnt;
    }

    public static void main(String[] args) {
        Contest3 contest = new Contest3();
        {

        }
    }
}
