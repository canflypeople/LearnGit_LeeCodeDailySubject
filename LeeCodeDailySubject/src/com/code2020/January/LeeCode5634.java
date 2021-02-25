package com.code2020.January;

import java.util.*;

public class LeeCode5634 {

    /**
     * 栈
     * @param s
     * @param x
     * @param y
     * @return
     */
    public int maximumGain1(String s, int x, int y) {
        int gain = 0;
        Map<String, Integer> map = new HashMap<>();
        map.put("ab", x);
        map.put("ba", y);
        String maxStr = x > y ? "ab" : "ba";
        String minStr = x > y ? "ba" : "ab";
        Stack<Character> stack = new Stack<>();
        int index = 0, n = s.length();
        while (index < n) {
            char c = s.charAt(index);
            if (!stack.isEmpty()) {
                if (stack.peek() == maxStr.charAt(0) && c == maxStr.charAt(1)) {
                    stack.pop();
                    gain += map.get(maxStr);
                } else {
                    if (stack.size() >= 2) {
                        char c1 = stack.pop();
                        char c2 = stack.pop();
                        if (c1 == minStr.charAt(1) && c2 == minStr.charAt(0)) {
                            gain += map.get(minStr);
                        } else {
                            stack.push(c2);
                            stack.push(c1);
                        }
                    }
                    stack.push(c);
                }
            } else {
                stack.push(c);
            }
            index++;
        }
        if (stack.size() >= 2) {
            char c1 = stack.pop();
            char c2 = stack.pop();
            if (c1 == minStr.charAt(1) && c2 == minStr.charAt(0)) {
                gain += map.get(minStr);
            }
        }
        return gain;
    }

    public int maximumGain(String s, int x, int y) {
        int gain = 0;
        Map<String, Integer> map = new HashMap<>();
        map.put("ab", x);
        map.put("ba", y);
        String maxStr = x > y ? "ab" : "ba";
        String minStr = x > y ? "ba" : "ab";
        int n = s.length();
        StringBuilder sb = new StringBuilder(s);
        int index = 0;
        while (index < n) {
            while (index < n && (s.charAt(index) != 'a' && s.charAt(index) != 'b')) {
                index++;
            }
            int beginIndex = index;
            while (index + 1 < n && (s.charAt(index) == 'a' || s.charAt(index) == 'b')) {
                index++;
            }
            gain += getMaxScore(s.substring(beginIndex, index + 1), map, maxStr, minStr);
            index++;
        }

        return gain;
    }

    private int getMaxScore(String substring, Map<String, Integer> map, String maxStr, String minStr) {
        if (substring.length() < 2) {
            return 0;
        }
        int score = 0;
        StringBuilder sb = new StringBuilder(substring);
        while (sb.indexOf(maxStr) >= 0 || sb.indexOf(minStr) >= 0) {
            while (sb.indexOf(maxStr) >= 0) {
                int i = sb.indexOf(maxStr);
                sb.replace(i, i + 2, "");
                score += map.get(maxStr);
            }
            if (sb.indexOf(minStr) >= 0) {
                int i = sb.indexOf(minStr);
                sb.replace(i, i + 2, "");
                score += map.get(minStr);
            }
        }
        return score;
    }


    public static void main(String[] args) {
        LeeCode5634 leeCode5634 = new LeeCode5634();
        System.out.println(leeCode5634.maximumGain1("cdbcbbaaabab"
                ,4
                ,5));
    }

}
