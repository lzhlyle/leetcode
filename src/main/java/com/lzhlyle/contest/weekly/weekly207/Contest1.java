package com.lzhlyle.contest.weekly.weekly207;

public class Contest1 {
    // bf
    public String reorderSpaces(String text) {
        int blank = 0;
        for (char c : text.toCharArray())
            if (c == ' ') blank++;

        String[] arr = text.trim().split("\\s+");
        int word = arr.length;
        if (word == 1) {
            StringBuilder builder = new StringBuilder();
            builder.append(arr[0]);
            while (blank-- > 0)
                builder.append(" ");
            return builder.toString();
        }

        int each = blank / (word - 1);
        StringBuilder empty = new StringBuilder();
        for (int i = 0; i < each; i++)
            empty.append(" ");

        int rest = blank % (word - 1);
        StringBuilder restEmpty = new StringBuilder();
        for (int i = 0; i < rest; i++)
            restEmpty.append(" ");

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < word; i++) {
            builder.append(arr[i]);
            if (i != word - 1) builder.append(empty);
        }
        builder.append(restEmpty);
        return builder.toString();
    }

    public static void main(String[] args) {
        Contest1 contest = new Contest1();
        {
            contest.reorderSpaces("   aaa   bbb   ccc");
        }
    }
}
