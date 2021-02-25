package com.December;

import java.util.*;

/**
 * 316. 去除重复字母
 * 给你一个字符串 s ，请你去除字符串中重复的字母，使得每个字母只出现一次。需保证 返回结果的字典序最小（要求不能打乱其他字符的相对位置）。
 */
public class LeeCode316 {

    static void getI() {

    }

    /**
     * 用map来存储剩余字符出现的次数
     * 用栈来存储去重的字符串，并遍历字符串入栈
     * 用set来存储栈中存在的元素
     * 入栈中，当前元素比栈顶元素要小，并且栈顶元素在字符串后面还出现过，则将栈顶元素
     * 若当前元素比栈顶元素要大，则入栈
     * @param s
     * @return
     */
    public String removeDuplicateLetters(String s) {
        Integer.parseInt("");
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                break ;
            }
            System.out.println("----");
        }
        int[] count = new int[26];
        Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (!set.contains(c)) {
                while (!stack.isEmpty() && (stack.peek() > c && count[stack.peek() - 'a'] > 0)) {
                    set.remove(stack.peek());
                    stack.pop();
                }
                stack.push(c);
                set.add(c);
            }
            count[c - 'a']--;

        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }



    public static void main(String[] args) {
        System.out.println((int)99.99);
        LeeCode316 leeCode316 = new LeeCode316();
        System.out.println(leeCode316.removeDuplicateLetters("abacb"));
    }

}

class ClassA extends LeeCode316 {

}
