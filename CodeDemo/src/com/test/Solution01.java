package com.test;

import com.December.match.three.Solution;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.time.temporal.ChronoField;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution01 {

    /**
     * 找到第一个不存在重复元素的字符对应的索引
     * @param s
     * @return
     */
    public int getFirstNoRepeatChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        Set<Character> set = new HashSet<>();
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                set.add(entry.getKey());
            }
        }
        for (int i = 0; i < s.length(); i++) {
            if (set.contains(s.charAt(i))) {
                return i;
            }
        }
        return -1;

    }

    public static void main(String[] args) {
        Solution01 solution01 = new Solution01();
        System.out.println(solution01.getFirstNoRepeatChar("huawei"));
        System.out.println(solution01.getFirstNoRepeatChar("hello huawei"));
        System.out.println(solution01.getFirstNoRepeatChar("aaa"));

    }
}
