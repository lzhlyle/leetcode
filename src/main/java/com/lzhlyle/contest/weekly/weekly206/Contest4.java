package com.lzhlyle.contest.weekly.weekly206;

import java.util.Stack;

public class Contest4 {
    public boolean isTransformable(String s, String t) {
        char[] sarr = s.toCharArray();
        char[] tarr = t.toCharArray();
        int n = sarr.length;

        Stack<Integer>[] pos = new Stack[10]; // 记录每个数字的位置
        for (int v = 0; v <= 9; v++)
            pos[v] = new Stack<>();
        for (int i = 0; i < n; i++)
            pos[sarr[i] - '0'].push(i); // 大的在栈顶

        // 从后向前
        for (int i = n - 1; i >= 0; i--) {
            int d = tarr[i] - '0';
            if (pos[d].isEmpty()) return false;

            // 当前数字 d 之后，不应该有比它大的数
            // 否则会阻拦「向后冒泡」
            for (int j = d + 1; j < 10; j++)
                if (!pos[j].isEmpty() && pos[j].peek() > pos[d].peek())
                    return false;
            pos[d].pop(); // 能够换到 t[i] 位置
        }
        return true;
    }

    public static void main(String[] args) {
        Contest4 contest = new Contest4();
        {

        }
    }
}
