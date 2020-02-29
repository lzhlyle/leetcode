package com.lzhlyle.leetcode.recite.no438;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class FindAllAnagramsInAString_BruteForce_Adv_Adv {
    public List<Integer> findAnagrams(String students, String plans) {
        // 应届生人数太少，不可能达到完美配置
        if (students.length() < plans.length()) return Collections.emptyList();

        // 完美配置的结果
        List<Integer> perfect = new LinkedList<>();
        // 公司需要的人才配置(董事会不变的需要)
        int[] need = new int[26];
        // 人才招聘计划(随人员来来去去而动态变动)
        int[] hire = new int[26];
        // 按照公司需要的人才配置，初始人才招聘册
        for (char plan : plans.toCharArray()) {
            need[plan - 'a']++;
            hire[plan - 'a'] = need[plan - 'a'];
        }

        int needCnt = plans.length(); // 计划招聘人数
        int expected = needCnt; // 当前人才缺口
        char[] coders = students.toCharArray(); // 应届生程序员

        // 逐个应届生程序员面试
        for (int i = 0; i < coders.length; i++) {
            // 老员工离职
            if (i > needCnt - 1) {
                char leaving = coders[i - needCnt]; // 要离开的是谁
                if (need[leaving - 'a'] > 0 && hire[leaving - 'a'] >= 0) {
                    // 想留的 && 没有人才储备
                    expected++; // 当前人才缺口增大
                }
                hire[leaving - 'a']++; // 加入招聘计划（若本就人手富裕，相当于逐渐抵消富裕的状况）
            }

            // 新应届生面试
            char hiring = coders[i];
            if (need[hiring - 'a'] > 0 && hire[hiring - 'a'] > 0) {
                // 来得正是期望的 && 当前有招聘计划
                expected--; // 招聘需求减少
            }
            hire[hiring - 'a']--; // 不管缺不缺，先招进来（若人手富余，招聘需求为负数）

            if (expected == 0) perfect.add(i - needCnt + 1); // 达到最佳配置，准备向公司邀功领赏
        }

        return perfect;
    }

    public static void main(String[] args) {
        List<Integer> res = new FindAllAnagramsInAString_BruteForce_Adv_Adv().findAnagrams("cbaebabacd", "abc");
        System.out.println(res);
    }
}
