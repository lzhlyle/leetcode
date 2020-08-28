package com.lzhlyle.leetcode.self.no657;

public class RobotReturnToOrigin {
    public boolean judgeCircle(String moves) {
        int lr = 0, ud = 0;
        for (char c : moves.toCharArray()) {
            if (c == 'L') lr++;
            else if (c == 'R') lr--;
            else if (c == 'U') ud++;
            else ud--;
        }
        return lr == 0 && ud == 0;
    }
}
