package com.com.code2021.february;

import java.util.Arrays;

/**
 * @program:
 * @description:
 * 395. 至少有K个重复字符的最长子串
 * 给你一个字符串 s 和一个整数 k ，请你找出 s 中的最长子串， 要求该子串中的每一字符出现次数都不少于 k 。返回这一子串的长度。
 * @author: zhongmou.ji
 * @create: 2021/2/27 下午1:13
 **/
public class LeeCode395 {
    /**
     * 使用哈希表存储剩余的字符，若剩余字符中的个数小于k，则直接将窗口置为最后一次出现该字符的后一位
     * @param s
     * @param k
     * @return
     */
    public int longestSubstring(String s, int k) {
        int ans = 0;
        int[] lastIndexs = new int[26];
        Arrays.fill(lastIndexs, -1);
        int n = s.length();
        int[] counts = new int[26];
        int[] currCount;
        for (char c : s.toCharArray()) {
            counts[c - 'a']++;
        }
        int left = 0, right = 0;
        while (right < n) {

        }
        return 0;

    }


    public boolean isMonotonic(int[] A) {
        int change = 0;
        if (A.length <= 1) {
            return true;
        }
        for (int i = 0; i < A.length - 1; i++) {
            if (change == 0) {
                if (A[i] > A[i + 1]) {
                    change = 1;
                } else if (A[i] < A[i + 1]) {
                    change = -1;
                }
            } else if ((change == 1 && A[i] < A[i + 1]) && (change == -1 && A[i] > A[i + 1])) {
                return false;
            }
        }
        return true;

    }
}
