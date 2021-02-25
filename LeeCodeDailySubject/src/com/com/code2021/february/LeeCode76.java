package com.com.code2021.february;

import java.util.*;

/**
 * @program:
 * @description:
 * 76. 最小覆盖子串
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 *
 * 注意：如果 s 中存在这样的子串，我们保证它是唯一的答案。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "ADOBECODEBANC", t = "ABC"
 * 输出："BANC"
 * 示例 2：
 *
 * 输入：s = "a", t = "a"
 * 输出："a"
 * @author: zhongmou.ji
 * @create: 2021/2/19 下午4:54
 **/
public class LeeCode76 {

    Map<Character, Integer> ori = new HashMap<>();
    Map<Character, Integer> cnt = new HashMap<>();

    /**
     * 滑动窗口
     * @param s
     * @param t
     * @return
     */
    public String minWindow(String s, String t) {
        // 左右指针
        int left = 0, right = 0;
        int len = Integer.MAX_VALUE, ansL = -1, ansR = -1;
        int n = s.length();
        for (char c : t.toCharArray()) {
            ori.put(c, ori.getOrDefault(c, 0) + 1);
        }
        String ans = "";
        while (right < n) {
            char c = s.charAt(right);
            right++;
            if (right < n && ori.containsKey(c)) {
                cnt.put(c, cnt.getOrDefault(c, 0) + 1);
            }
            while (check() && left <= right) {
                if (right - left < len) {
                    ansL = left;
                    ansR = right;
                }
                if (ori.containsKey(s.charAt(left))) {
                    cnt.put(s.charAt(left), cnt.getOrDefault(s.charAt(left), 0) - 1);
                }
                left++;
            }
        }
        return ansL == -1 ? "" : s.substring(ansL, ansR);
    }

    private boolean check() {
        Iterator<Map.Entry<Character, Integer>> iterator = ori.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Character, Integer> entry = iterator.next();
            if (cnt.getOrDefault(entry.getKey(), 0) < entry.getValue()) {
                return false;
            }
        }
        return true;
    }


}
